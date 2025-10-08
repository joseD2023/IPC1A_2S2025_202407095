/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Administrador;
import javax.swing.JOptionPane;


public class Controlador_Usuarios {
    
    Administrador c = new Administrador();
    Controlador_Clientes cliente = new Controlador_Clientes(); // con esto ya puedo acceder a los datos  gettes 
    Controlador_Vendedor vendedor = new Controlador_Vendedor();
    
    
    //necesito acceder al administrador con sus getters y setters 
    
    //aqui vamos a controlar por defecto el login de nuestor programa 
    
    /*Opcion 1: Modulo Cliente 
    Opcion 2: Modulo Administrador 
    Opcion 3: Modulo Vendedor*/
    
    public int verificarLogin(String codigo, String contra){
        
        if(cliente.ObtenerClienteCodigoContraseña(codigo, contra)){ // si es true me retorna que se consiguio al dueño del ese codigo y usuario 
            return 1;  
        }
        
        if(vendedor.ObtenerVendedorCodigoContraseña(codigo, contra)){
            return 3;
        }
    
        if(codigo.equals(c.getCodigo()) && contra.equals(c.getContra())){
            return 2;
        }else{
            JOptionPane.showMessageDialog(null, "Verifique los Datos");
        }
        return 0;
        
    }
    
    
    
}
