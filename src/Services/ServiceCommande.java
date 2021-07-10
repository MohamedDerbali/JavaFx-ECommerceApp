/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Commande;
import Entity.Produit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author derba
 */
public class ServiceCommande  {
private Connection connection=utils.connect.getInstance().getCnx();
    private Statement ste;
    private PreparedStatement ps;
    private ResultSet rs;
      
    public void add(Commande T) {
     String req ="insert into ligne_de_commande(prixTotal,adresse2,adresse,ville,codePostal,numTel,dateLivraison,quantite) values('"+T.getPrixTotal()+"','"+T.getAdresse2()+"','"+T.getAdresse()+"','"+T.getVille()+"','"+T.getCodePostal()+"','"+T.getNumTel()+"','"+T.getDateLivraison()+"','"+T.getQuantite()+"')";
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Commande> TriAll() {
        ArrayList<Commande> list =  new ArrayList<Commande>();
        String req="select * from ligne_de_commande";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
              int id=rs.getInt("id");
               int quantite=rs.getInt("quantite");
               Date dateLivraison= rs.getDate("dateLivraison");
           
               int numTel =rs.getInt("numTel");
                String codePostal =rs.getString("codePostal");
               String ville =rs.getString("ville");
               String adresse =rs.getString("adresse");
               String adresse2 =rs.getString("adresse2");
               float prixTotal =rs.getFloat("prixTotal");
   
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Commande s = new Commande(dateLivraison, prixTotal, adresse2, adresse, ville, codePostal, numTel, quantite);
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return list; 
    }
    public ObservableList <Commande> FindAll() {
        ObservableList <Commande> list =  FXCollections.observableArrayList();
        String req="select * from ligne_de_commande";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int id=rs.getInt("id");
               int quantite=rs.getInt("quantite");
               Date dateLivraison= rs.getDate("dateLivraison");
               int numTel =rs.getInt("numTel");
               String codePostal =rs.getString("codePostal");
               String ville =rs.getString("ville");
               String adresse =rs.getString("adresse");
               String adresse2 =rs.getString("adresse2");
               float prixTotal =rs.getFloat("prixTotal");
   
              
                
               Commande s = new Commande(dateLivraison, prixTotal, adresse2, adresse, ville, codePostal, numTel, quantite);
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }  list.stream().forEach(System.out::println);
        return  list; 
    }
    public void delete(Commande t) {
        String req="delete from Commande where id = '"+t.getId()+"'";

          try {
             ste=connection.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
              System.out.println("erreur");
        }  
    }
    
  public ObservableList<Commande> listerRecherche(String recherche) {
        ObservableList<Commande> lsist = FXCollections.observableArrayList();
          String req = "SELECT * FROM ligne_de_commande WHERE adresse2 like '%" + recherche + "%' or codePostal  like '%" + recherche + "%' or adresse  like '%" + recherche + "%'or prixTotal  like '%" + recherche + "%' or numTel  like '%" + recherche+"%' ";
         
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                int id=rs.getInt("id");
               int quantite=rs.getInt("quantite");
               Date dateLivraison= rs.getDate("dateLivraison");
              
               int numTel =rs.getInt("numTel");
                String codePostal =rs.getString("codePostal");
               String ville =rs.getString("ville");
               String adresse =rs.getString("adresse");
               String adresse2 =rs.getString("adresse2");
               float prixTotal =rs.getFloat("prixTotal");
   
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Commande s = new Commande(dateLivraison, prixTotal, adresse2, adresse, ville, codePostal, numTel, quantite);
               s.setId(id);
               lsist.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return lsist; 
    }

  
    public void remove(Commande T) {
    String req="delete from ligne_de_commande where id = '"+T.getId()+"'";

          try {
             ste=connection.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }


    public void Modif(Commande T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
