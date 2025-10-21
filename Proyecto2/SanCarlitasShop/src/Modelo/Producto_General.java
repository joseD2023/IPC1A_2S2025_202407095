/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Producto_General extends Productos{
    
    private String material;

    public Producto_General(String codigo_producto, String nombre_producto, String categoria_producto, String atributo_unico, double precio_producto, int stock_productos) {
        super(codigo_producto, nombre_producto, categoria_producto, atributo_unico, precio_producto, stock_productos);
        this.material = atributo_unico; 
        
    }

   
   

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    
    
}
