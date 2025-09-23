
package controlador;

import javax.swing.JOptionPane;
import modelo.Pokemones;


public class BatallaController {
    
    static Pokemones[] pokemon = new Pokemones[100];  //aqui vamos a guardar cada pokemon  
    static int indice_pokemon =0;
    
    //Vamos a crear un metodo para registrar un Pokemon 
    public static void registrarPokemon(Pokemones pokeregistrar){
        if(indice_pokemon < pokemon.length){
            pokemon[indice_pokemon] = pokeregistrar; // aqui agregamos al pokemon.
            indice_pokemon++; // AUMENTAMOS EL INDICE CADA VEZ QUE AGREGAMOS UNO
            JOptionPane.showMessageDialog(null, "Pokemono Registrado Correctamente");
        }
    }
    
    //visualizamos nuestro personaje 
    
    public static void visualizarPokemon(){
        
    }
    
    
}
