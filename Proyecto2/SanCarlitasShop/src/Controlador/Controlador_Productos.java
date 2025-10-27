/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Carrito_Compras;
import Modelo.Carrito_Temporal;
import Modelo.EventoBitacora;
import Modelo.Inventarios_PDF;
import Modelo.Pedidos;
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
    public static String codigo_clientes = " ";
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
            
            leer.readNext(); // saltamos el encabezado 
            while((vendedor_aux = leer.readNext())!= null){
                
                //instanciamos para los productos 
                if(!validacionCodigo(vendedor_aux[0])){
                    Productos producto_sistema = new Productos(vendedor_aux[0], vendedor_aux[1], vendedor_aux[2], vendedor_aux[3], vendedor_aux[4]);
                    
                    System.out.println("Mostrando el precio de cada producto" + vendedor_aux[4]);
                    System.out.println("sumar para ver si es un numero " + (1 + vendedor_aux[4]));
                    System.out.println("------------------------------------------------------");
                    
                    
                    
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
            leer.readNext(); //no queremos encabezados
            while((stock_aux = leer.readNext())!= null){
                if(validacionCodigo(stock_aux[0])){
                    try{
                        int stock = Integer.parseInt(stock_aux[1]);
                        Productos buscar_productos = objetoProductos(stock_aux[0]);
                        if(buscar_productos != null){
                            
                            buscar_productos.setStock_productos(stock);
                            
                            // Registro exitoso por producto
                        EventoBitacora.registrarEvento(
                            "Vendedor",
                            Controlador.Controlador_Vendedor.Codigo_vendedor,
                            "Actualizar Stock",
                            "Exitosa",
                            "Producto " + stock_aux[0] + " actualizado con stock " + stock,
                            "Normal"
                        );
                            
                        }else{
                            System.out.println("Productos no Encontrado" + stock_aux[0]);
                            // Producto no encontrado
                        EventoBitacora.registrarEvento(
                            "Vendedor",
                            Controlador.Controlador_Vendedor.Codigo_vendedor,
                            "Actualizar Stock",
                            "Fallida",
                            "Producto no encontrado: " + stock_aux[0],
                            "Crítico");
                        }

                    }catch(NumberFormatException e){
                        System.out.println("Stock invalidos" + stock_aux[1] + "del codigo" + " " + stock_aux[1]);
                        // Stock inválido
                    EventoBitacora.registrarEvento(
                        "Vendedor",
                        Controlador.Controlador_Vendedor.Codigo_vendedor,
                        "Actualizar Stock",
                        "Fallida",
                        "Stock inválido para producto " + stock_aux[0] + ": " + stock_aux[1],
                        "Crítico"
                    );
                        
                    }
                    
                }else{
                    System.out.println("Hay un codigo que aun no ha sido registrado");
                    // Código no registrado
                EventoBitacora.registrarEvento(
                    "Vendedor",
                    Controlador.Controlador_Vendedor.Codigo_vendedor,
                    "Actualizar Stock",
                    "Fallida",
                    "Código no registrado: " + stock_aux[0],
                    "Crítico"
                );

                }
                
                // Registro general: CSV cargado correctamente
        EventoBitacora.registrarEvento(
            "Vendedor",
            Controlador.Controlador_Vendedor.Codigo_vendedor,
            "Carga CSV Stock",
            "Exitosa",
            "Archivo " + archivo.getName() + " procesado correctamente",
            "Normal"
        );

                
            }
            
        }catch(Exception e){
            EventoBitacora.registrarEvento(
            "Vendedor",
            Controlador.Controlador_Vendedor.Codigo_vendedor,
            "Carga CSV Stock",
            "Fallida",
            "Error al procesar archivo " + archivo.getName() + ": " + "Archivo Denegado",
            "Crítico"
        );
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
            }else if(p.getCategoria_producto().equals("Tecnologia")){
                
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
                //BOTON PARA AGREGAR CARRITO Y ALMACENARLO  METODO
                
                
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
                
                    System.out.println("Precio Original del CSV" + tabla_productos_disponibles.getValueAt(fila, 4));
                
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
                    // Registrar evento en bitácora al agregar producto al carrito
                    EventoBitacora.registrarEvento("Cliente",codigo_cliente,"Agregar Producto Carrito","Exitosa", "Producto agregado: " + nombre + ", cantidad: " + cantidad_u + ", total Q" + total_pagar,"se Agrego el Carrito");
                    
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
             
             
             public static Inventarios_PDF[] verAcumuladasProductos(){
                 Inventarios_PDF[] n = new Inventarios_PDF[2];
                 for(Productos p: crear_producto){
                     if(p!= null){
                         
                         
                     }
                     
                 }
                 
                 return n;
             }
             
             
             
             
             
             
             
            
             
             
             //VAMOS A TRABAJA CON LOS CARRTIOS PARA LA GENERACION DE PDF 

             //almacenamiento para los pedidos mas vendidos 
             
             public static Inventarios_PDF[] almacenamiento_mas_vendidos = new Inventarios_PDF[1000]; 
             public static int indice_mas_vendidos =0;
             
             
             //almacenamiento para los menos vendidos 
             
             public static Inventarios_PDF[] almacenamineto_menos_vendidos = new Inventarios_PDF[10000];
             public static int indice_menos_vendidos =0;

             //almacenamiento para inventarios 
             
             public static Inventarios_PDF[] almacenamiento_inventarios = new Inventarios_PDF[1000];
             public static int indice_inventario=0;
             

             public static Inventarios_PDF[] obtenerProductosMasVendidos(){
                 
                  // Limpiar el array primero
                      for(int i = 0; i < indice_mas_vendidos; i++) {
                               almacenamiento_mas_vendidos[i] = null;
                              }
                 
                 //FILTRAR SOLO PRODUCTOS CON VENTAS 
                 
                 int contador_ventas =0; 
                 
                 for(int i=0; i<indice_producto; i++){
                     if(crear_producto[i] != null && crear_producto[i].getVentas_acumuladas() >0){
                         contador_ventas++; //me va a seguri para solo buscar productos con ventas 
                         
                     }
 
                 }
                 
                 
                 System.out.println("Producto con ventas" + contador_ventas); //me dice cuantos productos generaron ventas 
                 
                 if(contador_ventas ==0){
                     return new Inventarios_PDF[0];  
                 }
                 
                 
                 //productos con ventas 
                 
                 Inventarios_PDF[] productos_ventas = new Inventarios_PDF[contador_ventas];
                 int indice_ventas =0; 
                 
                 for(int i=0; i<indice_producto; i++){
                     if(crear_producto[i] != null && crear_producto[i].getVentas_acumuladas() >0){
                         Productos p = crear_producto[i];
                         productos_ventas[indice_ventas] = new Inventarios_PDF(p.getNombre_producto(), p.getVentas_acumuladas(), p.getCategoria_producto(), p.getVentas_acumuladas()*p.getPrecio_producto());
                         indice_ventas++;
                         
                         System.out.println("Debug" + p.getNombre_producto()+ " - Ventas: " + p.getVentas_acumuladas() +
                             " - Ingresos: " +  (p.getVentas_acumuladas()*p.getPrecio_producto()));
                         
                         
                     }
                     
                 }
                 

                 
                return productos_ventas;
                 
             }
             
             
             
             public static Inventarios_PDF[] obtenerProductosMenosVendidos(){
                 
                  // Limpiar el array primero
                      for(int i = 0; i < indice_menos_vendidos; i++) {
                               almacenamineto_menos_vendidos[i] = null;
                              }
                 
                 //FILTRAR SOLO PRODUCTOS CON VENTAS 
                 
                 int contador_ventas =0; 
                 
                 for(int i=0; i<indice_producto; i++){
                     if(crear_producto[i] != null && crear_producto[i].getVentas_acumuladas() >0){
                         contador_ventas++; //me va a seguri para solo buscar productos con ventas 
                         
                     }
 
                 }
                 
                 
                 System.out.println("Producto con ventas" + contador_ventas); //me dice cuantos productos generaron ventas 
                 
                 if(contador_ventas ==0){
                     return new Inventarios_PDF[0];  
                 }
                 
                 
                 //productos con ventas 
                 
                 Inventarios_PDF[] productos_ventas = new Inventarios_PDF[contador_ventas];
                 int indice_ventas =0; 
                 
                 for(int i=0; i<indice_producto; i++){
                     if(crear_producto[i] != null && crear_producto[i].getStock_productos() >= 0){
                         Productos p = crear_producto[i];
                         
                         System.out.println("Enramos al metodo producto menos vendidos ");
                         System.out.println("Informacion actual" + p.getNombre_producto() + " "+ "Stock dle producto" + p.getStock_productos());
                         
                         
                         
                         
                         
                         //recomendaciones para el stock 
                         if(p.getStock_productos() ==0){
                              System.out.println("Entro al contrusttor ");
                             
                              String recomendacion4 = "Stock insuficinete se acabo" + p.getStock_productos() + " " + "Ya no Hay";
                              productos_ventas[indice_ventas] = new Inventarios_PDF(p.getNombre_producto(), p.getVentas_acumuladas(), p.getStock_productos(), recomendacion4);
                              indice_ventas++;
                         }
                         
                         if(p.getStock_productos() < 5){
                             String recomendacion1 = "ADVERTENCIA Cantidad stock poca" + p.getStock_productos() + " " + "aun" + "(menor que 5)";
                             productos_ventas[indice_ventas] = new Inventarios_PDF(p.getNombre_producto(), p.getVentas_acumuladas(), p.getStock_productos(), recomendacion1);
                             
                             System.out.println("Informacion actual" + p.getNombre_producto() + " "+ "Stock dle producto" + p.getStock_productos());
                             indice_ventas++;
                             
                             System.out.println("------------------------------------------------------------------------------------------------------");
                             System.out.println("------------------------------------------------------------------------------------------------------");
                             
                             
                         }else if(p.getStock_productos()<10){
                             
                             
                             String recomendacion2 = "Stock apunto de Acabarse" + p.getStock_productos() + " " + "aun" + "(menor que 10)";
                             productos_ventas[indice_ventas] = new Inventarios_PDF(p.getNombre_producto(), p.getVentas_acumuladas(), p.getStock_productos(), recomendacion2);
                             System.out.println("Informacion actual" + p.getNombre_producto() + " "+ "Stock dle producto" + p.getStock_productos());

                             indice_ventas++;
                             
                             
                         }else if(p.getStock_productos() < 20){
                             //el stock cuando es menor a 10 podriamos decir recomendacion 
                             String recomendacion3 = "Stock aun Sufientes Cantidad" + p.getStock_productos() + " " + "aun" + "(menor que 20)";
                             productos_ventas[indice_ventas] = new Inventarios_PDF(p.getNombre_producto(), p.getVentas_acumuladas(), p.getStock_productos(), recomendacion3);
     
                             System.out.println("Informacion actual" + p.getNombre_producto() + " "+ "Stock dle producto" + p.getStock_productos());
                             indice_ventas++;
                             
                         }
                         
                         
                        
                         
                         
                     }
                     
                 }
                 

                 
                return productos_ventas;
                 
             }
             
             
             
             
             
             
             
 
             
             
             
             
             
             
        
             
             
  
             
             
             
             
       
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
  
             
             
             
             
    
 
             
             
             
             
             
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

