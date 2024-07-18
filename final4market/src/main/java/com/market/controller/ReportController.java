package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.ReportDTO;
import com.market.service.ReportService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*" )
public class ReportController {
	
	@Autowired
    private ReportService reportService;

	@GetMapping("/reports")
    public List<ReportDTO> getAllReports() {
        return reportService.getAllReports();
    }

	@GetMapping("/reports/getReport")
    public ReportDTO getReportById(@RequestParam("productNo") int productNo, 
                                   @RequestParam("sellerId") String sellerId,
                                   HttpServletRequest request) {
        String claimerId = request.getHeader("Claimer-Id");
        return reportService.getReportById(productNo, claimerId, sellerId);
    }

	@PutMapping("/reports")
    public ResponseEntity<Map<String, Object>> updateReportStatus(@RequestParam("productNo") int productNo, 
                                                                  @RequestParam("sellerId") String sellerId, 
                                                                  @RequestBody ReportDTO reportDTO,
                                                                  HttpServletRequest request) {
        String claimerId = request.getHeader("Claimer-Id");
        int count = reportService.updateReportStatus(productNo, claimerId, sellerId, reportDTO.getReportStatus());
        Map<String, Object> response = new HashMap<>();
        response.put("count", count);
        response.put("msg", count == 0 ? "신고 처리 상태 수정 실패" : "신고 처리 상태 수정 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
