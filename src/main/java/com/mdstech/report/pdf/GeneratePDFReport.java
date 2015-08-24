package com.mdstech.report.pdf;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mdstech.report.bo.TrancheClassBO;
import com.mdstech.report.bo.TransactionBO;

public class GeneratePDFReport {

	public void generateReport(OutputStream outputStream,
			TransactionBO transactionBO) throws Exception {
		Document document = createDocument();
		createPDPdfWriter(document, outputStream);
		document.open();
		// Title Header
		addPageTitle(document, transactionBO);
		// Tranches Section
		addTrancheSection(document, transactionBO.getTranches());
		document.close();
	}

	private void addTrancheSection(Document document,
			List<TrancheClassBO> tranches) throws DocumentException {
		PdfPTable phraseTable = new PdfPTable(2);
		float[] columnWidths = new float[] { 75f, 25f };
		phraseTable.setWidths(columnWidths);
		for (TrancheClassBO trancheClassBO : tranches) {
			PdfPCell pfCell = new PdfPCell();
			pfCell.addElement(new Phrase(trancheClassBO.getTrancheName()));
			pfCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			pfCell.setBorder(Rectangle.NO_BORDER);
			phraseTable.addCell(pfCell);

			PdfPCell pfCell1 = new PdfPCell();
			pfCell1.addElement(createAmountParagraph(
					trancheClassBO.getTrancheAmount(), false));
			pfCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			pfCell1.setBorder(Rectangle.NO_BORDER);
			phraseTable.addCell(pfCell1);
		}
		Phrase tableWrapper = new Phrase();
		tableWrapper.add(phraseTable);
		com.itextpdf.text.List list = new com.itextpdf.text.List(true, true,
				20f);
		list.add("Test 1");
		list.add(new ListItem(tableWrapper));
		list.add("Test 2");
		list.add(new ListItem(tableWrapper));
		document.add(list);
	}

	private Phrase createAmountParagraph(BigDecimal amount, boolean isPercent) {
		Phrase listItem = new Phrase(isPercent ? amount.toString() + "%" : "$"
				+ amount.toString());
		return listItem;
	}

	private void addPageTitle(Document document, TransactionBO transactionBO)
			throws DocumentException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Chunk titleParagraph = new Chunk(
				"INTERNAL STATEMENT OF DIRECT PREMIUM PAYMENT - "
						+ transactionBO.getTransactionName()
						+ " - "
						+ simpleDateFormat.format(transactionBO
								.getTransactionDate()), FontFactory.getFont(
						FontFactory.HELVETICA_BOLD, 14));
		titleParagraph.setUnderline(0.1f, -2f);
		document.add(titleParagraph);
	}

	private PdfWriter createPDPdfWriter(Document document,
			OutputStream outputStream) throws DocumentException {
		return PdfWriter.getInstance(document, outputStream);
	}

	private Document createDocument() {
		return new Document(PageSize.LETTER);
	}
}
