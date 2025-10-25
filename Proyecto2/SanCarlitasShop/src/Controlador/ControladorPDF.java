/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Inventarios_PDF;
import java.time.LocalDateTime;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceN;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import javax.swing.text.StyleConstants;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
public class ControladorPDF {
    static DateTimeFormatter formatoArchivo = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
    //aqui voy a generar los pdfs 
 
    public static void generarReportesVentas(Inventarios_PDF[] productos, String[] encabezados){

        int count = 0;
        for (Inventarios_PDF p : productos) {
            if (p != null) count++;
        }
        
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para generar el PDF");
            return;
        }
        
        String fecha_hora = LocalDateTime.now().format(formatoArchivo);
        String nombre_archivo = fecha_hora + "_ProductoMasVendidos.pdf";

        try{
            PdfWriter escribir_pdf = new PdfWriter("C:\\Users\\Admin\\IdeaProjects\\IPC12S\\src\\main\\java\\IPC1_Actividades_202407095\\Proyecto2\\" + nombre_archivo);

            PdfDocument pdf = new PdfDocument(escribir_pdf);
            Document documento = new Document(pdf);

            Paragraph titulo = new Paragraph("Reportes Ventas PROYECTO 2 USAC").setTextAlignment(TextAlignment.CENTER).setFontSize(18).setFontColor(new DeviceRgb(255,0,0)).setBold();
            documento.add(titulo);

            documento.add(crearTabla(productos,encabezados));
            documento.close();
            
            JOptionPane.showMessageDialog(null, "PDF generado exitosamente: " + nombre_archivo);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al crear archivo: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
        }
    }
    
    
    
    
    private static Table crearTabla(Inventarios_PDF[] datos_produtos, String[] encabezados) {
        Table tabla = new Table(UnitValue.createPercentArray(encabezados.length)).useAllAvailableWidth();

        for(String encabezado : encabezados){
            if (encabezado != null) {
                tabla.addHeaderCell(new Cell().add(new Paragraph(encabezado))).setBackgroundColor(ColorConstants.GRAY);
            }
        }

        for(int i=0; i < datos_produtos.length; i++){
            Inventarios_PDF p = datos_produtos[i]; 
            
            if(p != null) {
                String nombre = p.getNombre_producto() != null ? p.getNombre_producto() : "N/A";
                String categoria = p.getCategoria_productos() != null ? p.getCategoria_productos() : "N/A";
                String cantidad = String.valueOf(p.getCantidad_total_vendida());
                String ingresos = String.valueOf(p.getIngreseos_generados()) + "Q";
                
                
                tabla.addCell(nombre);
                tabla.addCell(cantidad);
                tabla.addCell(categoria);
                tabla.addCell(ingresos);
            } else {
                tabla.addCell("N/A");
                tabla.addCell("0");
                tabla.addCell("N/A");
                tabla.addCell("0Q");
            }
        }
        
        return tabla;
    }
    
    
    
    
    
    
    
    
    public static void bubblesortMasvendidos(Inventarios_PDF[] mas_vendidos){
        int tamano = mas_vendidos.length;
        
        Inventarios_PDF objeto_temporal;
        
        for(int i=0; i<tamano-1; i++){
            for(int j=0; j<tamano-i-1;j++){
                if(mas_vendidos[j] != null && mas_vendidos[j+1] != null) {
                    if(mas_vendidos[j].getCantidad_total_vendida() < mas_vendidos[j+1].getCantidad_total_vendida()){
                        objeto_temporal = mas_vendidos[j];
                        mas_vendidos[j] = mas_vendidos[j+1];
                        mas_vendidos[j+1] = objeto_temporal;
                    }
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    public static void bubblesortMenosVendidos(Inventarios_PDF[] menos_vendidos){
        int tamano = menos_vendidos.length; 
        
        Inventarios_PDF aux_objeto; 
        
        for(int i=0; i<tamano-1; i++){
            for(int j=0; j<tamano-i-1;j++){
                if(menos_vendidos[j] != null && menos_vendidos[j+1] != null) {
                    if(menos_vendidos[j].getCantidad_total_vendida() > menos_vendidos[j+1].getCantidad_total_vendida()){
                        aux_objeto= menos_vendidos[j];
                        menos_vendidos[j] = menos_vendidos[j+1];
                        menos_vendidos[j+1] = aux_objeto;
                    }
                }
            }
        }
    }
}
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    

