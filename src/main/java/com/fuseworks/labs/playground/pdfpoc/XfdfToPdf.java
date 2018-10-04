package com.fuseworks.labs.playground.pdfpoc;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.*;
import org.springframework.stereotype.Component;

import java.io.*;

import static jdk.nashorn.internal.objects.Global.println;

@Component
public class XfdfToPdf {

    protected static void fillPdf(String SRC, String XFDF, String DEST) throws IOException, DocumentException {
        XfdfReader xfdfReader = new XfdfReader(XFDF);


        PdfReader pdfReader = new PdfReader(SRC);

        FileOutputStream pdfos = new FileOutputStream(DEST);

        PdfStamper stamper = new PdfStamper(pdfReader, pdfos);

        AcroFields fields = stamper.getAcroFields();
        fields.getFields();

        fields.setFields(xfdfReader);
        fields.setField("Submitted by", "Dan the greatest ever!!");

        stamper.setFormFlattening(true);
        stamper.close();
        pdfReader.close();
    }

    protected static void createTablePDF(String DEST) throws IOException, DocumentException {
        Document document = new Document(PageSize.LETTER);

        PdfWriter.getInstance(document, new FileOutputStream(DEST));

        document.open();

        PdfPTable table = new PdfPTable(5);
        table.setHeaderRows(1);
        table.setSplitRows(false);
        table.setComplete(false);

        for (int i = 0; i < 5; i++) {table.addCell("Header " + i);}

        for (int i = 0; i < 1000; i++) {
            if (i%5 == 0) {
                document.add(table);
            }
            table.addCell("Test " + i);
        }

        table.setComplete(true);
        document.add(table);
        document.close();
    }

    protected static byte[] convertFileToByteArray(String src) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(src);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            println(ex.getStackTrace());
            println(ex.getMessage());
        }
        return bos.toByteArray();
    }
}
