/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Administrador;
import javax.swing.JOptionPane;


public class Controlador_Usuarios {
    
    Administrador c = new Administrador();
    
    //necesito acceder al administrador con sus getters y setters 
    
    //aqui vamos a controlar por defecto el login de nuestor programa 
    
    public boolean verificarLogin(String codigo, String contra){
    
        if(codigo.equals(c.getCodigo()) && contra.equals(c.getContra())){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Verifique los Datos");
        }
        return false;
        
    }
    
    
    
}
