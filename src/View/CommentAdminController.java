/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class CommentAdminController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Button commande;
    @FXML
    private Button Statistique;
    @FXML
    private Button supper;
    @FXML
    private TextField rech;
    @FXML
    private TableView<?> TableCommande;
    @FXML
    private TableColumn<?, ?> Id;
    @FXML
    private TableColumn<?, ?> dateCommande;
    @FXML
    private TableColumn<?, ?> dateMax;
    @FXML
    private TableColumn<?, ?> etat_vendu;
    @FXML
    private TableColumn<?, ?> id_user;
    @FXML
    private TableColumn<?, ?> etatLocation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void commandePress(ActionEvent event) {
    }

    @FXML
    private void StatistiquePress(ActionEvent event) {
    }

    @FXML
    private void SupprimerCommande(ActionEvent event) {
    }

    @FXML
    private void RechercheCommande(KeyEvent event) {
    }
    
}
