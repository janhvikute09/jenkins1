package CommonUtils;

import java.io.FileInputStream;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

		public String getDataFromExcelFile(String Sheetname,int Rownum,int Cellnum) throws EncryptedDocumentException
			{
				
				FileInputStream fis	= new FileInputStream("src\\test\\resources\\janhvi.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(Sheetname);
				Row rw = sh.getRow(Rownum);
				Cell cl = rw.getCell(Cellnum);
				String value = cl.getStringCellValue();
				return value;

			}

	}


