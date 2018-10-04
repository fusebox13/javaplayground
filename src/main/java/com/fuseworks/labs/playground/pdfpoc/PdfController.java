package com.fuseworks.labs.playground.pdfpoc;

import com.lowagie.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class PdfController {

    PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/download/pdf")
    public ResponseEntity<byte []> getPdf() throws IOException, DocumentException {
        byte [] bytes = this.pdfService.getPdf();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "something.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.MULTIPART_FORM_DATA).body(bytes);
    }
}
