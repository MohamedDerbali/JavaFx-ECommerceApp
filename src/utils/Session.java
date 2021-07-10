/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entity.User;


/**
 *
 * @author esprit
 */
public class Session {

    private static User connectedUser;
  
    public Session() {
        connectedUser=new User(21, "Hiba", "Sfexi", "Rasjbel", "hibasfaxi19@gmail.com", "Hiba", "hiba", "hibasfaxi19@gmail.com");

    }

    public static User getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(User connectedUser) {
        Session.connectedUser = connectedUser;
    }
    
    public static void logOut() {
        Session.connectedUser = null;
    }
    
    
}
