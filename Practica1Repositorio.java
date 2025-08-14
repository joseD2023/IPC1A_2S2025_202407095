package IPC1_Actividades_202407095;
import java.util.Scanner;

public class Practica1Repositorio {
    //DEFINIMOS LA ENTRADA A CONSOLA COMO VARIABLE GLOBAL
    static Scanner sc = new Scanner(System.in);

    /*-------------------------------------------------------------------------*/

    public static void main(String[] args){
        MenuGestionesPersonajes();

    }

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
            sc.nextLine(); // Borrar La entrada

            if(opc != 9){
                switch (opc){
                    case 1:
                        System.out.println("[INGRESE UN NOMBRE: ]");
                        String name = sc.nextLine();
                        sc.nextLine();
                        System.out.println("[INGRESE UN ARMA: ]");
                        String arm = sc.nextLine();
                        GestorPersonajes1.AgregarPesonajes(name, arm);
                        break;
                    case 2:
                        System.out.println("[INGRESE UN NOMBRE: ]");
                        String name3 = sc.nextLine();
                        GestorPersonajes1.ModificarPersonajes(name3);

                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("[INGRESE UN NOMBRE]");
                        String name4 = sc.nextLine();
                        GestorPersonajes1.eliminarPersonajes(name4);

                        break;
                    case 4:
                        System.out.println("[INGRESE UN NOMBRE]");
                        String name2 = sc.nextLine();
                        GestorPersonajes1.verDatosDeUnPersonaje(name2);
                        break;
                    case 5:
                        GestorPersonajes1.verListadoPersonajes();
                        break;

                    case 6:
                        sc.nextLine();
                        System.out.println("[INGRESE UN NOMBRE PARA P1]");
                        String p1 = sc.nextLine();
                        System.out.println("[INGRESE UN NOMBRE PARA P1]");
                        String p2 = sc.nextLine();
                        GestorPersonajes1.peleaPersoanejes(p1,p2);
                        break;
                    case 7:
                        GestorPersonajes1.historialPeleas();
                        break;
                    case 8:
                        GestorPersonajes1.creditos();
                        break;
                    default:
                        System.out.println("OPCION INVALIDA !!");
                        break;

                }

            }else{
                System.out.println("Gracias por Usar Nuestro Programa de IPC1");
                break;

            }






        }
    }
}
