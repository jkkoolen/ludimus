package eu.ludimus.web.ticket;

import eu.ludimus.service.dto.TicketDto;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component

public class VATExcelReport extends AbstractExcelView {
    final String DATA_KEY = "ticketDtoList";

    private static final String NAME = "VATOverview";
    public static final String DEBITEUREN = "1. Debiteuren";
    public static final String CREDITEUREN = "2. Crediteuren";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String INLINE_FILENAME = "inline; filename=\"%s.xls\"";
    public static final String EX_BTW_BEDRAG = "Ex. BTW bedrag";
    public static final String BTW = "BTW";
    public static final String BTW_21 = "BTW 21%";
    public static final String EURO = "€ ";
    public static final String BTW_6 = "BTW 6%";
    public static final String BTW_0 = "BTW 0%";
    public static final String TOTAAL = "Totaal";
    public static final BigDecimal PERCENTAGE_21 = BigDecimal.valueOf(.21);
    public static final BigDecimal PERCENTAGE_6 = BigDecimal.valueOf(.06);

    public final ModelAndView createModelAndView(List<TicketDto> ticketDtoList) {
        return new ModelAndView(this,DATA_KEY, ticketDtoList);
    }

    @Override
    public final void setContentType(String contentType) {
        super.setContentType(contentType);
    }

    @Override
    protected final void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader(CONTENT_DISPOSITION, String.format(INLINE_FILENAME,NAME));

        final List<TicketDto> ticketDtoList = (List<TicketDto>) model.get(DATA_KEY);
        int rowNumber = 0;
        final HSSFSheet sheet = workbook.createSheet(NAME);

        final HSSFRow row1 = sheet.createRow(rowNumber++);
        final HSSFCell row1col0Cell = row1.createCell(0);
        row1col0Cell.setCellValue(toBold(DEBITEUREN));
        final HSSFCell row1col3Cell = row1.createCell(3);
        row1col3Cell.setCellValue(toBold(CREDITEUREN));

        final HSSFRow row2 = sheet.createRow(rowNumber++);
        final HSSFCell row2col1Cell = row2.createCell(1);
        row2col1Cell.setCellValue(toBold(EX_BTW_BEDRAG));
        final HSSFCell row2col2Cell = row2.createCell(2);
        row2col2Cell.setCellValue(toBold(BTW));
        final HSSFCell row2col4Cell = row2.createCell(4);
        row2col4Cell.setCellValue(toBold(EX_BTW_BEDRAG));
        final HSSFCell row2col5Cell = row2.createCell(5);
        row2col5Cell.setCellValue(toBold(BTW));

        final Pair<Map<VAT, BigDecimal>, Map<VAT, BigDecimal>> pair = gather(ticketDtoList);

        final HSSFRow row3 = sheet.createRow(rowNumber++);
        final HSSFCell row3col0Cell = row3.createCell(0);
        row3col0Cell.setCellValue(BTW_21);
        final BigDecimal income21 = pair.getLeft().get(VAT.VAT_21);
        final HSSFCell row3col1Cell = row3.createCell(1);
        row3col1Cell.setCellValue(EURO + income21);
        final HSSFCell row3col2Cell = row3.createCell(2);
        row3col2Cell.setCellValue(EURO + income21.multiply(PERCENTAGE_21));
        final HSSFCell row3col3Cell = row3.createCell(3);
        row3col3Cell.setCellValue(BTW_21);
        final BigDecimal expense21 = pair.getRight().get(VAT.VAT_21);
        final HSSFCell row3col4Cell = row3.createCell(4);
        row3col4Cell.setCellValue(EURO + expense21);
        final HSSFCell row3col5Cell = row3.createCell(5);
        row3col5Cell.setCellValue(EURO + expense21.multiply(PERCENTAGE_21));

        final HSSFRow row4 = sheet.createRow(rowNumber++);
        final HSSFCell row4col0Cell = row4.createCell(0);
        row4col0Cell.setCellValue(BTW_6);
        final BigDecimal income6 = pair.getLeft().get(VAT.VAT_6);
        final HSSFCell row4col1Cell = row4.createCell(1);
        row4col1Cell.setCellValue(EURO + income6);
        final HSSFCell row4col2Cell = row4.createCell(2);
        row4col2Cell.setCellValue(EURO + income6.multiply(PERCENTAGE_6));
        final HSSFCell row4col3Cell = row4.createCell(3);
        row4col3Cell.setCellValue(BTW_6);
        final BigDecimal expense6 = pair.getRight().get(VAT.VAT_6);
        final HSSFCell row4col4Cell = row4.createCell(4);
        row4col4Cell.setCellValue(EURO + expense6);
        final HSSFCell row4col5Cell = row4.createCell(5);
        row4col5Cell.setCellValue(EURO + expense6.multiply(PERCENTAGE_6));

