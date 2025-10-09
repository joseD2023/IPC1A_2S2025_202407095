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
    
    public boolean  validarVendedorExistente(String codigo){
        
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
