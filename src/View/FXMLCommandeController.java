/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Commande;
import Services.ServiceCommande;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;


/**
 * FXML Controller class
 *
 * @author derba
 */
public class FXMLCommandeController implements Initializable {
 

  
    private int CurrentSelected;
    @FXML
    private TextField rech;
    @FXML
    private Button commande;
    @FXML
    private Button Statistique;
    @FXML
    private Button supper;
    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<Commande> TableCommande;
    @FXML
    private TableColumn<Commande, String> email;
    @FXML
    private TableColumn<Commande, String> adrese;
    @FXML
    private TableColumn<Commande, String> codepostal;
    @FXML
    private TableColumn<Commande, Integer> numtel;
    @FXML
    private TableColumn<Commande, Date> dateliv;
    @FXML
    private TableColumn<Commande, Integer> qte;
    @FXML
    private TableColumn<Commande, Float> prixtot;
    @FXML
    private TableColumn<Commande, Integer> id;
    @FXML
    private TableColumn<Commande, String> ville;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       buildTableviewCommandeData();
      buildTableviewRecherche();
supper.setDisable(true);
   supper.setDisable(true); 
}
 
   
   
    private void buildTableviewCommandeData() {
       
      
 ServiceCommande cs = new ServiceCommande();
     
     id.setCellValueFactory(new PropertyValueFactory<>("id"));
email.setCellValueFactory(new PropertyValueFactory<>("adresse"));
adrese.setCellValueFactory(new PropertyValueFactory<>("adresse2"));
codepostal.setCellValueFactory(new PropertyValueFactory<>("codePostal"));
numtel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
dateliv.setCellValueFactory(new PropertyValueFactory<>("dateLivraison"));
qte.setCellValueFactory(new PropertyValueFactory<>("quantite"));
prixtot.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));
ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
 
        TableCommande.setItems(cs.FindAll());


    }
     
         private void buildTableviewRecherche() {

        rech.textProperty().addListener((observable, oldValue, newValue) -> {
           ServiceCommande sf = new ServiceCommande();
            
           TableCommande.setItems(sf.listerRecherche(newValue));
           if (newValue.equals("")) {
               TableCommande.setItems(sf.FindAll());
           }
            TableCommande.refresh();

        });
    }
  
    
      @FXML
    void SupprimerCommande(ActionEvent event) {
ServiceCommande sa= new ServiceCommande();
 Commande A = TableCommande.getSelectionModel().getSelectedItem();
          System.out.println(A);
     sa.remove(A);
       buildTableviewCommandeData();
      
    }
public void exportCalendarPDF() throws FileNotFoundException,DocumentException {

 //FileNotFoundException, DocumentException 
              Document doc = new Document();
FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF files (.pdf)", ".pdf"),
                new FileChooser.ExtensionFilter("HTML files (.html)", ".html")
        );
        File saveFile = fileChooser.showSaveDialog(TableCommande.getScene().getWindow());

      //  file.save(saveFile.getAbsolutePath());

        PdfWriter.getInstance(doc,new FileOutputStream(saveFile.getAbsolutePath()));
        doc.open();
        System.out.println(doc.getHtmlStyleClass());
        ServiceCommande cas= new ServiceCommande();
         for ( Commande p :cas.FindAll())
         {
        doc.add(new Paragraph("Email :"+p.getAdresse()));
        doc.add(new Paragraph("Address  :"+p.getAdresse2()));
        doc.add(new Paragraph("Code Postal  :"+p.getCodePostal()));
        doc.add(new Paragraph("Ville  :"+p.getVille()));
        doc.add(new Paragraph("Date  :"+p.getDateLivraison()));
        doc.add(new Paragraph("=========================================="));
         }

        doc.close();

    }
    @FXML
    private void commandePress(ActionEvent event) throws IOException {
          AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLCommande.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(root);
    }

    @FXML
    private void StatistiquePress(ActionEvent event) throws IOException {
          AnchorPane root = FXMLLoader.load(getClass().getResource("Stat.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(root);
    }

    @FXML
    private void pdf(ActionEvent event) throws FileNotFoundException, DocumentException {
        exportCalendarPDF();
    }
    
}
