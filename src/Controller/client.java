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
public class client {
  
   private  String nombreyapellido ; 
    private int id ; 

    public String getNombreyapellido() {
        return nombreyapellido;
    }

    public void setNombreyapellido(String nombreyapellido) {
        this.nombreyapellido = nombreyapellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public client(String nombreyapellido, int id) {
        this.nombreyapellido = nombreyapellido;
        this.id = id;
    }
     public client() {
        
    }
    public String toString(){
        return this.nombreyapellido;
    }
}
