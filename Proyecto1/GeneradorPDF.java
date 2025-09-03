package IPC1_Actividades_202407095.Proyecto1;

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

public class GeneradorPDF {
    //aqui vamos a generar los metodos para Generar Nuestros PDF

    // fecha  y hora
    static DateTimeFormatter formatoArchivo = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");


    public static void generarReporteStock(String[][] inventario, String[] encabezado) {
        String fecha_hora = LocalDateTime.now().format(formatoArchivo);
        String nombre_archivo = fecha_hora + "_Stock.pdf";

        try {
            //CREAMOS EL DOCUMENTO PDF AUN NO LO LLENAMOS
            PdfWriter escribir = new PdfWriter("C:\\Users\\Admin\\IdeaProjects\\IPC12S\\src\\main\\java\\IPC1_Actividades_202407095\\Proyecto1\\" + nombre_archivo);
            PdfDocument pdf = new PdfDocument(escribir);
            Document documento = new Document(pdf); // creamos el documento


            //Centramos el titlulo
            Paragraph titulo = new Paragraph("REPORTES STOCK").setTextAlignment(TextAlignment.CENTER).setFontSize(18).setFontColor(new DeviceRgb(255,0,0)).setBold();
            documento.add(titulo);


            documento.add(crearTabla(inventario, encabezado));
            documento.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //GENERAR PDF DE LAS VENTAS

    public static void generarReportesVentas(String[][] inventario, String[] encabezados){

        //Vamos a programar las fechas
        String fecha_hora = LocalDateTime.now().format(formatoArchivo);
        String nombre_archivo = fecha_hora + "_Ventas.pdf";

        try{
            PdfWriter escribir_pdf = new PdfWriter("C:\\Users\\Admin\\IdeaProjects\\IPC12S\\src\\main\\java\\IPC1_Actividades_202407095\\Proyecto1\\" + nombre_archivo);

            PdfDocument pdf = new PdfDocument(escribir_pdf);
            Document documento = new Document(pdf);
            //documento.add(new AreaBreak()); // como un salto de pagina interesante


            Paragraph titulo = new Paragraph("Reportes Ventas").setTextAlignment(TextAlignment.CENTER).setFontSize(18).setFontColor(new DeviceRgb(255,0,0)).setBold();
            documento.add(titulo);


            //vamos a registrar nuestras ventas
            documento.add(crearTabla(inventario,encabezados));
            documento.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }





    private static Table crearTabla(String[][] datos_Inventario, String[] encabezados) {
        Table tabla_inventarios = new Table(UnitValue.createPercentArray(encabezados.length)).useAllAvailableWidth();
        // createPercentArray(encabezados.length) es el numero de columnas que me va a crear
        //use.Allavailablewidth le indica que ocupe todos el ancho disponible del documento

        //ahora vamos a recorrer la nuestros encabezados e inventario

        for(String encabezado : encabezados){
            //agrega los encabezados a nuestro PDF
            tabla_inventarios.addHeaderCell(new Cell().add(new Paragraph(encabezado))).setBackgroundColor(ColorConstants.GRAY);
        }

        for(String[] fila: datos_Inventario){
            for(String columnas: fila){
                tabla_inventarios.addCell(new Cell().add(new Paragraph(columnas))).setTextAlignment(TextAlignment.CENTER);
            }
        }

        return tabla_inventarios;
    }
}









