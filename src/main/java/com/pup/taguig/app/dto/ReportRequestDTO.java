package com.pup.taguig.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequestDTO {

    private String reportType;
    private String startDate;
    private String endDate;
}