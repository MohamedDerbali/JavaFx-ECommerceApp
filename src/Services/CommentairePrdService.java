/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Commentaire_prod;
import Entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author derba
 */
public class CommentairePrdService  {
private Connection connection=utils.connect.getInstance().getCnx();
    private Statement ste;
    private PreparedStatement ps;
    private ResultSet rs;

    public void add(Commentaire_prod T) {
     String req ="insert into commentaire_prod(id_user,comment,datePublication,Rate,id_Prod) values('"+21+"','"+T.getCommentaire()+"','"+T.getDatePublication()+"','"+T.getRate()+"','"+T.getIdprd()+"')";
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CommentairePrdService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Commentaire_prod> FindAll(int idp) {
          ObservableList <Commentaire_prod> list = FXCollections.observableArrayList();
  String req="select * from Commentaire_prod where id_Prod = '"+idp+"'";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int id=rs.getInt("id");
               int idusr= rs.getInt("id_user");
               String comment =rs.getString("comment");
               Date datePublication =rs.getDate("datePublication");
               String Rate =rs.getString("Rate");
               
              
               
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Commentaire_prod s = new Commentaire_prod( id, idusr ,comment,datePublication,Rate,idp);
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return list; 
    }

    public Commentaire_prod Find(int id) {
     String req="select * from Commentaire_prod where id = '"+id+"'";
           Commentaire_prod s = new Commentaire_prod();
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                   
               int idusr= rs.getInt("id_user");
               String comment =rs.getString("comment");
               Date datePublication =rs.getDate("datePublication");
               String Rate =rs.getString("Rate");
               int id_Prod =rs.getInt("id_Prod");
              
             s.setId(id);
             s.setCommentaire(comment);
             s.setDatePublication(datePublication);
             s.setIdprd(id_Prod);
             s.setRate(Rate);
             s.setUserid(idusr);
             
             }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }

        return s;
    }
    public User Finduser(int id) {
     String req="select * from utilisateur where id = '"+id+"'";
           User s = new User();
             

        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                   
               String nomUser =rs.getString("Nom");
               String prenomUser =rs.getString("Prenom");
               String adressUser =rs.getString("Adresse");
               String emailUser =rs.getString("email");
               String userName =rs.getString("username");
               String usernameCanonical =rs.getString("username_canonical");
               String emailCanonical =rs.getString("email_canonical");
             s.setIdUser(id);
             s.setAdressUser(adressUser);
             s.setNomUser(nomUser);
             s.setPrenomUser(prenomUser);
             s.setUsernameCanonical(usernameCanonical);
             s.setUserName(userName);
             s.setEmailUser(emailUser);
             s.setEmailCanonical(emailCanonical);
             
             }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }

        return s;
    }
    public int counte() {
        String req="select count(*) as qte from commentaire_prod";
      int x=0;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int num=rs.getInt("qte");
        return num;
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        
          
    return 0;
    }

  
    public void remove(Commentaire_prod T) {
    String req="delete from commentaire_prod where id = '"+T.getId()+"'";

          try {
             ste=connection.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(CommentairePrdService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }


    public void Modif(Commentaire_prod T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
