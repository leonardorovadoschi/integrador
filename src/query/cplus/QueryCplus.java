/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query.cplus;

import entidade.cplus.Calculoicms;
import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Campocustomvalor;
import entidade.cplus.Cfop;
import entidade.cplus.Cliente;
import entidade.cplus.Clientecaracteristica;
import entidade.cplus.Contareceber;
import entidade.cplus.Documento;
import entidade.cplus.Documentodocref;
import entidade.cplus.Fornecedor;
import entidade.cplus.Fornproduto;
import entidade.cplus.Gtintributavel;
import entidade.cplus.Localizacao;
import entidade.cplus.Moentrega;
import entidade.cplus.Moentregaprod;
import entidade.cplus.Movdocreferenciado;
import entidade.cplus.Movecfdocumento;
import entidade.cplus.Movenda;
import entidade.cplus.Movendadevolucao;
import entidade.cplus.Movendadocref;
import entidade.cplus.Movendaprod;
import entidade.cplus.Movendaprodcomp;
import entidade.cplus.Movendaproddevolucaocompra;
import entidade.cplus.Movendaprodserial;
import entidade.cplus.Moventrada;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Moventradaprodserial;
import entidade.cplus.Nfceletronica;
import entidade.cplus.Orcamento;
import entidade.cplus.Orcamentoprod;
import entidade.cplus.Pedidoitem;
import entidade.cplus.Produto;
import entidade.cplus.Produtocaracteristica;
import entidade.cplus.Produtocodigo;
import entidade.cplus.Produtoestoque;
import entidade.cplus.Produtopreco;
import entidade.cplus.Produtoserial;
import entidade.cplus.Sistemaacesso;
import entidade.cplus.Tipomovimento;
import entidade.cplus.Uf;
import entidade.cplus.Unidade;
import entidade.cplus.Usuario;
import entidade.cplus.Usuarioacesso;
import entidade.cplus.Vale;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author leonardo
 */
public class QueryCplus {

    public QueryCplus(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /**
     * Função que retorna lista de produtos de entrada, sendo Compra e CST 10 pelo codigo do produto
     * @param codigo
     * @return 
     */
     public List<Moventradaprod> lisProdEntrada(String codigo) {
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("SELECT prod FROM Moventradaprod prod WHERE prod.codprod.codigo =:codigo AND prod.codsituacaotributaria =:CST AND prod.codmoventr.codtipomovimento.flagtipomovimento =:tipoMovimento ORDER BY prod.codmoventr.data DESC");
        query.setParameter("codigo", codigo);
        query.setParameter("tipoMovimento", 'C');
        query.setParameter("CST", "10");
        return query.getResultList();
    }
     /**
     * Função que retorna lista de produtos de entrada, sendo Compra e CST 60 pelo codigo do produto
     * @param codigo
     * @return 
     */
     public List<Moventradaprod> lisProdEntrada2(String codigo) {
        EntityManager em = getEntityManager();
        javax.persistence.Query query = em.createQuery("SELECT prod FROM Moventradaprod prod WHERE prod.codprod.codigo =:codigo AND prod.codsituacaotributaria =:CST AND prod.codmoventr.codtipomovimento.flagtipomovimento =:tipoMovimento ORDER BY prod.codmoventr.data DESC");
        query.setParameter("codigo", codigo);
        query.setParameter("tipoMovimento", 'C');
        query.setParameter("CST", "60");
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que pesquisa por alteraÃ§Ã£o de data na tabela estoque do Cplus
     *
     * @param dataInicio
     * @param dataFim
     * @return uma lista de Produtos
     */
    public List<Produtoestoque> resultProData(Calendar dataInicio, Calendar dataFim) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produtoestoque p WHERE p.lastChange BETWEEN :dataInicio AND :dataFim");
        query.setParameter("dataInicio", dataInicio.getTime());//primeiro parametro  
        query.setParameter("dataFim", dataFim.getTime());//primeiro parametro 
        return query.getResultList();
    }
    
    public List<Produtoestoque> resultProData(Calendar dataInicio) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produtoestoque p WHERE p.lastChange >= :dataInicio");
        query.setParameter("dataInicio", dataInicio.getTime());//primeiro parametro  
        ///query.setParameter("dataFim", dataFim.getTime());//primeiro parametro 
        return query.getResultList();
    }

