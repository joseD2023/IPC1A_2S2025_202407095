/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDateTime;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */
public class Bitacora_Eventos {
    
    //declaramos los atributos que nos puedes ayudar dentro de la bitacora 
    
    private String poke1; 
    private String poke2;
    private LocalDateTime tiempo_inicio; 
    private LocalDateTime tiempo_final; 
    private String informacion_batalla;
    private String Ganador; 
     private JTextArea textArea; // referencia al JTextArea
    
    
    public Bitacora_Eventos(String poke1, String poke2, LocalDateTime tiempo){
        this.poke1 = poke1;
        this.poke2 = poke2; 
        this.tiempo_inicio = tiempo;
        this.informacion_batalla = ""; //no tengo nada para mostrar en la informacion batalla
        this.Ganador ="";{

    }
        
        
    }
    
    
    //metodos para agregar eventos 
    
    public void eventoAgregados(String evento){
        informacion_batalla +=  evento + "\n"; //cada vez que llamemos a este metodo nos va a concatenear la informacion
        
        
    }
    
    public void ganadorBatalla(String ganador, LocalDateTime tiempofinal){
        String t = "[" + tiempofinal +"]";
        this.Ganador = ganador;
        
        
    }
    
    public void mostrarBitacora(){
        //vamos a mostrar lo que guardo la bitacora 
        System.out.println(poke1 + "vs" + poke2);
        System.out.print(tiempo_inicio);
        System.out.println(informacion_batalla);
        
        
                
    }
    
    
   
    
}
