/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import entidade.cplus.Documento;
import entidade.cplus.Documentodocref;
import entidade.cplus.Documentoitem;
import entidade.cplus.Moentrega;
import entidade.cplus.Moentregaprod;
import entidade.cplus.Movecfdocumento;
import entidade.cplus.Movecfdocumentoitem;
import entidade.cplus.Movenda;
import entidade.cplus.Movendaprod;
import entidade.cplus.Movendaprodcomp;
import entidade.cplus.Movendaproddevolucaocompra;
import entidade.cplus.Movendaprodserial;
import entidade.cplus.Nfceletronica;
import query.cplus.QueryCplus;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.cplus.DocumentoJpaController;
import jpa.cplus.DocumentodocrefJpaController;
import jpa.cplus.DocumentoitemJpaController;
import jpa.cplus.MoentregaJpaController;
import jpa.cplus.MoentregaprodJpaController;
import jpa.cplus.MovecfdocumentoitemJpaController;
import jpa.cplus.MovendaJpaController;
import jpa.cplus.MovendaprodJpaController;
import jpa.cplus.MovendaprodcompJpaController;
import jpa.cplus.MovendaproddevolucaocompraJpaController;
import jpa.cplus.MovendaprodserialJpaController;
import jpa.cplus.NfceletronicaJpaController;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;

/**
 *
 * @author leonardo
 */
public class DeletarPedidoCplus {

