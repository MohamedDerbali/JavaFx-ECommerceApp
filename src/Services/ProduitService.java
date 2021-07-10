/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Produit;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author derba
 */
public class ProduitService  {
private Connection connection=utils.connect.getInstance().getCnx();
    private Statement ste;
    private PreparedStatement ps;
    private ResultSet rs;

    public void add(Produit T) {
     String req ="insert into Produit(user_id,model,type,price,quantity,photo) values('"+15+"','"+T.getModel()+"','"+T.getType()+"','"+T.getPrice()+"','"+T.getQuantity()+"','"+T.getPhoto()+"')";
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void addTowishList(int user , int produit ) {
     String req ="insert into wishlist(id_cl,id_pro) values('"+user+"','"+produit+"')";
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void RemoveFromwishList(int user , int produit ) {
             String req="delete FROM wishlist WHERE id_cl like " + user + " and id_pro  like " + produit +" ";
         
        try {
             ste=connection.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     
     public boolean checkwish(int user , int produit ){
           String req="SELECT * FROM wishlist WHERE id_cl like " + user + " and id_pro  like " + produit +" ";
         
           try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
               return rs.next();
         
            
        } catch (SQLException ex) {
   
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
     }
   public ObservableList<Produit> FindAval(String x) {
       ObservableList <Produit> list = FXCollections.observableArrayList();
       String req="select * from Produit where quantity <> 0 Order By quantity DESC";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int id=rs.getInt("id");
               String idusr= rs.getString("user_id");
               String model =rs.getString("model");
               String type =rs.getString("type");
               String price =rs.getString("price");
               String quantity =rs.getString("quantity");
               String photo =rs.getString("photo");
               
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Produit s = new Produit( model, type ,price,quantity,photo);
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return list; 
    }
  
            public ObservableList<Produit> MywishList(User ConnectedUsr) {
       ObservableList <Produit> list = FXCollections.observableArrayList();
       String req="SElECT * From produit INNER JOIN wishlist ON wishlist.id_pro=produit.id where wishlist.id_cl = "+ConnectedUsr.getIdUser();
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int id=rs.getInt("id");
               String idusr= rs.getString("user_id");
               String model =rs.getString("model");
               String type =rs.getString("type");
               String price =rs.getString("price");
               String quantity =rs.getString("quantity");
               String photo =rs.getString("photo");
               
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Produit s = new Produit( model, type ,price,quantity,photo);
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return list; 
    }
    public ObservableList<Produit> FindAll() {
       ObservableList <Produit> list = FXCollections.observableArrayList();
       String req="select * from Produit";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int id=rs.getInt("id");
               String idusr= rs.getString("user_id");
               String model =rs.getString("model");
               String type =rs.getString("type");
               String price =rs.getString("price");
               String quantity =rs.getString("quantity");
               String photo =rs.getString("photo");
               
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Produit s = new Produit( model, type ,price,quantity,photo);
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return list; 
    }
    public ObservableList<Produit> tricro() {
       ObservableList <Produit> list = FXCollections.observableArrayList();
       String req="select * from Produit Order By price ASC";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int id=rs.getInt("id");
               String idusr= rs.getString("user_id");
               String model =rs.getString("model");
               String type =rs.getString("type");
               String price =rs.getString("price");
               String quantity =rs.getString("quantity");
               String photo =rs.getString("photo");
               
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Produit s = new Produit( model, type ,price,quantity,photo);
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return list; 
    }
    public ObservableList<Produit> tridec() {
       ObservableList <Produit> list = FXCollections.observableArrayList();
       String req="select * from Produit order By price DESC";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int id=rs.getInt("id");
               String idusr= rs.getString("user_id");
               String model =rs.getString("model");
               String type =rs.getString("type");
               String price =rs.getString("price");
               String quantity =rs.getString("quantity");
               String photo =rs.getString("photo");
               
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Produit s = new Produit( model, type ,price,quantity,photo);
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return list; 
    }
     public ObservableList<Produit> listerRecherche(String recherche) {
       ObservableList <Produit> list = FXCollections.observableArrayList();
        String req = "SELECT * FROM Produit WHERE model like '%" + recherche + "%' or type  like '%" + recherche + "%' or price  like '%" + recherche + "%'or quantity  like '%" + recherche +"%' ";
         
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int id=rs.getInt("id");
               String idusr= rs.getString("user_id");
               String model =rs.getString("model");
               String type =rs.getString("type");
               String price =rs.getString("price");
               String quantity =rs.getString("quantity");
               String photo =rs.getString("photo");
               
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Produit s = new Produit( model, type ,price,quantity,photo);
               s.setId(id);
               list.add(s);
               
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
         
         return list;   
    }  
    public Produit Find(int id) {
     String req="select * from Produit where id = '"+id+"'";
           Produit s = new Produit();
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
          
               String idusr= rs.getString("user_id");
               String model =rs.getString("model");
               String type =rs.getString("type");
               String price =rs.getString("price");
               String quantity =rs.getString("quantity");
               String photo =rs.getString("photo");
                //list.add(new Societe(Id , nom, tel ,adresse,image));
             s.setId(id);
             s.setModel(model);
             s.setPhoto(photo);
             s.setPrice(price);
             s.setQuantity(quantity);
             s.setType(type);
             
             }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }

        return s;
    }
    
    public int counte() {
        String req="select count(*) as qte from Produit";
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

   public String quantity(int k) {
        String req="select quantity as qte from Produit where id = '"+k+"'";
      int x=0;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               String num=rs.getString("qte");
      
        return num;
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        
          
    return "0";
    }
    public void remove(Produit T) {
    String req="delete from Produit where id = '"+T.getId()+"'";

          try {
             ste=connection.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }


    public void Modif(Produit T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void commandePass(int key, Integer value) {
        System.out.println(value);
        try {
           
            ps=connection.prepareStatement("Update Produit set quantity=? where id=? ");
         int b=Integer.parseInt(this.quantity(key)) - value;
            ps.setString(1,Integer.toString(b));
          
            ps.setInt(2, key);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
