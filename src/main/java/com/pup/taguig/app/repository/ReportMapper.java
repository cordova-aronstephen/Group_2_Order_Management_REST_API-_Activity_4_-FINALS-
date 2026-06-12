package com.pup.taguig.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pup.taguig.app.model.Report;
import com.pup.taguig.app.model.TopProduct;

@Mapper
public interface ReportMapper {

    public Report getTotalSales();
    public List<TopProduct> getTopProducts();
}