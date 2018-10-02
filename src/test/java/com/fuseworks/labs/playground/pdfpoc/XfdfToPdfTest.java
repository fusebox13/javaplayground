package com.fuseworks.labs.playground.pdfpoc;

import com.lowagie.text.DocumentException;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class XfdfToPdfTest {

    @Test
    public void createPdfTest() throws IOException, DocumentException {
        File xfdf = ResourceUtils
                .getFile("classpath:static/data.xfdf");

        File pdfSrc = ResourceUtils
                .getFile("classpath:static/Requisition_Fillable.pdf");

        File dest = ResourceUtils.getFile("classpath:static");
        String DEST_URI = dest.getAbsolutePath() + "\\generatedPDF.pdf";
        String TABLE_DEST_URI = dest.getAbsolutePath() + "\\table.pdf";
        System.out.println(xfdf.getAbsolutePath());
        System.out.println(pdfSrc.getAbsolutePath());
        System.out.println(DEST_URI);

        XfdfToPdf.fillPdf(pdfSrc.getAbsolutePath(), xfdf.getAbsolutePath(), DEST_URI);
        XfdfToPdf.createTablePDF(TABLE_DEST_URI);
    }

}