package modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CriarPDF {
    private Document documento = new Document();
    private Pedido pedido;

    public CriarPDF (Pedido p) throws FileNotFoundException, DocumentException {
        this.pedido = p;
        PdfWriter.getInstance(documento, new FileOutputStream("pdf//pedido.pdf"));

        documento.setPageSize(PageSize.A4);
        documento.addSubject("Delivery - Extrato de Pedido");
        documento.addKeywords("extrato de pedido");
        documento.addCreator("Delivery");
        documento.addAuthor("Delivery Sistema de Entregas");
        documento.open();
        documento.add(new Paragraph("Delivery Sistema de Entrega - Extrato do Pedido"));
        documento.add(new Paragraph(p.toString()));
        documento.close();
    }
}
