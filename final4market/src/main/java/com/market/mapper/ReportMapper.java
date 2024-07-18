package com.market.mapper;

import com.market.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ReportMapper {
    List<ReportDTO> getAllReports();
    ReportDTO getReportById(@Param("productNo") int productNo, @Param("claimerId") String claimerId, @Param("sellerId") String sellerId);
    int updateReportStatus(@Param("productNo") int productNo, @Param("claimerId") String claimerId, @Param("sellerId") String sellerId, @Param("reportStatus") char reportStatus);
}
