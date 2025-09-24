
package controlador;

import javax.swing.JOptionPane;
import modelo.Pokemones;


public class BatallaController {
    
    public static Pokemones[] pokemon = new Pokemones[100];  //aqui vamos a guardar cada pokemon  
    public static int indice_pokemon =0;
    
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
    
    //verificacion de existencia pokemon por id 
    
    public static boolean pokemonValidoId(String id){
        for(int i=0; i<indice_pokemon; i++){
            if(id.equalsIgnoreCase(Integer.toString(pokemon[i].getId()))){
                return true;
                
            }
        }
        return false;
    }
    
    /* LA CLASE VISTA MODIFICAR POKEMON */
    //BUSCAR POKEMONES POR NOMBRE Y ID
    //visualizamos nuestro personaje 
    public static Pokemones visualizarPokemonNombre(String buscar_nombre){ // el tipo de retorno es un objeto osea Pokemones es un objeto
        for(int i=0; i<indice_pokemon; i++){
            if(buscar_nombre.equalsIgnoreCase(pokemon[i].getNombre_pokemon())){
                return pokemon[i];  // si encuentra al pokemon retorna el objeto        
            }
        }  
        
        return null;
    }
    
    public static Pokemones visualizarporID(String id){
        for(int i=0; i<indice_pokemon; i++){
            if(id.equalsIgnoreCase(Integer.toString(pokemon[i].getId()))){ // lo convertimos a string pra convaparar
                return pokemon[i]; //devuelve el objeto de un pokemon
                
            }
        }
        
        return null;
    }
    
    //METODO PARA ELIMINAR POR NOMBRE Y ID
    
    /*---------------------------------------------------------------------------------------------------*/
    
    public static void pokemonEliminarId(String id){ // pedimos el id 
        int id_buscar = Integer.parseInt(id);
        for(int i=0; i< indice_pokemon; i++){ // recorremos solo los pokemones recorridos 
            if(pokemon[i].getId() == id_buscar){ // comparamos valores 
                pokemon[i] = null; // aqui eliminamos el pokemon que el id nos dijo para eliminar
                
                
                // ahora vamos a correr todos los elementos 
                for(int j=i; j<indice_pokemon-1; j++){
                    pokemon[j] = pokemon[j+1];
                }
                
                pokemon[indice_pokemon -1 ] = null; 
                indice_pokemon--;
                break;
            }
        } 
    }
    
    
    public static void pokemonEliminarNombre(String n){ // pedimos el id 
        for(int i=0; i< indice_pokemon; i++){ // recorremos solo los pokemones recorridos 
            if(n.equalsIgnoreCase(pokemon[i].getNombre_pokemon())){ // comparamos valores 
                pokemon[i] = null; // aqui eliminamos el pokemon que el id nos dijo para eliminar
                
                
                for(int j=i; j< indice_pokemon -1; j++){
                    pokemon[j] = pokemon[j+1];
              
                }
                
                pokemon[indice_pokemon-1] = null; 
                indice_pokemon --;
                break;
            }
        } 
    }
    
    /*---------------------------------------------------------------------------------------------------*/
    
    //valida los datos para el sistema aceptarlo lo Use en Agregar Personajes
    
    public static boolean validarDatos(int vida, int nivel, int velocidad, int agilidad, int defensa){
        if((vida >= 100 && vida <= 500) && (nivel>= 10 && nivel<= 100) && (velocidad >= 1 && velocidad<=10) && (agilidad>= 1 && agilidad<=10) && (defensa>=1 && defensa<= 50)){
            
            return true;
        }
        return false;
        
    }
    
 
    
    
  
    
    
    
    
    
    
    
    
    
        
    }
    
    

