
package modelo;


public class Pokemones { // creamos nuestra definicion de Pokemons
    
    private String nombre_pokemon; 
    private String arma; 
    private String hp;
    private String nivel_ataque;
    private String velocidad_ataque;
    private String agilidad; 
    
     public Pokemones(String nombre_pokemon, String arma, String hp, String nivel_ataque, String velocidad_ataque, String agilidad){
        this.nombre_pokemon = nombre_pokemon;
        this.arma = arma;
        this.hp = hp;
        this.nivel_ataque = nivel_ataque;
        this.velocidad_ataque = velocidad_ataque;
        this.agilidad = agilidad;
    }

    public String getNombre_pokemon() {
        return nombre_pokemon;
    }

    public void setNombre_pokemon(String nombre_pokemon) {
        this.nombre_pokemon = nombre_pokemon;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getNivel_ataque() {
        return nivel_ataque;
    }

    public void setNivel_ataque(String nivel_ataque) {
        this.nivel_ataque = nivel_ataque;
    }

    public String getVelocidad_ataque() {
        return velocidad_ataque;
    }

    public void setVelocidad_ataque(String velocidad_ataque) {
        this.velocidad_ataque = velocidad_ataque;
    }

    public String getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(String agilidad) {
        this.agilidad = agilidad;
    }
    
    
   
    
        
    
}
