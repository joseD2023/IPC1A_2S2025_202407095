/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.Controlador_Clientes.carrito;
import static Controlador.Controlador_Clientes.indice_carrito;
import Modelo.Carrito_Compras;
import Modelo.Carrito_Temporal;
import Modelo.Productos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Controlador_Carrito_Temporal {
    
    public static Carrito_Temporal[] carrito_temporal = new Carrito_Temporal[1000];
    public static int indice_carrito_temporal =0; 
    
    //necesitamos guardar ese carrito temporal para luego buscar y volver a colcoarlo 
    
    public static void agregar_carrito_temporal(Carrito_Temporal temporal_carrito){
        if(indice_carrito_temporal < carrito_temporal.length){
            carrito_temporal[indice_carrito_temporal] = temporal_carrito; 
            indice_carrito_temporal++;   
        }
        
    }
    
    public static void eliminarCarritoTemporal(String codigo_carrito){
       for(int i=0; i<indice_carrito_temporal; i++){
            if(carrito_temporal[i] != null){
              if(codigo_carrito.equals(carrito_temporal[i].getCodigo_producto())){
                 carrito_temporal[i] = null; //eliminado del carrito 
                
                 //ahora vamos a mover todo para no tener problemas con los null
                
                  for(int j=i; j<indice_carrito_temporal-1; j++){
                    carrito_temporal[j] = carrito_temporal[j+1]; // corremos todo a la siguiente posicion 
                   }
                
                   carrito_temporal[indice_carrito_temporal-1] = null; 
                   indice_carrito_temporal--;
                  break; //borramos definitivamente el carrito 
 
            }
                
            }
            
        }
    }
    
    
    public static Carrito_Temporal objetoCarritoTemporal(String codigo){
        for(int i=0; i<indice_carrito_temporal; i++){
            if(carrito_temporal[i] != null){
                if(codigo.equals(carrito_temporal[i].getCodigo_producto())){
                    return carrito_temporal[i];
                
            }
                
            }
            
        }
        
        return null;
    }
    
    
    //necesito visualizar el producto de cada cliente a traves del codigo 
    
    public static void visualizarCarritoClientes(String codigo_cliente, DefaultTableModel tabla_carritos){
        
        
      if(carrito_temporal != null && carrito_temporal.length >0){
          for(Carrito_Temporal ct : carrito_temporal){
              if(ct != null){
                  Object[] fila = {ct.getCodigo_producto(), ct.getFecha_generacion(), ct.getCodigo_cliente(), ct.getNombre_cliente(), ct.getTotal_pagar()};
                  tabla_carritos.addRow(fila); // y la agregamos de nuevo 
                  
              }
              
          }
          
      }
        
    }
    
    
    public static void cargarCarritosTemporalesCliente(String codigoCliente) {
    // Limpiar carrito actual
    for(int i = 0; i < indice_carrito; i++) {
        carrito[i] = null;
    }
    indice_carrito = 0;
    
    // Buscar en carritos temporales de ESTE cliente
    for(int i = 0; i < Controlador_Carrito_Temporal.indice_carrito_temporal; i++) {
        if(Controlador_Carrito_Temporal.carrito_temporal[i] != null && 
           codigoCliente.equals(Controlador_Carrito_Temporal.carrito_temporal[i].getCodigo_cliente())) {
            
            Carrito_Temporal temp = Controlador_Carrito_Temporal.carrito_temporal[i];
            Productos producto = Controlador_Productos.objetoProductos(temp.getCodigo_producto());
            
            if(producto != null) {
                Carrito_Compras nuevo = new Carrito_Compras(
                    temp.getCodigo_producto(),
                    producto.getNombre_producto(),
                    producto.getCategoria_producto(),
                    temp.getCantidad(),
                    producto.getPrecio_producto(),
                    temp.getTotal_pagar()
                );
                
                if(indice_carrito < carrito.length) {
                    carrito[indice_carrito] = nuevo;
                    indice_carrito++;
                }
            }
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
