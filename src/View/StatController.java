/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Commande;
import Services.ServiceCommande;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class StatController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private AnchorPane stat;
    @FXML
    private PieChart statou;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        ServiceCommande xD=new ServiceCommande();
        ObservableList<Commande>k = xD.FindAll();
        
ObservableList<Data> answer = FXCollections.observableArrayList();
    for(Commande t : k ){
answer.add(new PieChart.Data("Commande :"+t.getId(), t.getQuantite())
);
      
       }
         statou = new PieChart(answer);
        statou.setTitle("Quantité Vendu Commandes");
       stat.getChildren().add(statou);
    }    
    

    @FXML
    private void presscmde(ActionEvent event) throws IOException {
           AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLCommande.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(root);
    }
    
}