    public List<Produtoestoque> listEstoquesPorProd(String codProduto) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produtoestoque p WHERE p.produtoestoquePK.codprod = :codProduto");
        query.setParameter("codProduto", codProduto);//primeiro parametro        
        return query.getResultList();
    }

    public List<Contareceber> resultPorFlag(String flagCancelada) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Contareceber p WHERE  p.codmovenda = :codigoPedido AND p.flagcancelada = :flagCancelada");
        query.setParameter("flagCancelada", flagCancelada);
        query.setParameter("flag", (char) 'N');

        return query.getResultList();
    }

    public List<Contareceber> resultPorData(Calendar dataInicio, Calendar dataFim) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Contareceber p WHERE p.flagpago = :flagPago AND p.lastChange BETWEEN :dataInicio AND :dataFim");
        query.setParameter("dataInicio", dataInicio.getTime());
        query.setParameter("dataFim", dataFim.getTime());
        query.setParameter("flagPago", 'Y');

        return query.getResultList();
    }

    public List<Produtocodigo> listProdutoCodigo(String codProduto) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produtocodigo p where p.codprod.codprod =:codProduto");
        query.setParameter("codProduto", codProduto);//primeiro parametro                 
        return query.getResultList();
    }

    public List<Produto> listagemProdutoPorSerial(String serial) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT p.codprod FROM Produtoserial p where p.serial =:serial");
        query.setParameter("serial", serial);//primeiro parametro        
        return query.getResultList();
    }

    public List<Produto> listagemProdutoPorLocalizacao(String codLoc) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Produto p where p.codloc =:codLoc");
        query.setParameter("codLoc", codLoc);//primeiro parametro        
        return query.getResultList();
    }
    /**
     * FunÃ§Ã£o que lista todos os seriais da saida
     *
     * @param codMoVenda
     * @return
     */
    public List<Movendaprodserial> listSerialSaida(String codMoVenda) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT serSaida FROM Movendaprodserial serSaida WHERE sersaida.codmovprod.codmovenda.codmovenda =:codMoVenda");
        query.setParameter("codMoVenda", codMoVenda);
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que verifica devoluÃ§Ã£o feita pelo cliente
     *
     * @param codMovEntrada
     * @param codMovSaida
     * @return
     */
    public List<Movendadevolucao> listagemMoVendaDevolucaoCliente(String codMovEntrada, String codMovSaida) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT dev FROM Movendadevolucao dev WHERE dev.codmoveprod =:codMovEntrada AND dev.codmovprod =:codMovSaida");
        query.setParameter("codMovSaida", codMovSaida);
        query.setParameter("codMovEntrada", codMovEntrada);
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que verifica se o item jÃ¡ existe na entrada e se o preÃ§o Ã©
     * igual ao vendido
     *
     * @param codMovEntrada
     * @param codProduto
     * @param valorUnitario
     * @return
     */
    public List<Moventradaprod> listagemMovEntradaProd(String codMovEntrada, String codProduto, BigDecimal valorUnitario) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod FROM Moventradaprod prod WHERE prod.codmoventr.codmoventr =:codMovEntrada AND prod.codprod.codprod =:codProduto AND prod.valorunitario =:valorUnitario");
        query.setParameter("codMovEntrada", codMovEntrada);
        query.setParameter("codProduto", codProduto);
        query.setParameter("valorUnitario", valorUnitario);
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que verifica se jÃ¡ existe uma entrada de cliente sem nota
     * emitida
     *
     * @param tipoMovimentoCodigo
     * @param codCliente
     * @return
     */
    public List<Moventrada> listagemMoventradaCliente(String tipoMovimentoCodigo, String codCliente) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ent FROM Moventrada ent WHERE ent.codtipomovimento.codigo =:tipoMovimentoCodigo AND ent.codcli.codcli =:codCliente AND ent.numnota IS NULL");
        query.setParameter("tipoMovimentoCodigo", tipoMovimentoCodigo);
        query.setParameter("codCliente", codCliente);
        return query.getResultList();
    }


    public List<Produtoserial> resultadoPorCodigoSaida(String codMoVenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT SAIDASERIAL.codprodutoserial FROM Movendaprodserial saidaSerial WHERE SAIDASERIAL.codmovprod.codmovenda.codmovenda = :codMoVenda");
        query.setParameter("codMoVenda", codMoVenda);//primeiro parametro
        return query.getResultList();
    }

    /**
     * funÃ§Ã£o que retorna uma lista de seriais atraves do codigo de entrada
     *
     * @param codMovEntrada
     * @return
     */
    public List<Produtoserial> resultadoPorCodigoEntrada(String codMovEntrada) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ENTRADASERIAL.codprodutoserial FROM Moventradaprodserial entradaSerial WHERE entradaSerial.codmoveprod.codmoventr.codmoventr = :codMovEntrada");
        query.setParameter("codMovEntrada", codMovEntrada);//primeiro parametro
        return query.getResultList();
    }

    /**
     * FuÃ§Ã£o que pesquisa serial usa like acha qualquer combinaÃ§Ã£o
     *
     * @param serialProduto
     * @return lista com a conbinação encontrada
     */
    public List<Produtoserial> resultadoSerialLike(String serialProduto) {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("SELECT prodSerial FROM Produtoserial prodSerial WHERE PRODSERIAL.serial LIKE :serialProduto");
        query.setParameter("serialProduto", "%" + serialProduto + "%");//primeiro parametro
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que presquisa o serial exato
     *
     * @param serial Recebe um String com o serial
     * @return retorna uma list da classe entidades.Produtoserial
     */
    public List<Produtoserial> pesquisaSerialExato(String serial) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT ser FROM Produtoserial ser WHERE ser.serial =:serial");
        query.setParameter("serial", serial);
        return query.getResultList();
    }
    
     public List<Produtoserial> pesquisaCodProdutoSerial(String codProdutoSerial) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT ser FROM Produtoserial ser WHERE ser.codprodutoserial =:codProdutoSerial");
        query.setParameter("codProdutoSerial", codProdutoSerial);
        return query.getResultList();
    }

    /**
     * Função que incrementa a tabela ProdutoSerial
     *
     * @return String Retorna o valor do ultimo registro da tabela Produtoserial
     * campo codprodutoserial e adiciona 1
     */
    public int incrementProdutoSerial() {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT MAX(cp.codprodutoserial) FROM Produtoserial cp");//passa o valor do ultimo registro e acrecenta 1
        int increment = 0;
        for (Object m : query.getResultList()) {   //passa o valor de um objeto
            increment = Integer.parseInt(m.toString());//converte objeto em string e depois em inteiro           
        }
        return increment;
    }

    /**
     * Essa é a query criada: "SELECT MAX(cp.codprodutoserial) FROM
     * Produtoserial cp"
     *
     * @return String Retorna o valor do ultimo registro da tabela Produtoserial
     * campo codprodutoserial e adiciona 1
     */
    public int incrementMovEntradaProdSerial() {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT MAX(me.codmoventradaprodserial) FROM Moventradaprodserial me");//passa o valor do ultimo registro e acrecenta 1
        int increment = 0;
        for (Object m : query.getResultList()) {   //passa o valor de um objeto
            increment = Integer.parseInt(m.toString());//converte objeto em string e depois em inteiro           
        }
        return increment;
    }

    public List<Moventradaprodserial> listagemSerialEntrada(String codMovEntrada) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Moventradaprodserial p where p.codmoveprod.codmoventr.codmoventr =:codMovEntrada");
        query.setParameter("codMovEntrada", codMovEntrada);//primeiro parametro        
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que recebe serial, ou de Entrada de serial
     *
     * @param serial
     * @return lista Moventradaprodserial
     */
    public List<Moventradaprodserial> listagemEntradaSerial(String serial) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Moventradaprodserial ven WHERE ven.codprodutoserial.serial =:serial");
        query.setParameter("serial", serial);//primeiro parametro          
        return query.getResultList();
    }

    public List<Movendaprodserial> listagemSaidaSerial(String serialLike) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movendaprodserial ven WHERE ven.codprodutoserial.serial like :serial");
        query.setParameter("serial", "%" + serialLike + "%");//primeiro parametro          
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que recebe codMovProdSerial, ou de saidas de serial
     *
     * @param serial serial exato
     * @return lista Movendaprodserial
     */
    public List<Movendaprodserial> listagemSaidaSerialExato(String serial) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movendaprodserial ven WHERE ven.codprodutoserial.serial =:serial");
        query.setParameter("serial", serial);//primeiro parametro          
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que verifica se jÃ¡ existe uma saida para Fornecedor sem nota
     * emitida e nÃ£o for venda
     *
     * @param tipoMovimentoCodigo
     * @param codFornecedor
     * @return
     */
    public List<Movenda> listagemMovendaFornecedor(String tipoMovimentoCodigo, String codFornecedor) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movenda ven WHERE ven.codtipomovimento.codigo =:tipoMovimentoCodigo AND ven.codForn.codforn =:codFornecedor AND ven.numnota IS NULL AND ven.flagvenda =:flagVenda");
        query.setParameter("tipoMovimentoCodigo", tipoMovimentoCodigo);
        query.setParameter("codFornecedor", codFornecedor);
        query.setParameter("flagVenda", 'N');
        return query.getResultList();
    }

    public List<Movendaprod> listagemMovSaidaProd(String codMovSaida, String codProduto, BigDecimal valorUnitario) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod FROM Movendaprod prod WHERE prod.codmovenda.codmovenda =:codMovSaida AND prod.codprod.codprod =:codProduto AND prod.valorunitario =:valorUnitario");
        query.setParameter("codMovSaida", codMovSaida);
        query.setParameter("codProduto", codProduto);
        query.setParameter("valorUnitario", valorUnitario);
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que verifica se a saida para Cliente sem nota emitida enï¿½o for
     * Venda
     *
     * @param tipoMovimentoCodigo
     * @param codCliente
     * @return
     */
    public List<Movenda> listagemMovendaCliente(String tipoMovimentoCodigo, String codCliente) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movenda ven WHERE ven.codtipomovimento.codigo =:tipoMovimentoCodigo AND ven.codcli.codcli =:codCliente AND ven.numnota IS NULL AND ven.flagvenda =:flagVenda");
        query.setParameter("tipoMovimentoCodigo", tipoMovimentoCodigo);
        query.setParameter("codCliente", codCliente);
        query.setParameter("flagVenda", 'N');
        return query.getResultList();
    }

    /**
     * @param codMovEntradaProd
     * @return Lista da classe Moventradaprodserial
     */
    public List<Moventradaprodserial> listagemSerialEntradaProd(String codMovEntradaProd) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Moventradaprodserial p where p.codmoveprod.codmoveprod =:codMovEntradaProd");
        query.setParameter("codMovEntradaProd", codMovEntradaProd);//primeiro parametro        
        return query.getResultList();
    }

    public List<Unidade> resultPorUnidadeProduto(String codigoUnidade) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Unidade p WHERE p.codigo = :codigoUnidade");
        query.setParameter("codigoUnidade", codigoUnidade);//primeiro parametro
        return query.getResultList();
    }
    /**
     * Não funciona pos o c-plus tenta usar o mesmo cod
     * @return 
     */
    public String incrementAuditoria() { 
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT MAX(cast(trim(m.codauditoria) as integer)) FROM Auditoria m");
        Object result = query.getSingleResult();
        String sequencia = result == null ? "0" : result.toString();
        return String.format("%09d", Integer.valueOf(sequencia) + 1);
       // String increment = null;
       // for (Object m : query.getResultList()) {   //passa o valor de um objeto
       //     int res = Integer.parseInt(m.toString());//converte objeto em string e depois em inteiro
      //      res++;
      //      increment = String.valueOf(res);
       // }
       // return increment;
    }

    /**
     * Função eu verifica se a nota já está relacionada com a
     * devolução de compra
     *
     * @param codEntrada
     * @param codSaida
     * @return
     */
    public List<Movdocreferenciado> relacaoNotaDevolucaoFornecedor(String codEntrada, String codSaida) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT dev FROM Movdocreferenciado dev WHERE dev.identidadeorigem =:codSaida AND dev.identidadeorigemref =:codEntrada");
        query.setParameter("codSaida", codSaida);
        query.setParameter("codEntrada", codEntrada);
        return query.getResultList();
    }

    public List<Movdocreferenciado> relacaoNotaDevolucaoFornecedorSaida(String codSaida) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT dev FROM Movdocreferenciado dev WHERE dev.identidadeorigem =:codSaida");
        query.setParameter("codSaida", codSaida);
        return query.getResultList();
    }

    /**
     * Função qeu lista devolução de compra pelo produto da saida
     *
     * @param codMovProdSaida
     * @return
     */
    public List<Movendaproddevolucaocompra> listagemControlaDevolucaoPorSaidaProd(String codMovProdSaida) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT dev FROM Movendaproddevolucaocompra dev WHERE dev.codmovprod.codmovprod =:codMovSaida");
        query.setParameter("codMovSaida", codMovProdSaida);
        return query.getResultList();
    }
    
    public List<Produtoestoque> resultComEstoque() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produtoestoque p WHERE p.estatu > 0.00");
      //  query.setParameter("valor", codProduto);//primeiro parametro        
        return query.getResultList();
    }

    public List<Produtopreco> resultTodosPrecos(String codigoProduto) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produtopreco p where p.codprod.codprod =:valor");
        query.setParameter("valor", codigoProduto);

        return query.getResultList();
    }

    public List<Produtocodigo> listagemProdutoCodigo(String codProduto) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Produtocodigo p where p.codprod.codprod =:codProduto");
        query.setParameter("codProduto", codProduto);//primeiro parametro        
        return query.getResultList();
    }

    public List<Moventradaprod> listagemMovEntradaProdPorEntrada(String codMovEntrada) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod FROM Moventradaprod prod WHERE prod.codmoventr.codmoventr =:codMovEntrada");
        query.setParameter("codMovEntrada", codMovEntrada);
        return query.getResultList();
    }

    public List<Campocustomvalor> resultCampoPersonalisado(String codProduto) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Campocustomvalor p WHERE p.identidadeorigem =:codProduto");
        query.setParameter("codProduto", codProduto);//primeiro parametro
        return query.getResultList();
    }

    public List<Produto> listProduto(String codProduto) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produto p WHERE p.codprod = :codProduto");
        query.setParameter("codProduto", codProduto);//primeiro parametro
        return query.getResultList();
    }

    public List<Calculoicms> resultCalculoIcms(String DescricaoIcms) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Calculoicms p WHERE p.nomecalculoicms LIKE :DescricaoIcms");
        query.setParameter("DescricaoIcms", "%" + DescricaoIcms + "%");//primeiro parametro
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que pesquisa por qualquer parte do nome do cliente
     *
     * @param nomeCliente
     * @return
     */
    public List<Cliente> listagemClientePorQualquerParteNome(String nomeCliente) {
        if (!"".equals(nomeCliente)) {
            nomeCliente = nomeCliente.trim();
            String[] listPalavras = nomeCliente.split(" ");
            String quer = "";
            for (int cont = 0; listPalavras.length > cont; cont++) {
                if (cont == 0) {
                    quer = " cli.nomecli LIKE :nomeCli" + cont;
                } else {
                    quer = quer + " AND cli.nomecli LIKE :nomeCli" + cont;
                }
            }
            quer = quer + " ORDER BY cli.nomecli";
            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT cli  FROM Cliente cli  WHERE " + quer);

            for (int cont = 0; listPalavras.length > cont; cont++) {
                query.setParameter("nomeCli" + cont, "%" + listPalavras[cont].trim() + "%");//primeiro parametro 
            }
            return query.getResultList();
        } else {
            return null;
        }
    }

    /**
     * FunÃ§Ã£o que retorna uma lista de clientes de uma determinada
     * caracteristica, com a data inicail de atualizaÃ§Ã£o
     *
     * @param caracCliente
     * @param dataInicio
     * @return
     */
    private List<Cliente> listClienteData(String caracCliente, Calendar dataInicio) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p.codcli FROM Clientecaracteristica p WHERE p.codcaracteristicapessoa.codcaracteristicapessoa = :caracCliente AND p.codcli.lastChange >= :dataInicio");
        query.setParameter("dataInicio", dataInicio.getTime());
        query.setParameter("caracCliente", caracCliente);
        return query.getResultList();
    }
    
    public List<Cliente> listClienteData(Calendar dataInicio) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.lastChange > :dataInicio");
        query.setParameter("dataInicio", dataInicio.getTime());
        return query.getResultList();
    }

    /**
     * Traz uma lista com Clientes de um determinada caracteristica
     *
     * @param caracCliente
     * @return
     */
    public List<Cliente> listCaracteristicaCliente(String caracCliente) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p.codcli FROM Clientecaracteristica p WHERE p.codcaracteristicapessoa.codcaracteristicapessoa = :caracCliente");
        query.setParameter("caracCliente", caracCliente);
        return query.getResultList();
    }
    
     public List<Clientecaracteristica> listClienteCaracteristica(String codCaracteristicaPessoa, String codCliente) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Clientecaracteristica p WHERE p.codcli.codcli = :codCliente AND p.codcaracteristicapessoa.codcaracteristicapessoa =:codCaracteristicaPessoa");
        query.setParameter("codCliente", codCliente);
        query.setParameter("codCaracteristicaPessoa", codCaracteristicaPessoa);
        return query.getResultList();
    }

    /**
     * Traz um Clientes de um determinada caracteristica
     *
     * @param caracCliente
     * @param codCliente
     * @return
     */
    public List<Cliente> listCaracteristicaCliente(String caracCliente, String codCliente) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p.codcli FROM Clientecaracteristica p WHERE p.codcaracteristicapessoa.codcaracteristicapessoa = :caracCliente AND p.codcli.codcli =:codCliente");
        query.setParameter("caracCliente", caracCliente);
        query.setParameter("codCliente", codCliente);
        return query.getResultList();
    }
    
    public List<Cliente> listClienteEmail(String caracCliente, String email) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p.codcli FROM Clientecaracteristica p WHERE p.codcaracteristicapessoa.codcaracteristicapessoa = :caracCliente AND p.codcli.email =:email");
        query.setParameter("caracCliente", caracCliente);
        query.setParameter("email", email);
        return query.getResultList();
    }

    public List<Cliente> resultUfCliente(String ufCliente) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.estado = :ufCliente");
        query.setParameter("ufCliente", ufCliente);//primeiro parametro
        return query.getResultList();
    }

    public List<Cliente> resultUfCliente(String ufCliente, char flagFisica) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.estado = :ufCliente AND p.flagfisica =:flagFisica ORDER BY p.codtipomovimento.nometipomovimento");
        query.setParameter("ufCliente", ufCliente);//primeiro parametro
        query.setParameter("flagFisica", flagFisica);
        return query.getResultList();
    }

    public List<Cliente> resultPortCnpjOuCpf(String cnpjOuCpf) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.cnpj =:cnpjOuCpf OR p.cpf =:cnpjOuCpf");
        query.setParameter("cnpjOuCpf", cnpjOuCpf);//primeiro parametro
        return query.getResultList();
    }

    public List<Nfceletronica> resultPorCodMovenda(String codMovenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Nfceletronica p WHERE p.codmovenda.codmovenda =:codMovenda");
        query.setParameter("codMovenda", codMovenda);//primeiro parametro
        return query.getResultList();
    }

    public List<Moentregaprod> resultMoentregaProd(String codMovProd) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Moentregaprod devProd WHERE devProd.codmovprod =:codMovProd");
        query.setParameter("codMovProd", codMovProd);//primeiro parametro              
        return query.getResultList();
    }

    public List<Moentrega> resultMoentrega(String codMovVenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Moentrega devProd WHERE devProd.codmovenda =:codMovVenda");
        query.setParameter("codMovVenda", codMovVenda);//primeiro parametro              
        return query.getResultList();
    }

    public List<Movendaprodcomp> resultMovendaprodcomp(String codMovProd) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Movendaprodcomp devProd WHERE devProd.codmovprod.codmovprod =:codMovProd");
        query.setParameter("codMovProd", codMovProd);//primeiro parametro              
        return query.getResultList();
    }

    public List<Nfceletronica> resultNfceletronica(String codMoVenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT nfc FROM Nfceletronica nfc WHERE nfc.codmovenda.codmovenda =:codMoVenda");
        query.setParameter("codMoVenda", codMoVenda);//primeiro parametro              
        return query.getResultList();
    }

    public List<Documentodocref> resultDocumentodocref(String codMovVenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Documentodocref devProd WHERE devProd.codmovenda =:codMovVenda");
        query.setParameter("codMovVenda", codMovVenda);//primeiro parametro              
        return query.getResultList();
    }

    public List<Documento> resultDocumento(String numeroPedido) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Documento devProd WHERE devProd.numeropedido =:numeroPedido");
        query.setParameter("numeroPedido", numeroPedido);//primeiro parametro              
        return query.getResultList();
    }

    public List<Movendadocref> resultMovendaDocRef(String codMovenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Movendadocref devProd WHERE devProd.codmovenda.codmovenda =:codMovenda");
        query.setParameter("codMovenda", codMovenda);//primeiro parametro              
        return query.getResultList();
    }

    public List<Documento> resultDocumento(Date inicio, Date fim) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Documento devProd WHERE devProd.numnota IS NOT NULL AND devprod.dataemissao BETWEEN :inicio AND :fim");
        query.setParameter("inicio", inicio);
        query.setParameter("fim", fim);
        return query.getResultList();
    }

    public List<Documento> resultDocumento(Date inicio, Date fim, String ufDiferenteDe) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Documento devProd WHERE devProd.numnota IS NOT NULL AND devProd.destestado !=:ufDiferenteDe AND devprod.dataemissao BETWEEN :inicio AND :fim");
        query.setParameter("inicio", inicio);
        query.setParameter("fim", fim);
        query.setParameter("ufDiferenteDe", ufDiferenteDe);
        return query.getResultList();
    }

    public List<Movecfdocumento> resultMovendaECFDocumento(String codigoMovVenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Movecfdocumento devProd WHERE devProd.codmovenda.codmovenda =:codigoMovVenda");
        query.setParameter("codigoMovVenda", codigoMovVenda);//primeiro parametro           
        return query.getResultList();
    }

    public List<Movendaproddevolucaocompra> resultMovendaProdutoDevolucaoCompa(String codigoMovProd) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT devProd FROM Movendaproddevolucaocompra devProd WHERE devProd.codmovprod.codmovprod =:codigoMovProd");
        query.setParameter("codigoMovProd", codigoMovProd);//primeiro parametro             
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o com alguns filtros para listagem de operaÃ§Ãµes
     *
     * @param flagDevolucao se for devolucao Y senao N
     * @param inativo se for inativo Y senao N
     * @param tipoMovimento se for Venda V se for saida S se fou Compra C se for
     * Entrada E
     * @param fornecedorCliente se for fornecedor F se for cliente C
     * @param pesquisa se refere ao termo da pesquisa
     * @param descricao se refere true para descriï¿½ï¿½o da operaï¿½ï¿½o ou
     * false para o codigo da operaï¿½ï¿½o
     * @return
     */
    public List<Tipomovimento> listagemOperacao(char flagDevolucao, char inativo, char tipoMovimento, char fornecedorCliente, String pesquisa, boolean descricao) {
        EntityManager em = getEntityManager();
        String tipoPes;
        if ("".equals(pesquisa)) {
            tipoPes = "";
        } else {
            tipoPes = " AND ";
            if (descricao) {
                tipoPes = tipoPes + "mov.nometipomovimento LIKE :pesquisa";
            } else {
                tipoPes = "mov.codigo LIKE :pesquisa";
            }
        }
        Query query = em.createQuery("SELECT mov FROM Tipomovimento mov WHERE mov.flagdevolucao =:flagDevolucao AND mov.flagtipomovimento =:tipoMovimento AND mov.flagforncli =:fornecedorCliente AND mov.flaginativo =:inativo" + tipoPes);
        query.setParameter("flagDevolucao", flagDevolucao);//primeiro parametro 
        query.setParameter("tipoMovimento", tipoMovimento);
        query.setParameter("fornecedorCliente", fornecedorCliente);
        query.setParameter("inativo", inativo);
        if (!"".equals(pesquisa)) {
            query.setParameter("pesquisa", "%" + pesquisa + "%");
        }
        return query.getResultList();
    }

   

    public List<Movendaprod> resultProdutoVenda(String codigoProduto, Boolean tipoMovimento, Integer maxResultado) {
        String quer = "";
        if (tipoMovimento) {
            quer = quer + " AND tipoMov.flagtipomovimento =:tipoMovimento";
        }
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT MOVPROD FROM Movendaprod movProd INNER JOIN MOVPROD.codmovenda mov INNER JOIN mov.codtipomovimento tipoMov WHERE MOVPROD.codprod.codprod =:codigoProduto" + quer + " ORDER BY mov.data DESC");
        query.setParameter("codigoProduto", codigoProduto);//primeiro parametro 
        if (tipoMovimento) {
            char val = 'V';
            query.setParameter("tipoMovimento", val);//primeiro parametro 
        }
        query.setMaxResults(maxResultado);

        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que retorna listagem de saidas com tipo de movimento e data
     *
     * @param codigoProduto
     * @param tipoMovimento
     * @param dataInicial
     * @param dataFinal
     * @return List Movendaprod
     */
    public List<Movendaprod> resultProdutoVenda(String codigoProduto, char tipoMovimento, Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod FROM Movendaprod prod WHERE prod.codprod.codprod =:codigoProduto AND prod.codmovenda.codtipomovimento.flagtipomovimento =:tipoMovimento AND prod.codmovenda.data BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("codigoProduto", codigoProduto);
        query.setParameter("tipoMovimento", tipoMovimento);
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    /**
     * Função que separa as palavras de uma frase e converte em dermos
     * separados
     *
     * @param nomeProduto
     * @param ativo resultado de produtos ativos
     * @return retorna uma lista de Produtos
     */
    public List<Produto> resultPorNomeProdutoOuCodigo(String nomeProduto, Boolean ativo, int maxResul) {
        if (!"".equals(nomeProduto)) {
            nomeProduto = nomeProduto.trim();
            String[] listPalavras = nomeProduto.split(" ");

            String querCodigo = "";
            if (listPalavras.length < 2) {
                querCodigo = "p.codigo LIKE :codigo";
            }

            String quer = "";
            for (int cont = 0; listPalavras.length > cont; cont++) {
                if (cont == 0) {
                    String querOr = "";
                    if (listPalavras.length < 2) {
                        querOr = " OR";
                    }
                    quer = querOr + " p.nomeprod LIKE :nomeProd" + cont;
                } else {
                    quer = quer + " AND p.nomeprod LIKE :nomeProd" + cont;
                }
            }
            if (ativo) {
                quer = quer + " AND p.flaginativo =:flagInativo";
            }
            quer = quer + " ORDER BY EST.estatu DESC";

            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT p FROM Produtoestoque est INNER JOIN EST.produto p WHERE " + querCodigo + quer).setMaxResults(maxResul);
            if (listPalavras.length < 2) {
                query.setParameter("codigo", "%" + nomeProduto.trim() + "%");//primeiro parametro 
            }
            for (int cont = 0; listPalavras.length > cont; cont++) {
                query.setParameter("nomeProd" + cont, "%" + listPalavras[cont].trim() + "%");//primeiro parametro 
            }
            if (ativo) {
                char inativo = 'N';
                query.setParameter("flagInativo", inativo);
            }
            return query.getResultList();
        } else {
            return null;
        }
    }

    public List<Produto> resultPorOrigemProduto(Character origem) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod FROM Produto prod WHERE prod.flagorigemproduto =:origem");
        query.setParameter("origem", origem);
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que pesquisa lista de produtos por Codigo de Entrada
     *
     * @param codMovEntrada
     * @return lista de Produtos
     */
    public List<Produto> resultProdutosPorCodigoEntrada(String codMovEntrada) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT MOVPROD.codprod FROM Moventradaprod movProd WHERE MOVPROD.codmoventr.codmoventr =:codMovEntrada");
        query.setParameter("codMovEntrada", codMovEntrada);//primeiro parametro      
        return query.getResultList();
    }

    /**
     * FunÃ§Ã£o que pesquisa lista de entradas pelo numero da nota
     *
     * @param numeroNota
     * @return lista de Moventrada
     */
    public List<Moventrada> resultadoPelaNotaEntrada(Integer numeroNota) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Moventrada mov WHERE mov.numnota =:numeroNota");
        query.setParameter("numeroNota", numeroNota);//primeiro parametro      
        return query.getResultList();
    }

    public List<Moventrada> resultadoPelaDataEntrada(Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Moventrada mov WHERE mov.data BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataInicial);//primeiro parametro  
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    /**
     * Resultado e entrada por codcli do cliente
     *
     * @param nomeCliente
     * @return
     */
    public List<Moventrada> resultadoPeloClienteEntrada(String nomeCliente) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Moventrada mov WHERE mov.codcli.codcli =:nomeCliente");
        query.setParameter("nomeCliente", nomeCliente);//primeiro parametro      
        return query.getResultList();
    }
    
    public List<Moventrada> resultPorProduto(String codigoProduto, Boolean tipoMovimento, Integer maxResultado) {
        String quer = "";
        if (tipoMovimento) {
            quer = quer + " AND tipoMov.flagtipomovimento =:tipoMovimento";
        }
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT MOVPROD.codmoventr FROM Moventradaprod movProd INNER JOIN MOVPROD.codmoventr mov INNER JOIN mov.codtipomovimento tipoMov WHERE MOVPROD.codprod.codigo =:codigoProduto" + quer + " ORDER BY mov.data DESC");
        query.setParameter("codigoProduto", codigoProduto);//primeiro parametro 
        if (tipoMovimento) {
            char val = 'C';
            query.setParameter("tipoMovimento", val);//primeiro parametro 
        }
        query.setMaxResults(maxResultado);
        return query.getResultList();
    }

     /**
     * Função que retorna uma lista de entradas o tipoMovimento for true  
     * será compras, se for false será tudo maxResultado siginifica o numero de
     * resultados retornados a ordem Ã© pela ultima data de entrada
     *
     * @param codigoProduto
     * @param tipoMovimento
     * @param maxResultado
     * @return
     */
    public List<Moventradaprod> resultProdutoEntrada(String codigoProduto, Boolean tipoMovimento, Integer maxResultado) {
        String quer = "";
        if (tipoMovimento) {
            quer = quer + " AND tipoMov.flagtipomovimento =:tipoMovimento";
        }
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT MOVPROD FROM Moventradaprod movProd INNER JOIN MOVPROD.codmoventr mov INNER JOIN mov.codtipomovimento tipoMov WHERE MOVPROD.codprod.codprod =:codigoProduto" + quer + " ORDER BY mov.data DESC");
        query.setParameter("codigoProduto", codigoProduto);//primeiro parametro 
        if (tipoMovimento) {
            char val = 'C';
            query.setParameter("tipoMovimento", val);//primeiro parametro 
        }
        query.setMaxResults(maxResultado);
        return query.getResultList();
    }
    
    /**
     * Função que retorna uma lista a partir do codProd e do cod da Entrada
     *
     * @param codigoProduto
     * @param codigoMovEntrada
     * @return
     */
    public List<Moventradaprod> resultProdutoEntrada(String codigoProduto, String codigoMovEntrada) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Moventradaprod p WHERE p.codprod.codprod = :codigoProduto AND p.codmoventr.codmoventr =:codigoMovEntrada");
        query.setParameter("codigoProduto", codigoProduto);//primeiro parametro 
        query.setParameter("codigoMovEntrada", codigoMovEntrada);//primeiro parametro 
        return query.getResultList();
    }

    /**
     * Funï¿½ï¿½o que retorna uma lista a partir do numero da Nota da Entrada
     *
     * @param numeroNota
     * @return
     */
    public List<Moventradaprod> resultProdutoEntrada(Integer numeroNota) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Moventradaprod p WHERE p.codmoventr.numnota = :codigoProduto");
        query.setParameter("numeroNota", numeroNota);//primeiro parametro         
        return query.getResultList();
    }

    /**
     * Funï¿½ï¿½o que procura todos os produtos com entrada antes ou na mesma
     * data informada tambem filtra por operaï¿½ï¿½o que atualiza estoque e
     * somente compra ou nï¿½o
     *
     * @param codigoProduto
     * @param dataFinal
     * @param somenteCompra
     * @return
     */
    public List<Moventradaprod> resultProdutoEntrada(String codigoProduto, Date dataFinal, boolean somenteCompra) {
        String quer = "";
        if (somenteCompra) {
            quer = quer + " AND p.codmoventr.codtipomovimento.flagtipomovimento =:tipoMovimento";
        }
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Moventradaprod p WHERE p.codprod.codprod = :codigoProduto AND p.codmoventr.dataemissao <=:dataFinal AND p.codmoventr.codtipomovimento.flagatualizaestoque =:controlaEstoque" + quer + " ORDER BY p.codmoventr.data DESC");
        query.setParameter("codigoProduto", codigoProduto);
        query.setParameter("dataFinal", dataFinal);
        query.setParameter("controlaEstoque", 'Y');
        if (somenteCompra) {
            char val = 'C';
            query.setParameter("tipoMovimento", val);//primeiro parametro 
        }
        return query.getResultList();
    }

    /**
     * Funï¿½ï¿½o que retorna lista de produto entrada
     *
     * @param codigoProduto
     * @param tipoMovimento
     * @param dataEntradaInicial
     * @param dataEntradaFinal
     * @return List Moventradaprod
     */
    public List<Moventradaprod> resultProdutoEntrada(String codigoProduto, char tipoMovimento, Date dataEntradaInicial, Date dataEntradaFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Moventradaprod p WHERE p.codprod.codprod = :codigoProduto AND p.codmoventr.codtipomovimento.flagtipomovimento =:tipoMovimento AND p.codmoventr.data BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("codigoProduto", codigoProduto);
        query.setParameter("tipoMovimento", tipoMovimento);
        query.setParameter("dataInicial", dataEntradaInicial);
        query.setParameter("dataFinal", dataEntradaFinal);
        return query.getResultList();
    }

    public List<Moventradaprod> resultProdutoEntradaEmissao(Date dataEntradaInicial, Date dataEntradaFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Moventradaprod p WHERE p.codmoventr.dataemissao BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataEntradaInicial);
        query.setParameter("dataFinal", dataEntradaFinal);
        return query.getResultList();
    }

    public List<Movenda> resultUltimaVenda(String codigoProduto, Character tipoMovimento, Integer maxResultado) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Movendaprod movProd INNER JOIN MOVPROD.codmovenda mov INNER JOIN mov.codtipomovimento tipoMov WHERE MOVPROD.codprod.codprod =:codigoProduto AND tipoMov.flagtipomovimento =:tipoMovimento ORDER BY mov.data DESC");
        query.setParameter("codigoProduto", codigoProduto);
        query.setParameter("tipoMovimento", tipoMovimento);
        query.setMaxResults(maxResultado);

        return query.getResultList();
    }

    public List<Movenda> resultPorClientePeloMesVenda(String codCliCplus, Date dataVendaInicial, Date dataVendaFinal, Character tipoMovimento) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Movenda mov WHERE mov.codcli.codcli = :codCliCplus AND mov.codtipomovimento.flagtipomovimento =:tipoMovimento AND mov.data BETWEEN :dataVendaInicial AND :dataVendaFinal");
        query.setParameter("codCliCplus", codCliCplus);
        query.setParameter("dataVendaInicial", dataVendaInicial);
        query.setParameter("dataVendaFinal", dataVendaFinal);
        query.setParameter("tipoMovimento", tipoMovimento);

        return query.getResultList();
    }

    public List<Moventrada> resultUltimaCompra(String codigoProduto, Character tipoMovimento, Integer maxResultado) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Moventradaprod movProd INNER JOIN MOVPROD.codmoventr mov INNER JOIN mov.codtipomovimento tipoMov WHERE MOVPROD.codprod.codprod =:codigoProduto AND tipoMov.flagtipomovimento =:tipoMovimento ORDER BY mov.data DESC");
        query.setParameter("codigoProduto", codigoProduto);//primeiro parametro 
        query.setParameter("tipoMovimento", tipoMovimento);//primeiro parametro 
        query.setMaxResults(maxResultado);
        return query.getResultList();
    }  

    /**
     * Retorna todos os preços do produto
     *
     * @param codProduto
     * @return
     */
    public List<Produtopreco> listPrecos(String codProduto) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produtopreco p where p.codprod.codprod =:codProduto");
        query.setParameter("codProduto", codProduto);
        return query.getResultList();
    }

    /**
     * Retorna o preço pelo codigo
     *
     * @param codProduto
     * @param codPreco
     * @return
     */
    public List<Produtopreco> listPrecos(String codProduto, String codPreco) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produtopreco p where p.codprod.codprod =:codProduto AND p.codpreco.codpreco =:codPreco");
        query.setParameter("codProduto", codProduto);
        query.setParameter("codPreco", codPreco);
        return query.getResultList();
    }

    public List<Produto> resultProPorcentagem(String codigoPreco, BigDecimal valorMenorQue) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p.codprod FROM Produtopreco p where p.codpreco.codpreco =:codigoPreco AND p.margem <:valorMenorQue");
        query.setParameter("valorMenorQue", valorMenorQue);
        query.setParameter("codigoPreco", codigoPreco);

        return query.getResultList();
    }

    public List<Produtocodigo> resultEanProduto(String codProd) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produtocodigo p where p.codprod.codprod =:codProd AND p.codtipocodigo =:tipoCodigo");
        query.setParameter("codProd", codProd);
        query.setParameter("tipoCodigo", "000000002");
        return query.getResultList();
    }

    public List<Produto> resultPorEanProduto(String codigoEanProduto) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p.codprod FROM Produtocodigo p where p.codigo =:codigoEanProduto AND p.codtipocodigo =:tipoCodigo");
        query.setParameter("codigoEanProduto", codigoEanProduto);//primeiro parametro        
        query.setParameter("tipoCodigo", "000000002");//primeiro parametro  
        return query.getResultList();
    }

    public List<Orcamento> resultPorCodigoOrcamento(String codOrc) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Orcamento p WHERE p.codorc = :codOrc");
        query.setParameter("codOrc", codOrc);//primeiro parametro
        return query.getResultList();
    }

    public List<Orcamento> listOrcamentoEntregaTelefone(String entregaTelefone) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Orcamento p WHERE p.entregatelefone =:entregaTelefone");
        query.setParameter("entregaTelefone", entregaTelefone);//primeiro parametro
        return query.getResultList();
    }

    public List<Movenda> resultMovendaPorEntregaTelefone(String entregaTelefone) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Movenda p WHERE  p.entregatelefone = :entregaTelefone");
        query.setParameter("entregaTelefone", entregaTelefone);//primeiro parametro 
        return query.getResultList();
    }
    public List<Movenda> resultMovendaPorEntregaTelefone(String entregaTelefone, char flagcancelada ) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Movenda p WHERE  p.entregatelefone =:entregaTelefone AND p.flagcancelada =:flagcancelada ");
        query.setParameter("entregaTelefone", entregaTelefone);
        query.setParameter("flagcancelada", flagcancelada );
        return query.getResultList();
    }

    public List<Movenda> resultMovendaPorEntregaTelefoneData(Date dataFinal, Date dataInicial) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Movenda p WHERE  p.entregatelefone IS NOT NULL AND p.data BETWEEN :dataInicial AND :dataFinal ");
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }
    

    public List<Movenda> resultMovendaPorDataTipoMovimento(char tipoMovimento, Date dataFinal, Date dataInicial) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Movenda p WHERE p.codtipomovimento.flagtipomovimento =:tipoMovimento AND p.data BETWEEN :dataInicial AND :dataFinal ");
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        query.setParameter("tipoMovimento", tipoMovimento);
        return query.getResultList();
    }

    /**
     * Função que procura todos os produtos com saida antes ou na mesma data
     * informada tambem filtra por operação que atualiza estoque!
     *
     * @param codigoProduto
     * @param dataFinal
     * @return
     */
    public List<Movendaprod> resultProdutoSaida(String codigoProduto, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Movendaprod p WHERE p.codprod.codprod = :codigoProduto AND p.codmovenda.data <=:dataFinal AND p.codmovenda.codtipomovimento.flagatualizaestoque =:controlaEstoque");
        query.setParameter("codigoProduto", codigoProduto);
        query.setParameter("dataFinal", dataFinal);
        query.setParameter("controlaEstoque", 'Y');
        return query.getResultList();
    }
    
    /**
     * Função que procura vendas após a data informada
     * @param codigoProduto
     * @param dataFinal
     * @return 
     */
    public List<Movendaprod> naoVendidoDesDe(String codigoProduto, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Movendaprod p WHERE p.codprod.codprod = :codigoProduto AND p.codmovenda.data >:dataFinal AND p.codmovenda.codtipomovimento.flagatualizaestoque =:controlaEstoque");
        query.setParameter("codigoProduto", codigoProduto);
        query.setParameter("dataFinal", dataFinal);
        query.setParameter("controlaEstoque", 'Y');
        return query.getResultList();
    }
    
    public List<Moventradaprod> compradoAntes(String codProduto, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod FROM Moventradaprod prod WHERE prod.codprod.codprod =:codProduto AND prod.codmoventr.data >:dataFinal");
        query.setParameter("codProduto", codProduto);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    public List<Movendaprod> listMovendaProd(String codMovenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movendaprod ven WHERE ven.codmovenda.codmovenda =:codMovenda");
        query.setParameter("codMovenda", codMovenda);//primeiro parametro 

        return query.getResultList();
    }

    /**
     * Função que retorna saidas relacionadas a cupom fiscal!
     *
     * @param dataInicial
     * @param dataFinal
     * @return
     */
    public List<Movenda> listaMovendaPorDataECupomPedido(Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movenda ven WHERE ven.data BETWEEN :dataInicial AND :dataFinal AND ven.codempresaaux =:cupom");
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        query.setParameter("cupom", 0);

        return query.getResultList();
    }

    /**
     * Funï¿½ï¿½o que retorna todas as saidas de um periodo
     *
     * @param dataInicial
     * @param dataFinal
     * @return
     */
    public List<Movenda> listaMovendaPorDataPedido(Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movenda ven WHERE ven.data BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataInicial);//primeiro parametro
        query.setParameter("dataFinal", dataFinal);//primeiro parametro

        return query.getResultList();
    }

    public List<Movenda> listaMovendaPorNumeroPedido(Integer numPedido) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movenda ven WHERE ven.numped =:numPedido");
        query.setParameter("numPedido", numPedido);//primeiro parametro          
        return query.getResultList();
    }

    public List<Movenda> listaMovendaPorNumeroNFCe(String numNfce) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT nfc.codmovenda FROM Nfceletronica nfc WHERE nfc.codnfceletronica =:numNfce");
        query.setParameter("numNfce", numNfce);//primeiro parametro          
        return query.getResultList();
    }

    public List<Movenda> listaMovendaObservacao(String obcervacao) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movenda ven WHERE ven.obs LIKE :obcervacao ORDER BY VEN.numped DESC");
        query.setParameter("obcervacao", "%" + obcervacao.trim() + "%");//primeiro parametro          
        return query.getResultList();
    }
    
    public List<Movenda> listaMovendaPorProduto(Produto pro, Integer maxResult) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven.codmovenda FROM Movendaprod ven WHERE ven.codprod =:pro ORDER BY VEN.codmovenda.numped DESC");
        query.setParameter("pro", pro);//primeiro parametro 
        query.setMaxResults(maxResult);
        return query.getResultList();
    }
    
    public List<Nfceletronica> listaNFC(String codMovenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT nfc FROM Nfceletronica nfc WHERE nfc.codmovenda.codmovenda =:codMovenda");
        query.setParameter("codMovenda", codMovenda);//primeiro parametro   
        return query.getResultList();
    }

    /**
     * retorna somente autorizados
     *
     * @param dataEmissaoInicial
     * @param dataEmissaoFinal
     * @return
     */
    public List<Nfceletronica> listaNFC(Date dataEmissaoInicial, Date dataEmissaoFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT nfc FROM Nfceletronica nfc WHERE nfc.statusnfceletronica =:status AND nfc.datahoraemissao BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataEmissaoInicial);
        query.setParameter("dataFinal", dataEmissaoFinal);
        query.setParameter("status", "A");
        return query.getResultList();
    }

    public List<Documento> listDocumento(Date dataEmissaoInicial, Date dataEmissaoFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT nfc FROM Documento nfc WHERE nfc.flagcancelada =:status AND nfc.dataemissao BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataEmissaoInicial);
        query.setParameter("dataFinal", dataEmissaoFinal);
        query.setParameter("status", 'N');
        return query.getResultList();
    }

    /**
     * Funï¿½ï¿½o para listagem de saida
     *
     * @param numNota
     * @return
     */
    public List<Movenda> listaMovendaPorNumeroNota(Integer numNota) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movenda ven WHERE ven.numnota =:numNota");
        query.setParameter("numNota", numNota);//primeiro parametro 

        return query.getResultList();
    }

    public List<Movenda> listaMovendaCodMovenda(String CodMovenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movenda ven WHERE ven.codmovenda =:CodMovenda");
        query.setParameter("CodMovenda", CodMovenda);//primeiro parametro 

        return query.getResultList();
    }

    public List<Movenda> listaMovendaPorNumeroCupom(Integer numCupom) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movenda ven WHERE ven.numcupom =:numCupom");
        query.setParameter("numCupom", numCupom);//primeiro parametro 

        return query.getResultList();
    }

    public List<Moventrada> listaMovEntradaPorFabricante(String fabricante) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ent From Produto prod INNER JOIN prod.moventradaprodCollection.codmoventr ent Where prod.codfabricante =:fabricante");
        query.setParameter("fabricante", "000000001");//primeiro parametro 

        return query.getResultList();
    }

    public List<Moventrada> listateste(String fabricante, Date dataInicial, Date dataFinal, Boolean cliFor) {
        EntityManager em = getEntityManager();
        char clienteFornecedor;
        if (cliFor) {
            clienteFornecedor = 'F';
        } else {
            clienteFornecedor = 'C';
        }

        String quer = "select distinct ven.CODMOVENTR, ven.* from MOVENTRADA ven inner join MOVENTRADAPROD entProd on entProd.CODMOVENTR = ven.CODMOVENTR inner join Produto prod on prod.CODPROD = entProd.CODPROD inner join FABRICANTE fab on fab.CODFABRICANTE = prod.CODFABRICANTE where ven.FLAGFORNCLI = ? AND fab.NOMEFABRICANTE = ?  AND ven.\"DATA\" BETWEEN ? AND ?";
        Query query = em.createNativeQuery(quer, Moventrada.class);
        query.setParameter(1, clienteFornecedor);//primeiro parametro 
        query.setParameter(2, fabricante);//primeiro parametro 
        query.setParameter(3, dataInicial);
        query.setParameter(4, dataFinal);

        return query.getResultList();
    }

    /**
     * Fonï¿½ï¿½o que pesquisa por qualquer parte do nome do fornecedor
     *
     * @param nomeFornecedor
     * @return
     */
    public List<Fornecedor> listagemFornecedorPorQualquerParteNome(String nomeFornecedor) {
        if (!"".equals(nomeFornecedor)) {
            nomeFornecedor = nomeFornecedor.trim();
            String[] listPalavras = nomeFornecedor.split(" ");
            String quer = "";
            for (int cont = 0; listPalavras.length > cont; cont++) {
                if (cont == 0) {
                    quer = " forn.nomeforn LIKE :nomeCli" + cont;
                } else {
                    quer = quer + " AND forn.nomeforn LIKE :nomeCli" + cont;
                }
            }
            quer = quer + " ORDER BY forn.nomeforn";
            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT forn  FROM Fornecedor forn  WHERE" + quer);

            for (int cont = 0; listPalavras.length > cont; cont++) {
                query.setParameter("nomeCli" + cont, "%" + listPalavras[cont].trim() + "%");//primeiro parametro 
            }
            return query.getResultList();
        } else {
            return null;
        }
    }

    public List<Cliente> listClienteData(String caracCliente, Calendar dataInicio, Calendar dataFim) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p.codcli FROM Clientecaracteristica p WHERE p.codcaracteristicapessoa.codcaracteristicapessoa = :caracCliente AND p.codcli.lastChange BETWEEN :dataInicio AND :dataFim");
        query.setParameter("dataInicio", dataInicio.getTime());
        query.setParameter("dataFim", dataFim.getTime());
        query.setParameter("caracCliente", caracCliente);
        return query.getResultList();
    }

    public List<Sistemaacesso> listagemSistemaAcesso(String descricaoAcesso) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT u FROM Sistemaacesso u WHERE u.descricao =:descricaoAcesso");
        query.setParameter("descricaoAcesso", descricaoAcesso);
        return query.getResultList();
    }

    public List<Usuarioacesso> listagemUsuarioAcesso(String codUsuario, int codSistemaAcesso) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuarioacesso u WHERE u.usuarioacessoPK.coduser =:codUsuario AND u.usuarioacessoPK.codsistemaacesso =:codSistemaAcesso");
        query.setParameter("codUsuario", codUsuario);//primeiro parametro   
        query.setParameter("codSistemaAcesso", codSistemaAcesso);
        return query.getResultList();
    }

    public List<Usuario> listagemUsuario(String senha) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Usuario ven WHERE ven.senha =:senha");
        query.setParameter("senha", senha);
        return query.getResultList();
    }

    public List<Uf> listUf(String nomeUf) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Uf ven WHERE ven.nomeuf =:nomeUf");
        query.setParameter("nomeUf", nomeUf);//primeiro parametro          
        return query.getResultList();
    }

    public List<Orcamentoprod> listProdutosOrcemanto(String codOrcamento) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Orcamentoprod ven WHERE ven.codorc.codorc =:codOrcamento");
        query.setParameter("codOrcamento", codOrcamento);//primeiro parametro          
        return query.getResultList();
    }

    /**
     * funï¿½ï¿½o qeu acha o calculo de icms dependendo da funï¿½ï¿½o
     *
     * @param codUfOrigem
     * @param codUfDestino
     * @param codCfop seria a CFOP primaria ex 5405
     * @param codCalculoIcms
     * @return
     */
    public List<Calculoicmsestado> listcalculoIcmsEstadol(String codUfOrigem, String codUfDestino, String codCfop, String codCalculoIcms) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT icm FROM Calculoicmsestado icm WHERE icm.coduforigem.coduf =:codUfOrigem AND icm.codufdestino.coduf =:codUfDestino AND icm.codcalculoicms.codcalculoicms =:codCalculoIcms AND icm.codcfop.codcfop =:codCfop");
        query.setParameter("codUfOrigem", codUfOrigem);//primeiro parametro   
        query.setParameter("codUfDestino", codUfDestino);
        query.setParameter("codCfop", codCfop);
        query.setParameter("codCalculoIcms", codCalculoIcms);
        return query.getResultList();
    }

    /**
     * Funï¿½ï¿½o que recebe o ncm da direita para esquerda todos
     *
     * @param codigoClassificacaoFiscal
     * @return List Produto C-plus
     */
    public List<Produto> listaProdutoPorNcm(String codigoClassificacaoFiscal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod From Produto prod WHERE prod.codclassificacaofiscal.codigoclassificacaofiscal like :valor");
        query.setParameter("estatu", BigDecimal.ZERO);//primeiro parametro 
        query.setParameter("valor", codigoClassificacaoFiscal + "%");//primeiro parametro      
        return query.getResultList();
    }
  
     public List<Produto> listLastChange(Date dataInicio) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produto p WHERE p.lastChange > :dataInicio");
        query.setParameter("dataInicio", dataInicio);//primeiro parametro 
        //query.setParameter("dataFim", dataFim);//primeiro parametro
        return query.getResultList();
    }

    /**
     * Função que recebe o ncm da direita para esquerda todos, e se estoque
     * for maior que zero
     *
     * @param codigoClassificacaoFiscal
     * @param filtroEstoque
     * @return List Produto C-plus
     */
    public List<Produto> listaProdutoPorEstoque(String codigoClassificacaoFiscal, Boolean filtroEstoque) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod From Produtoestoque est INNER JOIN est.produto prod WHERE est.estatu >:estatu AND prod.codclassificacaofiscal.codigoclassificacaofiscal like :valor");
        if (filtroEstoque) {
            query.setParameter("estatu", BigDecimal.ZERO);//primeiro parametro 
        } else {
            query.setParameter("estatu", new BigDecimal(-100.00));//primeiro parametro 
        }
        query.setParameter("valor", codigoClassificacaoFiscal + "%");//primeiro parametro 
        return query.getResultList();
    }

    public List<Orcamento> resultPorNumeroOrcamentoCplus(String numeroOrcamento) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Orcamento p where p.numeroorcamento like :valor");
        query.setParameter("valor", ("%" + numeroOrcamento));//primeiro parametro        
        return query.getResultList();
    }

    public List<Orcamento> resultPorStatusOrcamentoCplus(Character statusOrcamento) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Orcamento p where p.flagstatus =:valor");
        query.setParameter("valor", statusOrcamento);//primeiro parametro        
        return query.getResultList();
    }

    public List<Orcamento> resultPorDataOrcamentoCplus(Date dataInicial, Date dataFinal, boolean status) {
        EntityManager em = getEntityManager();
        String str = "";
        char valor = '1';
        if (status) {
            str = " AND p.flagstatus =:valor";
        }
        Query query = em.createQuery("SELECT p FROM Orcamento p where p.data BETWEEN :dataInicial AND :dataFinal" + str + "");
        query.setParameter("dataInicial", dataInicial);//primeiro parametro  
        query.setParameter("dataFinal", dataFinal);//primeiro parametro 
        if (status) {
            query.setParameter("valor", valor);
        }
        return query.getResultList();
    }

    public List<Orcamentoprod> resultPorCodigoOrcamentoCplus(String codigoOrcamento) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Orcamentoprod p where p.codorc.codorc = :valor");
        query.setParameter("valor", codigoOrcamento);//primeiro parametro        
        return query.getResultList();
    }

    public List<Contareceber> resultReceberPorVenda(String codigoMovenda) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Contareceber p where p.codmovenda = :valor");
        query.setParameter("valor", codigoMovenda);//primeiro parametro        
        return query.getResultList();
    }

    /**
     * Lista calculo de Icms Por Estado
     *
     * @param cfopSTForaUf 
     * @param codCalculoIcms 
     * @param filtroPorCfop
     * @return
     */
    public List<Calculoicmsestado> resultCalculoIcmsPorEstado(String cfopSTForaUf, String codCalculoIcms, boolean filtroPorCfop) {
        String queryCfop;
        if (filtroPorCfop) {
            queryCfop = "p.codcfop.codcfop = :cfopSTForaUf AND ";
        } else {
            queryCfop = "";
        }
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Calculoicmsestado p WHERE " + queryCfop + "p.codcalculoicms.codcalculoicms =:codCalculoIcms");
        query.setParameter("codCalculoIcms", codCalculoIcms);
        if (filtroPorCfop) {
            query.setParameter("cfopSTForaUf", cfopSTForaUf);
        }
        return query.getResultList();
    }

    public List<Calculoicmsestado> resultCalculoIcmsPorEstado(Uf UfDestino, Cfop codCfop) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Calculoicmsestado p WHERE p.codufdestino =:UfDestino AND p.codcfop =:codCfop");
        query.setParameter("UfDestino", UfDestino);
        query.setParameter("codCfop", codCfop);

        return query.getResultList();
    }

    public List<Calculoicmsestado> resultCalculoIcmsPorEstado(Uf UfDestino) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Calculoicmsestado p WHERE p.codufdestino =:UfDestino");
        query.setParameter("UfDestino", UfDestino);
        return query.getResultList();
    }

    public List<Calculoicmsestado> resultCalculoIcmsPorEstado(Cfop codCfop) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Calculoicmsestado p WHERE p.codcfop =:codCfop");
        query.setParameter("codCfop", codCfop);
        return query.getResultList();
    }

    public List<Cliente> listCliente(String codCli) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.codcli =:codCli");
        query.setParameter("codCli", codCli);
        return query.getResultList();
    }

    public List<Cliente> listClienteEmail(String codEmail) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.email =:codEmail");
        query.setParameter("codEmail", codEmail);
        return query.getResultList();
    }

    public String incrementNumOrcamento() {
        Query query = getEntityManager().createQuery("SELECT MAX(cast(trim(p.numeroorcamento) as integer)) FROM Orcamentoprod p");
        Object result = query.getSingleResult();
        String sequencia = result == null ? "0" : result.toString();
        return String.format("%06d", Integer.valueOf(sequencia) + 1);
    }
    
     public String incrementOrcProd() {
        Query query = getEntityManager().createQuery("SELECT MAX(cast(trim(p.codorcprod) as integer)) FROM Orcamentoprod p");
        Object result = query.getSingleResult();
        String sequencia = result == null ? "0" : result.toString();
        return String.format("%06d", Integer.valueOf(sequencia) + 1);
    }

    public List<Cliente> listClientCpfCnpj(String cpfCnpj) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.cnpj =:cpfCnpj or p.cpf =:cpfCnpj");
        query.setParameter("cpfCnpj", cpfCnpj);
        return query.getResultList();
    }
