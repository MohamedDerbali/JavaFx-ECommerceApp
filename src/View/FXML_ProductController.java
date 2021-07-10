/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Produit;
import Entity.User;
import Services.ProduitService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import utils.Panier;
import static utils.Panier.PassCommande;
import static utils.Panier.viderPanier;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class FXML_ProductController implements Initializable {
 double xOffset=0;
double yOffset=0;



    @FXML
    private ScrollPane scroll;
    @FXML
    private AnchorPane panelle;
    @FXML
    private Text elementpanier;
    @FXML
    private ImageView panier;
    public ObservableList<Produit>lst=null;
     Panier P = new Panier();
  public static int SelectedElement;
    ProduitService sb=new ProduitService();
    @FXML
    private TextField search;
    @FXML
    private CheckBox available;
    @FXML
    private CheckBox mostp;
    @FXML
    private CheckBox pompe;
    @FXML
    private CheckBox lowp;
    @FXML
    private CheckBox clepedale;
    @FXML
    private CheckBox otherstype;
    @FXML
    private CheckBox f11;
    @FXML
    private CheckBox f10;
    @FXML
    private CheckBox othersmodel;
    @FXML
    private MenuItem afficher;
    @FXML
    private MenuItem ajouterProd;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
     try {
         
         FileInputStream x = new FileInputStream("C:\\Users\\derba\\OneDrive\\Documents\\NetBeansProjects\\Gabtni\\src\\image\\126083.png");
         
                  Image image = new Image(x);
                   panier.setImage(image);
     } catch (FileNotFoundException ex) {
         Logger.getLogger(FXML_ProductController.class.getName()).log(Level.SEVERE, null, ex);
     }
       afficherGrid(sb.FindAll());
        
     
  

    
    }
    
    public void changePage(String emplacement) throws IOException{
         AnchorPane root = FXMLLoader.load(getClass().getResource(emplacement));
        panelle.getChildren().removeAll();
        panelle.getChildren().setAll(root);
    }
    
    
    
    public static int Idstat(){
        return SelectedElement;
    }
