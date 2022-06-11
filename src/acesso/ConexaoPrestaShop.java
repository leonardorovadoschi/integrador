/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acesso;

import entidade.prestaShop.PsAccessory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author leo
 */
public class ConexaoPrestaShop {

    private Connection con = null;
    private String hostName = null;
    private String userName = null;
    private String password = null;
    private String url = null;
    private String jdbcDriver = null;
    private String dataBaseName = null;
    private String dataBasePrefix = null;
    private String dabaBasePort = null;

    public ConexaoPrestaShop() {
        super();

        /**
         * Os dados setados abaixo servem para uma conexão em MySQL. Altere de
         * acordo com seu BD. Aconselhamos carregar estes dados de um arquivo.
         */
// jdbc:firebirdsql://192.168.10.180:3050/c:\cplus/cplus.fdb;
        hostName = "//192.168.10.190";
        userName = "leonardo";
        password = "Leonardo@2012";
        jdbcDriver = "com.mysql.jdbc.Driver";
        dataBaseName = "prestashop";
        dataBasePrefix = "jdbc:mysql:";
        dabaBasePort = "3306";

        url = dataBasePrefix + hostName + ":" + dabaBasePort + "/" + dataBaseName + "?zeroDateTimeBehavior=CONVERT_TO_NULL&autoReconnect=true&autoReconnect=true&useSSL=false";

        /**
         * Exemplo de um URL completo para MySQL: a concatenação acima deve
         * ficar algo como: jdbc:'mysql:/localhost:3306/meu_bd'
         */
    }

    /**
     * Retorna uma java.sql.Connection.
     *
     * @return con
     */
    public Connection getConnection() {
        try {
            if (con == null) {
                Class.forName(jdbcDriver);
                con = DriverManager.getConnection(url, userName, password);
            } else if (con.isClosed()) {
                con = null;
                return getConnection();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao conectar com Banco de Dados PrestaShop!!!\n " + e);
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                //TODO: use um sistema de log apropriado.
                JOptionPane.showMessageDialog(null, "Houve um erro ao fexar conex�o Banco de DadosPrestaShop!!!!\n " + e);
            }
        }
    }

    public List<PsAccessory> listPsAcessory(Connection conn, int id_product_1, int id_product_2) {
        StringBuilder sql = new StringBuilder();
        List<PsAccessory> str = new ArrayList<>();
        PsAccessory acess;
        sql.append("SELECT * ");
        sql.append("FROM ps_accessory ");
        sql.append("WHERE id_product_1 =?");
        //sql.append(nomeTabela);
        sql.append(" AND id_product_2 =?");
        //sql.append(nomeCampo);
       // Connection conn = getConnection();

        PreparedStatement comando;
        try {
            comando = conn.prepareStatement(sql.toString());
            comando.setInt(1, id_product_1);
            comando.setInt(2, id_product_2);
            ResultSet resultado;
            resultado = comando.executeQuery();
            while (resultado.next()) {
                acess = new PsAccessory();
                acess.setIdProduct_1(resultado.getInt("id_product_1"));
                acess.setIdProduct_2(resultado.getInt("id_product_2"));
                str.add(acess);
            }
            resultado.close();
            comando.close();
            //conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }

    public void criaPsAccessory(Connection conn, int idProduct, int idProduct0) {
       // Connection conn = getConnection();
        String sql = "INSERT INTO ps_accessory(id_product_1,id_product_2) VALUES (?,?)";
        //PsAccessory pa = new PsAccessory();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduct);
            stmt.setInt(2, idProduct0);
            stmt.execute();
           // stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPrestaShop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
