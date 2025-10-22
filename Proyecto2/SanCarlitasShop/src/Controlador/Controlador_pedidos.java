/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Carrito_Compras;
import Modelo.Carrito_Temporal;
import Modelo.Pedidos;
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
    
    public static void obtenerPedidoCliente(JTable tabla_pedido){
        
        tabla_pedido.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public  void mouseClicked(java.awt.event.MouseEvent evt){
                int fila = tabla_pedido.rowAtPoint(evt.getPoint());
                
                String codigo_producto = tabla_pedido.getValueAt(fila, 0).toString(); // ya tengo el codigo de la tabla del producto 
                
                //puedo acceder a al objeto del carrito temporal 
                
                Carrito_Temporal buscar_producto = Controlador_Carrito_Temporal.objetoCarritoTemporal(codigo_producto);
               
                Pedidos confirmar = new Pedidos(buscar_producto.getCodigo_producto(), buscar_producto.getFecha_generacion(), buscar_producto.getCodigo_cliente(), buscar_producto.getNombre_cliente(),buscar_producto.getTotal_pagar());
                //con esto ya tengo para verficiar para poder confirmar si el vendedor acepta el pedido 
                
                agregar_pedidos(confirmar);
                
                
            }
        });
                
  
        

        
    }
    
    
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
    





















































































































    
    
}
