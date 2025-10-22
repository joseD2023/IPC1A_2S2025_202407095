/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.Controlador_Clientes.eliminarCarrito;
import static Controlador.Controlador_Clientes.objetoCarrito;
import static Controlador.Controlador_Clientes.solicitarCantidadCliente;
import static Controlador.Controlador_Clientes.visualizacionCarritos;
import Modelo.Carrito_Compras;
import Modelo.Carrito_Temporal;
import Modelo.Pedidos;
import Modelo.Productos;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Controlador_pedidos {
    
    //aqui vamos a guardar toda la logica para el controlador pedidos 
    
    public static Pedidos[] pedidos_clientes = new Pedidos[100]; 
    public static int indice_pedidos;
    
    
    //vamos agregar los pedidos que tenemos 
    
    public static void agregar_pedidos(Pedidos nuevo_pedido){
        if(nuevo_pedido == null){
            return; 
        }
        if(indice_pedidos < pedidos_clientes.length){
            //entonces ahora agregamos los nuevos pedidos 
            pedidos_clientes[indice_pedidos] = nuevo_pedido;
            indice_pedidos++; 
   
        }
   
    }
    
    
    
    public static void eliminar_pedidos(String codigo){
        
        for(int i=0; i<indice_pedidos; i++){
            if(pedidos_clientes[i] != null){
                if(codigo.equals(pedidos_clientes[i].getCodigo_producto())){
                //vamos a eliminar el pedido 
                pedidos_clientes[i] = null; 
                
                //ahora movemos lo que esta en el pedido 
                
                for(int j=i; j<indice_pedidos-1; j++ ){
                    pedidos_clientes[j] = pedidos_clientes[j+1];
                }
                
                pedidos_clientes[indice_pedidos-1] = null; 
                indice_pedidos--;                
            }
                
            }
        }
        
    }
    
    
    public static Pedidos objetoPedidos(String codigo){
        
        for(int i=0; i<indice_pedidos; i++){
            if(codigo.equals(pedidos_clientes[i].getCodigo_producto())){
                return pedidos_clientes[i];
            }
        }
        
        return null;    
    }
    
    
    //necesito agregar al pedido y que este este en cola para ser mandado al otro lado 
    //BOTON CONFIRMACION 
    
    
    public static void obtenerPedidoCliente(JTable tabla_pedido){
        
        DefaultTableModel modelo = (DefaultTableModel) tabla_pedido.getModel(); 
        int filas = modelo.getRowCount(); //obtener lo que tiene el carrito en ese instante en sus filas 
        
        for(int i=0; i < filas; i++){
            String codigo_producto = modelo.getValueAt(i, 0).toString(); //obtenemos el codigo del productos 
            
            //lo buscamos en el carrito temporal 
            
            Carrito_Temporal obtener_pedidos = Controlador_Carrito_Temporal.objetoCarritoTemporal(codigo_producto);
            
            if(obtener_pedidos != null){
                Pedidos pedido_nuevo = new Pedidos(obtener_pedidos.getCodigo_producto(), obtener_pedidos.getFecha_generacion(), obtener_pedidos.getCodigo_cliente(), obtener_pedidos.getNombre_cliente() ,obtener_pedidos.getTotal_pagar());
                
                //ahora agregamos el pedido para el carrito 
                
                Controlador_pedidos.agregar_pedidos(pedido_nuevo);
                
                System.out.println("NOmbre Cliente" + " " + obtener_pedidos.getNombre_cliente() + " " + "Producto:"+ obtener_pedidos.getNombre_producto());
                
            }
        }
        
   
                
  
        

        
    }
    
    
    
    //logica para visualizar el pediod en el vendedor debe ser esto 
    
    public static void visualizarTablaPedidos(DefaultTableModel tabla){
        
        Controlador_Productos.limpiar(tabla); //limpiamos la tabla cada vez para no encontrar repetidos 
        
        if(pedidos_clientes != null && pedidos_clientes.length >0){
            for(Pedidos p: pedidos_clientes){
                if(p != null){
                    Object[] fila = {p.getCodigo_producto(),p.getFecha_generacion(),p.getCodigo_cliente(),p.getNombre_cliente(),p.getTotal_pagar(), "Confirmar"};
                    tabla.addRow(fila);
                    
                }
                
            }
            
        }
    }
    
    
    
    
    
    
     public static void carritoBtonesPedidos(JTable tabla, DefaultTableModel tabla_carito){
          
          tabla.addMouseListener(new java.awt.event.MouseAdapter(){
              @Override
              public void mouseClicked(java.awt.event.MouseEvent evt){
                int columna = tabla.columnAtPoint(evt.getPoint());
                int fila = tabla.rowAtPoint(evt.getPoint());
                // Como necesitmaos dos botones vamos a preguntarle al usuario que dese hacer 
                String codigo = tabla.getValueAt(fila, 0).toString(); // solo necesito el codigo para acceder a todo el documento 
                if(columna == 5){ 
                    //esta parte es para confirmar los pedidos y que el vendedor venda ese producto y lo quite del sistema y diga que esta vendido
                    //aqui deberias de eliminar los pedidos que hizo el cliente y decir que ya lo vendimo s
                    
                    
                    //ahora vamos a eliminar el carrito al momento de decir que si vamos a confirmar 
                    
                    eliminar_pedidos(codigo);
                    Controlador_Carrito_Temporal.eliminarCarritoTemporal(codigo);
                    Controlador.Controlador_Clientes.eliminarCarrito(codigo);
                    
                    visualizarTablaPedidos(tabla_carito);
                    
                    JOptionPane.showMessageDialog(null, "Peidod Eleminado");
      
                }
                
                
               
              }
              
          });
          
          
          
          
      }
     
     
     //si hay productos en el carrito y se quiere hacer un pedido no debe estar vacios 
     
     public static boolean carritoLleno(JTable tabla_pedido){
         DefaultTableModel modelo = (DefaultTableModel) tabla_pedido.getModel(); 
         int filas = modelo.getRowCount(); //obtener lo que tiene el carrito en ese instante en sus filas 
         
         for(int i=0; i<filas; i++){
             String codigo = modelo.getValueAt(i, 0).toString();
             
             if(codigo.isEmpty() || codigo == null){
                 return true; // tru si esta vacio o es nullo 
 
             }
         }
         
         return false;
         
     }
    





















































































































    
    
}
