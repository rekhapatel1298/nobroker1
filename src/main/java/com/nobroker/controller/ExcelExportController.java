package com.nobroker.controller;
//
//import com.nobroker.service.ExcelExportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/excel")
//public class ExcelExportController {
//
//    @Autowired
//    private ExcelExportService excelExportService;

////    http://localhost:8080/api/excel
//    @GetMapping("/export")
//    public String exportToExcel() {
//        excelExportService.exportToExcel();
//        return "Excel file exported successfully!";
//    }


import com.nobroker.service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

    @RestController
    @RequestMapping("/api/excel")
    public class ExcelExportController {

        @Autowired
        private ExcelExportService excelExportService;

//        http://localhost:8080//api/excel/export
        @GetMapping("/export")
        public ResponseEntity<byte[]> exportToExcel() throws IOException {
            byte[] excelByte = excelExportService.exportToExcel();

            // Set response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "users.xlsx");

            // Copy file content to response

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(excelByte);
        }
    }



