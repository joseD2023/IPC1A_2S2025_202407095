package IPC1_Actividades_202407095.Proyecto1;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

import java.io.FileNotFoundException;

public class GeneradorPDF {
    //aqui vamos a generar los metodos para Generar Nuestros PDF
    public static String[] encabezados = {"codigo", "nombre", "Catalogo", "Precio", "Stock"};

    public static void generarReporteStock(String[][] inventario) {
        try {

            //CREAMOS EL DOCUMENTO PDF AUN NO LO LLENAMOS
            PdfWriter escribir = new PdfWriter("C:\\Users\\Admin\\IdeaProjects\\IPC12S\\src\\main\\java\\IPC1_Actividades_202407095\\Proyecto1\\Stock.pdf");
            PdfDocument pdf = new PdfDocument(escribir);
            Document documento = new Document(pdf); // creamos el documento
            documento.add(crearTabla(inventario));
            documento.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Table crearTabla(String[][] datos_Inventario) {
        Table tabla_inventarios = new Table(UnitValue.createPercentArray(encabezados.length)).useAllAvailableWidth();
        // createPercentArray(encabezados.length) es el numero de columnas que me va a crear
        //use.Allavailablewidth le indica que ocupe todos el ancho disponible del documento

        //ahora vamos a recorrer la nuestros encabezados e inventario

        for(String encabezado : encabezados){
            tabla_inventarios.addHeaderCell(new Cell().add(new Paragraph(encabezado)));
            //agrega los encabezados a nuestro PDF
        }

        for(String[] fila: datos_Inventario){
            for(String columnas: fila){
                tabla_inventarios.addCell(new Cell().add(new Paragraph(columnas)));
            }
        }

        return tabla_inventarios;
    }
}









