package com.mdstech.report.bo;

import java.math.BigDecimal;

public class TrancheClassBO {
	private String trancheName;
	private BigDecimal trancheAmount;

	public String getTrancheName() {
		return trancheName;
	}

	public void setTrancheName(String trancheName) {
		this.trancheName = trancheName;
	}

	public BigDecimal getTrancheAmount() {
		return trancheAmount;
	}

	public void setTrancheAmount(BigDecimal trancheAmount) {
		this.trancheAmount = trancheAmount;
	}
}
