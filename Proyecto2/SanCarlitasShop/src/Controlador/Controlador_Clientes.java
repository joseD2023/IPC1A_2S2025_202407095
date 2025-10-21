/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.Controlador_Productos.crear_producto;
import static Controlador.Controlador_Productos.limpiar;
import Modelo.Carrito_Compras;
import Modelo.Cliente;
import Modelo.Productos;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Controlador_Clientes {
    //aqui vamos a trabajar todo lo relacionado a clientes 
    
    public static Cliente[] crear_clientes = new Cliente[100];
    public static Carrito_Compras[] carrito = new Carrito_Compras[100];
    public static int indice_carrito; 
    public static int indice_clientes =0; 
    
 
    //vamos a crear metodos para por los clientes pueden hacer 
    public static void crearClientes(Cliente nuevo_cliente){
        if(indice_clientes < crear_clientes.length){
            // como es menor aun puede almacenar clientes 
            crear_clientes[indice_clientes] = nuevo_cliente; 
            indice_clientes++; 
            
        }else{
            JOptionPane.showMessageDialog(null, "Limite de Vendedores llegado a su limite");
        }  
    }
    
    //Acceder a los objetos a traves de una funcion 
    
    public static Cliente objetoCliente(String codigo){
        for(int i=0; i<indice_clientes; i++){
            if(codigo.equals(crear_clientes[i].getCodigo())){
                return crear_clientes[i];
            }
        }
        return null;
        
    }
    
    //validar clientes en Existencia por Codigo y Contraseña 
    
    public static boolean validarClientesExistentes(String codigo){
        for(int i=0; i<indice_clientes; i++){
            if(codigo.equals(crear_clientes[i].getCodigo())){
                return true;
            }
        }
        return false;
    }
    
    public static  boolean validarContraseñaCliente(String contra){
         for(int i=0; i<indice_clientes; i++){
            if(contra.equals(crear_clientes[i].getContra())){
                return true;
            }
        }
        return false;
        
    }
    
     //obtener las contraseñas del cualquier vendedor 
    
    public static boolean ObtenerClienteCodigoContraseña(String codigo, String contraseña){
        for(int i=0; i<indice_clientes; i++){
            if(codigo.equals(crear_clientes[i].getCodigo()) && contraseña.equals(crear_clientes[i].getContra())){
                return true;
            }
        }
        return false; 
        
    }
    
    
    //metodo para eliminar un cliente dentro del sistema 
    
    public static void eliminarCliente(String codi){
        for(int i=0; i<indice_clientes; i++){
            if(codi.equals(crear_clientes[i].getCodigo())){
                //lo encontramos lo eliminamos 
                crear_clientes[i] = null; 

                //ahora movemos a correr todos los elementos 
                
                for(int j=i; j<indice_clientes-1; j++){
                    crear_clientes[j] = crear_clientes[j+1];
                }
                
                crear_clientes[indice_clientes-1] = null; 
                indice_clientes--; 
                break; 
                
                
            }
        }
        
    }
    
     // para guardar en CSV 
    
    public static void cargarCsvClientes(File archivo){
        
        try(CSVReader leer = new CSVReader(new FileReader(archivo))){
            String[] cliente_aux = null; 
            
            while((cliente_aux = leer.readNext())!= null){
                
                if(!validarClientesExistentes(cliente_aux[0])){
                    Cliente cliente_sistema = new Cliente(cliente_aux[0], cliente_aux[1], cliente_aux[2], cliente_aux[3], cliente_aux[4]);
                    crearClientes(cliente_sistema);   
                }else{
                    System.out.println("Codigo repetidos" + cliente_aux[0]);
                }
            }
            
            leer.close();
            
        }catch(Exception e){
            throw new RuntimeException(e);
            
        }
        
    }
    
    
    /*----------------------- CONTROLES ACERCA DEL CARRITO  -----------------------------------------------------*/
    
    public static void agregarCarrito(Carrito_Compras compra){
        if(indice_carrito < carrito.length){
            carrito[indice_carrito] = compra; 
            indice_carrito ++;
        }else{
            System.out.println("Limite");
        } 
    }
    /*------------------------------------------------------------------------*/
    
    public static Carrito_Compras objetoCarrito(String codigo){
        for(int i=0; i<indice_carrito; i++){
            if(codigo.equals(carrito[i].getCodigo_producto())){
                return carrito[i]; //obtenemos el objeto para nuestro carrito 
            }
        }
        return null;
 
    }
    
     /*------------------------------------------------------------------------*/
    
    public static void visualizacionCarritos(DefaultTableModel tabla_carritos){
        limpiar(tabla_carritos);
        
        if(carrito != null && carrito.length >0){
            for(Carrito_Compras ca: carrito){
                if(ca != null){
                    Object[] fila = {ca.getCodigo_producto(), ca.getNombre_producto(), ca.getCantidad(), ca.getPrecio(), ca.getTotoal(), "Eliminar"};
                    tabla_carritos.addRow(fila);
                }
                
            }
            
        }
    }

    /*----------------------------------------------------------------------------*/
    
    public static void eliminarCarrito(String codigo_carrito){
        
        for(int i=0; i<indice_carrito; i++){
            if(codigo_carrito.equals(carrito[i].getCodigo_producto())){
                carrito[i] = null; //eliminado del carrito 
                
                //ahora vamos a mover todo para no tener problemas con los null
                
                for(int j=i; j<indice_carrito-1; j++){
                    carrito[j] = carrito[j+1]; // corremos todo a la siguiente posicion 
                }
                
                carrito[indice_carrito-1] = null; 
                indice_carrito--;
                break; //borramos definitivamente el carrito 
 
            }
        }
    }
    
     /*----------------------------------------------------------------------------*/
    
    
    /*------------------------- VIsualizacion de SWING -------------------------------------*/
    
    
    public static void limpiar(DefaultTableModel modelo){
        int filas = modelo.getRowCount(); 
        for(int i=filas-1; i>=0; i--){
            modelo.removeRow(i);
        }
        
    }
    
     /*----------------------------------------------------------------------------*/
    
    public static void visualizarProductos(DefaultTableModel tabla_producto){
        limpiar(tabla_producto);
        
        if(crear_clientes != null && crear_clientes.length >0){
            for(Cliente c: crear_clientes){
                if(c != null){
                    Object[] fila = {c.getCodigo(),c.getNombre()};
                    tabla_producto.addRow(fila);
                }
                
            }
            
        }
        
    }
    
     /*----------------------------------------------------------------------------*/
    
      public static double solicitarCantidadCliente(int stock){
            String cantidad_txt = JOptionPane.showInputDialog(
              null, 
             "¿Cuántas unidades de  desea?",
             "Cantidad",
             JOptionPane.QUESTION_MESSAGE
             );
            
            if(cantidad_txt != null && !cantidad_txt.isEmpty()){
                  try{
                    int cantidad =  Integer.parseInt(cantidad_txt);
                    if(cantidad > 0 && cantidad <= stock){
                      return cantidad;
                    }else{
                        JOptionPane.showMessageDialog(null, "Cantidad no valida Stock");
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
            }
            }else{
                JOptionPane.showMessageDialog(null, "Campo Vacio");
            }
            
            return -1;
  
        }
      
      
      /*----------------------------------------------------------------------------*/
      
      //mostrar botones para actualizar o eliminar del carrito
      
      public static void carritoBtones(JTable tabla, DefaultTableModel tabla_carito, DefaultTableModel tabla_producto){
          
          tabla.addMouseListener(new java.awt.event.MouseAdapter(){
              @Override
              public void mouseClicked(java.awt.event.MouseEvent evt){
                int columna = tabla.columnAtPoint(evt.getPoint());
                int fila = tabla.rowAtPoint(evt.getPoint());
                
                if(columna == 5){
                    String codigo = tabla.getValueAt(fila, 0).toString(); // solo necesito el codigo para acceder a todo el documento 
                    //necesiot si elimino regresar al stock para que no se pierda eso 
                    //vamos a obtener la cantidad que el usuario ingreso 
                    
                    Carrito_Compras carrito_cantidad_recuperar = objetoCarrito(codigo); //accedo a la cantidad y ahora lo vuelvo a sumar como al inicio
                    int cantidad_recuperar = carrito_cantidad_recuperar.getCantidad(); // y obtemos la cantidad 
                    //*---------------------------------------------------------------------------------*/
                    
                    //necesitamos encontrar el stock 
                    
                    int stock_recuperar = Controlador_Productos.objetoProductos(codigo).getStock_productos(); // ya tenemos el verdadero stock y ahora le sumamos la cantidad que le restamos 
                    

                    //ahora lo sumamos 
                    Productos stock_producto = Controlador_Productos.objetoProductos(codigo); // y ahora se actualizar la parte del stock
                    stock_producto.setStock_productos(stock_recuperar + cantidad_recuperar); //recuperamos el stock
                    

                    //vamos a tratar de eliminar el producto del carrtio  
                    eliminarCarrito(codigo); // ingreso el codigo y en la funciona va eliminar el carrito
                    JOptionPane.showMessageDialog(null, "Carrito Eliminado");
                    
                    
                    
                    visualizacionCarritos(tabla_carito); // para que lo actualice
                    //tambien debemos actualizar la tabla 
                    
                    Controlador.Controlador_Productos.visualizarProductos(tabla_producto);
                }
              }
              
          });
          
      }
      
      

      

        

   
   
    
   
    
            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            
    
}
