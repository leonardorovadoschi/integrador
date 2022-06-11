/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acesso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author leo
 */
public class ConexaoDB {

    private Connection con = null;
    private String hostName = null;
    private String userName = null;
    private String password = null;
    private String url = null;
    private String jdbcDriver = null;
    private String dataBaseName = null;
    private String dataBasePrefix = null;
    private String dabaBasePort = null;

    public ConexaoDB() {
        super();

        /**
         * Os dados setados abaixo servem para uma conexão em MySQL. Altere de
         * acordo com seu BD. Aconselhamos carregar estes dados de um arquivo.
         */
// jdbc:firebirdsql://192.168.10.180:3050/c:\cplus/cplus.fdb;
        hostName = "//192.168.10.180";
        userName = "sysdba";
        password = "masterkey";
        jdbcDriver = "org.firebirdsql.jdbc.FBDriver";
        dataBaseName = "c:\\cplus/cplus.fdb";
        dataBasePrefix = "jdbc:firebirdsql:";
        dabaBasePort = "3050";

        url = dataBasePrefix + hostName + ":" + dabaBasePort + "/" + dataBaseName + "";

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
            JOptionPane.showMessageDialog(null, "Houve um erro ao conectar com Banco de Dados C-Plus!!!\n " + e);
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                //TODO: use um sistema de log apropriado.
                JOptionPane.showMessageDialog(null, "Houve um erro ao fexar conexão Banco de Dados C-Plus!!!\n " + e);
            }
        }
    }

    public Integer ultimoCodigo(String nomeTabela, String nomeCampo) {
        StringBuilder sql = new StringBuilder();
        Integer str = 0;
        sql.append("SELECT * ");
        sql.append("FROM Codigo ");
        sql.append("WHERE nomeTabela =?");
        //sql.append(nomeTabela);
        sql.append(" AND nomeCampo =?");
        //sql.append(nomeCampo);
        Connection conn = getConnection();

        PreparedStatement comando;
        try {
            comando = conn.prepareStatement(sql.toString());
            comando.setString(1,  nomeTabela);
            comando.setString(2,  nomeCampo);
            ResultSet resultado;
            resultado = comando.executeQuery();
            while (resultado.next()) {
                str = Integer.valueOf(resultado.getString("ultimoCodigo"));
            }
            resultado.close();
            comando.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }             
        return str;
    }
    
    public void atualizarCodigo(String nomeTabela, String nomeCampo, Integer ultimoCodigo ) {
        StringBuilder sql = new StringBuilder();
       // String str = "";
        sql.append("UPDATE CODIGO ");
        sql.append("SET ultimoCodigo =?");
        sql.append(" WHERE nomeTabela =?");       
        sql.append(" AND nomeCampo =?");
        //sql.append(nomeCampo);
        Connection conn = getConnection();
        PreparedStatement comando;
        try {
            comando = conn.prepareStatement(sql.toString());
            comando.setInt(1,  ultimoCodigo);
            comando.setString(2,  nomeTabela);
            comando.setString(3,  nomeCampo);
            comando.executeUpdate();
            comando.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }             
        
    }

}
