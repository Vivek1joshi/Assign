package ReadExcelData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataConfig {

    HSSFWorkbook wb;
    HSSFSheet sheet;
    HSSFRow rows;
    HSSFCell cell;

    public ExcelDataConfig(String excelPath) throws IOException {
        try {
            File src = new File(excelPath);
            FileInputStream file = new FileInputStream(src);
            wb = new HSSFWorkbook(file);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetNumber, int row,int column){
        sheet = wb.getSheetAt(sheetNumber);
        rows = sheet.getRow(row);
        cell = rows.getCell(column);
        DataFormatter dataFormatter = new DataFormatter();
        String data;
        try{
            data = dataFormatter.formatCellValue(cell);
        }
        catch (Exception e) {
            data="";
        }
        return data;
    }

    public int getRowCount(int sheetIndex){
        sheet = wb.getSheetAt(sheetIndex);
        int row = sheet.getLastRowNum();
        return row;
    }

    public int getCellCount(int sheetIndex, int rownum){
        rows = wb.getSheetAt(sheetIndex).getRow(rownum);
        int cellCount = rows.getLastCellNum();
        return cellCount;
    }
}