public List<Movendaproddevolucaocompra> listagemControlaDevolucaoPorSaida(String codMovSaida, String filtro){
        EntityManager em = getEntityManager();
        Query query;
        if("T".equals(filtro)){
        query = em.createQuery("SELECT prod FROM Movendaproddevolucaocompra prod WHERE prod.codmovprod.codmovenda.codmovenda =:codMovSaida");
        query.setParameter("codMovSaida", codMovSaida); 
        }else if("Y".equals(filtro)){
        query = em.createQuery("SELECT prod FROM Movendaproddevolucaocompra prod WHERE prod.codmovprod.codmovenda.codmovenda =:codMovSaida AND prod.valorcusto = prod.valorretornado");
        query.setParameter("codMovSaida", codMovSaida); 
        }else{
            query = em.createQuery("SELECT prod FROM Movendaproddevolucaocompra prod WHERE prod.codmovprod.codmovenda.codmovenda =:codMovSaida AND prod.valorcusto > prod.valorretornado");
        query.setParameter("codMovSaida", codMovSaida); 
        }
        return query.getResultList();
    }

/**
         * Função que lista Devolucao pelo código da tabela
         * @param codDevolucaoCompra
         * @return 
         */
       public List<Movendaproddevolucaocompra> listagemporcodigoMovProdDevolucao(String codDevolucaoCompra){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod FROM Movendaproddevolucaocompra prod WHERE prod.codmovendaproddevolucaocompra =:codDevolucaoCompra");
        query.setParameter("codDevolucaoCompra", codDevolucaoCompra);      
        return query.getResultList();
    }
        /**
         * função que lista produtos controle RMA por Fornecedor
         * @param codFornecedor
     * @param filtro Y se refere a resolvido N não resolvido e T todos
         * @return 
         */
        public List<Movendaproddevolucaocompra> listagemControlaDevolucaoPorFornecedor(String codFornecedor, String filtro){
        EntityManager em = getEntityManager();
        Query query;
        if("T".equals(filtro)){
        query = em.createQuery("SELECT prod FROM Movendaproddevolucaocompra prod WHERE prod.codforn.codforn =:codFornecedor");
        query.setParameter("codFornecedor", codFornecedor); 
        }else if("Y".equals(filtro)){
        query = em.createQuery("SELECT prod FROM Movendaproddevolucaocompra prod WHERE prod.codforn.codforn =:codFornecedor AND prod.valorcusto = prod.valorretornado");
        query.setParameter("codFornecedor", codFornecedor); 
        }else{
            query = em.createQuery("SELECT prod FROM Movendaproddevolucaocompra prod WHERE prod.codforn.codforn =:codFornecedor AND prod.valorcusto > prod.valorretornado");
        query.setParameter("codFornecedor", codFornecedor);
        }
        return query.getResultList();
    }
        /**
       * Função que pesquisa se já existe vale na devolução que não foi quitado e que é referente a devolução
       * ou a entrada do cliente
     * @param codMovEntrada
       * @param codCliente
       * @return 
       */
      public List<Vale> listagemValePorDevolucao(String codMovEntrada, String codCliente){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT va FROM Vale va WHERE va.codmoventr =:codMovEntrada AND va.codcli.codcli =:codCliente AND va.flagtipo =:tipo AND va.datpag IS NULL");
        query.setParameter("codMovEntrada", codMovEntrada);   
        query.setParameter("codCliente", codCliente); 
        query.setParameter("tipo", 'D');
        return query.getResultList();
    }

    public Iterable<Campocustomvalor> listCampoMaster(String codProd, String codCampoCustomMaster) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT va FROM Campocustomvalor va WHERE va.identidadeorigem =:codProd AND va.codcampocustommaster.codcampocustommaster =:codCampoCustomMaster");
        query.setParameter("codProd", codProd);   
        query.setParameter("codCampoCustomMaster", codCampoCustomMaster); 
        return query.getResultList();
    }
    
    public Iterable<Campocustomvalor> listCampoMasterValor(String valor, String codCampoCustomMaster) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT va FROM Campocustomvalor va WHERE va.codcampocustommaster.codcampocustommaster =:codCampoCustomMaster AND va.valor =:valor");
        query.setParameter("valor", valor);   
        query.setParameter("codCampoCustomMaster", codCampoCustomMaster); 
        return query.getResultList();
    }

    public List<Movendaprod> listMovendaProdEntregaTelefone(String entregaTelefone) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prod FROM Movendaprod prod WHERE prod.codmovenda.entregatelefone =:entregaTelefone");
        query.setParameter("entregaTelefone", entregaTelefone);      
        return query.getResultList();
    }
     public List<Movendaprodserial> listagemSaidaSerialPorMovProduto(String codMovProd){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Movendaprodserial ven WHERE ven.codmovprod.codmovprod =:codMovProd");
        query.setParameter("codMovProd", codMovProd);//primeiro parametro          
        return query.getResultList();
    }

    public List<Produto> listProdutoCaracteristica(String codCaracteristica) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven.codprod FROM Produtocaracteristica ven WHERE ven.codcaracteristica =:codCaracteristica");
        query.setParameter("codCaracteristica", codCaracteristica);        
        return query.getResultList();
    }
    
    public List<Produtocaracteristica> listProdutoCaracteristicaDoProduto(String codProd) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Produtocaracteristica ven WHERE ven.codprod.codprod =:codProd");
        query.setParameter("codProd", codProd);        
        return query.getResultList();
    }
    
     public List<Produtocaracteristica> listCaracteristicaProduto(String codProduto) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven.codprod FROM Produtocaracteristica ven WHERE ven.codprod.codprod =:codProduto AND ven.codcaracteristica = '000000005'");
        query.setParameter("codProduto", codProduto);
      //  query.setParameter("codCaracteristica", codCaracteristica);        
        return query.getResultList();
    }

    public List<Produto> listProdutoSerial(String codprodutoserial) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven.codprod FROM Produtoserial ven WHERE ven.codprodutoserial =:codprodutoserial");
        query.setParameter("codprodutoserial", codprodutoserial);        
        return query.getResultList();
    }

    public List<Produto> listProdutoEan(String codigoEan) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven.codprod FROM Produtocodigo ven WHERE ven.codigo =:codigoEan");
        query.setParameter("codigoEan", codigoEan);        
        return query.getResultList();
    }
    
    public List<Produto> listProdutoCodigoPrincipal(String codigo) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Produto ven WHERE ven.codigo =:codigo");
        query.setParameter("codigo", codigo);        
        return query.getResultList();
    }

    public List<Cliente> cliente(char indiedest) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM Cliente ven WHERE ven.indiedest =:indiedest");
        query.setParameter("indiedest", indiedest);        
        return query.getResultList();
    }

    public List<Fornproduto> resultForProduto(String codProd, String codFor) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Fornproduto mov WHERE mov.fornprodutoPK.codprod =:codProd AND mov.fornprodutoPK.codforn =:codFor ORDER BY mov.datatu Desc");
        query.setParameter("codProd", codProd);//primeiro parametro  
        query.setParameter("codFor", codFor);
        return query.getResultList();
    }
    
    public List<Fornecedor> resultFornecedor(String codFor) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Fornecedor mov WHERE mov.codforn =:codFor");
        query.setParameter("codFor", codFor);//primeiro parametro      
        return query.getResultList();
    }
     public List<Gtintributavel> resultGtin(String codGtin) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Gtintributavel mov WHERE mov.codgtintributavel =:codGtin");
        query.setParameter("codGtin", codGtin);//primeiro parametro      
        return query.getResultList();
    }
     
      public List<Localizacao> listLocalizacao(String codLoc) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT v FROM Localizacao v WHERE v.codloc =:codLoc");
        query.setParameter("codLoc", codLoc);//primeiro parametro      
        return query.getResultList();
    }

   public List<Localizacao> listLocalizacaoDes(String descricao) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT v FROM Localizacao v WHERE v.descricao =:descricao");
        query.setParameter("descricao", descricao);//primeiro parametro      
        return query.getResultList();
    }      
     /**
      * Função que retorna produto no pedido de compra
      * S = Confirmado
      * T = Finalizado
      * D = Em Digitação
      * @param status
      * @param codProd
      * @return 
      */
     public List<Pedidoitem> produtoCompra(char status, String codProd) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Pedidoitem mov WHERE mov.codped.status =:status AND mov.codprod.codprod =:codProd");
        query.setParameter("status", status); 
        query.setParameter("codProd", codProd);
        
        return query.getResultList();
    }
     
     /**
      * Função que retorna produto comprados
      * S = Confirmado
      * T = Finalizado
      * D = Em Digitação
      * @param status
      * @return 
      */
     public List<Pedidoitem> produtosComprados(char status) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT mov FROM Pedidoitem mov WHERE mov.codped.status =:status");
        query.setParameter("status", status);              
        return query.getResultList();
    }
      
}
