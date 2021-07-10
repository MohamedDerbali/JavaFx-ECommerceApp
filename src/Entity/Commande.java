/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author derba
 */
public class Commande {
    private int id;
    private Date dateLivraison;
    private float prixTotal;
    private String adresse2;
    private String adresse;
    private String ville;
    private String codePostal;
    private int numTel;
    private int quantite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande(Date dateLivraison, float prixTotal, String adresse2, String adresse, String ville, String codePostal, int numTel, int quantite) {
        this.dateLivraison = dateLivraison;
        this.prixTotal = prixTotal;
        this.adresse2 = adresse2;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.numTel = numTel;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", dateLivraison=" + dateLivraison + ", prixTotal=" + prixTotal + ", adresse2=" + adresse2 + ", adresse=" + adresse + ", ville=" + ville + ", codePostal=" + codePostal + ", numTel=" + numTel + ", quantite=" + quantite + '}';
    }
    
    
  
}
