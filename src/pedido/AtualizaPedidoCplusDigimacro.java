/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

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
import java.util.Date;
import java.util.List;
import jpa.integrador.IntLogsJpaController;
import jpa.prestaShop.PsOrderHistoryJpaController;
import jpa.prestaShop.PsOrderInvoiceJpaController;
import jpa.prestaShop.PsOrderInvoicePaymentJpaController;
import jpa.prestaShop.PsOrderPaymentJpaController;
import jpa.prestaShop.PsOrdersJpaController;
import jpa.prestaShop.PsProductJpaController;
import jpa.prestaShop.PsStockAvailableJpaController;
import prestashop.Manager;
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
     * e no PrestaShop
     * @param order
     * @return false se houve erros
     */
    public boolean atualizarPedido(PsOrders order) {
        setCondicaoErro(true);
        List<Movenda> listmovenda = new QueryCplus().resultMovendaPorEntregaTelefone(order.getReference(), 'N');
        if (listmovenda.size() == 1) {
            for (Movenda movenda : listmovenda) {
                if (pedidoSeparado(movenda)) {//if que verifica se pedido já foi separado    
                    criaLog(new Date(System.currentTimeMillis()), ", Pedido Atualizado Nº Pedido: " + movenda.getNumped(), "Edição");
                    atualizaPedido(true, order, movenda);
                } else {//fim if que verifica se o pedido já foi separado
                    criaLog(new Date(System.currentTimeMillis()), ", Pedido não Separado Nº pedido: " + movenda.getNumped(), "Erro Edição");
                    atualizaPedido(false, order, movenda);
                }
            }//fim for movenda
        } else if (listmovenda.size() > 1) {
            for (Movenda movenda : listmovenda) {
                criaLog(new Date(System.currentTimeMillis()), ", Existe mais que um pedido com o memo ENTREGATELEFONE, pedido C-Plus: " + movenda.getNumped(), "Erro Atualização Pedido");
            }
        }
        return isCondicaoErro();
    }

    private void atualizaPedido(boolean separado, PsOrders order, Movenda movenda) {
        int currentState;
        if (separado) {
            if (order.getCurrentState() != 5) {
                currentState = 5;
                order.setCurrentState(currentState);
                psOrderHistory(currentState, order);
            }
        } else {
            if (order.getCurrentState() != 4) {
                currentState = 4;
                order.setCurrentState(currentState);
                psOrderHistory(currentState, order);
            }
        }
        try {
            new PsOrdersJpaController(Manager.getManagerPrestaShop()).edit(order);
            atualizaReservas(order);
            orderInvoice(order, movenda);

        } catch (jpa.prestaShop.exceptions.IllegalOrphanException ex) {
            setCondicaoErro(false);
            criaLog(order.getDateUpd(), ", SalesFlatOrdert " + order.getReference() + " " + ex, "Erro Edição");
        } catch (Exception ex) {
            setCondicaoErro(false);
            criaLog(order.getDateAdd(), ", SalesFlatOrdert " + order.getReference() + " " + ex, "Erro Edição");
        }
    }

    private boolean pedidoSeparado(Movenda movenda) {
        boolean condicao = false;
        List<Movendaprod> listMovendaProd = new QueryCplus().listMovendaProd(movenda.getCodmovenda());
        int quanMovendaProd = 0;
        for (Movendaprod prod : listMovendaProd) {
            quanMovendaProd = quanMovendaProd + quantidadeSaida(prod);
        }
        List<SaidaSerial> listSerial = new QueryIntegrador().listPorSaida(movenda.getCodmovenda());
        if (quanMovendaProd == listSerial.size()) {         
            condicao = true;
        }
        return condicao;
    }

    private int quantidadeSaida(Movendaprod movendaProd) {
        int quantidade = movendaProd.getQuantidade().intValue();
        for (Unidade un : new QueryCplus().resultPorUnidadeProduto(movendaProd.getCodprod().getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = quantidade / un.getFatorconversao().intValue();
            }
        }

        return quantidade;
    }

    private void criaLog(Date dataExecucao, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);

        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(Manager.getManagerIntegrador()).create(log);
    }

    private void psOrderHistory(Integer currentState, PsOrders order) {
        PsOrderHistory orderHistory = new PsOrderHistory();
        orderHistory.setDateAdd(new Date(System.currentTimeMillis()));
        orderHistory.setIdEmployee(1);
        orderHistory.setIdOrder(order.getIdOrder());
        orderHistory.setIdOrderState(currentState);
        new PsOrderHistoryJpaController(Manager.getManagerPrestaShop()).create(orderHistory);

    }

    private void orderInvoice(PsOrders order, Movenda movenda) {     
        List<PsOrderInvoice> lOi = new QueryPrestaShop().listOsOrderInvoic(order.getIdOrder());
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
            new PsOrderInvoiceJpaController(Manager.getManagerPrestaShop()).create(oi);          
        }
        for (PsOrderInvoice oi : new QueryPrestaShop().listOsOrderInvoic(order.getIdOrder())) {
            List<PsOrderPayment> listOP = new QueryPrestaShop().listPsOrderPayment(order.getReference());
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
                new PsOrderPaymentJpaController(Manager.getManagerPrestaShop()).create(op);
            }
            listOP = new QueryPrestaShop().listPsOrderPayment(order.getReference());
            for (PsOrderPayment op : listOP) {
                PsOrderInvoicePayment oip = new PsOrderInvoicePayment();
                oip.setPsOrderInvoicePaymentPK(new PsOrderInvoicePaymentPK(oi.getIdOrderInvoice(), op.getIdOrderPayment()));
                oip.setIdOrder(order.getIdOrder());
                try {
                    new PsOrderInvoicePaymentJpaController(Manager.getManagerPrestaShop()).edit(oip);
                } catch (Exception ex) {
                    criaLog(oi.getDateAdd(), ", PsOrderInvoicePayment " + order.getReference() + " " + ex, "Erro Criar");
                }
            }
        }
    }

    private void atualizaReservas(PsOrders order) {
        for (PsOrderDetail item : new QueryPrestaShop().listPsOrderDetail(order.getIdOrder())) {
            int idProduct = new PsProductJpaController(Manager.getManagerPrestaShop()).findPsProduct(item.getProductId()).getIdProduct();
            for (PsStockAvailable sa : new QueryPrestaShop().listEstoqueProduto(idProduct)) {
                int novo = sa.getReservedQuantity() - item.getProductQuantity();
                if (novo > 0) {
                    sa.setReservedQuantity(novo);
                    try {
                        new PsStockAvailableJpaController(Manager.getManagerPrestaShop()).edit(sa);
                    } catch (Exception ex) {
                        criaLog(new Date(System.currentTimeMillis()), ", PsStockAvailable " + order.getReference() + " " + ex, "Erro Editar");
                    }
                }
            }
        }
    }
}
