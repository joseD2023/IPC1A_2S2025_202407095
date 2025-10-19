/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Vendedor;
import javax.swing.JOptionPane;


public class Controlador_Vendedor {
    
    //aqui vamos a crear los vendedores y sus funcionalidades como metodos y acciones en cada cosa que haga
    
    public static Vendedor[] crear_vendedor = new Vendedor[100]; //garantizamos que los vendedores no sean accedido facilmente 
    public static  int indice_vendedor=0; 
    
    public static boolean  crearVendedores(String codigo, String nombre, String genero, String contraseña){
        if(indice_vendedor<crear_vendedor.length){
            Vendedor nuevo_vendedor = new Vendedor(codigo, nombre, genero, contraseña); 
            crear_vendedor[indice_vendedor] = nuevo_vendedor; 
            return true; 
        }else{
            return false;
        }
        
    }

    
    //Metodos para crear clientes 
    public void crearVendedores(Vendedor vendedor_nuevo){ //debe guardar un objeto 
        if(indice_vendedor < crear_vendedor.length){
            //si el inidce es menor entonces podemos agregar vendedores nuevos 
            crear_vendedor[indice_vendedor] = vendedor_nuevo; 
            indice_vendedor ++;   
        }else{
            JOptionPane.showMessageDialog(null, "Limite de Vendedores llegado a su limite");
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
