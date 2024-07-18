package com.market.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reports")
    public ResponseEntity<List<ReportDTO>> getAllReports(HttpServletRequest request) {
        String adminId = request.getHeader("Admin-Id");
        List<ReportDTO> reports = reportService.getAllReports(adminId);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/reports/filtered")
    public ResponseEntity<List<ReportDTO>> getFilteredReports(HttpServletRequest request,
                                                              @RequestParam Map<String, String> params) {
        String adminId = request.getHeader("Admin-Id");
        String claimerId = request.getHeader("Claimer-Id");
        List<ReportDTO> reports = reportService.getFilteredReports(adminId, claimerId, params);
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

    @PutMapping("/reports/readStatus")
    public ResponseEntity<Map<String, Object>> updateReadStatus(@RequestParam("productNo") int productNo,
                                                                @RequestParam("sellerId") String sellerId,
                                                                @RequestParam("readStatus") char readStatus,
                                                                HttpServletRequest request) {
        String claimerId = request.getHeader("Claimer-Id");
        String adminId = request.getHeader("Admin-Id");
        int count = reportService.updateReadStatus(productNo, claimerId, sellerId, adminId, readStatus);
        Map<String, Object> response = new HashMap<>();
        response.put("count", count);
        response.put("msg", count == 0 ? "신고 읽기 상태 수정 실패" : "신고 읽기 상태 수정 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
