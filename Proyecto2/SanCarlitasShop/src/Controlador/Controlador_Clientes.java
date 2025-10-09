/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import javax.swing.JOptionPane;


public class Controlador_Clientes {
    //aqui vamos a trabajar todo lo relacionado a clientes 
    
    public static Cliente[] crear_clientes = new Cliente[100];
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
    
   
    
   
    
            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            
    
}
