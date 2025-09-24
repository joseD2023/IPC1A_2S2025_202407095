/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


public class BatallasHistorial {
    
    private int numero_batalla = 0;
    private String fecha;
    private String pokemon1;
    private String pokemon2;
    private String ganador;

    public BatallasHistorial(String fecha, String pokemon1, String pokemon2, String ganador) {
        this.fecha = fecha;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.ganador = ganador;
    }

    public int getNumero_batalla() {
        return numero_batalla;
    }

    public void setNumero_batalla(int numero_batalla) {
        this.numero_batalla = numero_batalla;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(String pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public String getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(String pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
    
    
    
}
