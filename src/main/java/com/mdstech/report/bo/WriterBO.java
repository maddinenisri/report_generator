package com.mdstech.report.bo;

import java.util.List;

public class WriterBO {

	private String writerName;
	private String paymentRecipient;
	private List<PaymentBO> payments;

	public String getPaymentRecipient() {
		return paymentRecipient;
	}

	public void setPaymentRecipient(String paymentRecipient) {
		this.paymentRecipient = paymentRecipient;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public List<PaymentBO> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentBO> payments) {
		this.payments = payments;
	}
}
