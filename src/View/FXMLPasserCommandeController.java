/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Commande;
import Services.ServiceCommande;
import java.net.URL;
import java.sql.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import utils.Panier;
import static utils.Panier.PassCommande;
import static utils.Panier.viderPanier;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class FXMLPasserCommandeController implements Initializable {

    @FXML
    private TextField adre;
    @FXML
    private TextField email;
    @FXML
    private TextField ville;
    @FXML
    private TextField codepos;
    @FXML
    private TextField num;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  
    }    

    @FXML
    private void passerCmde(ActionEvent event) throws MessagingException {
        ServiceCommande SCc=new ServiceCommande();
        
        java.util.Date today=new java.util.Date();
         
        Date sqlDate = new Date(today.getTime());
        Commande cde=new Commande(sqlDate, (float)Panier.totalPrice, adre.getText(), email.getText(), ville.getText(), codepos.getText(), Integer.parseInt(num.getText()), Panier.itemCount);
        SCc.add(cde);
        PassCommande(Panier.getPtm());
        viderPanier();
        mailling(email.getText());
    }
 public void mailling(String adr) {

        //authentication info
        final String username = "velov638@gmail.com";
        final String password = "Velo123456789.";
        String fromEmail = "test.nom2020@gmail.com";


        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }

});
        //Start our mail message
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
                                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(adr)); 
            msg.setSubject("Commande");
            msg.setText("Votre Commande est Passé avec Succées !");
             
            Transport.send(msg);
            
        }catch (MessagingException e) {
            e.printStackTrace();
        }
        // TODO Auto-generated catch block

    }
    
}
