/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Owner
 */
public class sales {
    
    private int idsales ; 
    private String saleDescription ; 
    private int idvendors ; 
    private String posales ;

    public sales(int idsales, String saleDescription, int idvendors, String posales) {
        this.idsales = idsales;
        this.saleDescription = saleDescription;
        this.idvendors = idvendors;
        this.posales = posales;
    }

    public sales (){
    
    }
    public int getIdsales() {
        return idsales;
    }

    public void setIdsales(int idsales) {
        this.idsales = idsales;
    }

    public String getSaleDescription() {
        return saleDescription;
    }

    public void setSaleDescription(String saleDescription) {
        this.saleDescription = saleDescription;
    }

    public int getIdvendors() {
        return idvendors;
    }

    public void setIdvendors(int idvendors) {
        this.idvendors = idvendors;
    }

    public String getPosales() {
        return posales;
    }

    public void setPosales(String posales) {
        this.posales = posales;
    }
}
