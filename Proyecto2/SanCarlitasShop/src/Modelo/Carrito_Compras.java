/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Carrito_Compras {
    //aqui vamos a manejar un vector temporal para el uso depues para hacer pedidos 
    
    private String codigo_producto;  
    private String nombre_producto; 
    private String categoria;
    private int Cantidad; 
    private double precio;
    private double  totoal; 

    public Carrito_Compras(String codigo_producto, String nombre_producto, String categoria, int Cantidad, double precio, double totoal) {
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.categoria = categoria;
        this.Cantidad = Cantidad;
        this.precio = precio;
        this.totoal = totoal;
    }
    
 

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotoal() {
        return totoal * precio;
    }

    public void setTotoal(double totoal) {
        this.totoal = totoal;
    }
    
    

    
    
}
