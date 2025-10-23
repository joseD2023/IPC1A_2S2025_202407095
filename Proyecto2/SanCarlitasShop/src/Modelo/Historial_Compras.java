/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Historial_Compras {
    private String codigo_cliente_historial;
    private String fecha_confirmacion; 
    private double total_comprar; 

    public Historial_Compras(String codigo_cliente_historial, String fecha_confirmacion, double total_comprar) {
        this.codigo_cliente_historial = codigo_cliente_historial;
        this.fecha_confirmacion = fecha_confirmacion;
        this.total_comprar = total_comprar;
    }

    public String getCodigo_cliente_historial() {
        return codigo_cliente_historial;
    }

    public void setCodigo_cliente_historial(String codigo_cliente_historial) {
        this.codigo_cliente_historial = codigo_cliente_historial;
    }

    public String getFecha_confirmacion() {
        return fecha_confirmacion;
    }

    public void setFecha_confirmacion(String fecha_confirmacion) {
        this.fecha_confirmacion = fecha_confirmacion;
    }

    public double getTotal_comprar() {
        return total_comprar;
    }

    public void setTotal_comprar(double total_comprar) {
        this.total_comprar = total_comprar;
    }
    
    
    
}
