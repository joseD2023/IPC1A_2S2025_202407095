    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package controlador;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
    import javax.swing.JTextArea;
    import javax.swing.SwingUtilities;
    import modelo.Historial;
    import modelo.Pokemones;








    public class Hilopokemon implements Runnable{
        private Pokemones miPokemon; // atributos de los pokemones 
        private Pokemones oponPokemon; // atributos del hilo pero esos atributos son instancias de objetos 
        private JTextArea textArea; // referencia al JTextArea
  








         public Hilopokemon(Pokemones miPokemon, Pokemones oponPokemon, JTextArea textArea) {
            this.miPokemon = miPokemon;
            this.oponPokemon = oponPokemon;
            this.textArea = textArea;// Configuración del textArea solo una vez
            this.textArea.setLineWrap(true);
            this.textArea.setWrapStyleWord(true);
        }



         @Override
        public void run() {

            //hacemos todas las acciones en runnable 

            while(miPokemon.getHp()>0 && oponPokemon.getHp()>0){//miestras tenga vida se va a ejecutar el bucle 

                //condicion de agilidad de que esquive el ataque 


                if(Math.random() < (oponPokemon.getAgilidad()/10.0)){ // si la probabilidad es mas grande que la agilidad del pokemon entonces golpea al pokemon
                    //agilidad de que mi pokemon pueda pegarle a mi oponente 
                    //si la probaiblidad es mayor es decir math.random es mayor mi pokemon le pegueo efectivamente al oponente
                    int nueva_vida_pokemon = oponPokemon.getHp() - ((miPokemon.getNivel_ataque()*4)/oponPokemon.getDefensa());
                    //si  le pego a mi oponenen entonces su defensa aparece y reduce el daño de vida al pokemon oponenten

                    oponPokemon.setHp(Math.max(nueva_vida_pokemon, 0)); //evitamos vidas negativas 

                    String mensaje = miPokemon.getNombre_pokemon() + " Ataco a " + " " + oponPokemon.getNombre_pokemon()
                            + " y ahora tiene un nivel de vida de " + " "+ oponPokemon.getHp() + "\n";;


                    SwingUtilities.invokeLater(()-> {
                    textArea.append(mensaje);
                });


                }else{
                    //si no le pego mi pokemon entonces el otro pokemon me at
                    String mensaje2 = miPokemon.getNombre_pokemon() + " ataco pero " + " "+ oponPokemon.getNombre_pokemon()
                            + " esquivó. Aún tiene vida de " + " "+oponPokemon.getHp() + "\n";


                    SwingUtilities.invokeLater(() -> {
                        textArea.append(mensaje2);

                    });




                }

                try{
                    Thread.sleep(1000/miPokemon.getVelocidad_ataque());
                }catch(InterruptedException e){

                }
                
                
                
                
                
                if(oponPokemon.getHp() <=0 && miPokemon.getHp()<= 0){
                    String empate = "Los pokemones" + oponPokemon.getNombre_pokemon() + " " + "Y" + miPokemon.getNombre_pokemon()+" " + "Quedaron empate";
                    SwingUtilities.invokeLater(()-> {
                      textArea.append(empate);
                    });
                    
                    //vamos a validar por si quedan empatados 
                    
                    int contador = BatallasHistorial.indice_batalla;
                    
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                     String finBatalla = LocalDateTime.now().format(formato);
                     
                     Historial historial_nuevo = new Historial(contador, 
                             finBatalla, miPokemon.getNombre_pokemon(), oponPokemon.getNombre_pokemon(), "empate");
                     
                     BatallasHistorial.agregarBatallaHistorial(historial_nuevo);
                     
                     miPokemon.registrarBatalla(false); // no gano
                     return;
                                     
                }else if(oponPokemon.getHp() <=0){
                    String mensaje3 = oponPokemon.getNombre_pokemon() + " "+ "Fue derratado por " + " "+ miPokemon.getNombre_pokemon()+ "\n";
                    SwingUtilities.invokeLater(() -> {
                    textArea.append(mensaje3);
                    });
                    
                     int contador = BatallasHistorial.indice_batalla;
                     
                     DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                     String finBatalla = LocalDateTime.now().format(formato);
                     
                     // creamos nueva instancia para guardar en el historial 
                     
                     
                     Historial nuevo_historial = new Historial(
                             contador,
                     finBatalla,
                     miPokemon.getNombre_pokemon(),
                     oponPokemon.getNombre_pokemon(),
                     miPokemon.getNombre_pokemon()); // ganador 
                     
                     BatallasHistorial.agregarBatallaHistorial(nuevo_historial);
                    
                    
                    
                    
                    
                    
                    
                    miPokemon.registrarBatalla(false);


                    return;
                    
                }else if(miPokemon.getHp() <= 0){
                     String mensaje4 = miPokemon.getNombre_pokemon() + " "+ "Fue  derratado por " + " "+ oponPokemon.getNombre_pokemon()+ "\n";
                     SwingUtilities.invokeLater(() -> {
                    textArea.append(mensaje4);
                    });
                   
                     miPokemon.registrarBatalla(true); // perdio el pokemon mio 

                  
                    return;
                    
                }

             




          



            }














            }






    }
