package com.mdstech.report.bo;

import java.util.Date;
import java.util.List;

public class TransactionBO {

	private Date transactionDate;
	private String transactionName;
	
	private List<WriterBO> writers;
	private List<TrancheClassBO> tranches;
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	public List<WriterBO> getWriters() {
		return writers;
	}
	public void setWriters(List<WriterBO> writers) {
		this.writers = writers;
	}
	public List<TrancheClassBO> getTranches() {
		return tranches;
	}
	public void setTranches(List<TrancheClassBO> tranches) {
		this.tranches = tranches;
	}
}
