/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entity.Produit;
import Services.ProduitService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author derba
 */
public class Panier {
    public static int itemCount ;
    public   static double totalPrice;
    private static HashMap<Produit,Integer> ptm=new HashMap<>();
    public Panier()
    {

     
      itemCount = 0;
      totalPrice = 0.0;
    }
      public Boolean addToCart(Produit m)
    {    if(Integer.parseInt(m.getQuantity())==0)
        return false;
 
             for (Map.Entry<Produit, Integer> entry : ptm.entrySet()) {
        
                if(entry.getKey().equals(m)){
                    if(entry.getValue()< Integer.parseInt(m.getQuantity())){
                    ptm.replace(entry.getKey(),entry.getValue(),(entry.getValue()+1));
                    totalPrice += Integer.parseInt(m.getPrice()) * Integer.parseInt(m.getQuantity());
                    itemCount++;
                  return true;
                }
                 return false;
            }}
             ptm.put(m, 1);
             totalPrice += Integer.parseInt(m.getPrice()) * Integer.parseInt(m.getQuantity());
             itemCount++;
             return true;
    }
        public static void PassCommande(HashMap<Produit,Integer> xD)
    {           ProduitService pc = new ProduitService();
             for (Map.Entry<Produit, Integer> entry : xD.entrySet()) {
   
         
             pc.commandePass(entry.getKey().getId(),entry.getValue());
                 
                }
             

    }
        
    
    public  int getItemCount() {
        return itemCount;
    }

    public  void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public  double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static HashMap<Produit, Integer> getPtm() {
        return ptm;
    }

    public static void setPtm(HashMap<Produit, Integer> ptm) {
        Panier.ptm = ptm;
    }
    public static void viderPanier(){
       Panier.setPtm(new HashMap<> ());
       
      Panier.itemCount = 0;
      Panier.totalPrice = 0.0;
       
    }
}


