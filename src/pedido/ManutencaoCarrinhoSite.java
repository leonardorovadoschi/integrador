/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import entidade.prestaShop.PsCart;
import entidade.prestaShop.PsCartCartRule;
import entidade.prestaShop.PsCartCartRulePK;
import entidade.prestaShop.PsCartProduct;
import entidade.prestaShop.PsCartRule;
import entidade.prestaShop.PsCartRuleLang;
import entidade.prestaShop.PsCartRuleLangPK;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.prestaShop.PsCartCartRuleJpaController;
import jpa.prestaShop.PsCartJpaController;
import jpa.prestaShop.PsCartRuleJpaController;
import jpa.prestaShop.PsCartRuleLangJpaController;
import jpa.prestaShop.exceptions.NonexistentEntityException;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class ManutencaoCarrinhoSite {

    public void DeletaCarrinhoVazio(PsCart cart, EntityManagerFactory managerPrestaShop) {
        List<PsCartProduct> listProdCart = new QueryPrestaShop(managerPrestaShop).listCarProduct(cart.getIdCart());
        if (listProdCart.isEmpty()) {
            try {
                for (PsCartCartRule cartCartRule : new QueryPrestaShop(managerPrestaShop).listCartCartRule(cart.getIdCart())) {
                    for (PsCartRule cartRule : new QueryPrestaShop(managerPrestaShop).listCartRule(cartCartRule.getPsCartCartRulePK().getIdCartRule())) {
                        //for (PsCartRuleLang cartRuleLang : new QueryPrestaShop(managerPrestaShop).listCartRuleLang(cartCartRule.getPsCartCartRulePK().getIdCartRule())) {                         
                            new PsCartRuleLangJpaController(managerPrestaShop).destroy(new PsCartRuleLangPK(cartRule.getIdCartRule(), 2));                          
                            new PsCartCartRuleJpaController(managerPrestaShop).destroy(new PsCartCartRulePK(cart.getIdCart(), cartRule.getIdCartRule()));
                            new PsCartRuleJpaController(managerPrestaShop).destroy(cartRule.getIdCartRule());
                       // }
                    }
                }
                new PsCartJpaController(managerPrestaShop).destroy(cart.getIdCart());
            } catch (NonexistentEntityException ex) {
                 JOptionPane.showMessageDialog(null, "HOUVE UM ERRO AO EXCLUIR CARRINHO, Verifique!! \n" + ex, "Erro Excluir", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
