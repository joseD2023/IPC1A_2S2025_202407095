/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Carrito_Temporal;
import Modelo.Historial_Compras;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Controlador_Historial_Compras {
    
    public static Historial_Compras[] historial_compras = new Historial_Compras[1000]; 
    public static int indice_historial_compras =0;
    
    public static String codigo_cliente = " ";
    
    //funcion para otener el codigo del cliente 
    
    public static void obtenerCodigo(String codigo){
        codigo_cliente = codigo; //actualizamos el codigo nos va a serviar mas adelante  
    }
    
    public static void agregarHistorial(Historial_Compras historial){
        if(historial != null){
            if(indice_historial_compras < historial_compras.length){
                historial_compras[indice_historial_compras] = historial; 
                indice_historial_compras++;
                
            }
        }
        
    }
    
    
    //visualizador de Historial 
    
    public static void visualizadorHistorialCompras(DefaultTableModel tabla_compras){
        Controlador_Productos.limpiar(tabla_compras); //limpiamos nuestras tablas 
        
        if(historial_compras != null && historial_compras.length >0){
            for(Historial_Compras h: historial_compras){
                if(h != null){
                    Object[] filas ={h.getCodigo_cliente_historial(), h.getFecha_confirmacion(), h.getTotal_comprar()};
                    tabla_compras.addRow(filas);
                    
                }
                
            }
            
        }
    }
    
    public static void visualizadorHistorialCompras(DefaultTableModel tabla_compras, String codigo){
        Controlador_Productos.limpiar(tabla_compras); // limpiamos para no ver nada solo lo que necesitamos
        for(Historial_Compras h1 : historial_compras){
            if(h1 != null && h1.getCodigo_cliente_historial().equals(codigo)){ // si no es nullo y se encuentra el cliente registrado lo muestro con todos su datos e historial
                Object[] filas = {h1.getCodigo_cliente_historial(), h1.getFecha_confirmacion(), h1.getTotal_comprar()};
                tabla_compras.addRow(filas);
                
            }
            
        }
        
    }
    
    
    public static void guardarObjeto(){
        
        // Obtener fecha actual
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Carrito_Temporal buscar_total = Controlador_Carrito_Temporal.objetoCarritoTemporal(codigo_cliente);
        
        if(buscar_total != null){
            double total = buscar_total.getTotal_pagar();
            Historial_Compras historial_nuevo = new Historial_Compras(codigo_cliente, fecha, total);
            agregarHistorial(historial_nuevo);
        }
        
    }
    
    public static void obtenerHistorialCompras(JTable tabla, String codigo_historial){
        for(int i=0; i<tabla.getRowCount(); i++){
            //acedemos a todo lo que esta ahi 
        }
        
    }
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
