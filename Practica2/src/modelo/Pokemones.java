
package modelo;


public class Pokemones { // creamos nuestra definicion de Pokemons
    
    private String nombre_pokemon; 
    private String arma; 
    private int hp;
    private int nivel_ataque;
    private int  velocidad_ataque;
    private int agilidad; 
    private int defensa;
    private int id;
    
    //estos atributos nos van a servir para identificar las batallas y cuantas gano y cuantas perdio 
    
    private int total_batallas = 0;
    private int ganadas = 0;
    private int perdidas = 0;

    
    
     public Pokemones(String nombre_pokemon, String arma, int hp, int nivel_ataque, int velocidad_ataque, int agilidad, int defensa, int id){
        this.nombre_pokemon = nombre_pokemon;
        this.arma = arma;
        this.hp = hp;
        this.nivel_ataque = nivel_ataque;
        this.velocidad_ataque = velocidad_ataque;
        this.agilidad = agilidad;
        this.defensa = defensa;
        this.id = id;
        
    }
     
     //metodo cantidad de batallas ganada 
     
     public void registrarBatalla(boolean  gano){
         total_batallas++;  // batallas que ha hecho
         if(gano){
             ganadas++; //conteo de cuantas gano 
             
         }else{
             perdidas++; // conteo de cuantas perdio 
         }
     }
     
     
     // encontrar el nombre del oponente

    public int getTotal_batallas() {
        return total_batallas;
    }

    public void setTotal_batallas(int total_batallas) {
        this.total_batallas = total_batallas;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }
     
     
     
     
     
     
     
     
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getNivel_ataque() {
        return nivel_ataque;
    }

    public void setNivel_ataque(int nivel_ataque) {
        this.nivel_ataque = nivel_ataque;
    }

    public int getVelocidad_ataque() {
        return velocidad_ataque;
    }

    public void setVelocidad_ataque(int velocidad_ataque) {
        this.velocidad_ataque = velocidad_ataque;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

   
        
    
}
