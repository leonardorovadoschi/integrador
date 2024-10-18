/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import entidade.cplus.Calculoicms;
import entidade.prestaShop.PsTaxRulesGroup;
import entidade.prestaShop.PsTaxRulesGroupShop;
import entidade.prestaShop.PsTaxRulesGroupShopPK;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import jpa.prestaShop.PsTaxRulesGroupJpaController;
import jpa.prestaShop.PsTaxRulesGroupShopJpaController;
import prestashop.Manager;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class TaxRuleGroup {
    
    public void atualizarPsTaxRuleGroup(Calculoicms calIcms){
        List<PsTaxRulesGroup> taxTRG =  new QueryPrestaShop().resulTaxRulesGroup(calIcms.getNomecalculoicms());
        if(taxTRG.isEmpty()){
            criaPsTaxRuleGroup( calIcms);
        }else{
            for(PsTaxRulesGroup psTRG : taxTRG){
            editaPsTaxRuleGroup(calIcms, psTRG);
                    }
        }
    }

    private void criaPsTaxRuleGroup(Calculoicms calIcms) {
        PsTaxRulesGroup pTRG = new PsTaxRulesGroup();
        pTRG.setActive(1);
        pTRG.setDateAdd(new Date(System.currentTimeMillis()));
        pTRG.setDateUpd(new Date(System.currentTimeMillis()));
        pTRG.setDeleted(false);
        pTRG.setName(calIcms.getNomecalculoicms());
        new PsTaxRulesGroupJpaController(Manager.getManagerPrestaShop()).create(pTRG);
        
        PsTaxRulesGroupShop pTRGS = new PsTaxRulesGroupShop();
        pTRGS.setPsTaxRulesGroupShopPK(new PsTaxRulesGroupShopPK(pTRG.getIdTaxRulesGroup(), 1));
        try {
            new PsTaxRulesGroupShopJpaController(Manager.getManagerPrestaShop()).create(pTRGS);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Houve um erro ao gravar PsTaxRulesGroupShop "+ ex +" , Verifique!! \n" , "Erro Site Criar", JOptionPane.ERROR_MESSAGE);
        }             
    }
  
    private void editaPsTaxRuleGroup(Calculoicms calIcms, PsTaxRulesGroup psTRG) {
        psTRG.setActive(1);
        //psTRG.setDateAdd(new Date(System.currentTimeMillis()));
        psTRG.setDateUpd(new Date(System.currentTimeMillis()));
        psTRG.setDeleted(false);
        psTRG.setName(calIcms.getNomecalculoicms());
        try {
            new PsTaxRulesGroupJpaController(Manager.getManagerPrestaShop()).edit(psTRG);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao editar PsTaxRulesGroupShop "+ ex +" , Verifique!! \n" , "Erro Site Editar", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
