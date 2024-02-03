package com.example.ReportGenration.Controller;

import com.example.ReportGenration.Srevice.ElgibilityService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ReportController {

    @Autowired
    ElgibilityService elgibilityService;
    @GetMapping("/downloadExcel")
    public void generateExcel(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";

        String headerValue = "attachment;filename= data.xls";

        response.setHeader(headerKey, headerValue);

        this.elgibilityService.generateExcel(response);
    }

    @GetMapping("/downloadPdf")
    public void generatePdf(HttpServletResponse response) throws Exception {

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

       elgibilityService.generatePdf(response);

        // UserPDFExporter exporter = new UserPDFExporter(listUsers);

        // exporter.export(response);

    }
}
