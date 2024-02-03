package com.example.ReportGenration.Srevice;

import com.example.ReportGenration.Responce.SearchRequest;
import com.example.ReportGenration.Responce.SearchResponce;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public interface ElgibilityService {

    public List<String> getUniqePlanName();

    public List<String> getUniqePlanStatus();

    public List<SearchResponce> getSearchReq(SearchRequest request);

    public void generateExcel(HttpServletResponse response) throws IOException;
    public void generatePdf(HttpServletResponse response) throws IOException;


}
