package com.market.dto;

public class DeliveryDTO {
	private int deliveryNo;
	private String deliveryName;
	private String tradeArea;
	private int deliveryCharge;
	
	public DeliveryDTO() {
	}

	public int getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(int deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getTradiArea() {
		return tradeArea;
	}

	public void setTradiArea(String tradiArea) {
		this.tradeArea = tradiArea;
	}

	public int getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	@Override
	public String toString() {
		return "DeliveryDTO [deliveryNo=" + deliveryNo + ", deliveryName=" + deliveryName + ", tradeArea=" + tradeArea
				+ ", deliveryCharge=" + deliveryCharge + "]";
	}


	
}
