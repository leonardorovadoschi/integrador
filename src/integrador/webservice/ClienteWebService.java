/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.webservice;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author leo
 */
public class ClienteWebService {

    /**
     * @var string Shop URL
     */
    protected String url;
    /**
     * @var string Authentification key
     */
    protected String key;
    /**
     * @var boolean is debug activated
     */
    protected boolean debug;

    private final CloseableHttpClient httpclient;
    private CloseableHttpResponse response;
    private HashMap<String, Object> responseReturns;

    /**
     * PrestaShopWebservice constructor.      <code>
     *
     * try
     * {
     * 	PSWebServiceClient ws = new PSWebServiceClient('http://mystore.com/', 'ZQ88PRJX5VWQHCWE4EE7SQ7HPNX00RAJ', false);
     * 	// Agora temos um objeto webservice para brincar
     * }
     * catch (PrestaShopWebserviceException ex)
     * {
     * 	// Handle exception
     * }
     *
     * </code>
     *
     * @param url Root URL for the shop
     * @param key Authentification key
     * @param debug Modo de depuração ativado (true) or deactivated (false)
     */
    public ClienteWebService(String url, String key, boolean debug) {
        this.url = url;
        this.key = key;
        this.debug = debug;

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(key, ""));

        this.httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
    }

    /**
     * Pegue o código de status e lance uma exceção se o servidor não retornou o
     * código 200 ou 201
     *
     * @param status_code Código de status de um retorno HTTP
     * @throws integrador.webservice.PrestaShopWebserviceException
     */
    protected void verificarCodigoDeStatus(int status_code) throws PrestaShopWebserviceException {

        String error_label = "Esta chamada para PrestaShop Web Services falhou e retornou um status HTTP %d. Que significa: %s.";
        switch (status_code) {
            case 200:
            case 201:
                break;
            case 204:
                throw new PrestaShopWebserviceException(String.format(error_label, status_code, "No content"), this);
            case 400:
                throw new PrestaShopWebserviceException(String.format(error_label, status_code, "Bad Request"), this);
            case 401:
                throw new PrestaShopWebserviceException(String.format(error_label, status_code, "Unauthorized"), this);
            case 404:
                throw new PrestaShopWebserviceException(String.format(error_label, status_code, "Not Found"), this);
            case 405:
                throw new PrestaShopWebserviceException(String.format(error_label, status_code, "Method Not Allowed"), this);
            case 500:
                throw new PrestaShopWebserviceException(String.format(error_label, status_code, "Internal Server Error"), this);
            default:
                throw new PrestaShopWebserviceException("This call to PrestaShop Web Services returned an unexpected HTTP status of:" + status_code);
        }
    }

    protected String obterConteudoResposta() {
        try {
            return readInputStreamAsString((InputStream) this.responseReturns.get("response"));
        } catch (IOException ex) {
            return "";
        }
    }

    /**
     * Handles request to PrestaShop Webservice. Can throw exception.
     *
     * @param request
     * @return array status_code, response
     * @throws integrador.webservice.PrestaShopWebserviceException
     */
    protected HashMap<String, Object> executarRequest(HttpUriRequest request) throws PrestaShopWebserviceException {

        HashMap<String, Object> returns = new HashMap<>();

        try {
            response = httpclient.execute(request);
            Header[] headers = response.getAllHeaders();
            HttpEntity entity = response.getEntity();

            if (this.debug) {
                System.out.println("Status:  " + response.getStatusLine());
                System.out.println("====================Header======================");
                for (Header h : headers) {
                    System.out.println(h.getName() + " : " + h.getValue());
                }
                //System.out.println("====================ResponseBody================");
                //System.out.println(readInputStreamAsString(entity.getContent()));

            }

            returns.put("status_code", response.getStatusLine().getStatusCode());
            returns.put("response", entity.getContent());
            returns.put("header", headers);

            this.responseReturns = returns;

        } catch (IOException ex) {
            throw new PrestaShopWebserviceException("Bad HTTP response : " + ex.toString());
        }

        return returns;
    }

    /**
     * Load XML from string. Can throw exception
     *
     * @param responseBody
     * @return parsedXml
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    protected Document analizarXML(InputStream responseBody) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //System.out.println(responseBody);
        return docBuilder.parse(responseBody);
    }

    /**
     * Add (POST) a resource
     * <p>
     * Unique parameter must take : <br><br>
     * 'resource' => Resource name<br>
     * 'postXml' => Full XML string to add resource<br><br>
     *
     * @param opt
     * @return xml response
     * @throws integrador.webservice.PrestaShopWebserviceException
     */
    public Document adicionar(Map<String, Object> opt) throws PrestaShopWebserviceException {
        if ((opt.containsKey("resource") && opt.containsKey("postXml")) || (opt.containsKey("url") && opt.containsKey("postXml"))) {
            String completeUrl;
            completeUrl = (opt.containsKey("resource") ? this.url + "/api/" + (String) opt.get("resource") : (String) opt.get("url"));
            String xml = (String) opt.get("postXml");
            if (opt.containsKey("id_shop")) {
                completeUrl += "&id_shop=" + (String) opt.get("id_shop");
            }
            if (opt.containsKey("id_group_shop")) {
                completeUrl += "&id_group_shop=" + (String) opt.get("id_group_shop");
            }

            StringEntity entity = new StringEntity(xml, ContentType.create("text/xml", Consts.UTF_8));
                    //entity.setChunked(true);

            HttpPost httppost = new HttpPost(completeUrl);
            httppost.setEntity(entity);

            HashMap<String, Object> resoult = this.executarRequest(httppost);
            this.verificarCodigoDeStatus((Integer) resoult.get("status_code"));

            try {
                Document doc = this.analizarXML((InputStream) resoult.get("response"));
                response.close();
                return doc;
            } catch (ParserConfigurationException | SAXException | IOException ex) {
                throw new PrestaShopWebserviceException("Response XML Parse exception");
            }

        } else {
            throw new PrestaShopWebserviceException("Bad parameters given");
        }

    }

    /**
     * Recuperar (GET) um recurso
     * <p>
     * O parâmetro exclusivo deve ter : <br><br>
     * 'url' => URL completo para uma solicitação GET de Webservice (ex:
     * http://mystore.com/api/customers/1/)<br>
     * OR<br>
     * 'resource' => Nome do recurso,<br>
     * 'id' => ID de um recurso que você deseja obter<br><br>
     * </p>
     * <code>
     *
     * try
     * {
     *  PSWebServiceClient ws = new PrestaShopWebservice('http://mystore.com/', 'ZQ88PRJX5VWQHCWE4EE7SQ7HPNX00RAJ', false);
     *  HashMap<String,Object> opt = new HashMap();
     *  opt.put("resouce","orders");
     *  opt.put("id",1);
     *  Document xml = ws->get(opt);
     *	// Here in xml, a XMLElement objeto que você pode analisar
     * catch (PrestaShopWebserviceException ex)
     * {
     *  Handle exception
     * }
     * inválido - codificado
     *  Espaço	%20
     *  "	%22
     * <	%3C >	%3E #	%23 %	%25 |	%7C
     * </code>
     *
     * @param opt Map representing resource to get.
     * @return Document response
     * @throws integrador.webservice.PrestaShopWebserviceException
     */
    public Document getFuncao(Map<String, Object> opt) throws PrestaShopWebserviceException {
        String completeUrl;
        if (opt.containsKey("url")) {
            completeUrl = (String) opt.get("url");
        } else if (opt.containsKey("resource")) {
            completeUrl = this.url + "/api/" + opt.get("resource");
            if (opt.containsKey("id")) {
                completeUrl += "/" + opt.get("id");
            }

            String[] params = new String[]{"filter", "display", "sort", "limit", "id_shop", "id_group_shop"};
            for (String p : params) {
                if (opt.containsKey("p")) {
                    try {
                        completeUrl += "?" + p + "=" + URLEncoder.encode((String) opt.get(p), "UTF-8") + "&";
                    } catch (UnsupportedEncodingException ex) {
                        throw new PrestaShopWebserviceException("URI encodin excepton: " + ex.toString());
                    }
                }
            }

        } else {
            throw new PrestaShopWebserviceException("Bad parameters given");
        }
        //*  Espaço	%20
        //*  "	%22
        //*  <	%3C
        //*  >	%3E
        //*  #	%23
        //*  %	%25
        //*  |	%7C
        completeUrl = completeUrl.replaceAll(" ", "%20");
        completeUrl = completeUrl.replaceAll("\\|", "%7C");
        completeUrl = completeUrl.replaceAll("\\%", "%25");

        HttpGet httpget = new HttpGet(completeUrl);
        HashMap<String, Object> resoult = this.executarRequest(httpget);

        this.verificarCodigoDeStatus((int) resoult.get("status_code"));// check the response validity

        try {
            Document doc = this.analizarXML((InputStream) resoult.get("response"));
            response.close();
            return doc;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new PrestaShopWebserviceException("Response XML Parse exception: " + ex.toString());
        }

    }

    /**
     * Método principal (HEAD) um recurso
     *
     * @param opt Mapa representando recurso para solicitação de head.
     * @return XMLElement status_code, response
     * @throws integrador.webservice.PrestaShopWebserviceException
     */
    public Map<String, String> cabecalho(Map<String, Object> opt) throws PrestaShopWebserviceException {
        String completeUrl;
        if (opt.containsKey("url")) {
            completeUrl = (String) opt.get("url");
        } else if (opt.containsKey("resource")) {
            completeUrl = this.url + "/api/" + opt.get("resource");
            if (opt.containsKey("id")) {
                completeUrl += "/" + opt.get("id");
            }

            String[] params = new String[]{"filter", "display", "sort", "limit"};
            for (String p : params) {
                if (opt.containsKey("p")) {
                    try {
                        completeUrl += "?" + p + "=" + URLEncoder.encode((String) opt.get(p), "UTF-8") + "&";
                    } catch (UnsupportedEncodingException ex) {
                        throw new PrestaShopWebserviceException("URI encodin excepton: " + ex.toString());
                    }
                }
            }

        } else {
            throw new PrestaShopWebserviceException("Bad parameters given");
        }

        HttpHead httphead = new HttpHead(completeUrl);
        HashMap<String, Object> resoult = this.executarRequest(httphead);
        this.verificarCodigoDeStatus((int) resoult.get("status_code"));// check the response validity

        HashMap<String, String> headers = new HashMap();
        for (Header h : (Header[]) resoult.get("header")) {
            headers.put(h.getName(), h.getValue());
        }
        return headers;
    }

    /**
     * Edit (PUT) a resource
     * <p>
     * O parâmetro exclusivo deve ter : <br><br>
     * 'resource' => Nome do recurso ,<br>
     * 'id' => ID de um recurso que você deseja editar,<br>
     * 'putXml' => String XML modificada de um recurso<br><br>
     *
     * @param opt representando recurso para editar.
     * @return
     * @throws integrador.webservice.PrestaShopWebserviceException
     */
    public Document edit(Map<String, Object> opt) throws PrestaShopWebserviceException {

        String xml = "";
        String completeUrl;
        if (opt.containsKey("url")) {
            completeUrl = (String) opt.get("url");
        } else if (((opt.containsKey("resource") && opt.containsKey("id")) || opt.containsKey("url")) && opt.containsKey("putXml")) {
            completeUrl = (opt.containsKey("url")) ? (String) opt.get("url") : this.url + "/api/" + opt.get("resource") + "/" + opt.get("id");
            xml = (String) opt.get("putXml");
            if (opt.containsKey("id_shop")) {
                completeUrl += "&id_shop=" + opt.get("id_shop");
            }
            if (opt.containsKey("id_group_shop")) {
                completeUrl += "&id_group_shop=" + opt.get("id_group_shop");
            }
        } else {
            throw new PrestaShopWebserviceException("Bad parameters given");
        }

        StringEntity entity = new StringEntity(xml, ContentType.create("text/xml", Consts.UTF_8));
            //entity.setChunked(true);

        HttpPut httpput = new HttpPut(completeUrl);
        httpput.setEntity(entity);
        HashMap<String, Object> resoult = this.executarRequest(httpput);
        this.verificarCodigoDeStatus((int) resoult.get("status_code"));// check the response validity

        try {
            Document doc = this.analizarXML((InputStream) resoult.get("response"));
            response.close();
            return doc;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new PrestaShopWebserviceException("Response XML Parse exception: " + ex.toString());
        }
    }

    /**
     * Delete (DELETE) a resource. Unique parameter must take : <br><br>
     * 'resource' => Resource name<br>
     * 'id' => ID or array which contains IDs of a resource(s) you want to
     * delete<br><br>
     *
     * @param opt representing resource to delete.
     * @return
     * @throws integrador.webservice.PrestaShopWebserviceException
     */
    public boolean delete(Map<String, Object> opt) throws PrestaShopWebserviceException {
        String completeUrl = "";
        if (opt.containsKey("url")) {
            completeUrl = (String) opt.get("url");
        } else if (opt.containsKey("resource") && opt.containsKey("id")) //if (opt.get("id"))
        //        completeUrl = this.url+"/api/"+opt.get("resource")+"/?id=[".implode(',', $options['id'])+"]";
        //else
        {
            completeUrl = this.url + "/api/" + opt.get("resource") + "/" + opt.get("id");
        }

        if (opt.containsKey("id_shop")) {
            completeUrl += "&id_shop=" + opt.get("id_shop");
        }
        if (opt.containsKey("id_group_shop")) {
            completeUrl += "&id_group_shop=" + opt.get("id_group_shop");
        }

        HttpDelete httpdelete = new HttpDelete(completeUrl);
        HashMap<String, Object> resoult = this.executarRequest(httpdelete);

        this.verificarCodigoDeStatus((int) resoult.get("status_code"));// check the response validity    

        return true;
    }

    /**
     *
     * @param imgURL
     * @param productId
     * @return xml response
     * @throws integrador.webservice.PrestaShopWebserviceException
     * @throws java.net.MalformedURLException
     */
    public Document addImg(String imgURL, Integer productId) throws PrestaShopWebserviceException, MalformedURLException, IOException {

        URL imgUrl = new URL(imgURL);
        InputStream is = imgUrl.openStream();

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();

        String completeUrl = this.url + "/api/images/products/" + String.valueOf(productId);
        HttpPost httppost = new HttpPost(completeUrl);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("image", new ByteArrayBody(buffer.toByteArray(), "upload.jpg"));

        HttpEntity entity = builder.build();
        httppost.setEntity(entity);

        HashMap<String, Object> resoult = this.executarRequest(httppost);
        this.verificarCodigoDeStatus((Integer) resoult.get("status_code"));

        try {
            Document doc = this.analizarXML((InputStream) resoult.get("response"));
            response.close();
            return doc;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new PrestaShopWebserviceException("Response XML Parse exception");
        }

    }

    private String readInputStreamAsString(InputStream in)
            throws IOException {

        BufferedInputStream bis = new BufferedInputStream(in);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = bis.read();
        while (result != -1) {
            byte b = (byte) result;
            buf.write(b);
            result = bis.read();
        }

        String returns = buf.toString();
        return returns;
    }

    public String DocumentToString(Document doc) throws TransformerException {
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = transfac.newTransformer();
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));

        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(doc.getDocumentElement());

        trans.transform(source, result);
        String xmlString = sw.toString();

        return xmlString;
    }

    /**
     * Função responsavel por devolver ids de uma consulta Web Service HashMap
     * <String,Object> getSchemaOpt = new HashMap();
     * getSchemaOpt.put("url",shopUrl+"/api/orders?filter[id_customer]=11");
     * Document document = ws.get(getSchemaOpt); NodeList nList =
     * document.getElementsByTagName("order") Retorna uma lista ids, em String
     *
     * @param nList
     * @return
     */
    public List<String> retornaListaId(NodeList nList) {
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            // getSchemaOpt = new HashMap();
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                ids.add(eElement.getAttribute("id"));
                // System.out.println(elementAtribute +": " + txt);               
            }
        }
        return ids;
    }

    /**
     * Função responsavel por devolver o valor de um campo por uma consulta
     * webservice HashMap <String,Object> getSchemaOpt = new HashMap();
     * getSchemaOpt.put("url",shopUrl+"/api/orders/"+id); document =
     * ws.get(getSchemaOpt); Element elemento = document.getDocumentElement();
     * NodeList listNode = elemento.getElementsByTagName("order"); for (int i =
     * 0; i < listNode.getLength(); i++) Element endElement = (Element)
     * listNode.item(i); System.out.println("Id: "+ obterValorObjeto(endElement,
     * "id")); System.out.println("id_customer: "+ obterValorObjeto(endElement,
     * "id_customer")); System.out.println("id_address_invoice: "+
     * obterValorObjeto(endElement, "id_address_invoice")); @param elemento
     * @param nomeElemento @return
     */
    public String obterValorObjeto(Element elemento, String nomeElemento) {
        NodeList listaElemento = elemento.getElementsByTagName(nomeElemento);
        if (listaElemento == null) {
            return "";
        }
        Element noElemento = (Element) listaElemento.item(0);
        if (noElemento == null) {
            return "";
        }
        Node no = noElemento.getFirstChild();
        System.out.println("noElemento.getFirstChild(): " + noElemento.getTagName());
        if(no == null){
            return "";
        }
        
        //System.out.println("Nó getNodeName(): " + no.getTextContent());
        System.out.println("Nó getNodeValue(): " + no.getNodeValue());  
        return no.getNodeValue();
    }
}
