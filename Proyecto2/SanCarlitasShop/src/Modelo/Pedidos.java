/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Pedidos{
    private String codigo_producto; 
    private String fecha_generacion ;
    private String codigo_cliente;
    private String nombre_cliente;
    private double total_pagar; 

    public Pedidos(String codigo_producto, String fecha_generacion, String codigo_cliente, String nombre_cliente, double total_pagar) {
        this.codigo_producto = codigo_producto;
        this.fecha_generacion = fecha_generacion;
        this.codigo_cliente = codigo_cliente;
        this.nombre_cliente = nombre_cliente;
        this.total_pagar = total_pagar;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getFecha_generacion() {
        return fecha_generacion;
    }

    public void setFecha_generacion(String fecha_generacion) {
        this.fecha_generacion = fecha_generacion;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public double getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(double total_pagar) {
        this.total_pagar = total_pagar;
    }
    
    
    
    

 
    
    
    
    
    
}
