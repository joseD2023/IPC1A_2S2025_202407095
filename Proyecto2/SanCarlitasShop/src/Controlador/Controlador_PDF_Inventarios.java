/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.EventoBitacora;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Controlador_PDF_Inventarios {
    public static void exportarBitacoraPDF() {
        try {
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));
            String ruta =  "C:\\Users\\Admin\\IdeaProjects\\IPC12S\\src\\main\\java\\IPC1_Actividades_202407095\\Proyecto2\\bitacora_" + fecha + ".pdf";
            
            PdfWriter writer = new PdfWriter(ruta);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            
            // Título
            Paragraph titulo = new Paragraph("Bitacora del sistema")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(16);
            document.add(titulo);
            
            // Tabla
            float[] anchos = {20f, 15f, 12f, 15f, 10f, 20f, 10f};
            Table tabla = new Table(UnitValue.createPercentArray(anchos));
            
            // Encabezados
            tabla.addHeaderCell("Fecha");
            tabla.addHeaderCell("Tipo");
            tabla.addHeaderCell("Código");
            tabla.addHeaderCell("Operación");
            tabla.addHeaderCell("Estado");
            tabla.addHeaderCell("Descripción");
            tabla.addHeaderCell("Prioridad");
            
            // Datos
            EventoBitacora[] eventos = EventoBitacora.obtenerEventos();
            for (EventoBitacora evento : eventos) {
                if (evento != null) {
                    tabla.addCell(evento.getFechaHora());
                    tabla.addCell(evento.getTipoUsuario());
                    tabla.addCell(evento.getCodigoUsuario());
                    tabla.addCell(evento.getOperacion());
                    tabla.addCell(evento.getEstado());
                    tabla.addCell(evento.getDescripcion());
                    tabla.addCell(evento.getPrioridad());
                }
            }
            
            document.add(tabla);
            document.close();
            
            JOptionPane.showMessageDialog(null, "PDF generado: " + ruta);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
}
