/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import javax.swing.JTextArea;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controlador_sistemas {
    
    private JTextArea areaTexto;
    private boolean ejecutando = true;
    
    // Contadores para los monitores
    private static int usuariosActivos = 0;
    private static int pedidosPendientes = 0;
    private static int ventasDelDia = 0;
    
    public Controlador_sistemas(JTextArea areaTexto) {
        this.areaTexto = areaTexto;
    }
    
    public void detenerMonitores() {
        ejecutando = false;
    }
    
    // Métodos para modificar contadores desde otras clases
    public static void usuarioLogin() { 
        usuariosActivos++; 
    }
    
    public static void usuarioLogout() { 
        if (usuariosActivos > 0) usuariosActivos--; 
    }
    
    public static void nuevoPedido() { 
        pedidosPendientes++; 
    }
    
    public static void pedidoProcesado() { 
        if (pedidosPendientes > 0) {
            pedidosPendientes--; 
            ventasDelDia++;
        }
    }

    // Hilo 1: Monitor de Sesiones Activas (cada 10 segundos)
    private void iniciarMonitorSesiones() {
        Thread hilo = new Thread(() -> {
            while (ejecutando) {
                try {
                    String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
                    String mensaje = "Usuarios Activos actualmente: " + usuariosActivos + " Última actividad: " + " " +timestamp;
                    agregarMensaje(mensaje);
                    Thread.sleep(10000); // 10 segundos
                } catch (InterruptedException e) {
                    // Hilo interrumpido
                }
            }
        });
        hilo.start();
    }

    // Hilo 2: Monitor de Pedidos Pendientes (cada 8 segundos)
    private void iniciarMonitorPedidos() {
        Thread hilo = new Thread(() -> {
            while (ejecutando) {
                try {
                    String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
                    String mensaje = "Pedidos Pendientes: " + pedidosPendientes + " Procesando... " + " "+ timestamp;
                    agregarMensaje(mensaje);
                    Thread.sleep(8000); // 8 segundos
                } catch (InterruptedException e) {
                    // Hilo interrumpido
                }
            }
        });
        hilo.start();
    }

    // Hilo 3: Monitor de Estadísticas (cada 15 segundos)
    private void iniciarMonitorEstadisticas() {
        Thread hilo = new Thread(() -> {
            while (ejecutando) {
                try {
                    String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
                    int productosRegistrados = obtenerProductosRegistrados();
                    String mensaje = "Ventas del día: " + ventasDelDia + " |Productos registrados: " + productosRegistrados + " | " + " "+ timestamp;
                    agregarMensaje(mensaje);
                    Thread.sleep(15000); // 15 segundos
                } catch (InterruptedException e) {
                    // Hilo interrumpido
                }
            }
        });
        hilo.start();
    }
    
    private void agregarMensaje(String mensaje) {
        if (areaTexto != null) {
            // Agregar el mensaje al JTextArea
            areaTexto.append(mensaje + "\n");
            // Auto-scroll al final
            areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
        }
        // También imprimir en consola del sistema
        System.out.println(mensaje);
    }
    
    private int obtenerProductosRegistrados() {
        // Conectar con tu Controlador_Productos
        try {
            // return Controlador_Productos.indice_productos; // Ajusta según tu código
            return 25; // Temporal para pruebas
        } catch (Exception e) {
            return 0;
        }
    }
    
    public void iniciarTodosLosMonitores() {
        iniciarMonitorSesiones();
        iniciarMonitorPedidos();
        iniciarMonitorEstadisticas();
        agregarMensaje("+-----   Actividades en Curso -----+");
        agregarMensaje("Hilos activos: Sesiones (10s) | Pedidos (8s) | Estadísticas (15s)");
    }
    
}
