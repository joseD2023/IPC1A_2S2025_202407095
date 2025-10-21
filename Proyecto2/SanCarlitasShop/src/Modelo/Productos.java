/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Productos {
    
    //aqui vamos a crear los atributos que se pueden heredar  
    
    protected String codigo_producto; 
    protected String nombre_producto; 
    protected  String categoria_producto; 
    protected double precio_producto; 
    protected  String atributo_unico;
    protected  int stock_productos; 
    

  
    public Productos(String codigo_producto, String nombre_producto, String categoria_producto,String atributo_unico, double precio_producto, int stock_productos) {
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.categoria_producto = categoria_producto;
        this.precio_producto = precio_producto;
        this.atributo_unico = atributo_unico;
        this.stock_productos = stock_productos;
    }
    
    public Productos(String codigo_producto, String nombre_producto, String categoria_producto,String atributo_unico){
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.categoria_producto = categoria_producto;
        this.atributo_unico = atributo_unico;
    }
    

    public int getStock_productos() {
        return stock_productos;
    }

    public void setStock_productos(int stock_productos) {
        this.stock_productos = stock_productos;
    }

    public String getAtributo_unico() {
        return atributo_unico;
    }

    public void setAtributo_unico(String atributo_unico) {
        this.atributo_unico = atributo_unico;
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

    public String getCategoria_producto() {
        return categoria_producto;
    }

    public void setCategoria_producto(String categoria_producto) {
        this.categoria_producto = categoria_producto;
    }
    
     public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }


    
    
    
    
}
