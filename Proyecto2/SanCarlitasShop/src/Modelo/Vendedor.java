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
    private int numero_venta;
    private String confirmacion;
    
    //constructor 
    
    public Vendedor(String codigo, String nombre, String genero, String contra){ // aqui ya inicializamos nuestro contructos 
        super(codigo, nombre, contra);
        this.genero = genero;  
        this.numero_venta =0;
    }
    
    public Vendedor(String codigo, String nombre, String genero, String contra, String confirmacion){ // aqui ya inicializamos nuestro contructos 
        super(codigo, nombre, contra);
        this.genero = genero;  
        this.numero_venta =0;
        this.confirmacion = confirmacion; 
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }
    
    

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
    }
    
}