    /**
     * Fun��o que deleta pedido no c-plus e todas as tabelas de dependencia
     * @param movenda
     * @param managerCplus
     * @return verdadeiro se n�o houver erros
     */
    public boolean deletarPedidoCplus(Movenda movenda, EntityManagerFactory managerCplus) {
        boolean condicaoErro = true;
        QueryCplus queryCplus = new QueryCplus(managerCplus);
        DocumentodocrefJpaController documentodocrefJpaController = new DocumentodocrefJpaController(managerCplus);
        MovendaprodJpaController movendaprodJpaController = new MovendaprodJpaController(managerCplus);

        if ("Y".equals(movenda.getFlagcancelada().toString())) {//if que verifica se o Pedido est� cancelado
            List<Documentodocref> listdocCref = queryCplus.resultDocumentodocref(movenda.getCodmovenda());
            for (Documentodocref cref : listdocCref) {
                try {
                    documentodocrefJpaController.destroy(cref.getCoddocumentodocref());
                } catch (NonexistentEntityException ex) {
                    condicaoErro = false;
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Documentodocref\n" + ex);
                }
            }
            List<Movecfdocumento> listEcfDoc = queryCplus.resultMovendaECFDocumento(movenda.getCodmovenda());
            for (Movecfdocumento ecfDoc : listEcfDoc) {
                for (Movecfdocumentoitem ecfDocItem : ecfDoc.getMovecfdocumentoitemCollection()) {
                    try {
                        if (condicaoErro) {
                            new MovecfdocumentoitemJpaController(managerCplus).destroy(ecfDocItem.getCodmovecfdocumentoitem());
                        }
                    } catch (NonexistentEntityException ex) {
                        condicaoErro = false;
                        JOptionPane.showMessageDialog(null, "Erro ao Excluir Movecfdocumentoitem\n" + ex);
                    }
                }
                try {
                    if (condicaoErro) {
                        new MovecfdocumentoitemJpaController(managerCplus).destroy(ecfDoc.getCodmovecfdocumento());
                    }
                } catch (NonexistentEntityException ex) {
                    condicaoErro = false;
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Movecfdocumentoitem\n" + ex);
                }
            }
            List<Documento> listdoc = queryCplus.resultDocumento(movenda.getNumped().toString());
            for (Documento doc : listdoc) {
                for (Documentoitem item : doc.getDocumentoitemCollection()) {
                    try {
                        if (condicaoErro) {
                            new DocumentoitemJpaController(managerCplus).destroy(item.getCoddocumentoitem());
                        }
                    } catch (NonexistentEntityException ex) {
                        condicaoErro = false;
                        JOptionPane.showMessageDialog(null, "Erro ao Excluir Documentoitem \n" + ex);
                    } catch (IllegalOrphanException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao Excluir Documentoitem \n" + ex);
                    } 
                    //System.out.println("Exclusao Documento Item : ");
                }//fim for DocumentoItem                        
                try {
                    if (condicaoErro) {
                        new DocumentoJpaController(managerCplus).destroy(doc.getCoddocumento());
                    }
                } catch (IllegalOrphanException | NonexistentEntityException ex) {
                    condicaoErro = false;
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Documento\n" + ex);
                }//fim catch
                // System.out.println("Exclusao Documento : ");
            }
            for (Movendaprod movProd : movenda.getMovendaprodCollection()) {
                List<Moentregaprod> listMoentregaProd = queryCplus.resultMoentregaProd(movProd.getCodmovprod());
                for (Moentregaprod entProd : listMoentregaProd) {
                    try {
                        if (condicaoErro) {
                            new MoentregaprodJpaController(managerCplus).destroy(entProd.getId());
                        }
                    } catch (NonexistentEntityException ex) {
                        condicaoErro = false;
                        JOptionPane.showMessageDialog(null, "Erro ao Excluir Moentregaprod\n" + ex);
                    }//fim catch
                }//fim for Moentregaprod
                List<Movendaprodcomp> listVendaProdComp = queryCplus.resultMovendaprodcomp(movProd.getCodmovprod());
                for (Movendaprodcomp comp : listVendaProdComp) {
                    try {
                        if (condicaoErro) {
                            new MovendaprodcompJpaController(managerCplus).destroy(comp.getCodmovendaprodcomp());
                        }
                    } catch (NonexistentEntityException ex) {
                        condicaoErro = false;
                        JOptionPane.showMessageDialog(null, "Erro ao Excluir Movendaprodcomp\n" + ex);
                    }//fim catch
                }//fim for Movendaprodcomp
                for (Movendaprodserial serial : movProd.getMovendaprodserialCollection()) {
                    try {
                        if (condicaoErro) {
                            new MovendaprodserialJpaController(managerCplus).destroy(serial.getCodmovendaprodserial());
                        }
                    } catch (NonexistentEntityException ex) {
                        condicaoErro = false;
                        JOptionPane.showMessageDialog(null, "Erro ao Excluir Movendaprodserial\n" + ex);
                    }//fim catch
                }//fim Movendaprodserial

                List<Movendaproddevolucaocompra> listdevProd = queryCplus.resultMovendaProdutoDevolucaoCompa(movProd.getCodmovprod());
                for (Movendaproddevolucaocompra devProd : listdevProd) {
                    try {
                        if (condicaoErro) {
                            new MovendaproddevolucaocompraJpaController(managerCplus).destroy(devProd.getCodmovendaproddevolucaocompra());
                        }
                    } catch (NonexistentEntityException ex) {
                        condicaoErro = false;
                        JOptionPane.showMessageDialog(null, "Erro ao Excluir Movendaproddevolucaocompra\n" + ex);
                    }
                }

                try {
                    if (condicaoErro) {
                        movendaprodJpaController.destroy(movProd.getCodmovprod());
                    }
                } catch (IllegalOrphanException | NonexistentEntityException ex) {
                    condicaoErro = false;
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Movendaprod\n" + ex);
                }//fim catch
            }//fim for Movprod
            List<Nfceletronica> listNfc = queryCplus.resultNfceletronica(movenda.getCodmovenda());
            for (Nfceletronica nfc : listNfc) {
                try {
                    if (condicaoErro) {
                        new NfceletronicaJpaController(managerCplus).destroy(nfc.getCodnfceletronica());
                    }
                } catch (NonexistentEntityException ex) {
                    condicaoErro = false;
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Nfceletronica\n" + ex);
                }
            }
            List<Moentrega> listMoentrega = queryCplus.resultMoentrega(movenda.getCodmovenda());
            for (Moentrega ent : listMoentrega) {
                try {
                    if (condicaoErro) {
                        new MoentregaJpaController(managerCplus).destroy(ent.getCodmovenda());
                    }
                } catch (NonexistentEntityException ex) {
                    condicaoErro = false;
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Moentrega\n" + ex);
                }
            }//fim for Moentrega
           
            try {
                if (condicaoErro) {
                    new MovendaJpaController(managerCplus).destroy(movenda.getCodmovenda());
                }
            } catch (IllegalOrphanException | NonexistentEntityException ex) {
                condicaoErro = false;
                JOptionPane.showMessageDialog(null, "Erro ao Excluir Movenda\n" + ex);
            }
            /**if(condicaoErro){
             List<Movendadocref>  listMovendaDocRef = queryCplus.resultMovendaDocRef(movenda.getCodmovenda());
            for(Movendadocref ref : listMovendaDocRef){
                try {
                    new MovendadocrefJpaController(managerCplus).destroy(ref.getCodmovendadocref());
                } catch (NonexistentEntityException ex) {
                    condicaoErro = false;
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir Movendadocre \n" + ex);
                }
            }
            }*/
        } else {
            JOptionPane.showMessageDialog(null, "Pedido deve ser Cancelado no C-Plus!!");
        }//fim else que verifica se o pedido est� cancelado                
        return condicaoErro;
    }
}
