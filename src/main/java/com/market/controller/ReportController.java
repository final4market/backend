package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.ReportDTO;
import com.market.service.ReportService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReportController {

	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reports")
    public ResponseEntity<List<ReportDTO>> getAllReports(HttpServletRequest request) {

        String adminId = request.getHeader("AdminId");

        List<ReportDTO> reports = reportService.getAllReports(adminId);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/reports/filtered")
    public ResponseEntity<List<ReportDTO>> getFilteredReports(HttpServletRequest request,
                                                              @RequestParam Map<String, String> params) {

        String adminId = request.getHeader("AdminId");
        String claimerId = request.getHeader("ClaimerId");

        params.put("adminId", adminId);
        if (claimerId != null) {
            params.put("claimerId", claimerId);
        }
        logger.debug("Filters received: {}", params);
        List<ReportDTO> reports = reportService.getFilteredReports(params);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/reports/reportInfo")
    public ResponseEntity<?> getReportById(@RequestParam("productNo") int productNo,
                                           @RequestParam("sellerId") String sellerId,
                                           HttpServletRequest request) {
        String claimerId = request.getHeader("Claimer-Id");

        if (claimerId == null || claimerId.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("msg", "Claimer ID is missing in the request headers.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        ReportDTO report = reportService.getReportById(productNo, claimerId, sellerId);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @PutMapping("/reports")
    public ResponseEntity<Map<String, Object>> updateReportStatus(
        @RequestBody Map<String, String> body,
        HttpServletRequest request) {

        int productNo = Integer.parseInt(body.get("productNo"));
        String sellerId = body.get("sellerId");
        char reportStatus = body.get("reportStatus").charAt(0);

        String claimerId = request.getHeader("ClaimerId");

        int count = reportService.updateReportStatus(productNo, claimerId, sellerId, reportStatus);
        Map<String, Object> response = new HashMap<>();
        response.put("count", count);
        response.put("msg", count == 0 ? "신고 처리 상태 수정 실패" : "신고 처리 상태 수정 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/reports/readStatus")
    public ResponseEntity<Map<String, Object>> updateReadStatus(@RequestParam("productNo") int productNo,
                                                                @RequestParam("sellerId") String sellerId,
                                                                @RequestParam("readStatus") char readStatus,
                                                                HttpServletRequest request) {

        String claimerId = request.getHeader("ClaimerId");
        String adminId = request.getHeader("AdminId");
        
        Map<String, Object> response = new HashMap<>();

        if (claimerId == null || adminId == null) {
            response.put("count", 0);
            response.put("msg", "헤더 정보가 누락되었습니다.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            int count = reportService.updateReadStatus(productNo, claimerId, sellerId, adminId, readStatus);
            response.put("count", count);
            response.put("msg", count == 0 ? "신고 읽기 상태 수정 실패" : "신고 읽기 상태 수정 성공");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("count", 0);
            response.put("msg", "서버 오류 발생: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/insertReport")
	public Map<String, Object> insertReport(@RequestBody ReportDTO dto){
		Map<String, Object> map = new HashMap<>();
		System.out.println(dto);
		try {			
			reportService.insertReport(dto);
			map.put("msg", "신고가 접수되었습니다");
			return map;
		} catch (Exception e) {
			map.put("msg", "신고 접수에 실패했습니다");
			return map;
		}
	}
}
