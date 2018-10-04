package com.fuseworks.labs.playground.pdfpoc;

import com.lowagie.text.DocumentException;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Service
public class PdfService {

    XfdfToPdf pdfGenerator;

    public PdfService(XfdfToPdf pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    public byte[] getPdf() throws IOException, DocumentException {
        File xfdf = ResourceUtils
                .getFile("classpath:static/data.xfdf");

        File pdfSrc = ResourceUtils
                .getFile("classpath:static/Requisition_Fillable.pdf");

        File dest = ResourceUtils.getFile("classpath:static");
        String DEST_URI = dest.getAbsolutePath() + "/generatedPDF.pdf";
        String TABLE_DEST_URI = dest.getAbsolutePath() + "/table.pdf";

        XfdfToPdf.fillPdf(pdfSrc.getAbsolutePath(), xfdf.getAbsolutePath(), DEST_URI);
        byte[] pdfByteArr = XfdfToPdf.convertFileToByteArray(DEST_URI);

        return pdfByteArr;
    }
}
