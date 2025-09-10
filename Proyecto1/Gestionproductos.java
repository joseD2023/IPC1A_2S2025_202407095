package IPC1_Actividades_202407095.Proyecto1;
import java.io.Writer;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//para TEXT
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Gestionproductos {
    //VARIABLES A UTILIZAR CON LIBRERIAS
    static Scanner sc = new Scanner(System.in);
    static LocalDateTime tiempo = LocalDateTime.now();
    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // día/mes/año hora:minuto:segundo

    //VAMOS A CREAR LAS MATRICES O VECTORES PARA GUARDAR LA INFORMACION
    static String[][] inventario = new String[100][5];
    static String [][] registrar_venta = new String[100][4]; //aqui vamos a registrar las ventas
    static String [][] bitacora_accioens = new String [100][4];
    // con 4 columnas codigo producto, cantidad vendida, Fecha y Hora de Transccion y total de venta.
    static int posicion_registro =0;
    static int poscion_bitacora = 0;
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

        bitacora("Agregar Producto", true, "Jose");
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

       }
           System.out.println("--------------------------------------------------------------------------");
       bitacora("Buscar Producto por Codigo", true, "Jose");
       if(!msj3){
           System.out.println("El Codigo del Producto No esta en el Inventario!!");
           bitacora("Buscar Producto por Codigo", false, "Jose");
       }

    }

    public static void buscarProductonombre(String n){
        boolean msj = false;
        for(int i=0; i<inventario[posicion_productos].length;i++){
            if(n.equalsIgnoreCase(inventario[i][1])){ // me busca la fila que tiene datos y luego las manda a imprimir
                System.out.println("--------------------------------");
                System.out.println("Codigo Producto: " + inventario[i][0]);
                System.out.println("Nombre Producto: " + inventario[i][1]);
                System.out.println("Catalogo Producto: " + inventario[i][2]);
                System.out.println("Precio Producto: " + inventario[i][3]);
                System.out.println("Stock Producto: " + inventario[i][4]);
                System.out.println("--------------------------------");
                msj = true; // esto quiere decir que si encontro el producto

            }
        }
            System.out.println("--------------------------------------------------------------------------");
        bitacora("Buscar Producto por Nombre", true, "Jose");
        if(!msj){
            System.out.println("El nombre del producto no esta en el inventario!!");
            bitacora("Buscar Producto por Nombre", false, "Jose");
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
        }

            System.out.println("--------------------------------------------------------------------------");
        bitacora("Buscar Producto por Catalogo", true, "Jose");
        if(!msj2){
            System.out.println("El codigo del producto no esta en el inventario!!");
            bitacora("Buscar Producto por Catalogo", false, "Jose");
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
                    bitacora("Eliminar Producto", true, "Jose");
                    posicion_productos--; // aquí eliminamos un espacio para los productos.
                    return;

                }else{
                    System.out.println("Usted Cancelo La Eliminacion del Producto!!");
                    bitacora("Cancelacion Eliminar Producto", false, "Jose");

                    break;
                }

            }else{
                System.out.println("Producto Para Eliminar No Encontrado!!");
                bitacora("Eliminar Producto (No Encontro Producto)", false, "Jose");
                return;
            }
        }

    }

    /*-------------------------------------------------------------------------------------------*/

    public static void registrarVenta(String codigoventa){

        int pos = codigoposicion(codigoventa); //obtenemos la posicion de nuestro fila
        int stock = Integer.parseInt(inventario[pos][4]);//posicion del codigo lo convertimos a entero
        System.out.println("El Numero de Productos Disponibles es: " + " "+stock); //verificamos si me de el valor de esa posicion
        if(stock != -1){
            // necesitamos trabajar para restar las ventas (vamos a tener una repeticion por si escribio mal la cantidad o cosas asi
            int cantidad_vender;
            boolean condicion = false;

            do{
                System.out.println("Cantidad que quiere vender");
                cantidad_vender = sc.nextInt();

                if(cantidad_vender > 0 && cantidad_vender > stock){
                    System.out.println("Ingrese una cantidad válida (1 a " + stock + ")");
                }else{
                    condicion = true;
                }

            }while(!condicion);

            //aqui vamos a trabajar con la resta de ventas
            int venta_reducida = stock - cantidad_vender; // aqui eliminamos los productos vendidos
            inventario[pos][4] = Integer.toString(venta_reducida); // y aqui agregamos el producto reducido pero convertido a texto
            //como nuestra matriz es string no podemos ingresar enteros entonces lo convertimos a string con integer.tostring

            //Precio Unitario

            double precio_unitario = Double.parseDouble(inventario[pos][3]);
            double total_venta = cantidad_vender * precio_unitario;



            System.out.println("Venta Realizada Exitosamente!!");
            bitacora("Venta Realizada", true, "Jose");

            //vamos a convertir la fecha en string
            String textofecha = LocalDateTime.now().format(formato); // usamos el formato de arriba para el texto

            registrar_venta[posicion_registro][0] = codigoventa; //codigo del producto
            registrar_venta[posicion_registro][1] = Integer.toString(cantidad_vender); // cantidad vendida
            registrar_venta[posicion_registro][2] = textofecha; // fecha y hora de transccion
            registrar_venta[posicion_registro][3] = Double.toString(total_venta) + "Q"; // total de venta



            posicion_registro++;
        }else{
            bitacora("La Venta No se Realizo", false, "Jose");
            System.out.println("+------------------------------+");
        }
    }

    /*-------------------------------------------------------------------------------------------*/

    public static void bitacora(String accion, boolean correcta, String usuario){
        String textofecha = LocalDateTime.now().format(formato);
        bitacora_accioens[poscion_bitacora][0] = textofecha;
        bitacora_accioens[poscion_bitacora][1] = accion;
        bitacora_accioens[poscion_bitacora][2] = String.valueOf(correcta);
        bitacora_accioens[poscion_bitacora][3] = usuario;
        poscion_bitacora++;
    }

    /*-------------------------------------------------------------------------------------------*/

    public static void verBitacora(){
        for(int i=0; i<poscion_bitacora; i++){ // aqui es necesario solo recorrer las filas que ya estan agregadas no las que estan vacias
            // si colocamos bitacora_acciones[posicion_bitacora] lo que estas acceddiendo es a filas vacias.
            System.out.println("--------------------------------");
            System.out.println("Fecha y Hora De Accion: " + bitacora_accioens[i][0]);
            System.out.println("Tipo de Accion: " + bitacora_accioens[i][1]);
            System.out.println("Accion Correcta o Errónea: " + bitacora_accioens[i][2]);
            System.out.println("Persona que Efectuo la Accion: " + bitacora_accioens[i][3]);
            System.out.println("--------------------------------");
        }
    }

    /*-------------------------------------------------------------------------------------------*/

    public static void verDatosEstudiante(){
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                       *** CRÉDITOS DEL PROGRAMA ***                                ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                                    ║");
        System.out.println("║           Nombre: José De la Rosa                                                  ║");
        System.out.println("║           Carné: 202407095                                                         ║");
        System.out.println("║           Curso: IPC1 A - Laboratorio                                              ║");
        System.out.println("║           Universidad: USAC                                                        ║");
        System.out.println("║           Repositorio: https://github.com/joseD2023/IPC1_Actividades_202407095     ║");
        System.out.println("║                                                                                    ║");
        System.out.println("║                          ¡Gracias por usar este programa!                          ║");
        System.out.println("║                                                                                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("\n");
        bitacora("Ver Datos Estudiantes", true, "Jose");

    }

    /*-------------------------------------------------------------------------------------------*/

    //AGREGAR EL STOCK DEL PDF

    public static void pdf(){
        String[] encabezados = {"codigo", "nombre", "Catalogo", "Precio", "Stock"};
        String[][] inventario_productos = new String[posicion_productos][5];
        for(int i=0; i<posicion_productos; i++){ // recorremos la matriz hasta el limite de donde hay productos
            for(int j=0; j<inventario[i].length; j++){ // ahora recorremos lo que hay en columnas para obtener los datos
                inventario_productos[i][j] = inventario[i][j]; // le decimos que nos de la informacion a nuestra nueva matriz temporal para generar nuestro pdf
            }
        }
        GeneradorPDF.generarReporteStock(inventario_productos, encabezados);
        //evitar los null de la matriz solo hasta donde llega producto
    }

    //vamos a generar el pdf para el Registro de ventas

    public static void pdfVentas(){
        String horario = String.valueOf(tiempo);
        String[] encabezados1 = {"Codigo Producto","Cantidad Vendida", "Fecha", "Venta Total"};
        String[][] ventas_registrada = new String[posicion_registro][4];
        for(int i=0; i<posicion_registro; i++){
            for(int j=0; j<registrar_venta[i].length; j++){
                ventas_registrada[i][j] = registrar_venta[i][j];
            }
        }

        GeneradorPDF.generarReportesVentas(ventas_registrada, encabezados1);
    }

    // Registrar Ventas
    public static void registrarTodasVentasTxt() {
        String textofecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));

        String rutaArchivo = textofecha + "ventas.txt";


        try{

            FileWriter escribir = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\IPC12S\\src\\main\\java\\IPC1_Actividades_202407095\\Proyecto1\\"+ rutaArchivo, true);
            PrintWriter escribir_txt = new PrintWriter(escribir);

            String encabezados = "Codigo" + "|" + "Cantidad Vendida" + "|" + "Fecha" + "|"+ "Venta Total";
            escribir_txt.println(encabezados);

            for (int i = 0; i < posicion_registro; i++) {
                String linea = registrar_venta[i][0] + "|" + " " +
                        registrar_venta[i][1] + "|" + " " +
                        registrar_venta[i][3] + "|" + " " +// total
                        registrar_venta[i][2]; // fecha
                escribir_txt.println(linea);
            }

            escribir_txt.close();

            System.out.println("Todas las ventas registradas en TXT correctamente!");

        } catch (IOException e) {
            System.out.println("Error al guardar las ventas en el archivo: " + e.getMessage());
        }
    }



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
