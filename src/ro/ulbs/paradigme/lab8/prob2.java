package ro.ulbs.paradigme.lab8;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class prob2 {

    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Grades");

        // Structura de date
        Map<String, Object[]> data = new TreeMap<>();
        data.put("2", new Object[]{"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[]{"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[]{"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[]{"Brian", "Schultz", 7, 6, 8, 9});

        // Font bold
        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true);

        // Stil pentru antet: bold + verde
        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(boldFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());


        // Stil pentru coloanele Max și Average: galben
        XSSFCellStyle yellowStyle = workbook.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Scriere antet
        String[] headers = {"Name", "Surname", "Grade 1", "Grade 2", "Grade 3", "Grade 4", "Max", "Average"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Scriere date + formule
        int rowNum = 1;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row = sheet.createRow(rowNum);
            Object[] rowData = entry.getValue();

            // Scrie numele, prenumele, notele
            for (int i = 0; i < rowData.length; i++) {
                Cell cell = row.createCell(i);
                if (rowData[i] instanceof String)
                    cell.setCellValue((String) rowData[i]);
                else if (rowData[i] instanceof Integer)
                    cell.setCellValue((Integer) rowData[i]);
            }

            int excelRow = rowNum + 1; // Excel e 1-based

            // Formula Max(Di:Gi)
            Cell maxCell = row.createCell(6);
            maxCell.setCellFormula(String.format("MAX(C%d:F%d)", excelRow, excelRow));
            maxCell.setCellStyle(yellowStyle);

            // Formula Average(Di:Gi)
            Cell avgCell = row.createCell(7);
            avgCell.setCellFormula(String.format("AVERAGE(C%d:F%d)", excelRow, excelRow));
            avgCell.setCellStyle(yellowStyle);

            rowNum++;
        }

        // Autosize pentru toate coloanele
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Salvare fisier
        try (FileOutputStream out = new FileOutputStream("prob2.xlsx")) {
            workbook.write(out);
            workbook.close();
            System.out.println("Fisierul output8.xlsx a fost generat cu succes.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
