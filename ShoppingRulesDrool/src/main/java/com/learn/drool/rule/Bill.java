package com.learn.drool.rule;

public class Bill {

	private Double finalAmount=0d;
	
	private Double discount=0d;
	
	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void calculateFinalBill(){
		finalAmount=finalAmount-discount;
		System.out.println(finalAmount);
	}
}
