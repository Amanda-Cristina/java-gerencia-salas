/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoDados;

import java.sql.*;

/**
 *
 * @author Monica
 */
public class CriaBaseDados {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/";
        String senha = "root";
        String user = "root";
        String baseBD = "LOO_2021_2";
        String sql = "CREATE DATABASE " + baseBD;
        try {
            Connection conexao = DriverManager.getConnection(url, user, senha);
            Statement sessao = conexao.createStatement();
            sessao.executeUpdate(sql);
            System.out.println("Database " + baseBD + " criado com successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
