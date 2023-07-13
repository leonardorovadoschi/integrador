/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import entidade.cplus.Contareceber;
import entidade.cplus.Movenda;
import entidade.cplus.Movendaprod;
//import entidade.cplus.Movendaprodserial;
import entidade.cplus.Unidade;
import entidade.integrador.IntLogs;
import entidade.integrador.SaidaSerial;
import entidade.prestaShop.PsOrderDetail;
import entidade.prestaShop.PsOrderHistory;
import entidade.prestaShop.PsOrderInvoice;
import entidade.prestaShop.PsOrderInvoicePayment;
import entidade.prestaShop.PsOrderInvoicePaymentPK;
import entidade.prestaShop.PsOrderPayment;
import entidade.prestaShop.PsOrders;
import entidade.prestaShop.PsStockAvailable;
import query.cplus.QueryCplus;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.IntLogsJpaController;
import jpa.prestaShop.PsOrderHistoryJpaController;
import jpa.prestaShop.PsOrderInvoiceJpaController;
import jpa.prestaShop.PsOrderInvoicePaymentJpaController;
import jpa.prestaShop.PsOrderPaymentJpaController;
import jpa.prestaShop.PsOrdersJpaController;
import jpa.prestaShop.PsProductJpaController;
import jpa.prestaShop.PsStockAvailableJpaController;
import query.integrador.QueryIntegrador;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class AtualizaPedidoCplusDigimacro {

    boolean condicaoErro;

    private boolean isCondicaoErro() {
        return condicaoErro;
    }

    private void setCondicaoErro(boolean condicaoErro) {
        this.condicaoErro = condicaoErro;
    }

    /**
     * Função que cuida da atualização do pedido, faz as operações no integrador
     * e no Magento
     *
     * @param managerIntegrador
     * @param managerDigimacro seria da loja em que vai ser atualizado
     * @param managerCplus
     * @param order
     * @return false se houve erros
     */
    public boolean atualizarPedido(EntityManagerFactory managerIntegrador, EntityManagerFactory managerDigimacro, EntityManagerFactory managerCplus, PsOrders order) {
        setCondicaoErro(true);
        List<Movenda> listmovenda = new QueryCplus(managerCplus).resultMovendaPorEntregaTelefone(order.getReference(), 'N');
        if (listmovenda.size() == 1) {
            for (Movenda movenda : listmovenda) {
                if (pedidoSeparado(movenda, managerCplus, managerIntegrador)) {//if que verifica se pedido já foi separado    
                    criaLog(new Date(System.currentTimeMillis()), ", Pedido Atualizado Nº Pedido: " + movenda.getNumped(), "Edição", managerIntegrador);
                    atualizaPedido(true, managerCplus, managerDigimacro, managerIntegrador, order, movenda);
                } else {//fim if que verifica se o pedido já foi separado
                    criaLog(new Date(System.currentTimeMillis()), ", Pedido não Separado Nº pedido: " + movenda.getNumped(), "Erro Edição", managerIntegrador);
                    atualizaPedido(false, managerCplus, managerDigimacro, managerIntegrador, order, movenda);
                }
            }//fim for movenda
        } else if (listmovenda.size() > 1) {
            for (Movenda movenda : listmovenda) {
                criaLog(new Date(System.currentTimeMillis()), ", Existe mais que um pedido com o memo ENTREGATELEFONE, pedido C-Plus: " + movenda.getNumped(), "Erro Atualização Pedido", managerIntegrador);
            }
        }
        return isCondicaoErro();
    }

    private void atualizaPedido(boolean separado, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro, EntityManagerFactory managerIntegracao, PsOrders order, Movenda movenda) {
        int currentState;
        if (separado) {
            if (order.getCurrentState() != 5) {
                currentState = 5;
                order.setCurrentState(currentState);
                psOrderHistory(currentState, order, managerDigimacro, managerIntegracao);
            }
        } else {
            if (order.getCurrentState() != 4) {
                currentState = 4;
                order.setCurrentState(currentState);
                psOrderHistory(currentState, order, managerDigimacro, managerIntegracao);
            }
        }
        try {
            new PsOrdersJpaController(managerDigimacro).edit(order);
            atualizaReservas(managerDigimacro, managerIntegracao, order);
            orderInvoice(order, movenda, managerCplus, managerDigimacro, managerIntegracao);

        } catch (jpa.prestaShop.exceptions.IllegalOrphanException ex) {
            setCondicaoErro(false);
            criaLog(order.getDateUpd(), ", SalesFlatOrdert " + order.getReference() + " " + ex, "Erro Edição", managerIntegracao);
        } catch (Exception ex) {
            setCondicaoErro(false);
            criaLog(order.getDateAdd(), ", SalesFlatOrdert " + order.getReference() + " " + ex, "Erro Edição", managerIntegracao);
        }
    }

    private boolean pedidoSeparado(Movenda movenda, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        boolean condicao = false;
        List<Movendaprod> listMovendaProd = new QueryCplus(managerCplus).listMovendaProd(movenda.getCodmovenda());
        int quanMovendaProd = 0;
        for (Movendaprod prod : listMovendaProd) {
            quanMovendaProd = quanMovendaProd + quantidadeSaida(prod, managerCplus);
        }
        List<SaidaSerial> listSerial = new QueryIntegrador(managerIntegrador).listPorSaida(movenda.getCodmovenda());
        if (quanMovendaProd == listSerial.size()) {         
            condicao = true;
        }
        return condicao;
    }

    private int quantidadeSaida(Movendaprod movendaProd, EntityManagerFactory managerCplus) {
        int quantidade = movendaProd.getQuantidade().intValue();
        for (Unidade un : new QueryCplus(managerCplus).resultPorUnidadeProduto(movendaProd.getCodprod().getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = quantidade / un.getFatorconversao().intValue();
            }
        }

        return quantidade;
    }

    private void criaLog(Date dataExecucao, String mensagem, String tipoLog, EntityManagerFactory managerIntegracao) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);

        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegracao).create(log);
    }

    private void psOrderHistory(Integer currentState, PsOrders order, EntityManagerFactory managerDigimacro, EntityManagerFactory managerIntegracao) {
        PsOrderHistory orderHistory = new PsOrderHistory();
        orderHistory.setDateAdd(new Date(System.currentTimeMillis()));
        orderHistory.setIdEmployee(1);
        orderHistory.setIdOrder(order.getIdOrder());
        orderHistory.setIdOrderState(currentState);
        new PsOrderHistoryJpaController(managerDigimacro).create(orderHistory);

    }

    private void orderInvoice(PsOrders order, Movenda movenda, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro, EntityManagerFactory managerIntegracao) {     
        List<PsOrderInvoice> lOi = new QueryPrestaShop(managerDigimacro).listOsOrderInvoic(order.getIdOrder());
        if (lOi.isEmpty()) {
            PsOrderInvoice oi = new PsOrderInvoice();
            oi.setIdOrder(order.getIdOrder());
            oi.setNumber(1);
            oi.setDeliveryNumber(1);
            oi.setDeliveryDate(new Date(System.currentTimeMillis()));
            oi.setTotalDiscountTaxExcl(order.getTotalDiscountsTaxExcl());
            oi.setTotalDiscountTaxIncl(order.getTotalDiscountsTaxIncl());
            oi.setTotalPaidTaxExcl(order.getTotalPaidTaxExcl());
            oi.setTotalPaidTaxIncl(order.getTotalPaidTaxIncl());
            oi.setTotalProducts(order.getTotalProducts());
            oi.setTotalProductsWt(order.getTotalProductsWt());
            oi.setTotalShippingTaxExcl(order.getTotalShippingTaxExcl());
            oi.setTotalShippingTaxIncl(order.getTotalShippingTaxIncl());
            oi.setShippingTaxComputationMethod(0);
            oi.setTotalWrappingTaxExcl(order.getTotalWrappingTaxExcl());
            oi.setTotalWrappingTaxIncl(order.getTotalWrappingTaxIncl());
            oi.setShopAddress("Lajeado - RS");
            oi.setNote("");
            oi.setDateAdd(new Date(System.currentTimeMillis()));
            new PsOrderInvoiceJpaController(managerDigimacro).create(oi);          
        }
        for (PsOrderInvoice oi : new QueryPrestaShop(managerDigimacro).listOsOrderInvoic(order.getIdOrder())) {
            List<PsOrderPayment> listOP = new QueryPrestaShop(managerDigimacro).listPsOrderPayment(order.getReference());
            if (listOP.isEmpty()) {
                PsOrderPayment op = new PsOrderPayment();
                op.setOrderReference(order.getReference());
                op.setDateAdd(new Date(System.currentTimeMillis()));
                op.setIdCurrency(1);
                op.setAmount(order.getTotalPaidTaxIncl());
                op.setPaymentMethod("Pagamento");
                op.setConversionRate(BigDecimal.ONE);
                op.setTransactionId("");
                op.setCardNumber("");
                op.setCardBrand("");
                op.setCardExpiration("");
                op.setCardHolder("");
                new PsOrderPaymentJpaController(managerDigimacro).create(op);
            }
            listOP = new QueryPrestaShop(managerDigimacro).listPsOrderPayment(order.getReference());
            for (PsOrderPayment op : listOP) {
                PsOrderInvoicePayment oip = new PsOrderInvoicePayment();
                oip.setPsOrderInvoicePaymentPK(new PsOrderInvoicePaymentPK(oi.getIdOrderInvoice(), op.getIdOrderPayment()));
                oip.setIdOrder(order.getIdOrder());
                try {
                    new PsOrderInvoicePaymentJpaController(managerDigimacro).edit(oip);
                } catch (Exception ex) {
                    criaLog(oi.getDateAdd(), ", PsOrderInvoicePayment " + order.getReference() + " " + ex, "Erro Criar", managerIntegracao);
                }
            }
        }
    }

    private void atualizaReservas(EntityManagerFactory managerDigimacro, EntityManagerFactory managerIntegracao, PsOrders order) {
        for (PsOrderDetail item : new QueryPrestaShop(managerDigimacro).listPsOrderDetail(order.getIdOrder())) {
            int idProduct = new PsProductJpaController(managerDigimacro).findPsProduct(item.getProductId()).getIdProduct();
            for (PsStockAvailable sa : new QueryPrestaShop(managerDigimacro).listEstoqueProduto(idProduct)) {
                int novo = sa.getReservedQuantity() - item.getProductQuantity();
                if (novo > 0) {
                    sa.setReservedQuantity(novo);
                    try {
                        new PsStockAvailableJpaController(managerDigimacro).edit(sa);
                    } catch (Exception ex) {
                        criaLog(new Date(System.currentTimeMillis()), ", PsStockAvailable " + order.getReference() + " " + ex, "Erro Editar", managerIntegracao);
                    }
                }
            }
        }
    }
}
