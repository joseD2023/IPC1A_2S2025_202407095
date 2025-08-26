import java.util.Scanner;
import java.lang.Math;

public class Actividad4Tarea {
    static Scanner sc = new Scanner(System.in);
    static double a;
    static double b; // variables que nos van a servir para el resto del codigo""
    static double resultado=0;

    public static void main(String[] args){
       while(true){
           System.out.println("+-- Calculadora IPC1A --+");
           System.out.println("1. Suma");
           System.out.println("2. Resta");
           System.out.println("3. Multiplicacion");
           System.out.println("4. Division");
           System.out.println("5. Potencia");
           System.out.println("6. Raiz");
           System.out.println("7. Salir");

           String opc = sc.nextLine().trim();

           switch (opc){
               case "uno":
                   System.out.println("Suma de Valores");
                   pedirnumero();
                   sumar();
                   sc.nextLine();
                   break;
               case "dos":
                   System.out.println("Resta de Valores");
                   pedirnumero();
                   restar();
                   sc.nextLine();
                   break;
               case "tres":
                   System.out.println("Multiplicaciones de Valores");
                   pedirnumero();
                   multiplicacion();
                   sc.nextLine();
                   break;
               case "cuatro":
                   System.out.println("Divisiones de Valores");
                   pedirnumero();
                   division();
                   sc.nextLine();
                   break;
               case "cinco":
                   System.out.println("Potencia de Valores");
                   pedirnumero();
                   potencia();
                   sc.nextLine();
                   break;
               case "seis":
                   System.out.println("Calculo de Una raiz Cuadrada");
                   raiz();
                   break;
               default:
                   break;

           }
           if(opc.equalsIgnoreCase("siete")){
               System.out.println("Gracias por utilizar Nuestra Calculadora IPC1A");
               break;
           }
       }



    }
    //vamos a hacer una funcion que pida numeros

    static void pedirnumero(){
        System.out.println("Ingrese El primer valor");
        a = sc.nextDouble();
        System.out.println("Ingrese El segundo valor");
        b = sc.nextDouble();

    }

    //Funcion Suma

    static void sumar(){
        resultado = a + b;
        System.out.println("El resultado de la Suma es: " + " " + resultado);

    }

    //Funcion Resta

    static void restar() {
        resultado = a - b;
        System.out.println("El resultado de la resta es: " + " " + resultado);
    }

    //Funcion Multiplication

    static void multiplicacion(){
        resultado = a*b;
        System.out.println("El resultado de la Multiplicacion es: " + " " + resultado);
    }

    //Funcion division
    static void division(){
        sc.nextLine();
        System.out.println("Donde ira (a) o (b) en el Denominador: ");
        String denominador = sc.nextLine().trim();
        if(a==0 && b==0){
            resultado = 0;
            System.out.println("Resultado de la operacion: " + " " + resultado);

        }
        if((denominador.equalsIgnoreCase("a") && a !=0)){
            resultado = b /a;
            System.out.println("Resultado de la Division: " + " " + resultado);
        } else if(a==0 && b!=0){
            System.out.println("El valor del denominador es 0 no se puede dividir un numero en 0");
        }

        if(denominador.equalsIgnoreCase("b") && b !=0){
            resultado = a / b;
            System.out.println("Resultado de la Division: " + " " + resultado);

        }else if (b==0 && a !=0) {
            System.out.println("El valor del denominador es 0 no se puede dividir un numero en 0");

        }
    }

    //Funcion potencia

    static void potencia(){
        sc.nextLine();
        System.out.println("Elija quien es la base para la potencia (a) o (b): ");
        String elegir = sc.nextLine().trim();
        if(elegir.equalsIgnoreCase("a")){
            resultado = Math.pow(a,b);
            System.out.println("Resultado de La potencia: " + " " + a + " " + "^"
                    + b + " " + resultado);
        }else{
            resultado = Math.pow(b,a);
            System.out.println("Resultado de La potencia: " + " " + b + " " + "^"
            + a + " " + resultado);
        }
    }

    //Funcion Raiz
    static void raiz(){
        System.out.println("Ingrese Un numero Positivo para la Raiz: ");
        double r = sc.nextDouble();
        sc.nextLine();
        if(r>=0){
            resultado = Math.sqrt(r);
            System.out.println("El resultado de la Raiz es: " + " " + resultado);
        }else{
            System.out.println("No se puede calcular Raices Negativas");
        }

    }


}
