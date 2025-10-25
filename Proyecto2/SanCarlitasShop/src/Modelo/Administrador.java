/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import static Vista.Modulo_Administrador.admi;


public class Administrador extends Usuario{ 
    
// hacemos la herencia de usuario
    //constructor vacia ya que ya esta predefinido o harcodeados los nombres 
    public Administrador(){
        super("“admin", "Jose De La Rosa (ING.Sistemas)", "IPC1A");
    }
    
    
    public static void obtenerCodigoAdministrado(String cod_admi){
        admi = cod_admi; // obtenemos el codiog del adminisitrador 
    }
    
    
    
    
}
