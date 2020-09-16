package utilities.excel_reader;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.property.PropertyManager;

public class ExcelFileReader {

    public static String getArrayFromExcel(String fileName) throws Exception {
        XSSFWorkbook excelBook = new XSSFWorkbook(new FileInputStream(PropertyManager.getInstance().getTestingFiles() + fileName));
        XSSFSheet excelSheet = excelBook.getSheet("Sheet1");

        ArrayList<String> stringifiedRows = new ArrayList<>();
        for (Row row : excelSheet) {
            int colNums = row.getLastCellNum();
            ArrayList<String> parsedRow = new ArrayList<>();
            String rowString;

            for (int i = 0; i < colNums; i++) {
                Cell column = row.getCell(i);

                if (column != null) {
                    String text = column.getStringCellValue();

                    if (text.equals("null")) {
                        parsedRow.add("  ");
                    } else {
                        parsedRow.add(text);
                    }
                } else {
                    parsedRow.add("  ");
                }
            }
            StringBuilder buffer = new StringBuilder();

            int length = parsedRow.size();

            for (String s : parsedRow) {
                buffer.append(s);
            }

            rowString = buffer.toString();
            stringifiedRows.add(rowString);
        }

        StringBuilder buffer = new StringBuilder();

        int length = stringifiedRows.size();

        for (String stringifiedRow : stringifiedRows) {
            buffer.append(stringifiedRow);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
