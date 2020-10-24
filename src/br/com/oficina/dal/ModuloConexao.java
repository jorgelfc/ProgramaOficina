/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.dal;

import com.mysql.cj.jdbc.ha.ReplicationConnectionGroupManager;
import java.sql.*;
import java.util.*;


/**
 *
 * @author jorgecosta
 */
public class ModuloConexao {

    public static Connection conector() {

        java.sql.Connection conexao = null;

        //A linha abaixo chama o driver
        String Driver = "com.mysql.cj.jdbc.Driver";
        //Armazenando informacões sobre o banco.
        String url = "jdbc:mysql://localhost:3306/dboficina";
        String user = "root";
        String pass = "Julia001";

        //Estabelecendo a conexão.
        try {
            Class.forName(Driver);
            conexao = DriverManager.getConnection(url, user, pass);
            return conexao;
            
        } catch (Exception e) {
            //System.out.println(e);
            return null;
            
        }
    }

}
