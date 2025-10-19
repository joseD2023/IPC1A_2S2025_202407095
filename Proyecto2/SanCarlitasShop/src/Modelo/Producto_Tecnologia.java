/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Producto_Tecnologia extends Productos{
    
    private int meses_garantia;

    public Producto_Tecnologia(String codigo_producto, String nombre_producto, String categoria_producto, String atributo_unico, double precio_producto, int stock_productos) {
        super(codigo_producto, nombre_producto, categoria_producto, atributo_unico, precio_producto, stock_productos);
    }

   

 

    public int getMeses_garantia() {
        return meses_garantia;
    }

    public void setMeses_garantia(int meses_garantia) {
        this.meses_garantia = meses_garantia;
    }
    
    
    
}
