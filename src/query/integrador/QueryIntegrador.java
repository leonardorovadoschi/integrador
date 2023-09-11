/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query.integrador;

import entidade.integrador.EntradaSerial;
import entidade.integrador.IntConfiguracao;
import entidade.integrador.IntLogs;
import entidade.integrador.ProdFornecedor;
import entidade.integrador.SaidaSerial;
import entidade.integrador.SerialProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import jpa.integrador.IntConfiguracaoJpaController;

/**
 *
 * @author leo
 */
public class QueryIntegrador {
    public QueryIntegrador (EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public List <IntLogs> resultLogs() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM IntLogs p order by p.entityId desc");      
        query.setMaxResults(120);
        return query.getResultList();
    }
    /**
     * Função que bisca o tipo de Configuração e retorna o Valor da Configuração
     * @param tipoConfiguracao
     * @return 
     */
    public String valorConfiguracao(String tipoConfiguracao){
        EntityManager em = getEntityManager();
        String str= "";
        Query query = em.createQuery("SELECT p FROM IntConfiguracao p WHERE p.tipo =:tipoConfiguracao"); 
        query.setParameter("tipoConfiguracao", tipoConfiguracao);
        List<IntConfiguracao> lIConf = 
                query.getResultList();
        for(IntConfiguracao ic : lIConf){
            str = ic.getValor();
        }
        return str;
    }
    public void atualizaValorConfiguracao(String tipoConfiguracao, String valor) throws Exception{
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM IntConfiguracao p WHERE p.tipo =:tipoConfiguracao"); 
        query.setParameter("tipoConfiguracao", tipoConfiguracao);
        List<IntConfiguracao> lIConf = query.getResultList();
        for(IntConfiguracao ic : lIConf){
            ic.setValor(valor);
            new IntConfiguracaoJpaController(emf).edit(ic);
        }
    }
     public List<IntConfiguracao> listagemConfiguracaoproTipoConfiguracao(String tipoConfiguracao){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM IntConfiguracao c WHERE c.tipo =:tipoConfiguracao");
        query.setParameter("tipoConfiguracao", tipoConfiguracao);//primeiro parametro 
        return query.getResultList();
    }
      public List<IntConfiguracao> listagemConfiguracaoPorValor(String valorConfiguracao){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM IntConfiguracao c WHERE c.valor =:valorConfiguracao");
        query.setParameter("valorConfiguracao", valorConfiguracao);
        return query.getResultList();
    }

