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

    public Producto_Tecnologia(int meses_garantia, String codigo_producto, String nombre_producto, String categoria_producto, double precio_producto) {
        super(codigo_producto, nombre_producto, "Tecnologia", precio_producto);
        this.meses_garantia = meses_garantia;
    }

    public int getMeses_garantia() {
        return meses_garantia;
    }

    public void setMeses_garantia(int meses_garantia) {
        this.meses_garantia = meses_garantia;
    }
    
    
    
}
