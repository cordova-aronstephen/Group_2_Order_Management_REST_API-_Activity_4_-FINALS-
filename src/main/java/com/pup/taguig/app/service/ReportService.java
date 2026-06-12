package com.pup.taguig.app.service;

import java.util.List;

import com.pup.taguig.app.dto.ReportResponseDTO;
import com.pup.taguig.app.dto.TopProductResponseDTO;

public interface ReportService {

    public ReportResponseDTO getTotalSales();
    public List<TopProductResponseDTO> getTopProducts();
}