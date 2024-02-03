package com.example.ReportGenration.Srevice.Impl;

import com.example.ReportGenration.Entity.Eligibility;
import com.example.ReportGenration.Repository.EligibilityRepo;
import com.example.ReportGenration.Responce.SearchRequest;
import com.example.ReportGenration.Responce.SearchResponce;
import com.example.ReportGenration.Srevice.ElgibilityService;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl  implements ElgibilityService {

    @Autowired
    EligibilityRepo eligibilityRepo;
    @Override
    public List<String> getUniqePlanName() {
        return null;
    }

    @Override
    public List<String> getUniqePlanStatus() {
        return null;
    }

    @Override
    public List<SearchResponce> getSearchReq(SearchRequest request) {

        Eligibility queryBuilder= new Eligibility();


        String planName= request.getPlanName();
        if(planName != null && planName.equals("")){
            queryBuilder.setPlanName(planName);
        }

        String planStatus= request.getPlanStatus();
        if(planStatus != null && planStatus.equals("")){
            queryBuilder.setPlanStatus(planStatus);
        }



        Example<Eligibility> example= Example.of(queryBuilder);



        List<Eligibility> eligibilities= eligibilityRepo.findAll(example);

        List<SearchResponce> searchResponce1= new ArrayList<>();

        for (Eligibility eligibility : eligibilities){

            SearchResponce sr= new SearchResponce();
            BeanUtils.copyProperties(eligibility,sr);

            searchResponce1.add(sr);
        }



        return searchResponce1;
    }

    @Override
    public void generateExcel(HttpServletResponse response) throws IOException {
        List<Eligibility> eligibilities =eligibilityRepo.findAll();

        HSSFWorkbook workbook= new HSSFWorkbook();
        HSSFSheet sheet= workbook.createSheet();
        HSSFRow headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Email");
        headerRow.createCell(2).setCellValue("Adhar");
        headerRow.createCell(3).setCellValue("Gender");
        headerRow.createCell(4).setCellValue("Mobile No.");



        eligibilities.stream().forEach((entity)->{
            int i=1;
            HSSFRow dataRow= sheet.createRow(i);
            dataRow.createCell(0).setCellValue(entity.getName());
            dataRow.createCell(1).setCellValue(entity.getEmailId());
            dataRow.createCell(2).setCellValue(entity.getAdharNo());
            dataRow.createCell(3).setCellValue(entity.getGender());
            dataRow.createCell(4).setCellValue(entity.getMobileNo());
            i++;

        });

          ServletOutputStream outputStream = response.getOutputStream();
          workbook.write(outputStream);
          workbook.close();
          outputStream.close();


    }

    @Override
    public void generatePdf(HttpServletResponse response) throws IOException {

        List<Eligibility> eligibilities =eligibilityRepo.findAll();



        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);



        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        font.setColor(Color.BLACK);


        cell.setPhrase(new Phrase("Name", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Adhar", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Gender", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Mobile No.", font));
        table.addCell(cell);

        for(Eligibility eligibility : eligibilities){
            table.addCell(eligibility.getName());
            table.addCell(eligibility.getEmailId());
            table.addCell(eligibility.getAdharNo());
            table.addCell(eligibility.getGender());
            table.addCell(eligibility.getMobileNo());
        }

        document.add(table);
        document.close();



    }
}
