
package practica1_ipc1;
import java.util.Scanner;
import java.util.Random;

public class Practica1_IPC1 {
    //CREAMOS UN VECTOR PARA GUARDAR LOS PERSONAJES DE MANERA GLOBAL
    
    static String[] personajesNombre = new String[20];
    static String[] armas = new String[20];
    static int[] niveles = new int[20];
    static String[][] habilidades = new String[20][5]; //aqui definimos una matriz para guardar las habilidades pero solo filas
    //En las habilidades decimos que tenemos o podemos tener 20 personajes y 5 habilades cada una 
    
    //ENTRADA DE CONSOLA DE MANERA GLOBAL
    static Scanner sc = new Scanner(System.in);
    
    //VARIABLE QUE ME VA DEFINIR LAS POSICIONES
     static int posiciones_personaje =0;
     
     //VAMOS A USAR RANDOM PARA EL NIVEL DE LAS HABILIDADES
     
     static Random ran = new Random();
     

    public static void main(String[] args) {
        //CLASE PRINCIPAL 
        
        MenuGestionesPersonajes();
     
    } //FInalizacion de Nuestra Clase Main
    
    public static void MenuGestionesPersonajes(){
        while(true){
            System.out.println("+--- MENU DE GESTION DE PERSONAJES ---+");
            System.out.println("1. Agregar Personajes ");
            System.out.println("2. Modificar Personaje");
            System.out.println("3. Eliminar Personaje ");
            System.out.println("4. Ver Datos de un Personaje ");
            System.out.println("5. Ver listado de Personajes ");
            System.out.println("6. Realizar pelea entre personajes");
            System.out.println("7. Ver Historial de peleas ");
            System.out.println("8. Ver datos de Estudiante ");
            System.out.println("9. Salir ");
            System.out.println(" Elegir una Opcion: ");
            
            int opc = sc.nextInt();
            sc.nextLine();
            
            switch(opc){
                case 1: 
                    System.out.println("+-- PANEL DE INGRESO PERSONAJE --+");
                    System.out.println("Ingrese Un Nombre para su personaje: ");
                    String name = sc.nextLine();
                    System.out.println("Ingrese Un arma para su Personaje: ");
                    String armer = sc.nextLine(); 
                    AgregarPersonajes(personajesNombre, name, armer); //aqui le damos parametros a mi funcion
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    break;  
            }
            
        }
        
    } //Finalizacion de Nuestra inicializacion
    
    //CREAMOS LOS METODOS PARA EL PROYECTO
    
    //METODO AGREGAR PERSONAJES
    public static void AgregarPersonajes(String[] personaje_nuevo, String nombre, String arma){
        boolean encontrado_personaje = false; //variable auxiliar para si el dado caso encuentra yo pueda utilizar esta parte del codigo.
        //Creamos niveles aleatorio 
        
        int nivel = ran.nextInt(100);
        
        
        
        for(int i=0; i < personaje_nuevo.length;i++){ //aqui vamos a recorrer el vector y verificar si no estan repetido el nombre
            if(nombre.equalsIgnoreCase(personaje_nuevo[i])){ //aqui vamos probando si existe algun personaje con el mismo nombre
                System.out.println("No se puede Agregar ya Existe ese Nombre de Usuario"); 
                encontrado_personaje = true;
                break;
            }  
        }
        
        
        
        
        //Si lo encontro o no podemos usar esta parte del codigo para asignar al nuevo personaje
        
        if(!encontrado_personaje){ //si no encontraron a personaje osea es diferente a verdadero entonces podemos agregar al personaje
            personajesNombre[posiciones_personaje] = nombre;
            armas[posiciones_personaje] = arma;
            niveles[posiciones_personaje]= nivel;
            //Vamos a usar un metodo para agregar habilidades
            AgregarHabilidades(habilidades);
            
            
            posiciones_personaje ++; //si se cumple la condicon la posicon se incrementa para el otro es decir 
            //si la posicon 0 lo ocupa kratos a la otra ya esta sumada o incrementada 
            
            System.out.println("CONTINUEEEE......");
            
        } else{
            System.out.println("Lo sentimos pero personaje ya usado!!");
        }
        
        
    }
    
    //METODO PARA AGREGAR HABILIDADES
    
    public static void AgregarHabilidades(String[][] habilidades){
        for(int i=0; i<=posiciones_personaje;i++){//RECORDATORIO IGUALARLO A LA POSICON O SI NO EL CICLO NO CUMPLE LA CONDICION
            for(int j=0;j< habilidades[i].length; j++){ // como la matriz no es cuadrada y solo quiero una parte entonces solo usamos una fila en este caso dado por posicionespersoanjes
                System.out.println("Ingrese habilidades MAX 5"); //aunque la matriz ya tiene solo para 5
                String nueva_habilidad = sc.nextLine();
                habilidades[posiciones_personaje][j] = nueva_habilidad; //aqui agregamos la nueva habilidad
            }
        } 
    }
    
    //METODO MODIFICAR PERSONAJES
    public static void ModificarPersonajes(){
        
    }
    
    //METODO VER DATOS DE UN PERSONAJE
    public static void VerDatosDeUnPersonaje(){
        
    }
    
    //METODO VER LISTADO DE PERSONAJES
    public static void VerListadoDePersonajes(){
        
    }
    
    //METODO REALIZAR PELEA ENTRE PERSONAJES
    public static void RealizarPeleaEntrePersonajes(){
        
    }
    
    //METODO VER HISTORIAL DE PELEAS
    public static void VerHistorialDePeleas(){
        
    }
    
    //METODO VER DATOS DE ESTUDIANTE
    public static void VerDatosDeEstudiante(){
        
    }
}
