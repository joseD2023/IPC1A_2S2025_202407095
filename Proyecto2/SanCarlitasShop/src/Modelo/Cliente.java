/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Cliente extends Usuario{ // heredan atributos 
     // vamos a crear atributos del cliente 
    //atributos fuera de la clase padre 
    //genero 
    //cumpleaños 
    private String genero;
    private String cumple; 
    

    
    
    
    
    
   
   
    public Cliente(String codigo, String nombre, String genero, String Cumpleaños, String contraseña){
        super(codigo,nombre, contraseña);
        this.genero = genero;
        this.cumple = Cumpleaños;
    }
    
    
    
    

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }
    
    
}
