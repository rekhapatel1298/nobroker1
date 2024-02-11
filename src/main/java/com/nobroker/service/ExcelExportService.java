package com.nobroker.service;
import com.nobroker.entity.User;
import com.nobroker.repository.UserRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    @Autowired
    UserRepository userRepository;

    public byte[] exportToExcel() throws IOException {
        List<User> dataList = userRepository.findAll();
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("User");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Mobile");
            headerRow.createCell(4).setCellValue("Password");
            headerRow.createCell(5).setCellValue("Email Verification");

            // Fill data rows
            int rowNum = 1;
            for (User user : dataList) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
                row.createCell(3).setCellValue(user.getMobile());
                row.createCell(4).setCellValue(user.getPassword());
                row.createCell(5).setCellValue(user.isEmailVerification());
            }
            workbook.write(out);
            return out.toByteArray();

        }
    }
}
