package com.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dto.ReportDTO;
import com.market.mapper.ReportMapper;

@Service
public class ReportService {

    @Autowired
    private ReportMapper reportMapper;

    public List<ReportDTO> getAllReports() {
        return reportMapper.getAllReports();
    }

    public ReportDTO getReportById(int productNo, String claimerId, String sellerId) {
        return reportMapper.getReportById(productNo, claimerId, sellerId);
    }

    public int updateReportStatus(int productNo, String claimerId, String sellerId, char reportStatus) {
        return reportMapper.updateReportStatus(productNo, claimerId, sellerId, reportStatus);
    }
}