void afficherGrid(ObservableList<Produit>lst){
    Session conUser=new Session();
                       User Usr = conUser.getConnectedUser(); 
                       ProduitService K=new ProduitService();
        int elements=lst.size();

          GridPane grid = new GridPane();

    grid.setPadding(new javafx.geometry.Insets(10,10,10,10));

 



 grid.setHgap(10);
 grid.setVgap(10);
 int cols=4, colCnt = 0, rowCnt = 0;

    for (int i=0; i<elements; i++) {
FileInputStream input = null;
              try {
                  input = new FileInputStream("C:\\Users\\derba\\OneDrive\\Documents\\NetBeansProjects\\Gabtni\\src\\image\\"+lst.get(i).getPhoto());
        
                  Image image = new Image(input);
                  ImageView imageView = new ImageView(image);
                  imageView.setFitHeight(100);
                  imageView.setFitWidth(100);
                  Label label1 = new Label(lst.get(i).getModel());
                  Label label2 = new Label(lst.get(i).getType());
                  Label label3 = new Label(lst.get(i).getQuantity());
                  Label label4 = new Label(lst.get(i).getPrice()+" $");
                  int xid=lst.get(i).getId();
                  Button btn=new Button("comment");
                  Button tnl=new Button("Add to Panier");
                 Button WishButton=new Button("remove From wishlist");
                 
                  tnl.setOnAction((event) -> {
                    //add panier 
                    if(P.addToCart(sb.Find(xid))){
                      Panier.getPtm().values().stream().forEach(System.out::println);
                       Panier.getPtm().keySet().stream().forEach(System.out::println);
                       System.out.println("total"+P.getItemCount());
                       System.out.println("total Price"+P.getTotalPrice());
                        String s=Integer.toString(P.getItemCount());
                       elementpanier.setText(s);
                       
               //end add panier
                  }
                    else{
                        System.out.println("Product out of stock !!");
                    }
                    
                  });
                  if(K.checkwish(Usr.getIdUser(),xid)==false){
                        WishButton=new Button("  ");
                  WishButton.setStyle("-fx-shape: \"M23.6,0c-3.4,0-6.3,2.7-7.6,5.6C14.7,2.7,11.8,0,8.4,0C3.8,0,0,3.8,0,8.4c0,9.4,9.5,11.9,16,21.2\n" +
"        c6.1-9.3,16-12.1,16-21.2C32,3.8,28.2,0,23.6,0z\"; -fx-background-color:red;");
                      
                   
                  WishButton.setOnAction((event) -> {
                       
                       
                       K.addTowishList(Usr.getIdUser(),xid);
                      afficherGrid(sb.FindAll());
                  });
                  }
                  else{
                       
                WishButton.setOnAction((event) -> {
                       
                       
                       K.RemoveFromwishList(Usr.getIdUser(),xid);
                      afficherGrid(sb.FindAll());
                  });
                  }
                  VBox root = new VBox(label1,imageView,label2,label3,label4,btn,tnl,WishButton);
                  btn.setOnAction((event) -> {
        
                        SelectedElement=xid;
                      try {
                          changePage("FXMLCommentProduit.fxml");
                      } catch (IOException ex) {
                          Logger.getLogger(FXML_ProductController.class.getName()).log(Level.SEVERE, null, ex);
                      }
                     
                  });
                  grid.add(root,colCnt,rowCnt);
                  colCnt+=1;
                  if (colCnt>cols) {
                      rowCnt++;
                      colCnt=0;
                  }     } catch (FileNotFoundException ex) {
              } 
    }
    scroll.setContent(grid);

}
    @FXML
    private void recherc(KeyEvent evt) {




search.textProperty().addListener((observable, oldValue, newValue) -> {       
afficherGrid(sb.listerRecherche(newValue));
      
    

    
                    
    });          
}  

    @FXML
    private void availably(ActionEvent event) {
     
        if(available.isSelected()==true){
           
          lst=sb.FindAval("0");
 //lst= lst.stream().filter(x->x.getQuantity().compareTo("0")<0).collect(Collectors.toCollection(FXCollections::observableArrayList));
  
     
         afficherGrid(lst);
            
        }
       
    }

    @FXML
    private void mostps(ActionEvent event) {
    if(mostp.isSelected()==true){
        lst=sb.tricro();
        afficherGrid(lst);
        lowp.setDisable(true);
    }
    else{
        lowp.setDisable(false);
    }
    }

    @FXML
    private void lowps(ActionEvent event) {
    if(lowp.isSelected()==true){
        lst=sb.tridec();
        afficherGrid(lst);
        mostp.setDisable(true);
    }
    else{
        mostp.setDisable(false);
    }
    }

    @FXML
    private void pomp(ActionEvent event) { 
         lst=sb.FindAll();
     if(pompe.isSelected()==true){
       
             ObservableList<Produit> Xd = lst.stream().filter(x->x.getType().toUpperCase().contains("POMPE")).collect(Collectors.toCollection(FXCollections::observableArrayList));
       Xd.stream().forEach(System.out::println);
        afficherGrid(Xd);
        clepedale.setDisable(true);
        otherstype.setDisable(true);
    }
    else{
           clepedale.setDisable(false);
        otherstype.setDisable(false);
    }
       
     
    }

    @FXML
    private void cle(ActionEvent event) {
            lst=sb.FindAll();
     if(clepedale.isSelected()==true){
       
             ObservableList<Produit> Xd = lst.stream().filter(x->x.getType().toLowerCase().contains("clé")).collect(Collectors.toCollection(FXCollections::observableArrayList));
       Xd.stream().forEach(System.out::println);
        afficherGrid(Xd);
        otherstype.setDisable(true);
        pompe.setDisable(true);
    }
    else{
           pompe.setDisable(false);
        otherstype.setDisable(false);
    }
    }

    @FXML
    private void othertp(ActionEvent event) {
              lst=sb.FindAll();
     if(otherstype.isSelected()==true){
       
             ObservableList<Produit> Xd = lst.stream().filter(x->x.getType().toLowerCase().contains("clé")==false && x.getType().toUpperCase().contains("POMPE")==false).collect(Collectors.toCollection(FXCollections::observableArrayList));
    
        afficherGrid(Xd);
        clepedale.setDisable(true);
        pompe.setDisable(true);
    }
    else{
           pompe.setDisable(false);
        clepedale.setDisable(false);
    }
    }

    @FXML
    private void fonze(ActionEvent event) {
              lst=sb.FindAll();
     if(f11.isSelected()==true){
       
             ObservableList<Produit> Xd = lst.stream().filter(x->x.getModel().toUpperCase().contains("FT11")).collect(Collectors.toCollection(FXCollections::observableArrayList));
    
        afficherGrid(Xd);
        f10.setDisable(true);
        othersmodel.setDisable(true);
    }
    else{
           f10.setDisable(false);
        othersmodel.setDisable(false);
    }
       
    }

    @FXML
    private void fdix(ActionEvent event) {
              lst=sb.FindAll();
     if(f10.isSelected()==true){
       
             ObservableList<Produit> Xd = lst.stream().filter(x->x.getModel().toUpperCase().contains("f10")).collect(Collectors.toCollection(FXCollections::observableArrayList));
      
        afficherGrid(Xd);
        f11.setDisable(true);
        othersmodel.setDisable(true);
    }
    else{
           f11.setDisable(false);
        othersmodel.setDisable(false);
    }
       
    }

    @FXML
    private void othr(ActionEvent event) {
              lst=sb.FindAll();
     if(othersmodel.isSelected()==true){
       
              ObservableList<Produit> Xd = lst.stream().filter(x->x.getType().toLowerCase().contains("FT11")==false && x.getType().toUpperCase().contains("f10")==false).collect(Collectors.toCollection(FXCollections::observableArrayList));
     
        afficherGrid(Xd);
        f11.setDisable(true);
        f10.setDisable(true);
    }
    else{
           f11.setDisable(false);
        f10.setDisable(false);
    }
       
    }

    @FXML
    private void CloseAction(ActionEvent event) {
    }

    @FXML
    private void print(ActionEvent event) throws IOException {
         changePage("FXML_Product.fxml");
    }

    @FXML
    private void add(ActionEvent event) throws IOException {
         changePage("FXMLAddProduit.fxml");
    }

    @FXML
    private void LocationAction(ActionEvent event) {
    }

    @FXML
    private void PannPage(MouseEvent event) throws IOException {
        changePage("pannPage.fxml");
    }

  
    }
    
    