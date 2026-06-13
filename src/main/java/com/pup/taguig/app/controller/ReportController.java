package com.pup.taguig.app.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pup.taguig.app.dto.ReportResponseDTO;
import com.pup.taguig.app.dto.TopProductResponseDTO;
import com.pup.taguig.app.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/sales")
    public ReportResponseDTO getTotalSales() {

        ReportResponseDTO result = null;

        if (Objects.nonNull(reportService)) {
            result = reportService.getTotalSales();
        }

        return result;
    }

    @GetMapping("/top-products")
    public List<TopProductResponseDTO> getTopProducts() {

        List<TopProductResponseDTO> result = null;

        if (Objects.nonNull(reportService)) {
            result = reportService.getTopProducts();
        }

        return result;
    }
}