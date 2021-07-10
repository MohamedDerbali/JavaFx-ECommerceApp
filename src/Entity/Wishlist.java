/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author derba
 */
public class Wishlist {
    private int id;
    private int id_cl;
    private int id_pro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cl() {
        return id_cl;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    @Override
    public String toString() {
        return "Wishlist{" + "id=" + id + ", id_cl=" + id_cl + ", id_pro=" + id_pro + '}';
    }

    public Wishlist(int id_cl, int id_pro) {
        this.id_cl = id_cl;
        this.id_pro = id_pro;
    }
    
}
