/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Carrito_Compras;
import Modelo.Carrito_Temporal;
import Modelo.Productos;
import Modelo.Tablareader;
import com.opencsv.CSVReader;
import java.io.File;
import javax.swing.JOptionPane;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Controlador_Productos {
    
    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    static String fechaHoraActual = LocalDateTime.now().format(formato);
    static String codigo_clientes = " ";
    public static int monto_total; 
    
    /*------------------ Seccion Productos Crear ------------------------------------------------------*/
    
    // crearmos la lista para guardar los productos y las acciones 
    
    public static Productos[] crear_producto = new Productos[100];
    public static int indice_producto = 0; 
    
    public static void crearProductos(Productos producto_nuevo){
        if(producto_nuevo != null){
            if(indice_producto < crear_producto.length){
            // confirmamos el espacio suficiente 
            crear_producto[indice_producto] = producto_nuevo; 
            indice_producto++;
        } 
        }
         
    }
    
     /*------------------------------------------------------------------------*/
    
    
    //Obtener el Objeto del producto
    public static Productos objetoProductos(String co){
        for(int i=0; i<indice_producto; i++){
            if(crear_producto[i] !=null){
                 if(co.equals(crear_producto[i].getCodigo_producto())){
                    return crear_producto[i];
                 }
            }
           
        }
        return null;   
    }
    
     /*------------------------------------------------------------------------*/
    
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
    
     /*------------------------------------------------------------------------*/
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
    
     /*------------------------------------------------------------------------*/
    public static void cargarCsv(File archCsv){
        //vamos a crear o a leer a nuestro CSv 
        try(CSVReader leer = new CSVReader(new FileReader(archCsv))){
            //Vector asistenten 
            String[] vendedor_aux = null; 
            while((vendedor_aux = leer.readNext())!= null){
                
                //instanciamos para los productos 
                if(!validacionCodigo(vendedor_aux[0])){
                    Productos producto_sistema = new Productos(vendedor_aux[0], vendedor_aux[1], vendedor_aux[2], vendedor_aux[3]);
                    crearProductos(producto_sistema);
                    
                }else{
                    System.out.println("No se agrego porque hay duplicados");
                }
            }
            
        }catch(Exception e){
            throw new RuntimeException(e); 
            
        }
    }
    
     /*------------------------------------------------------------------------*/
    
    public static void cargarCsvStock(File archivo){
        
        try(CSVReader leer = new CSVReader(new FileReader(archivo))){
            //vector asistente stock 
            String[] stock_aux = null; 
            while((stock_aux = leer.readNext())!= null){
                if(validacionCodigo(stock_aux[0])){
                    try{
                        int stock = Integer.parseInt(stock_aux[1]);
                        Productos buscar_productos = objetoProductos(stock_aux[0]);
                        if(buscar_productos != null){
                            buscar_productos.setStock_productos(stock);
                            
                        }else{
                            System.out.println("Productos no Encontrado" + stock_aux[0]);
                        }

                    }catch(NumberFormatException e){
                        System.out.println("Stock invalidos" + stock_aux[1] + "del codigo" + " " + stock_aux[1]);
                        
                    }
                    
                }else{
                    System.out.println("Hay un codigo que aun no ha sido registrado");
                }
            }
            
        }catch(Exception e){
            throw new RuntimeException(e); 
            
        }
        
    }
    
     /*------------------------------------------------------------------------*/
    
    //para mostrar la informacion segun el tipo de material si se puede deicr asi 
    public static String mostrarDetallesProducto(String codigo){
        
        if(validacionCodigo(codigo)){
            Productos p = objetoProductos(codigo); // me retonar el objeto y ahora yo puedo usar los getters y setters
            //dependiendo de lo que sea entonces vamos a mostrar el mensaje
            if(p.getCategoria_producto().equals("Alimento")){
                String informacion =  "ALIMENTO\n\n" + ":" + "\n "+ "\n" + "\n"+ "\n" +
                   "Este producto vence el\n" +  " " + " " + " " +
                   p.getAtributo_unico();
                return informacion;
            }else if(p.getCategoria_producto().equals("Tecnología")){
                
                 String informacion = "TECNOLOGÍA\n\n" + ":" + "\n "+ "\n" + "\n"+ "\n" +
                   "Meses de Garantía\n" + " " + " " + " " +
                   p.getAtributo_unico()+ " " +" "+ "años";
                return informacion;
            }else{
                 String informacion = "PRODUCTO GENERAL\n\n"+ ":"  + "\n" + "\n "+ "\n" + "\n"+ "\n" +
                   "Material del Producto\n" +  " " + " " + " " +
                   p.getAtributo_unico();
                return informacion;
            }   
        }else{
            System.out.println("Algun Error ");
            return null;
        }
        
        
    }
    
    /*------------------------- VIsualizacion de SWING -------------------------------------*/
    
    
        public static void limpiar(DefaultTableModel modelo){
            int filas = modelo.getRowCount(); 
            for(int i=filas-1; i>=0; i--){
                modelo.removeRow(i);
            }
        }


        /*------------------------------------------------------------------------*/
         public static void visualizarProductos(DefaultTableModel tabla_producto){
            limpiar(tabla_producto);

            if(crear_producto != null && crear_producto.length >0){
                for(Productos p: crear_producto){
                    if(p != null){
                        Object[] fila = {p.getCodigo_producto(),p.getNombre_producto(), p.getCategoria_producto(), p.getStock_productos(), "Agregar Al Carrito"};
                        tabla_producto.addRow(fila);
                    }
                }
            }
        }
         
          /*------------------------------------------------------------------------*/
         
         
             public static void mostrarBotones(JTable tabla_productos_disponibles, DefaultTableModel tabla1, DefaultTableModel tabla2){
             tabla_productos_disponibles.addMouseListener(new java.awt.event.MouseAdapter() {
             @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int columna = tabla_productos_disponibles.columnAtPoint(evt.getPoint());
                int fila = tabla_productos_disponibles.rowAtPoint(evt.getPoint());
                if(columna == 4) {
                // tratar de crear una ventana 
                String codigo = tabla_productos_disponibles.getValueAt(fila, 0).toString(); // aqui obtengo el codigo de la tabla 
                String nombre = tabla_productos_disponibles.getValueAt(fila, 1).toString();  // aqui obtengo el nombre del producto 
                String categoria = tabla_productos_disponibles.getValueAt(fila, 2).toString(); // aqui obtengo la categoria del producto
                int stock  = Integer.parseInt(tabla_productos_disponibles.getValueAt(fila, 3).toString()); //capturo el stock
                double precio_producto = Controlador_Productos.objetoProductos(codigo).getPrecio_producto(); // aquiconsigo el precio
                

                
                double cantidad_usuario = Controlador_Clientes.solicitarCantidadCliente(stock);
                int cantidad_u = (int) cantidad_usuario;
                
                double total_pagar = cantidad_u * precio_producto;
                
                Controlador_Productos.objetoProductos(codigo).setStock_productos(stock - cantidad_u); //aqui deberia actualizar el usuario 
                
                if(cantidad_usuario > 0){
                    
                    Carrito_Compras nuevo_carrito = new Carrito_Compras(codigo, nombre, categoria, cantidad_u, precio_producto, total_pagar);
                    
                    /*-------------------------------CARRITO TEMPORAL --------------------------------------------*/
                    
                    //necesito obtener el codigo cliente 
                    
                    String codigo_cliente = codigo_clientes; //codigo del cliente y asi sin perdernos mas
                    String nombre_cliente = Controlador_Clientes.objetoCliente(codigo_cliente).getNombre();
                    
                    
                    
                    Carrito_Temporal carrito_tem = new Carrito_Temporal(codigo, fechaHoraActual, codigo_cliente, nombre_cliente, total_pagar,cantidad_u, precio_producto, nombre, categoria);
                    Controlador_Carrito_Temporal.agregar_carrito_temporal(carrito_tem); // con esto ya tenemos el carrito temporal 
                    
                 
                    /*-------------------------------CARRITO TEMPORAL --------------------------------------------*/
                    
                    
                    
                    
                    
                    Controlador.Controlador_Clientes.agregarCarrito(nuevo_carrito);
                    
                    JOptionPane.showMessageDialog(null, "Carrito Agregado");
                    Controlador.Controlador_Productos.visualizarProductos(tabla1);
                    //Controlador.Controlador_Clientes.limpiar(tabla2);
                    Controlador.Controlador_Clientes.visualizacionCarritos(tabla2);
                    
                }
            }
        }
    });
        
    }
             
             
             //vamos a obtener el codigo del cliente de una manera de accion 
             
             public static void codigo_cliente(String codigo_client){
                 codigo_clientes = codigo_client;
             }
             
             
             
    
 
             
             
             
             
             
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

