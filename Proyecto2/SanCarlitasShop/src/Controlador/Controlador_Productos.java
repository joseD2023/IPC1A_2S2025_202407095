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
    
    
    //Actualizar producto 
    
    public static Productos objetoProductos(String co){
        for(int i=0; i<indice_producto; i++){
            if(co.equals(crear_producto[i].getCodigo_producto())){
                return crear_producto[i];
                
            }
        }
        return null;   
    }
    
    
    //Eliminar Producto 
    
    public static void eliminarProducto(String co){
        for(int i=0; i<indice_producto;i++){
            if(co.equals(crear_producto[i].getCodigo_producto())){
                //si se encuentra se eliminar 
                crear_producto[i] = null; //eliminamos 
                
                for(int j= i; j<indice_producto-1; j++){
                    crear_producto[j] = crear_producto[j+1];
                    
                    crear_producto[indice_producto-1] = null; 
                    indice_producto--; 
                }
            }
        }
        
    }
    
    
    //Acceder al codigo 
    
    public static boolean validacionCodigo(String codi){
        
        for(int i=0; i<indice_producto; i++){
            if(codi.equals(crear_producto[i].getCodigo_producto())){
                return true;
            }
        }
        
        return false;   
    }
    
    
    public static boolean  validarStock(String stock){
        try{
            int stock1 = Integer.parseInt(stock);
            return true;
            
        }catch(NullPointerException e){
            return false;
            
        }
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
