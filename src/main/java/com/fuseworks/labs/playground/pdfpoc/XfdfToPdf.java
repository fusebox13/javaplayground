package com.fuseworks.labs.playground.pdfpoc;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.XfdfReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XfdfToPdf {

    protected static void fillPdf(String SRC, String XFDF, String DEST) throws IOException, DocumentException {
        XfdfReader xfdfReader = new XfdfReader(XFDF);

        PdfReader pdfReader = new PdfReader(SRC);

        FileOutputStream pdfos = new FileOutputStream(DEST);

        PdfStamper stamper = new PdfStamper(pdfReader, pdfos);

        AcroFields fields = stamper.getAcroFields();

        fields.setFields(xfdfReader);

        stamper.setFormFlattening(true);
        stamper.close();
        pdfReader.close();
    }
}
