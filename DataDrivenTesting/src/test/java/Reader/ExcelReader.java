package Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static Object[][] getLoginData(String filePath) {
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row
                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                data.add(new Object[]{username, password});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][]);
    }
	public static Object[][] getRegisterData(String filePath) {
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            
            XSSFSheet sheet = workbook.getSheetAt(1);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row
                String FirstName = row.getCell(0).getStringCellValue();
                String LastName = row.getCell(1).getStringCellValue();
                String Address = row.getCell(2).getStringCellValue();
                String City = row.getCell(3).getStringCellValue();
                data.add(new Object[]{FirstName, LastName, Address,City});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][]);
    }
}
