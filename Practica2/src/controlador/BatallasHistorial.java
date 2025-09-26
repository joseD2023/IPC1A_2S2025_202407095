/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Historial;

/*NOS VA A SERVIR PARA CONTROLAR LOS HISTORIALES DE CADA BATALLA DE CADA POKEMON*/

public class BatallasHistorial {
    
    public static Historial[] historial_batallas = new Historial[100]; // guaradamos nuestro historial 
    public static int indice_batalla = 0;
    
    public static void agregarBatallaHistorial(Historial batalla){
        
        if(indice_batalla<historial_batallas.length){
            historial_batallas[indice_batalla] = batalla;
            indice_batalla++;
            JOptionPane.showMessageDialog(null, "Batalla agreada exitosamente");
        }
        
        
        
        
    }
    
    
    
    
}
