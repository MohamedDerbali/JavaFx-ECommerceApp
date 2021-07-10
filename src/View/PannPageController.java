/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Produit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import utils.Panier;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class PannPageController implements Initializable {

    @FXML
    private AnchorPane xD;
    @FXML
    private ScrollPane scrl;
    @FXML
    private TextField nbre;
    @FXML
    private TextField ttp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          GridPane grid = new GridPane();

    grid.setPadding(new javafx.geometry.Insets(10,10,10,10));
 int cols=1, colCnt = 0, rowCnt = 0;
 



 grid.setHgap(10);
 grid.setVgap(10);
        HashMap<Produit, Integer>ptm=Panier.getPtm();
         for (Map.Entry<Produit, Integer> entry : ptm.entrySet()) {
        
             
                      FileInputStream input = null;
              try {
                  input = new FileInputStream("C:\\Users\\derba\\OneDrive\\Documents\\NetBeansProjects\\Gabtni\\src\\image\\"+ entry.getKey().getPhoto());
        
                  Image image = new Image(input);
                  ImageView imageView = new ImageView(image);
                  imageView.setFitHeight(100);
                  imageView.setFitWidth(100);
                
                  Label label3 = new Label(Integer.toString(entry.getValue()));
                  Label label4 = new Label(entry.getValue() * Double.parseDouble(entry.getKey().getPrice())+" $");
              
                  HBox hbx=new HBox(imageView,label3,label4);
                   grid.add(hbx,colCnt,rowCnt);
                  rowCnt+=1;
                  if (rowCnt>cols) {
                      colCnt++;
                      colCnt=0;
                  }  
                  
    }       catch (FileNotFoundException ex) {    
                Logger.getLogger(PannPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         ttp.setText(Double.toString(Panier.totalPrice));
         nbre.setText(Integer.toString(Panier.itemCount));
     scrl.setContent(grid);
    }

    @FXML
    private void checkout(ActionEvent event) throws IOException {
     
         AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLPasserCommande.fxml"));
        xD.getChildren().removeAll();
        xD.getChildren().setAll(root);
    }
    
    
}
