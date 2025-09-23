
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
    
    //verificacion si existe un pokemon en la base de datos 
    
    public static boolean pokemonValido(String name_pokemon){
        
        for(int i=0; i< indice_pokemon; i++){ // ponemos solo los indices agregados no nos importa lo demas por lo null
            if(name_pokemon.trim().equalsIgnoreCase(pokemon[i].getNombre_pokemon().trim())){
                return true;
            }
        }
        
        return false;
        
    }
    
    //visualizamos nuestro personaje 
    public static Pokemones visualizarPokemonNombre(String buscar_nombre){ // el tipo de retorno es un objeto osea Pokemones es un objeto
        for(int i=0; i<indice_pokemon; i++){
            if(buscar_nombre.equalsIgnoreCase(pokemon[i].getNombre_pokemon())){
                return pokemon[i];  // si encuentra al pokemon retorna el objeto        
            }
        }  
        
        return null;
    }
    
    
    
    
    
    
    
    
        
    }
    
    

