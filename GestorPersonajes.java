package IPC1_Actividades_202407095;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorPersonajes {

    // AQUI LAS LIBRERIAS A USAR PARA EL MANEJO DE TALES //

    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    static LocalDateTime tiempo = LocalDateTime.now();


    //AQUI VAMOS A TRABAJAR CON METODOS Y ACCIONES //

    static String[][] historial_peleas = new String[100][4];
    static String[] idpersonajes = new String[100];
    static String[] personajesNombre = new String[100];
    static String[] armas = new String[100];
    static int[] niveles = new int[100];
    static String[][] habilidades = new String[100][5];
    static int contadorId =0; // crear Identificador
    static int posicionesPersonajes=0; //Nos servira para ubicar a los personajes
    static int contadorHistorial=0;
    static int puntosdevida=0;

    /*VAMOS A CREAR NUESTRO METODOS PARA LA REALIZACION DE LA PRACTICA*/

    public static void AgregarPesonajes(String nombre_personaje, String arma){
        boolean personaje_encontrado = false; // Condicion para conocer si encontramos un personaje
        for(int i=0; i<personajesNombre.length;i++){
            if(nombre_personaje.equalsIgnoreCase(personajesNombre[i]) && personajesNombre[i] != null){
                System.out.println("Personaje Encontrado " + ":" + " " + nombre_personaje);
                personaje_encontrado = true; //encontramos al personaje
                break;
            }
        }
        //Verificamos si el personaje no ha sido encontrado  osea estamos diciendo al condicional que siempre debe ser falso
        if(!personaje_encontrado){
            idpersonajes[posicionesPersonajes] = "ID" + (contadorId+1);
            personajesNombre[posicionesPersonajes] = nombre_personaje;
            armas[posicionesPersonajes] = arma;
            niveles[posicionesPersonajes] = rand.nextInt(100);

            for(int j=0; j< habilidades[posicionesPersonajes].length;j++){
                System.out.println("Ingrese habilidad " + (j+1) + ":");
                String nueva_habilidad = sc.nextLine();
                habilidades[posicionesPersonajes][j] = nueva_habilidad;
            }

            posicionesPersonajes++; //incremento en las posiciones del vector Personajes

        }else{
            System.out.println("LO SENTIMOS PERSONAJE YA REGISTRADO !!");
        }

        contadorId++;
    }

    /*-------------------------------------------------------------------------------------------------------*/
    //VAMOS A AGREGAR EL SEGUNDO METODO PARA S
    //MODIFICAR PERSONAJES

    public static void ModificarPersonajes(String nam){
        verDatosDeUnPersonaje(nam); //ver los datos del personaje que queremos modificar
        boolean encontrar_modificar = false;
        int posicion_encontrar =0;
        //buscar solo la posicion del personaje
        for(int i=0; i<personajesNombre.length; i++){
            if(nam.equalsIgnoreCase(personajesNombre[i])){
                encontrar_modificar = true;
                posicion_encontrar = i;
                break;
            }
        }

        if(encontrar_modificar){ //la condicion es que si se encuentre el personaje para poder modificarlo
            System.out.println("+-- Que Desea Modificar ---+");
            System.out.println("1. Arma");
            System.out.println("2. Habilidades ");
            System.out.println("3. Nivel de Poder ");

            int cambiar = sc.nextInt();
            sc.nextLine();

            switch (cambiar){
                case 1:
                    sc.nextLine();
                    System.out.println("Ingrese Nueva Arma ");
                    String arma_nueva = sc.nextLine().trim();
                    armas[posicion_encontrar] = arma_nueva;
                    System.out.println("ARMA MODIFICADA CORRECTAMENTE");
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Ingrese la posicion de la Habilidad a Modificar");
                    int posicion_habilidad = sc.nextInt()-1; //convertir a indice 0 para funcionar con el vector
                    sc.nextLine();
                    System.out.println("Ingrese la habilidad Nueva ");
                    String cambiar_habilidad = sc.nextLine().trim();

                    if(posicion_habilidad >= 0 && posicion_habilidad < habilidades[posicion_encontrar].length){
                        //Esto nos ayuda a que el usuario tenga que colocar una posicion valida antes de intentar cambiar una habilidad
                        habilidades[posicion_encontrar][posicion_habilidad] = cambiar_habilidad;
                        System.out.println("Habilidad Modificada Existosamente!!");
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Ingrese Nuevo Nivel de Poder");
                    int nuevo_nivel = sc.nextInt();
                    niveles[posicion_encontrar] = nuevo_nivel;
                    break;
                default:
                    System.out.println("OPCION INVALIDA !!");
                    break;
            }

        }
    }

    /*------------------------------------------------------------------------------------------------------*/
    public static void eliminarPersonajes(String borrar_personaje){
        int posicion_encontrar =0;
        boolean encontrado = false;
        for(int k=0; k<personajesNombre.length; k++){
            if(borrar_personaje.equalsIgnoreCase(personajesNombre[k])){
                encontrado = true;
                posicion_encontrar = k;
                break;
            }
        }

        if(encontrado){
            idpersonajes[posicion_encontrar] = null;
            personajesNombre[posicion_encontrar] = null;
            armas[posicion_encontrar] = null;
            niveles[posicion_encontrar] =0;

            //Borrar Habilidades
            for(int i=0; i<habilidades[posicion_encontrar].length; i++){
                habilidades[posicion_encontrar][i] = null;
            }

            System.out.println("Personaje Eliminado Exitosamente!!");
        } else{
            System.out.println("PERSONAJE NO ENCONTRADO !!");
        }

        /*ahora que eliminamos el personaje en el caso de los ID tenemos un problemas
         * Dejamos un Hueco en esta posicion y a la hora de agregar otro personaje nos va a fallar
         * el ID*/

        for(int i = posicion_encontrar; i < posicionesPersonajes-1; i++ ){
            /*Lo que hacemos es iniciar en la posicion que se borro y ahora vamos a trasladar
             * lo que esta adelante o como ajustar la matriz para que se mueva de posicion los datos
             * aun almacenados.*/
            idpersonajes[i] = idpersonajes[i+1];
            personajesNombre[i] = personajesNombre[i+1];
            armas[i] = armas[i+1];
            niveles[i] = niveles[i+1];

            //mover tambien las habilidades

            for(int j=0; j<habilidades[i].length;j++){
                habilidades[i][j] = habilidades[i+1][j];
            }

        }
        int ultima_posicion = posicionesPersonajes-1;
        personajesNombre[ultima_posicion] = null;
        armas[ultima_posicion] = null;
        niveles[ultima_posicion]=0;

        contadorId--;
        posicionesPersonajes--;




    }
    /*------------------------------------------------------------------------------------------------------*/

    //METODO PARA VER DATOS DE UN PERSONAJE

    public static void verDatosDeUnPersonaje(String name){
        boolean encontrado= false;
        int posicion_encontrada =0;
        for(int i=0; i<personajesNombre.length;i++){
            if(name.equalsIgnoreCase(personajesNombre[i])){
                System.out.println("+--- INFORMACION DEL PERSONAJE ---+");
                System.out.println("ID Personaje: " + " " + idpersonajes[i]);
                System.out.println("Nombre del Personaje: " + " " + personajesNombre[i]);
                System.out.println("Arma del Personaje: " + " " + armas[i]);
                System.out.println("Nivel del Personaje: " + " " + niveles[i]);
                posicion_encontrada = i;
                encontrado = true;
                break;
            }
        }

        //ahora vamos con las habilidades
        if(encontrado){
            for(int j=0; j<habilidades[posicion_encontrada].length; j++){
                System.out.println("Habilidad: " + " " + (j+1) + " "+ habilidades[posicion_encontrada][j]);
                //aqui le indicamos a for que solo quiero que recorra esa fila y que vaya mostrandome las columnas
            }


        } else{
            System.out.println("Aun No ha ingresado un Personaje con ese Nombre!!");
        }

    }

    /*-----------------------------------------------------------------------------------------------------------------------------*/

    //VER LISTADO DE PERSONAJES

    public static void verListadoPersonajes(){
        for(int i=0; i<personajesNombre.length;i++){
            if(personajesNombre[i] != null){
                System.out.println("ID PERSONAJE: "+ " "+idpersonajes[i]);
                System.out.println("NOMBRE PERSONAJE: "+" "+personajesNombre[i]);
                System.out.println("ARMA PERSONAJE"+" "+armas[i]);
                System.out.println("NIVEL PERSONAJE"+" "+niveles[i]);

                // IMPRIMIR LAS HABILIDADES DE CADA JUGADOR USANDO LA POSICION QUE QUEREMOS
                for(int j=0; j<habilidades[i].length; j++){
                    System.out.println("HABILIDA PERSONAJE"+ " "+ (j+1) + " "+habilidades[i][j]); //muestre cada habilidad
                }
                System.out.println("-------------------------------------------------");
            }else{
                System.out.println("AUN NO HAY PERSONAJES AGREGADOS!!");
                break;

            }

        }

    }

    /*------------------------------------------------------------------------------------------------------------------------------------*/

    //VAMOS A TRABAR EN LAS PELEAS ENTRE PERSONAJES

    public static void peleaPersoanejes(String personaje1, String personaje2){
        int pos1 =0;
        int pos2 =0;
        boolean existep1 = false;
        boolean existep2 = false;
        //primero mas que nada verificamos si ambos personajes existen en el sistema.
        for(int i=0; i<personajesNombre.length;i++){
            if(personaje1.equalsIgnoreCase(personajesNombre[i])){
                existep1 = true;
                pos1 =i;
            }
        }

        for(int j=0; j<personajesNombre.length;j++){
            if(personaje2.equalsIgnoreCase(personajesNombre[j])){
                existep2 = true;
                pos2 =j;
            }
        }

        if(existep1 && existep2){
            System.out.println("+-- BIENVENIDIOS A LA PELEA DEL AÑO --+");

            System.out.println("=======================================================");
            System.out.println("|                                                     |");
            System.out.println("|   * * * * * * * * * * * * * * * * * * * * * * * *  |");
            System.out.println("|   *                                             *  |");
            System.out.println("|   *       ¡ P R E P Á R A T E   P A R A !       *  |");
            System.out.println("|   *                                             *  |");
            System.out.println("|   *         ▄︻デ═══ LET'S GAME ════ー一        *  |");
            System.out.println("|   *                                             *  |");
            System.out.println("|   *   »»————>  Presiona START para comenzar <————««  *  |");
            System.out.println("|   *                                             *  |");
            System.out.println("|   * * * * * * * * * * * * * * * * * * * * * * * *  |");
            System.out.println("|                                                     |");
            System.out.println("=======================================================");
            System.out.println("   ↓ ↓  Modo épico activado ↓ ↓  ");
            System.out.println("["+personaje1+"]" + " " + niveles[pos1]  + " " + "Vs" + " " + "[" +personaje2+"]" + " "+ niveles[pos2]);
            System.out.println("----------------------------------------------------------------");

            String enfrentamiento = personaje1 + " " + "VS" + " " + personaje2;
            String ganador = " ";
            String perdedor = " ";

            if(niveles[pos1] > niveles[pos2]){
                System.out.println("¡GANA " + personaje1 + " CON " + niveles[pos1] + " DE PODER!");
                System.out.println("FINAL DE LA BATALLA" + tiempo);
                ganador = personaje1;
                perdedor = personaje2;

            } else if(niveles[pos2] > niveles[pos1]){
                System.out.println("¡GANA " + personaje2 + " CON " + niveles[pos2] + " DE PODER!");
                System.out.println("FINAL DE LA BATALLA" + tiempo);
                ganador = personaje2;
                perdedor = personaje1;

            } else{
                System.out.println("¡EMPATE ENTRE " + personaje1 + " Y " + personaje2 + "!");
                System.out.println("FINAL DE LA BATALLA" + tiempo);
                ganador = "EMPATARON LOS PENDEJOS";
                perdedor = "NO HAY PERDEDOR";


            }

            //VAMOS AGREGAR AL HISTORIAL LAS PELEAS
            String hora_comostring = tiempo.toString(); // convertirmos el valor del tiempo en un string

            historial_peleas[contadorHistorial][0] = hora_comostring;
            historial_peleas[contadorHistorial][1] = enfrentamiento;
            historial_peleas[contadorHistorial][2] = ganador;
            historial_peleas[contadorHistorial][3] = perdedor;

            contadorHistorial++;
        } else{
            System.out.println("PUEDE QUE ALGUN PERSONAJE NO EXISTA O AMBOS NO EXISTAN!!");
        }
    }

    /*----------------------------------------------------------------------------------------------------------------------------------*/

    //VAMOS A CONSTRUIR EL METOD PARA VER HISTORIAL DE PELEAS

    public static void historialPeleas(){
        if( contadorHistorial ==0 ){
            System.out.println("AUN NO HAY PERSONAJES QUE HA TENIDO PELEAS");


        }else{
            for(int i=0; i<contadorHistorial;i++){ // Esta parte del contador nos ayuda a que no recorra los espacios vacio de nuestra matriz
                //como contador historial ya tiene un numero de cuantas posiciones tiene almacenadas es decir si tiene dos peleas
                //ese contador tiene solo 2 indices entonces el for solo va a recorrer dos veces y ya no va reccores los demas espacios.
                System.out.println("+--- PELEA #" + (i + 1) + " ---+");
                System.out.println("Hora del Enfrentamiento: " + historial_peleas[i][0]);
                System.out.println("Enfrentamiento Entre: " + historial_peleas[i][1]);
                System.out.println("Ganador de La pelea: " + historial_peleas[i][2]);
                System.out.println("Perdedor de la Pelea: " + historial_peleas[i][3]);
                /*Lo que dice i es que va reccorer solo esa fila y los numeros son las columnas fijas que queremos que reccorra i*/
                System.out.println("------------------------------------------------------------------------------------------");
            }

        }



    }

    /*----------------------------------------------------------------------------------------------------------------------------*/

    public static void creditos(){
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║             *** CRÉDITOS DEL PROGRAMA ***      ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║                                                ║");
        System.out.println("║                                                ║");
        System.out.println("║           Nombre: José De la Rosa              ║");
        System.out.println("║           Carné: 202407095                     ║");
        System.out.println("║           Curso: IPC1 A - Laboratorio          ║");
        System.out.println("║           Universidad: USAC                    ║");
        System.out.println("║                                                ║");
        System.out.println("║                                                ║");
        System.out.println("║  ¡Gracias por usar este programa!              ║");
        System.out.println("║                                                ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("\n");
    }

}
