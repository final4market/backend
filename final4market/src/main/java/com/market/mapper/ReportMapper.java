package com.market.mapper;

import com.market.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    List<ReportDTO> getAllReports(String adminId);
    List<ReportDTO> getFilteredReports(String adminId, String claimerId, Map<String, String> params);
    ReportDTO getReportById(int productNo, String claimerId, String sellerId);
	int updateReportStatus(int productNo, String claimerId, String sellerId, char reportStatus);
	int updateReadStatus(int productNo, String claimerId, String sellerId, String adminId, char readStatus);
}
