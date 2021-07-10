/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amani
 */
public class connect {

    private String url = "jdbc:mysql://localhost/velo";
    private String login = "root";
    private String password = "";

    private java.sql.Connection cnx;

    private static connect instance;

    private connect() {
        try {
            cnx = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }

    }

    public static connect getInstance() {
        if (instance == null) {
            instance = new connect();
        }

        return instance;
    }

    public java.sql.Connection getCnx() {
        return cnx;
    }

    public void setCnx(java.sql.Connection cnx) {
        this.cnx = cnx;
    }

}