        final HSSFRow row5 = sheet.createRow(rowNumber++);
        final HSSFCell row5col0Cell = row5.createCell(0);
        row5col0Cell.setCellValue(BTW_0);
        final BigDecimal income0 = pair.getLeft().get(VAT.VAT_0);
        final HSSFCell row5col1Cell = row5.createCell(1);
        row5col1Cell.setCellValue(EURO + income0);
        final HSSFCell row5col2Cell = row5.createCell(2);
        row5col2Cell.setCellValue("-");
        final HSSFCell row5col3Cell = row5.createCell(3);
        row5col3Cell.setCellValue(BTW_0);
        final BigDecimal expense0 = pair.getRight().get(VAT.VAT_0);
        final HSSFCell row5col4Cell = row5.createCell(4);
        row5col4Cell.setCellValue(EURO + expense0);
        final HSSFCell row5col5Cell = row5.createCell(5);
        row5col5Cell.setCellValue("-");

        final HSSFRow row6 = sheet.createRow(rowNumber++);
        final HSSFCell row6col0Cell = row6.createCell(0);
        row6col0Cell.setCellValue(toBold(TOTAAL));
        final BigDecimal income = income21.add(income6).add(income0);
        final HSSFCell row6col1Cell = row6.createCell(1);
        row6col1Cell.setCellValue(toBold(EURO + income));
        final HSSFCell row6col2Cell = row6.createCell(2);
        final BigDecimal incomeVat = income21.multiply(PERCENTAGE_21).add(income6.multiply(PERCENTAGE_6));
        row6col2Cell.setCellValue(toBold(EURO + incomeVat));
        final HSSFCell row6col3Cell = row6.createCell(3);
        row6col3Cell.setCellValue(toBold(TOTAAL));
        final BigDecimal expense = expense21.add(expense6).add(expense0);
        final HSSFCell row6col4Cell = row6.createCell(4);
        row6col4Cell.setCellValue(toBold(EURO + expense));
        final HSSFCell row6col5Cell = row6.createCell(5);
        final BigDecimal expenseVat = expense21.multiply(PERCENTAGE_21).add(expense6.multiply(PERCENTAGE_6));
        row6col5Cell.setCellValue(toBold(EURO + expenseVat));


        final HSSFRow row7 = sheet.createRow(rowNumber++);
        final HSSFCell row7col0 = row7.createCell(0);
        final HSSFCell row7col1 = row7.createCell(1);
        if(incomeVat.compareTo(expenseVat) < 0) { //ontvangen
            row7col0.setCellValue(toBold("Te ontvangen"));
            row7col1.setCellValue(toBold(EURO + expenseVat.subtract(incomeVat)));
        } else { //betalen
            row7col0.setCellValue(toBold("Te betalen"));
            row7col1.setCellValue(toBold(EURO + incomeVat.subtract(expenseVat)));
        }

    }

    private Pair<Map<VAT, BigDecimal>, Map<VAT,BigDecimal>> gather(List<TicketDto> list) {
        Map<VAT, BigDecimal> income = new HashMap<>();
        income.put(VAT.VAT_21, BigDecimal.ZERO);
        income.put(VAT.VAT_6, BigDecimal.ZERO);
        income.put(VAT.VAT_0, BigDecimal.ZERO);
        Map<VAT, BigDecimal> expenses = new HashMap<>();
        expenses.put(VAT.VAT_21, BigDecimal.ZERO);
        expenses.put(VAT.VAT_6, BigDecimal.ZERO);
        expenses.put(VAT.VAT_0, BigDecimal.ZERO);
        for(TicketDto t : list) {
            if(t.isIncome()) {
                put(t, income);
            } else {
                put(t, expenses);
            }
        }
        return Pair.of(income, expenses);
    }

    private static final BigDecimal MIDDLE = new BigDecimal(6);
    private void put(TicketDto t, Map<VAT, BigDecimal> map) {
        final int i = MIDDLE.compareTo(t.getVatRate());
        switch(i) {
            case 1: // 0
                map.put(VAT.VAT_0, t.getPrice().add(map.get(VAT.VAT_0)));
                break;
            case 0: // 6
                map.put(VAT.VAT_6, t.getPrice().add(map.get(VAT.VAT_6)));
                break;
            default: // 21
                map.put(VAT.VAT_21, t.getPrice().add(map.get(VAT.VAT_21)));
                break;
        }
    }

    private HSSFRichTextString toBold(String value) {
        final HSSFRichTextString bold = new HSSFRichTextString(value);
        bold.applyFont(Font.BOLDWEIGHT_BOLD);
        return bold;
    }

}
