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
public class Commentaire_prod {
 private int id;
 private int userid;
 private String commentaire;
 private Date datePublication;
 private String Rate;
 private int idprd;

    public Commentaire_prod() {
        this.Rate="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String Rate) {
        this.Rate = Rate;
    }

    public int getIdprd() {
        return idprd;
    }

    public void setIdprd(int idprd) {
        this.idprd = idprd;
    }

    @Override
    public String toString() {
        return "commentaire_prod{" + "id=" + id + ", userid=" + userid + ", commentaire=" + commentaire + ", datePublication=" + datePublication + ", Rate=" + Rate + ", idprd=" + idprd + '}';
    }

    public Commentaire_prod(int id, int userid, String commentaire, Date datePublication, String Rate, int idprd) {
        this.id = id;
        this.userid = userid;
        this.commentaire = commentaire;
        this.datePublication = datePublication;
        this.Rate = Rate;
        this.idprd = idprd;
    }

    public Commentaire_prod(String commentaire, Date datePublication, String Rate) {
        this.commentaire = commentaire;
        this.datePublication = datePublication;
        this.Rate = Rate;
    }
 
}
