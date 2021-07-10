/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import utils.connect;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esprit
 */
public class LoginDao {

    private Statement st;
    private ResultSet rs;
    private static LoginDao instance;

    public LoginDao() {

    }

    public static LoginDao getInstance() {
        if (instance == null) {
            return new LoginDao();
        }
        return instance;
    }

    public User login(String email, String password) {
        User connectedUser = null;
        try {

            Connection connection = utils.connect.getInstance().getCnx();
            Statement ste = connection.createStatement();

            ResultSet rs = ste.executeQuery("SELECT * FROM User WHERE email= " + "'" + email + "'"
                    + " AND password_plain= " + "'" + password + "'");

            while (rs.next()) {
                if (rs.getString("email") != null && rs.getString("password_plain") != null) {
                    System.out.println("login User " + rs);
                    connectedUser = new User();
                    connectedUser.setIdUser(rs.getInt("id"));
                    connectedUser.setNomUser(rs.getString("nom"));
                    connectedUser.setPrenomUser(rs.getString("prenom"));
                    connectedUser.setEmailUser(rs.getString("email"));
                    connectedUser.setRole(rs.getString("role"));
                 connectedUser.setEnabled(rs.getBoolean("enabled"));
                 
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connectedUser;
    }
}
