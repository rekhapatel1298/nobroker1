package com.nobroker.controller;
import com.itextpdf.text.DocumentException;
import com.nobroker.entity.User;
import com.nobroker.service.PdfReportService;
import com.nobroker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pdf")
public class PdfExportController {
    @Autowired
    private PdfReportService pdfReportService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/report")
    public ResponseEntity<byte[]> generateUserReport() throws IOException {
        // Fetch user data from the database or any other source
       List<User> user = userService.getAllUser();

        try {
            byte[] pdfBytes = pdfReportService.generateUserPdfReport(user);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(pdfBytes);
        } catch (DocumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