    public List<ProdFornecedor> listProdFornecedor(String referenceCplus) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM ProdFornecedor c WHERE c.referenceCplus =:referenceCplus");
        query.setParameter("referenceCplus", referenceCplus);
        return query.getResultList();
    }
    
    public List<ProdFornecedor> listProdFornecedorEan(String ean, String nomeFornecedor) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM ProdFornecedor c WHERE c.ean =:ean AND c.nomeFornecedor =:nomeFornecedor");
        query.setParameter("ean", ean);
        query.setParameter("nomeFornecedor", nomeFornecedor);
        return query.getResultList();
    }

    public List<ProdFornecedor> listProdFornecedor(String codigoFornecedor, String nomeFornecedor) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM ProdFornecedor c WHERE c.codigoFornecedor =:codigoFornecedor AND c.nomeFornecedor =:nomeFornecedor");
        query.setParameter("codigoFornecedor", codigoFornecedor);
        query.setParameter("nomeFornecedor", nomeFornecedor);
        return query.getResultList();
    }
    
     public List<ProdFornecedor> listProdFornecedor(Integer ativo) {
       EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM ProdFornecedor c WHERE c.ativo =:ativo");
        query.setParameter("ativo", ativo);
        return query.getResultList();
    }

    public List<ProdFornecedor> resultPartNumberSnd(String partNumber, String nomeFornecedor , String estoque) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM ProdFornecedor c WHERE c.partNumber =:partNumber AND c.nomeFornecedor =:nomeFornecedor AND c.estoque =:estoque");
        query.setParameter("partNumber", partNumber);
         query.setParameter("nomeFornecedor", nomeFornecedor);
         query.setParameter("estoque", estoque);
        return query.getResultList();
    }
    
     public List<ProdFornecedor> listaProdFornecedor(String nomeFornecedor){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM ProdFornecedor ven WHERE ven.nomeFornecedor =:nomeFornecedor");
        query.setParameter("nomeFornecedor", nomeFornecedor);//primeiro parametro 
          
        return query.getResultList();
    }
      public List<ProdFornecedor> listaProdFornecedor(String nomeFornecedor, int ativo){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM ProdFornecedor ven WHERE ven.nomeFornecedor =:nomeFornecedor AND ven.ativo =:ativo");
        query.setParameter("nomeFornecedor", nomeFornecedor);
        query.setParameter("ativo", ativo);
          
        return query.getResultList();
    }

    public List<ProdFornecedor> resultEanEEstoque(String ean, String estoque, String nomeFornecedor) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM ProdFornecedor c WHERE c.ean =:ean AND c.estoque =:estoque AND c.nomeFornecedor =:nomeFornecedor");
        query.setParameter("ean", ean);
         query.setParameter("nomeFornecedor", nomeFornecedor);
         query.setParameter("estoque", estoque);
        return query.getResultList();
    }

    public List<ProdFornecedor> resultCodigoFornecedor(String referenceCplus, String nomeFornecedor) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM ProdFornecedor c WHERE c.referenceCplus =:referenceCplus AND c.nomeFornecedor =:nomeFornecedor");
        query.setParameter("referenceCplus", referenceCplus);
         query.setParameter("nomeFornecedor", nomeFornecedor);
        return query.getResultList();
    }

    public Iterable<ProdFornecedor> listProdFornecedor(String referenceCplus, int ativo) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM ProdFornecedor c WHERE c.referenceCplus =:referenceCplus AND c.ativo =:ativo");
        query.setParameter("referenceCplus", referenceCplus);
        query.setParameter("ativo", ativo);
         return query.getResultList();
    }

    public List<ProdFornecedor> resultFornecedor(String nomeFornecedor, String estoque, int disponivel) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM ProdFornecedor ven WHERE ven.nomeFornecedor =:nomeFornecedor AND ven.estoque =:estoque AND ven.disponivel =:disponivel");
        query.setParameter("nomeFornecedor", nomeFornecedor);
         query.setParameter("estoque", estoque);
        query.setParameter("disponivel", disponivel);
        return query.getResultList();
    }

    public List<ProdFornecedor> listaProdFornecedorDisponivel(String nomeFornecedor, int disponivel) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM ProdFornecedor ven WHERE ven.nomeFornecedor =:nomeFornecedor AND ven.disponivel =:disponivel");
        query.setParameter("nomeFornecedor", nomeFornecedor);
        query.setParameter("disponivel", disponivel);
        return query.getResultList();
    }

    public Iterable<ProdFornecedor> listProdFornecedorId(Integer idProdutos) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM ProdFornecedor c WHERE c.idProdutos =:idProdutos");
        query.setParameter("idProdutos", idProdutos);
         return query.getResultList();
    }
    
    public List<SerialProduto> listSerialExato(String serial) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM SerialProduto ven WHERE ven.serial =:serial");
        query.setParameter("serial", serial);
        return query.getResultList();
    }   
    
     public List<SerialProduto> listSerialLike(String serial) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prodSerial FROM SerialProduto prodSerial WHERE prodSerial.serial LIKE :serialProduto");
        query.setParameter("serialProduto", "%" + serial + "%");//primeiro parametro
        query.setMaxResults(200);
        return query.getResultList();
    }

    public List<EntradaSerial> listPorEntradaProd(String codmoveprod) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM EntradaSerial ven WHERE ven.codEntradaProd =:codmoveprod");
        query.setParameter("codmoveprod", codmoveprod);
        return query.getResultList();
    }
    
     public List<EntradaSerial> listPorIdEntradaProd(Integer idEntradaSerial) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM EntradaSerial ven WHERE ven.idEntradaSerial =:idEntradaSerial");
        query.setParameter("idEntradaSerial", idEntradaSerial);
        return query.getResultList();
    }
    
     public List<SaidaSerial> listPorSaidaProd(String codmovprod) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM SaidaSerial ven WHERE ven.codSaidaProd =:codmovprod");
        query.setParameter("codmovprod", codmovprod);
        return query.getResultList();
    }
     
     public List<SaidaSerial> listPorSaida(String codmov) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM SaidaSerial ven WHERE ven.codSaida =:codmov");
        query.setParameter("codmov", codmov);
        return query.getResultList();
    }
     
     public List<SaidaSerial> listPorSaida(Integer idSaidaSerial) {
         EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM SaidaSerial ven WHERE ven.idSaidaSerial =:idSaidaSerial");
        query.setParameter("idSaidaSerial", idSaidaSerial);
        return query.getResultList();
    }
     
     public List<SerialProduto> listCodProdSemSaida(String codProd) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT ven FROM SerialProduto ven WHERE ven.codProduto =:codProd AND ven.saidaSerialCollection IS EMPTY");
        query.setParameter("codProd", codProd);
        return query.getResultList();
    }  
      public List<SaidaSerial> listSaidaSerialLike(String serial) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prodSerial FROM SaidaSerial prodSerial WHERE prodSerial.idSerial.serial LIKE :serialProduto");
        query.setParameter("serialProduto", "%" + serial + "%");//primeiro parametro
        query.setMaxResults(200);
        return query.getResultList();
    }
      public List<SaidaSerial> listSaidaSerial(String serial) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prodSerial FROM SaidaSerial prodSerial WHERE prodSerial.idSerial.serial =:serialProduto");
        query.setParameter("serialProduto", serial);//primeiro parametro
        //query.setMaxResults(200);
        return query.getResultList();
    }
      public List<SaidaSerial> listSaidaSerial(String serial, String cadMovProd) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT prodSerial FROM SaidaSerial prodSerial WHERE prodSerial.idSerial.serial =:serialProduto AND prodSerial.codSaidaProd =:cadMovProd");
        query.setParameter("serialProduto", serial);//primeiro parametro
        query.setParameter("cadMovProd", cadMovProd);
        return query.getResultList();
    }
}
