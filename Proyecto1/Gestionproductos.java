package IPC1_Actividades_202407095.Proyecto1;
import java.util.Scanner;
import java.util.Random;

public class Gestionproductos {
    //VARIABLES A UTILIZAR CON LIBRERIAS
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    //VAMOS A CREAR LAS MATRICES O VECTORES PARA GUARDAR LA INFORMACION
    static String[][] inventario = new String[100][5];
    static int contadorid = 1;
    static int posicion_productos =0;



    public static void agregarProductos(String nameproducto, String categoria, double precio, int stock, String cod){
            inventario[posicion_productos][0] = cod;
            inventario[posicion_productos][1] = nameproducto;
            inventario[posicion_productos][2] = categoria;
            inventario[posicion_productos][3] = Double.toString(precio); // converti a texto el double
            inventario[posicion_productos][4] = Integer.toString(stock); // converti a texto el int
            System.out.println("Producto agregado Exitosamente!! ");
            posicion_productos++; // para que mueva de indice
        System.out.println("AGREGADO EXITOSAMENTE");
    }

    /*-------------------------------------------------------------------------------------------*/

    public static void buscarProductoCodigo(String b){
        boolean msj3 = false;
       for(int i=0; i<inventario[posicion_productos].length;i++){
           if(b.equalsIgnoreCase(inventario[i][0])){ // como solo quiero que verifique los codigos no toda la fila entonces fijamos la columna
               //supongamos que encuentra en que fila se encuentra el codigo necesitamos mostrar toda la fila entonces tomamos la posicon d ela fila y luego la recorremos.
               for (int j=0; j < inventario[i].length;j++){
                   System.out.println(inventario[i][j]);
                   msj3 = true;
               }
           }
       }
       if(!msj3){
           System.out.println("El Codigo del Producto No esta en el Inventario!!");
       }

    }

    public static void buscarProductonombre(String n){
        boolean msj = false;
        for(int i=0; i<inventario[posicion_productos].length;i++){
            if(n.equalsIgnoreCase(inventario[i][1])){
                for(int j=0; j<inventario[i].length; j++){
                    System.out.println(inventario[i][j]);
                    msj = true; // esto quiere decir que si encontro el producto
                }
            }
        }
        if(!msj){
            System.out.println("El nombre del producto no esta en el inventario!!");
        }

    }

    public static void buscarProductosCatalogo(String c){
        boolean msj2 = false;
        for(int i=0; i<inventario[posicion_productos].length;i++){
            if(c.equalsIgnoreCase(inventario[i][2])){
                for(int j=0; j<inventario[i].length; j++){
                    System.out.println(inventario[i][j]);
                    msj2 = true;
                }
            }
        }

        if(!msj2){
            System.out.println("El codigo del producto no esta en el inventario!!");
        }
    }

    /*-------------------------------------------------------------------------------------------*/

    public static void eliminarProducto(){

    }

    /*-------------------------------------------------------------------------------------------*/

    public static void registrarVenta(){

    }

    /*-------------------------------------------------------------------------------------------*/

    public static void bitacora(){

    }

    /*-------------------------------------------------------------------------------------------*/

    public static void generacionReportes(){

    }

    /*-------------------------------------------------------------------------------------------*/

    public static void verDatosEstudiante(){

    }
    /*-------------------------------------------------------------------------------------------*/
    public static void visualizarlist(){

    }

    /*-------------------------------------------------------------------------------------------*/
    /*METODO ALTERNOS POR SI NECESARIO CREAR UN METODO ADICIONAL AQUI LO VAMOS A COLOCAR*/

    //VERIFICACION DE DATOS REPETIDOS

    public static boolean productosexistentes(String producto){
        for(int i=0; i<inventario[posicion_productos].length;i++){
            if(producto.equalsIgnoreCase(inventario[posicion_productos][i])){
                return true; // verificamos que si esta entonces retorna true eso significa que si esta ese codigo en nuestro inventario
            }
        }
       return false;
    }

    //VAMOS A VALIDAR EL CODIGO SI EXISTE DENTRO DEL SISTEMA
    public static boolean codigosexistentes(String codi){
        for(int i=0; i<inventario[posicion_productos].length;i++){ //como necesito que se mueva en filas entonces hago que recorra las filas
            if(codi.equalsIgnoreCase(inventario[i][0])){ //como solo necesito que compare los codigos y los codigos solo estan en la primera columna
                //entonces necesito fijar la columna y variar entre las filas y compararlos para ver si no hay un codigo igual.
                return true;
            }
        }
        return false;

    }






}
