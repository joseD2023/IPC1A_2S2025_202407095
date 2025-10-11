/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

public class Producto_Alimentos extends Productos{
    
    private Date fecha_caducidad;

    public Producto_Alimentos(Date fecha_caducidad, String codigo_producto, String nombre_producto, String categoria_producto, double precio_producto) {
        super(codigo_producto, nombre_producto, "Alimento", precio_producto);
        this.fecha_caducidad = fecha_caducidad;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }
    
    
    
    
}
