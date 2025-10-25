/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class EventoBitacora {
    
    private String fechaHora;
    private String tipoUsuario;
    private String codigoUsuario;
    private String operacion;
    private String estado;
    private String descripcion;
    private String prioridad;

    public EventoBitacora(String tipoUsuario, String codigoUsuario, String operacion,
                          String estado, String descripcion, String prioridad) {
        this.fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.tipoUsuario = tipoUsuario;
        this.codigoUsuario = codigoUsuario;
        this.operacion = operacion;
        this.estado = estado;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    // Getters
    public String getFechaHora() { return fechaHora; }
    public String getTipoUsuario() { return tipoUsuario; }
    public String getCodigoUsuario() { return codigoUsuario; }
    public String getOperacion() { return operacion; }
    public String getEstado() { return estado; }
    public String getDescripcion() { return descripcion; }
    public String getPrioridad() { return prioridad; }

    
    
    private static final int MAX_EVENTOS = 1000; // tamaño máximo del arreglo
    private static EventoBitacora[] eventos = new EventoBitacora[MAX_EVENTOS];
    private static int contador = 0; // para llevar la posición actual

    // Registrar un nuevo evento
    public static void registrarEvento(String tipoUsuario, String codigoUsuario, String operacion,
                                       String estado, String descripcion, String prioridad) {
        if(contador < MAX_EVENTOS){
            eventos[contador++] = new EventoBitacora(tipoUsuario, codigoUsuario, operacion, estado, descripcion, prioridad);
            System.out.println(eventos[contador-1]); // también imprime en consola
        } else {
            System.out.println("Bitácora llena, no se pueden registrar más eventos.");
        }
    }

    // Consultar bitácora con filtros
    public static EventoBitacora[] consultar(String tipoUsuario, String operacion, String codigoUsuario){
        EventoBitacora[] resultados = new EventoBitacora[contador]; // tamaño máximo igual al contador
        int idx = 0;
        for(int i=0; i<contador; i++){
            EventoBitacora e = eventos[i];
            if((tipoUsuario==null || e.getTipoUsuario().equalsIgnoreCase(tipoUsuario)) &&
               (operacion==null || e.getOperacion().equalsIgnoreCase(operacion)) &&
               (codigoUsuario==null || e.getCodigoUsuario().equalsIgnoreCase(codigoUsuario))){
                resultados[idx++] = e;
            }
        }
        // ajustar tamaño del arreglo a los resultados encontrados
        EventoBitacora[] finales = new EventoBitacora[idx];
        for(int i=0;i<idx;i++) finales[i] = resultados[i];
        return finales;
    }
    
    
    

    // Exportar a CSV
    public static void exportarCSV(String rutaArchivo){
        try(FileWriter csv = new FileWriter(rutaArchivo)){
            csv.append("FechaHora,TipoUsuario,CodigoUsuario,Operacion,Estado,Descripcion,Prioridad\n");
            for(int i=0; i<contador; i++){
                EventoBitacora e = eventos[i];
                csv.append(String.format("%s,%s,%s,%s,%s,%s,%s\n",
                        e.getFechaHora(), e.getTipoUsuario(), e.getCodigoUsuario(),
                        e.getOperacion(), e.getEstado(), e.getDescripcion(), e.getPrioridad()));
            }
            csv.flush();
            System.out.println("Bitácora exportada a CSV correctamente");
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    // Limpiar bitácora
    public static void limpiarBitacora(){
        eventos = new EventoBitacora[MAX_EVENTOS];
        contador = 0;
    }

    // Obtener todos los eventos
    public static EventoBitacora[] obtenerEventos(){
        EventoBitacora[] actuales = new EventoBitacora[contador];
        for(int i=0;i<contador;i++) actuales[i] = eventos[i];
        return actuales;
    }
    
    
    @Override
    public String toString() {
        return String.format("[%s] | [%s] | [%s] | [%s] | [%s] | [%s] | [%s]",
                fechaHora, tipoUsuario, codigoUsuario, operacion, estado, descripcion, prioridad);
    }
    
}
