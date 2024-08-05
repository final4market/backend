package com.market.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.dto.ReportDTO;
import com.market.mapper.ReportMapper;

@Service
public class ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    @Autowired
    private ReportMapper reportMapper;
    
    @Transactional
    public List<ReportDTO> getAllReports(String adminId) {
        return reportMapper.getAllReports(adminId);
    }
    
    @Transactional
    public List<ReportDTO> getFilteredReports(Map<String, String> params) {
    	System.out.println("Params in service: " + params);
    	return reportMapper.getFilteredReports(params);
	}

    public ReportDTO getReportById(int productNo, String claimerId, String sellerId) {
        return reportMapper.getReportById(productNo, claimerId, sellerId);
    }

    public int updateReportStatus(int productNo, String claimerId, String sellerId, char reportStatus) {
        return reportMapper.updateReportStatus(productNo, claimerId, sellerId, reportStatus);
    }

    public int updateReadStatus(int productNo, String claimerId, String sellerId, String adminId, char readStatus) {
        return reportMapper.updateReadStatus(productNo, claimerId, sellerId, adminId, readStatus);
    }

	public int insertReport(ReportDTO dto) {
		return reportMapper.insertReport(dto);
	}
}
