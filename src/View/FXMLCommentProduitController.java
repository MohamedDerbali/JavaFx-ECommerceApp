/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Entity.User;
import Entity.Commentaire_prod;
import Entity.Produit;
import Services.CommentairePrdService;
import Services.ProduitService;
import static View.FXML_ProductController.Idstat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class FXMLCommentProduitController implements Initializable {

    @FXML
    private VBox commentaireview;
    @FXML
    private TextArea textComment;
VBox root;
    @FXML
    private AnchorPane contains;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           
ProduitService sb=new ProduitService();
Produit lst=sb.Find(Idstat());


  CommentairePrdService cs=new CommentairePrdService();


FileInputStream input = null;
              try {
                  input = new FileInputStream("C:\\Users\\derba\\OneDrive\\Documents\\NetBeansProjects\\Gabtni\\src\\image\\"+lst.getPhoto());
        
                  Image image = new Image(input);
                  ImageView imageView = new ImageView(image);
                  imageView.setFitHeight(100);
                  imageView.setFitWidth(100);
                  Label label1 = new Label(lst.getModel());
                  Label label2 = new Label(lst.getType());
                  Label label3 = new Label(lst.getQuantity());
                  Label label4 = new Label(lst.getPrice()+" $");
                 
                  root = new VBox(label1,imageView,label2,label3,label4);
                 
                       } catch (FileNotFoundException ex) {
                  Logger.getLogger(FXML_ProductController.class.getName()).log(Level.SEVERE, null, ex);
              } 
             contains.getChildren().add(root);
            printAllcomment();
             
               //  System.out.println("Product id:"+Idstat());
    }
    void printAllcomment(){
       
        commentaireview.getChildren().clear();
  CommentairePrdService cs=new CommentairePrdService();
 
String[] filter = new String[] {"blue", "red","green","yellow"};
String etoiless = "*****";
         for(Commentaire_prod ct:cs.FindAll(Idstat())){

             String comment=ct.getCommentaire();
        
for (String s : filter)
{
  if (comment.contains(s))
  {
comment = comment.replaceAll("\\b"+s+"\\b", etoiless);

    
  }
}
            
 
            //ImageView
            Label lcoment = new Label(comment);     
            Label split = new Label(" ");
            Label ldate = new Label(ct.getDatePublication().toString());
             HBox hb=new HBox(lcoment,split,ldate);
            //user Session instance
            Session conUser=new Session();
        
           if(conUser.getConnectedUser().equals(cs.Finduser(ct.getUserid()))){
               
            Button removeMycomment=new Button("Remove");
                  hb=new HBox(lcoment,split,ldate,removeMycomment);
                  removeMycomment.setOnAction((event) -> {
                      cs.remove(ct);
                      printAllcomment();
                  });
            } 
           //End user Session instance
            
                 commentaireview.getChildren().add(hb);
             }
    }

    @FXML
    private void commenter(ActionEvent event) {
        CommentairePrdService cs=new CommentairePrdService();
        Commentaire_prod cpt=new Commentaire_prod();
        cpt.setCommentaire(textComment.getText());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        cpt.setDatePublication(sqlDate);
        cpt.setIdprd(Idstat());
        cs.add(cpt);
     
        printAllcomment();
        
    }

    

    
     
    }    
    

