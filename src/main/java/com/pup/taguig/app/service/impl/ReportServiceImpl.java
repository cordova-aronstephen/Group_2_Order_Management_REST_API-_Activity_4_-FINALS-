package com.pup.taguig.app.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.ReportResponseDTO;
import com.pup.taguig.app.dto.TopProductResponseDTO;
import com.pup.taguig.app.model.Report;
import com.pup.taguig.app.model.TopProduct;
import com.pup.taguig.app.repository.ReportMapper;
import com.pup.taguig.app.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger LOGGER = LogManager.getLogger(ReportServiceImpl.class);

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public ReportResponseDTO getTotalSales() {
        LOGGER.info("Enter getTotalSales");

        Report report = reportMapper.getTotalSales();

        if (report == null) {
            throw new IllegalArgumentException("Sales report not found");
        }

        LOGGER.info("End getTotalSales");
        return toDTO(report);
    }

    @Override
    public List<TopProductResponseDTO> getTopProducts() {
        LOGGER.info("Enter getTopProducts");

        List<TopProduct> products = reportMapper.getTopProducts();

        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Top selling products report not found");
        }

        LOGGER.info("End getTopProducts");
        return products.stream()
                .map(product -> toDTO(product))
                .toList();
    }

    private ReportResponseDTO toDTO(Report report) {
        ReportResponseDTO responseDTO = new ReportResponseDTO();

        responseDTO.setTotalOrders(report.getTotalOrders());
        responseDTO.setTotalRevenue(report.getTotalRevenue());

        return responseDTO;
    }

    private TopProductResponseDTO toDTO(TopProduct product) {
        TopProductResponseDTO responseDTO = new TopProductResponseDTO();

        responseDTO.setProductId(product.getProductId());
        responseDTO.setProductName(product.getProductName());
        responseDTO.setTotalQuantitySold(product.getTotalQuantitySold());
        responseDTO.setRevenue(product.getRevenue());

        return responseDTO;
    }
}