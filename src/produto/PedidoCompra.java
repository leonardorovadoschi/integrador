/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import entidade.cplus.Pedidoitem;
import integrador.relatorio.ImprimeRelatorio;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class PedidoCompra {

    public String produtoComprado(EntityManagerFactory managerCplus, String codProdCplus) {
        String txt = "";
        for (Pedidoitem p : new QueryCplus(managerCplus).produtoCompra('S', codProdCplus)) {
            txt = txt + "Comprado: " + p.getQuantidade().intValue() + ", Previsão: " + incrementData(p.getCodped().getDataconfirmacao(), p.getCodped().getPrevisao()) + "\n";
        }
        return txt;
    }

    public void produtosComprados(EntityManagerFactory managerCplus) {
        //List<Pedidoitem> item = new ArrayList<>();
        List<Pedidoitem> l = new QueryCplus(managerCplus).produtosComprados('S');
        if (l.size() > 0) {
            Comparator ordemNome = new ComparadorNomeProdCompra();
            Collections.sort(l, ordemNome);
            new ImprimeRelatorio().imprimeRelatorio("/integrador/relatorio/PedidoCompra.jrxml", l);
        }
    }

    private String incrementData(Date dataBancoDados, int alterarDia) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar fimExecucao = Calendar.getInstance();
        fimExecucao.setTime(dataBancoDados);
        fimExecucao.add(Calendar.DAY_OF_MONTH, alterarDia);
        String dataFormat = sdf.format(fimExecucao.getTime());
        return dataFormat;
    }
}
