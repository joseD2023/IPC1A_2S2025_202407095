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
 
    public static void generarReportesVentas(Inventarios_PDF[] productos, String metodo, String name_archivo ){
        
        if(metodo.equals("masvendidos")){
            bubblesortMasvendidos(productos);
            
        }else if(metodo.equals("menosvendidos")){
            bubblesortMenosVendidos(productos);   
        }else if(metodo.equals("ventasporvendedor")){
           
         
            
            
        }

        /*--------------------------------------------------------------------------------------*/
        String fecha_hora = LocalDateTime.now().format(formatoArchivo);
        String nombre_archivo = fecha_hora + name_archivo + ".pdf";
         /*--------------------------------------------------------------------------------------*/

        try{
            PdfWriter escribir_pdf = new PdfWriter("C:\\Users\\Admin\\IdeaProjects\\IPC12S\\src\\main\\java\\IPC1_Actividades_202407095\\Proyecto2\\" + nombre_archivo);

            PdfDocument pdf = new PdfDocument(escribir_pdf);
            Document documento = new Document(pdf);

            Paragraph titulo = new Paragraph("Reportes Ventas PROYECTO 2 USAC").setTextAlignment(TextAlignment.CENTER).setFontSize(18).setFontColor(new DeviceRgb(255,0,0)).setBold();
            documento.add(titulo);
            
            if(metodo.equals("masvendidos")){
                String[] encabezados = {"Nombre del producto", "Cantidad total vendida", "Categoria del producto", "Ingresos generados"};
               documento.add(crearTabla(productos,encabezados));
            }else if(metodo.equals("menosvendidos")){
                String[] encabezado2 = {"Nombre del producto", "Cantidad total vendida", "Stock Actual Disponible", "Recomendacion de Promocion"};
                documento.add(crearTabla(productos,encabezado2));
            }

            
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
        
            //vamos atrabajar para el ingreso de los datos para poder visualizarlos en el pdf 
        
            for(Inventarios_PDF pdf: datos_produtos){
               if(pdf != null){ //diferente de null para poder ingresar los datos 
                
                
                String nombre_producto = pdf.getNombre_producto() != null ? pdf.getNombre_producto() : "/NAC";
                String cantidad_vendida = String.valueOf(pdf.getCantidad_total_vendida());
                
                
                if(encabezados[2].equals("Categoria del producto")){
                    String ingresos_generados= String.valueOf(pdf.getIngreseos_generados()); 
                    String categoria = pdf.getCategoria_productos() != null ? pdf.getCategoria_productos() : "/NAC";
 
                    tabla.addCell(nombre_producto);
                    tabla.addCell(cantidad_vendida);
                    tabla.addCell(categoria);
                    tabla.addCell(ingresos_generados);   
                    
                    
                }else if(encabezados[2].equals("Stock Actual Disponible")){
                    
                    String stock = Integer.toString(pdf.getStock_actual_disponible());
                    String recomendacion = pdf.getRecomendaciones_promocion() != null ? pdf.getRecomendaciones_promocion() : "sin recomendacion";
                    
                    tabla.addCell(nombre_producto);
                    tabla.addCell(cantidad_vendida);
                    tabla.addCell(stock);
                    tabla.addCell(recomendacion);
                    
                    
                }else if(encabezados[0].equals("Código Vendedor")){
                    
                    String codigo_vendedor = pdf.getCodigo_vendedor() != null ? pdf.getCodigo_vendedor(): "NAC";
                    String nombre_vendedor = pdf.getNombre_vendedor() != null ? pdf.getNombre_vendedor() : "NAC";
                    String pedidos_confiramdos = String.valueOf( pdf.getCantidad_pedido_confirmados()) != null ? String.valueOf( pdf.getCantidad_pedido_confirmados()) : "0";
                    String monto_total = String.valueOf(pdf.getVentas_generadas());
                    String producto_mas_vendido = pdf.getProducto_mas_vendido_vendedor() != null ? pdf.getProducto_mas_vendido_vendedor() : "NAC";
                    
                    tabla.addCell(codigo_vendedor);
                    tabla.addCell(nombre_vendedor);
                    tabla.addCell(pedidos_confiramdos);
                    tabla.addCell(monto_total);
                    tabla.addCell(producto_mas_vendido);
                    
                    
                    
                }
                
                
               
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
        System.out.println("METODO ORDENAMIENTO MENOS VENDIDO");
        
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
        
        System.out.println("finalizacion del metodo del ordenamiento");
    }
}
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    

