/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Productos;
import javax.swing.JOptionPane;


public class Controlador_Productos {
    
    // crearmos la lista para guardar los productos y las acciones 
    
    public static Productos[] crear_producto = new Productos[100];
    public static int indice_producto = 0; 
    
    public static void crearProductos(Productos producto_nuevo){
        if(indice_producto < crear_producto.length){
            // confirmamos el espacio suficiente 
            crear_producto[indice_producto] = producto_nuevo; 
            indice_producto++;
            
        }else{
            JOptionPane.showMessageDialog(null, "Limite de Productos llegado a su limite");
        }
        
    }
    
}
