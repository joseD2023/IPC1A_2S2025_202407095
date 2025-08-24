package IPC1_Actividades_202407095.Proyecto1;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Gestionproductos {
    //VARIABLES A UTILIZAR CON LIBRERIAS
    static Scanner sc = new Scanner(System.in);
    static LocalDateTime tiempo = LocalDateTime.now();

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
               System.out.println("--------------------------------");
               System.out.println("Codigo Producto: " + inventario[i][0]);
               System.out.println("Nombre Producto: " + inventario[i][1]);
               System.out.println("Catalogo Producto: " + inventario[i][2]);
               System.out.println("Precio Producto: " + inventario[i][3]);
               System.out.println("Stock Producto: " + inventario[i][4]);
               System.out.println("--------------------------------");
               msj3 = true;
           }
           System.out.println("--------------------------------------------------------------------------");

       }
       if(!msj3){
           System.out.println("El Codigo del Producto No esta en el Inventario!!");
       }

    }

    public static void buscarProductonombre(String n){
        boolean msj = false;
        for(int i=0; i<inventario[posicion_productos].length;i++){
            if(n.equalsIgnoreCase(inventario[i][1])){
                System.out.println("--------------------------------");
                System.out.println("Codigo Producto: " + inventario[i][0]);
                System.out.println("Nombre Producto: " + inventario[i][1]);
                System.out.println("Catalogo Producto: " + inventario[i][2]);
                System.out.println("Precio Producto: " + inventario[i][3]);
                System.out.println("Stock Producto: " + inventario[i][4]);
                System.out.println("--------------------------------");
                msj = true; // esto quiere decir que si encontro el producto

            }
            System.out.println("--------------------------------------------------------------------------");
        }
        if(!msj){
            System.out.println("El nombre del producto no esta en el inventario!!");
        }

    }

    public static void buscarProductosCatalogo(String c){
        boolean msj2 = false;
        for(int i=0; i<inventario[posicion_productos].length;i++){
            if(c.equalsIgnoreCase(inventario[i][2])){ // verifica cada fila pero en especial la posicion 2 de las columnas
                //si lo encuentra i seria la posicion de la fila y fijamos las columnas para imprimir
                System.out.println("--------------------------------");
                System.out.println("Codigo Producto: " + inventario[i][0]);
                System.out.println("Nombre Producto: " + inventario[i][1]);
                System.out.println("Catalogo Producto: " + inventario[i][2]);
                System.out.println("Precio Producto: " + inventario[i][3]);
                System.out.println("Stock Producto: " + inventario[i][4]);
                System.out.println("--------------------------------");
                msj2 = true;
            }
            System.out.println("--------------------------------------------------------------------------");
        }

        if(!msj2){
            System.out.println("El codigo del producto no esta en el inventario!!");
        }
    }

    /*-------------------------------------------------------------------------------------------*/

    public static void eliminarProducto(String codigoeliminar){
        int posicion_elimancion=0;
        for(int i=0; i<inventario[posicion_productos].length;i++){
            if(codigoeliminar.equalsIgnoreCase(inventario[i][0])){
                System.out.println("Confirme la Eliminacion de Este Producto (si/no) ? ");
                String confirmacion = sc.nextLine().trim();
                if(confirmacion.equalsIgnoreCase("si")){
                    //ya encontramos el codigo entonces vamos a eliminar la informacioon en esta parte
                    //como ya tenemos la fila que queremos eliminar solo eliminacimos esa fila
                    inventario[i][0] = null;
                    inventario[i][1] = null;
                    inventario[i][2] = null;
                    inventario[i][3] = null;
                    inventario[i][4] = null;
                    posicion_elimancion = i; //encontramos la posicion de donde se eliminó
                    /*aquí eliminamos todos los datos*/

                    //ahora como elimamos un espacio y corremos los datos
                    for(int j=posicion_elimancion; j<posicion_productos-1;j++) { //empezamos desde la fila que se elimino
                        for (int k = 0; k < inventario[j].length; k++) {
                            inventario[j][k] = inventario[j + 1][k]; //aquí estamos diciendo que loq ue tiene la otra fila lo quiero yo en esta fila que se elimino
                            //pero sin cambiar los datos de las columnas.
                        }
                    }

                    // aun necesitamos eliminar el ultimo elemento para que no haya repeticiones
                    inventario[posicion_productos-1][0] = null;
                    inventario[posicion_productos-1][1] = null;
                    inventario[posicion_productos-1][2] = null;
                    inventario[posicion_productos-1][3] = null;
                    inventario[posicion_productos-1][4] = null;

                    //borramos lo ultimo para que no exista repeticiones de lo que ya corrimos y asi tenemos un nuevo espacio para seguir trabajando


                    System.out.println("Producto Eliminado Exitosamente!!");
                    posicion_productos--; // aquí eliminamos un espacio para los productos.
                }else{
                    System.out.println("Usted Cancelo La Eliminacion del Producto!!");
                    break;
                }

            }
        }

    }

    /*-------------------------------------------------------------------------------------------*/

    public static void registrarVenta(String codigoventa){
        if(codigosexistentes(codigoventa)){ //con esta funcion puedo ver si existe el codigo
            int pos = codigoposicion(codigoventa); //obtenemos la posicion de nuestro fila
            int stock = Integer.parseInt(inventario[pos][4]);
            System.out.println("Cantidad que quiere vender");
            int cantidad_vender = sc.nextInt();
            if(cantidad_vender <= stock){
                System.out.println("si se puede vender");
            }else{
                System.out.println("Cantidad de Vender es mas de lo que se tiene :3");
            }



        }else{
            System.out.println("No se Encontro El codigo en el Inventario!!");
        }

    }

    /*-------------------------------------------------------------------------------------------*/

    public static void bitacora(){

    }

    /*-------------------------------------------------------------------------------------------*/

    public static void generacionReportes(){

    }

    /*-------------------------------------------------------------------------------------------*/

    public static void verDatosEstudiante(){
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

    //BUSCAR CODIGO Y POSCION (lo que queremos aqui que nos retorne la posicion)

    public static int codigoposicion(String codiven){
        for(int i=0; i<inventario[posicion_productos].length; i++){
            if(codiven.equalsIgnoreCase(inventario[i][0])){
                return  i;
            }

        }
        return -1;
    }






}
