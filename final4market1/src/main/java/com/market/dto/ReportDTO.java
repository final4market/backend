package com.market.dto;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

@Alias("report")
public class ReportDTO {
	private int productNo;
    private String claimerId;
    private String sellerId;
    private LocalDate reportDate;
    private String reportContent;
    private char reportStatus;
    private char reportReadStatus;
    
	public ReportDTO() {
		
	}

	public ReportDTO(int productNo, String claimerId, String sellerId, LocalDate reportDate, String reportContent,
			char reportStatus, char reportReadStatus) {
		this.productNo = productNo;
		this.claimerId = claimerId;
		this.sellerId = sellerId;
		this.reportDate = reportDate;
		this.reportContent = reportContent;
		this.reportStatus = reportStatus;
		this.reportReadStatus = reportReadStatus;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getClaimerId() {
		return claimerId;
	}

	public void setClaimerId(String claimerId) {
		this.claimerId = claimerId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public char getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(char reportStatus) {
		this.reportStatus = reportStatus;
	}

	public char getReportReadStatus() {
		return reportReadStatus;
	}

	public void setReportReadStatus(char reportReadStatus) {
		this.reportReadStatus = reportReadStatus;
	}

	@Override
	public String toString() {
		return "reportDTO [productNo=" + productNo + ", claimerId=" + claimerId + ", sellerId=" + sellerId
				+ ", reportDate=" + reportDate + ", reportContent=" + reportContent + ", reportStatus=" + reportStatus
				+ ", reportReadStatus=" + reportReadStatus + "]";
	}
	   

}
