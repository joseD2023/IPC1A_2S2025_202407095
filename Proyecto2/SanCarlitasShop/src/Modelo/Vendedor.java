/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Vendedor extends Usuario{ // Heredan ciertos atributos 
    //definir los atributos de los vendedores 
    //como vamos a crear vendedores entonces necesitamos tener un constructor para que estos se puedan crear 
    private String genero;
    
    //constructor 
    
    public Vendedor(String codigo, String nombre, String genero, String contra){ // aqui ya inicializamos nuestro contructos 
        super(codigo, nombre, contra);
        this.genero = genero;  
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
