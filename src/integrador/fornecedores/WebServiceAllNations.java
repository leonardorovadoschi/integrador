/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.fornecedores;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 *
 * @author leo
 */
public class WebServiceAllNations {
    
    public void retornaXmlRetornarListaProdutos() {
        try {
        String requestSoap;//requisicao/request no formato xml, repare que isto foi copiado da regiao destacada em azul na figura 1
        requestSoap =  "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                +"<soap:Body>\n" 
                +"<RetornarListaProdutos xmlns=\"http://allnations/wsintegracao/\">\n" 
                +"<CodigoCliente>0057910</CodigoCliente>\n" 
                +"<Senha>743275</Senha>\n" 
                +"<Data>11/06/2018</Data>\n" 
                +"</RetornarListaProdutos>\n" 
                +"</soap:Body>\n" 
                +"</soap:Envelope>";
        SOAPConnectionFactory soapConnectionFactory;
        
            soapConnectionFactory = SOAPConnectionFactory.newInstance();
        
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        String url = "http://wspub.allnations.com.br/wsIntEstoqueClientesV2/ServicoReservasPedidosExt.asmx";//url do webservice nao e a url do wsdl do webservice, repare que isto foi copia da parte vermelha da figura 1
        MimeHeaders headers = new MimeHeaders();
        headers.addHeader("Content-Type", "text/xml");
 
        //exclua esta regiao caso o webservice nao possua a proprieade SOAPAction
        headers.addHeader("SOAPAction", "http://allnations/wsintegracao/RetornarListaProdutos"); // header SOAPAction e sua respectiva url, esta url muda de webservice para webservice. Alguns webservice nao possuem esta proprieade, nestes webservice esta linha deve ser excluida
                                                                         // o valor "http://tempuri.org/CalcPrazo" foi obtido com base na região destacada em verde da figura 2.
 
        //fim da regiao a ser excluida caso o webservice nao possua a proprieade SOAPAction
 
        MessageFactory messageFactory = MessageFactory.newInstance();
 
        SOAPMessage msg = messageFactory.createMessage(headers, (new ByteArrayInputStream(requestSoap.getBytes())));
 
        SOAPMessage soapResponse = soapConnection.call(msg, url);
        Document xmlRespostaARequisicao=soapResponse.getSOAPBody().getOwnerDocument();
        System.out.println(passarXMLParaString(xmlRespostaARequisicao,4));//imprime na tela o xml de retorno.
        } catch (SOAPException ex) {
            Logger.getLogger(WebServiceAllNations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedOperationException ex) {
            Logger.getLogger(WebServiceAllNations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WebServiceAllNations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void retornaXmlRetornarListaProdutosEstoque() {
        try {
        String requestSoap;//requisicao/request no formato xml, repare que isto foi copiado da regiao destacada em azul na figura 1
        requestSoap =  "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                +"<soap:Body>\n" 
                +"<RetornarListaProdutosEstoque xmlns=\"http://allnations/wsintegracao/\">\n" 
                +"<CodigoCliente>0057910</CodigoCliente>\n" 
                +"<Senha>743275</Senha>\n" 
                +"<Data>11/06/2018</Data>\n" 
                +"</RetornarListaProdutosEstoque>\n" 
                +"</soap:Body>\n" 
                +"</soap:Envelope>";
        SOAPConnectionFactory soapConnectionFactory;
        
            soapConnectionFactory = SOAPConnectionFactory.newInstance();
        
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        String url = "http://wspub.allnations.com.br/wsIntEstoqueClientesV2/ServicoReservasPedidosExt.asmx";//url do webservice nao e a url do wsdl do webservice, repare que isto foi copia da parte vermelha da figura 1
        MimeHeaders headers = new MimeHeaders();
        headers.addHeader("Content-Type", "text/xml");
 
        //exclua esta regiao caso o webservice nao possua a proprieade SOAPAction
        headers.addHeader("SOAPAction", "http://allnations/wsintegracao/RetornarListaProdutosEstoque"); // header SOAPAction e sua respectiva url, esta url muda de webservice para webservice. Alguns webservice nao possuem esta proprieade, nestes webservice esta linha deve ser excluida
                                                                         // o valor "http://tempuri.org/CalcPrazo" foi obtido com base na região destacada em verde da figura 2.
 
        //fim da regiao a ser excluida caso o webservice nao possua a proprieade SOAPAction
 
        MessageFactory messageFactory = MessageFactory.newInstance();
 
        SOAPMessage msg = messageFactory.createMessage(headers, (new ByteArrayInputStream(requestSoap.getBytes())));
 
        SOAPMessage soapResponse = soapConnection.call(msg, url);
        Document xmlRespostaARequisicao=soapResponse.getSOAPBody().getOwnerDocument();
        System.out.println(passarXMLParaString(xmlRespostaARequisicao,4));//imprime na tela o xml de retorno.
        } catch (SOAPException ex) {
            Logger.getLogger(WebServiceAllNations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedOperationException ex) {
            Logger.getLogger(WebServiceAllNations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WebServiceAllNations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static String passarXMLParaString(Document xml, int espacosIdentacao){
        try {
            //set up a transformer
            TransformerFactory transfac = TransformerFactory.newInstance();
            transfac.setAttribute("indent-number", new Integer(espacosIdentacao));
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
 
            //create string from xml tree
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(xml);
            trans.transform(source, result);
            String xmlString = sw.toString();
            return xmlString;
        }
        catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
