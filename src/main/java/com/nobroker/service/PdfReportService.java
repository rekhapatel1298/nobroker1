package com.nobroker.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nobroker.entity.User;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class PdfReportService {

//    public byte[] generateUserPdfReport(List<User> userList) throws DocumentException {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Document document = new Document();
//        PdfWriter.getInstance(document, baos);
//        document.open();
//
//        // Add content to the PDF
//       for (User user:userList){
//           document.add(new Paragraph("User Report"));
//           document.add(new Paragraph("ID: " + user.getId()));
//           document.add(new Paragraph("Name: " + user.getName()));
//           document.add(new Paragraph("Email: " + user.getEmail()));
//           document.add(new Paragraph("Mobile: " + user.getMobile()));
//       }
//        // Add other fields as needed
//
//        document.close();
//        return baos.toByteArray();
//    }

    public byte[] generateUserPdfReport(List<User> userList) throws DocumentException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, baos);
        document.open();

        // Add title
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
        Paragraph title = new Paragraph("User Report ", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(" "));// Add a blank paragraph




        // Define table with 5 columns
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);

        // Add table headers
        table.addCell(new PdfPCell(new Phrase("ID")));
        table.addCell(new PdfPCell(new Phrase("Name")));
        table.addCell(new PdfPCell(new Phrase("Email")));
        table.addCell(new PdfPCell(new Phrase("Mobile")));
        table.addCell(new PdfPCell(new Phrase("Email Verification")));

        // Add user data to the table
        for (User user : userList) {
            table.addCell(new PdfPCell(new Phrase(String.valueOf(user.getId()))));
            table.addCell(new PdfPCell(new Phrase(user.getName())));
            table.addCell(new PdfPCell(new Phrase(user.getEmail())));
            table.addCell(new PdfPCell(new Phrase(user.getMobile())));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(user.isEmailVerification()))));
        }

        // Add table to the document
        document.add(table);

        document.close();
        return baos.toByteArray();
    }
}

