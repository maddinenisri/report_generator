package com.mdstech.report.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.mdstech.report.bo.TrancheClassBO;
import com.mdstech.report.bo.TransactionBO;

@RunWith(JUnit4.class)
public class GeneratePDFReportTest {

	@Test
	public void testGenerateReport() throws Exception {
		GeneratePDFReport generatePDFReport = new GeneratePDFReport();
		generatePDFReport.generateReport(new FileOutputStream(new File("./target/Sample.pdf")), createTestData());
	}

	private TransactionBO createTestData() {
		TransactionBO transactionBO = new TransactionBO();
		transactionBO.setTransactionName("Test 1");
		transactionBO.setTransactionDate(new Date());
		addTranches(transactionBO);
		return transactionBO;
	}
	
	private void addTranches(TransactionBO transactionBO) {
		List<TrancheClassBO> tranches = new ArrayList<TrancheClassBO>();
		for(int i=0; i<3; i++) {
			TrancheClassBO trancheClassBO = new TrancheClassBO();
			trancheClassBO.setTrancheAmount(new BigDecimal("100.00"));
			trancheClassBO.setTrancheName("Tranche "+i);
			tranches.add(trancheClassBO);
		}
		transactionBO.setTranches(tranches);
	}
}
