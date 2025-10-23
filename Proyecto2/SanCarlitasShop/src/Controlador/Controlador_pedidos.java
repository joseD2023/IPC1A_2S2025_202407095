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
import Modelo.Historial_Compras;
import Modelo.Pedidos;
import Modelo.Productos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public static double monto_final; 
    public static int indice_pedidos;
    
    
    //vamos agregar los pedidos que tenemos 
    
    public static void agregar_pedidos(Pedidos nuevo_pedido){
        if(nuevo_pedido == null){
            return; 
        }
        
        //vamos a ver si se me duplica los pedidos para ver eso 
        
        for(int i=0; i<indice_pedidos; i++){
            if (pedidos_clientes[i] != null && pedidos_clientes[i].getCodigo_producto().equals(nuevo_pedido.getCodigo_producto()) && pedidos_clientes[i].getCodigo_cliente().equals(nuevo_pedido.getCodigo_cliente())) {
                System.out.println("pedido duplicado, no se agregó");
                return;
             }
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
    
    
    //aqui lo que queremos es encontrar el objeto de pedidos que contienes todos los atributos ya llenados
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
    
    
    public static void obtenerPedidoCliente(JTable tabla_pedidos, String codigo_cliente_actual, String fe){
        
        for (int i = 0; i < tabla_pedidos.getRowCount(); i++) {
        String codigoProducto = tabla_pedidos.getValueAt(i, 0).toString();
        String nombreProducto = tabla_pedidos.getValueAt(i, 1).toString();
        int cantidad = Integer.parseInt(tabla_pedidos.getValueAt(i, 2).toString());
        double precio = Double.parseDouble(tabla_pedidos.getValueAt(i, 3).toString());
        double total = cantidad * precio;

        // Verificar duplicado
        boolean pedidoExistente = false;
        for (int j = 0; j < indice_pedidos; j++) {
            if (pedidos_clientes[j] != null) {
                if (pedidos_clientes[j].getCodigo_cliente().equals(codigo_cliente_actual) &&
                    pedidos_clientes[j].getCodigo_producto().equals(codigoProducto) && pedidos_clientes[j].getFecha_generacion().equals(fe)) { // 3 condicones para que un duplicado sea valdo 
                    pedidoExistente = true;
                    break;
                }
            }
        }

        if (!pedidoExistente) {
            // Obtener fecha actual
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Pedidos nuevoPedido = new Pedidos(
                codigoProducto,   // codigo_producto
                fecha,           // fecha_generacion
                codigo_cliente_actual, // codigo_cliente
                nombreProducto,  // nombre_cliente (si quieres poner el nombre del cliente real, debes pasarlo)
                total            // total_pagar
            );
            
            //aqui voy a generar mi constructor de historial para leugo guardarlos 
            
            Historial_Compras nuevo_historial = new Historial_Compras(codigo_cliente_actual, fecha, total); //y aqui tengo todo para confirmar 
            Controlador_Historial_Compras.agregarHistorial(nuevo_historial);
            
            System.out.println("*-------------- aqui se agrego al nuevo historial -------------------*");

            if (indice_pedidos < pedidos_clientes.length) {
                pedidos_clientes[indice_pedidos] = nuevoPedido;
                indice_pedidos++;
            } else {
                System.out.println("No hay espacio para más pedidos.");
            }
        } else {
            System.out.println("Pedido duplicado para el cliente " + codigo_cliente_actual + " y producto " + codigoProducto);
             //Controlador_Carrito_Temporal.eliminarCarritosDuplicados(codigo_cliente_actual);
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
    
    
    
    
    
    //BOTON DE CONFIRMAR PEDIDOS PARA QUE EL USUARIO TENGA LA CONFIRAMCION DEL PEDIDO DESEADO 
    
    
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
                    
                    //vamos a verificar si realmente pertence la confirmacion a dicho codigo 
                    
                    System.out.println("Fila a Confirmar" + " " + fila + " " + "Codigo es:" + " " + codigo);
                    
                    //aqui yo tengo que agregar la confirmacion para paraagregarlo al historial 
                    
                    
                    
                    //ahora vamos a eliminar el carrito al momento de decir que si vamos a confirmar 
                    
                    eliminar_pedidos(codigo);
                    Controlador_Carrito_Temporal.eliminarCarritoTemporal(codigo);
                    Controlador.Controlador_Clientes.eliminarCarrito(codigo);
                    
                    visualizarTablaPedidos(tabla_carito);
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Compra Realizada Existosamente");
      
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
