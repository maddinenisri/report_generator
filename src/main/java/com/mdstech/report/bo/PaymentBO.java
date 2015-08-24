package com.mdstech.report.bo;

import java.math.BigDecimal;

public class PaymentBO {
	private String paymentName;
	private BigDecimal paymentAmount;

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
}
