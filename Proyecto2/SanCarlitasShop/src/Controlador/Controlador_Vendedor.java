/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Vendedor;
import javax.swing.JOptionPane;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;


public class Controlador_Vendedor {
    
    //aqui vamos a crear los vendedores y sus funcionalidades como metodos y acciones en cada cosa que haga
    
    public static Vendedor[] crear_vendedor = new Vendedor[100]; //garantizamos que los vendedores no sean accedido facilmente 
    public static  int indice_vendedor=0; 
    public static String Codigo_vendedor;
    
    
     //Metodos para crear clientes 
    public static void crearVendedores(Vendedor vendedor_nuevo){ //debe guardar un objeto 
        if(indice_vendedor < crear_vendedor.length){
            //si el inidce es menor entonces podemos agregar vendedores nuevos 
            crear_vendedor[indice_vendedor] = vendedor_nuevo; 
            indice_vendedor ++;   
        }  
    }
    
    public static boolean  crearVendedores1(String codigo, String nombre, String genero, String contraseña){
        if(indice_vendedor<crear_vendedor.length){
            Vendedor nuevo_vendedor = new Vendedor(codigo, nombre, genero, contraseña); 
            crear_vendedor[indice_vendedor] = nuevo_vendedor; 
            indice_vendedor++;
            return true; 
        }else{
            return false;
        }
        
    }

    
   
    
    //PARA ACCEDER AL OBJETO 
    
    public static Vendedor objetoVendedor(String codigo){
        for(int i=0; i<indice_vendedor; i++){
            if(codigo.equals(crear_vendedor[i].getCodigo())){
                return crear_vendedor[i];
                
            }
        }
        
        return null;
        
    }
    
    
    //vamos acceder el objeto a traves de su codigo 
    
    //validacion de un vendedor existente 
    
    public static boolean  validarVendedorExistente(String codigo){
        
        for(int i=0; i<indice_vendedor; i++){
            if(codigo.equals(crear_vendedor[i].getCodigo())){
                return true; // valida si un vendedor existe
            }
        }
        return false;
        
    }
    
    // validacion de contraseña de vendedores existentes 
    
    public boolean  validarContrasenaExistente(String contra){
        for(int i=0; i<indice_vendedor; i++){
            if(contra.equals(crear_vendedor[i].getContra())){
                return true;
            }
        }
        return false;  
    }
    
    
     //obtener las contraseñas del cualquier vendedor 
       
   public boolean ObtenerVendedorCodigoContraseña(String codigo, String contraseña){
        for(int i=0; i<indice_vendedor; i++){
            if(codigo.equals(crear_vendedor[i].getCodigo()) && contraseña.equals(crear_vendedor[i].getContra())){
                return true;
            }
        }
        return false; 
        
    }
   
   //Eliminar al vendedor Cuidado, debemos correr todo los vendedores que estan posterior al que eliminamos para no tener errores de null 
   
   public static void eliminarVendedor(String codi){
       
       for(int i=0; i<indice_vendedor; i++){
           if(codi.equals(crear_vendedor[i].getCodigo())){
               crear_vendedor[i] = null; // eliminacion del usuario
               
               //ahora vamos a correr todos lo elementos 
               
               for(int j=i; j<indice_vendedor-1; j++){
                   crear_vendedor[j] = crear_vendedor[j+1];
               }
               
               //ahora limpiamos la ultima posicion 
               
               crear_vendedor[indice_vendedor-1] = null; 
               indice_vendedor--; 
               break; 
           }
       }
       
   }
   
   public static void cargarCsv(File arcCsv){
       
       
       //primero vamos acceder a nuestro directorio para buscar el archivo csv 
       
       try(CSVReader leer = new CSVReader(new FileReader(arcCsv))){
           String[] variable_aux = null;
           leer.readNext(); //saltamos a los encabezados
           
           while((variable_aux = leer.readNext()) != null){
               
               //VAMOS A VERFICAR EL CODIGO PARA CAMBIARLO 
               
               if(!validarVendedorExistente(variable_aux[0])){
                //instanciar para acceder para crear el objeto traido desde un archivo csv 
       
               Vendedor vendedorCsv = new Vendedor(variable_aux[0], variable_aux[1], variable_aux[2], variable_aux[3], variable_aux[4]);
               crearVendedores(vendedorCsv);
               
                   
               }else{
                   System.out.println("no se agrega por codigo repetido");
               }
              

           }
           
           leer.close();
           
       }catch(Exception e){
           throw new RuntimeException(e);
           
       }
       
       
       
   }
   
   
   //necesiamos saber cuantas ventas confirmadas hizo el vendedor 
   
   public static void confirmacionVentasVendedor(String codigo_vendedor){
       
       
   }
   
   
   public static void obtenerCodigoVendedor(String c){
       Codigo_vendedor = c; 
   }
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
