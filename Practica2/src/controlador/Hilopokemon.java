/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Pokemones;


class HilosPokemones implements Runnable{
    private Pokemones miPokemon; // atributos de los pokemones 
    private Pokemones oponPokemon;
    
    public HilosPokemones(Pokemones mipokemon, Pokemones oponentepokemon){
        this.miPokemon = mipokemon;
        this.oponPokemon = oponentepokemon;  
    }
    
    
    @Override
    public void run() {
        
        //vamos a trabajar con la batallas 
        while(oponPokemon.getHp()>0){
            
        }

        



        }
    }






public class Hilopokemon {
    
}
