package IPC1_Actividades_202407095.Proyecto1;
import java.util.Scanner;
public class Proyecto1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        MenuGestionProductos();

    }

    public static void MenuGestionProductos(){
        while(true){
            System.out.println("+--- BIENVENIDOS SISTEMA DE INVENTARIO DE ROPA ---+");
            System.out.println("1. Agregar Productos ");
            System.out.println("2. Buscar Productos  ");
            System.out.println("3. Eliminar Productos ");
            System.out.println("4. Registrar Ventas ");
            System.out.println("5. Bitacora ");
            System.out.println("6. Generacion de Reportes ");
            System.out.println("7. Ver Datos Estudiante   ");
            System.out.println("8. Salir Programa. ");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("Ingrese Una Opcion: ");

            int opc = sc.nextInt();

            if(opc != 9){
                switch (opc){
                    case 1:
                        sc.nextLine(); // limpiamos la entrada de nextline


                        //CODIDGO DEL PRODUCTO
                        String cod;

                        do{
                            System.out.println("Ingrese codigo producto: ");
                            cod = sc.nextLine().trim();
                            if(Gestionproductos.codigosexistentes(cod)){
                                System.out.println("Este Codigo Ya Existe!! ");
                            }
                        }while(Gestionproductos.codigosexistentes(cod));

                        System.out.println("Ingrese el Nombre del Producto: ");
                        String nameproducto = sc.nextLine().trim();
                        validacionEntrada(nameproducto); //validamos la entrada que sea String


                        System.out.println("Ingrese la categoria del Producto: ");
                        String categoria = sc.nextLine().trim();
                        validacionEntrada(categoria); //volvemos a validar la entrada de consola

                        //vamos agregar
                        String precio_producto;
                        do{
                            System.out.println("Ingrese el precio del Producto: ");
                            precio_producto = sc.nextLine().trim();

                            if(!precio_producto.matches("^[0-9]+(\\.[0-9]+)?$") || Integer.parseInt(precio_producto) <= 0){ // si es diferente a un numero va a tirar el mensaje de erro que debe ingresar un texto
                                System.out.println("El precio en Numeral (No Texto) o Ingrese Un numero Positivo");
                                /*Como esta definido de 0 a 9 eso significa que solo numeros positivos acepta*/
                            }
                        }while(!precio_producto.matches("^[0-9]+(\\.[0-9]+)?$") || Integer.parseInt(precio_producto) <= 0 ); // si esto es diferente a un numero osea si el usuario coloca un texto va a repetirse varias veces.

                        //ahora hacemos la conversion

                        double precio = Double.parseDouble(precio_producto); //hacemos la conversion para que nos funcione los calculos

                        //ahora cantidad de stock
                        String cantidad_stock;
                        do{
                            System.out.println("Ingrese la Cantidad de Stock (Debe ser positivo y Enteros): ");
                            cantidad_stock = sc.nextLine().trim();
                            if(!cantidad_stock.matches("^?[0-9]+$") || Integer.parseInt(cantidad_stock) <= 0){ // si es diferente a un numero entero y si es texto va a tirar un erro
                                System.out.println("Ingrese Un numero Positivo o Entero o Mayor a 0!!");

                            }
                        }while(!cantidad_stock.matches("^?[0-9]+$") || Integer.parseInt(cantidad_stock) <= 0); // se va a repetir si es texto ya que es diferente a un numero entero positivo

                        //ahora hacemos la conversion
                        int can = Integer.parseInt(cantidad_stock);
                        Gestionproductos.agregarProductos(nameproducto,categoria,precio,can,cod);
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("+--- BUSCAR PRODUCTO --+");
                        System.out.println("FORMA DE BUSCAR EL PRODUCTO (nombre/categoria/codigo");
                        String buscar_producto = sc.nextLine().trim();
                        switch (buscar_producto){
                            case "nombre":
                                //BUSCAMOS POR NOMBRE
                                sc.nextLine();
                                System.out.println("+--- Ingrese el Nombre del Producto ---+");
                                String name = sc.nextLine();
                                Gestionproductos.buscarProductonombre(name);
                                break;
                            case "categoria":
                                //BUSCAMOS POR CATEGORIA
                                sc.nextLine();
                                System.out.println("+--- Ingrese el Nombre de la categoria ---+");
                                String cate = sc.nextLine().trim();
                                Gestionproductos.buscarProductosCatalogo(cate);
                                break;
                            case "codigo":
                                //BUSCAMOS POR CODIGO
                                sc.nextLine();
                                System.out.println("+--- Ingrese el codigo del producto  ---+");
                                String codi = sc.nextLine().trim();
                                Gestionproductos.buscarProductoCodigo(codi);
                                break;
                            default:
                                System.out.println("Formato de Busqueda Invalido!! ");
                                break;
                        }
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("+--- Ingrese el codigo Para eliminar Producto:   ---+");
                        String codigoEli = sc.nextLine().trim();
                        Gestionproductos.eliminarProducto(codigoEli);
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.println("Ingrese El codigo para La venta:");
                        String codigoventa = sc.nextLine().trim();
                        if(Gestionproductos.codigosexistentes(codigoventa)){
                            Gestionproductos.registrarVenta(codigoventa);
                        }else{
                            System.out.println("El codigo No Existe en El Inventario!!");
                        }

                        break;
                    case 5:
                        System.out.println("+--- VISUALIZACION DE LA BITACORA ---+");
                        Gestionproductos.verBitacora();
                        break;
                    case 6:
                        break;
                    case 7:
                        Gestionproductos.verDatosEstudiante();
                        break;
                    case 8:
                        System.out.println("Inventario Creado");
                        Gestionproductos.pdf();
                        break;
                    case 10:
                        Gestionproductos.pdfVentas();
                        Gestionproductos.registrarTodasVentasTxt();

                        System.out.println("Registro venta Creado");

                    default:
                        break;
                }

            }else{
                System.out.println("Saliendo del Programa....");
                break;
            }


        }
    }

    //VAMOS A VALIDAR LA ENTRADA DE DATO COMO TEXTO

    public static void validacionEntrada(String e){

        while(e.matches(".*\\d.*")){
            System.out.println("Ingrese texto (sin Numeral): ");
            e = sc.nextLine(); // aqui decimos que debe de repetirse hasta que no sea con numeral
        }
    }

    /*-------------------------------------------------------------------------------------------------*/

    //GENERACION DE CODIGO PRODUCTO

}
