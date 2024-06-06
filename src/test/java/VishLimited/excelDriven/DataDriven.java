package VishLimited.excelDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<String>> getExcelData() throws IOException {

		// Fetch Path of the file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Data Source.xlsx");

		// Create excel object
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
		String fileName = System.getProperty("fileName") == null ? "credentials" : System.getProperty("fileName");

		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

		// Number of sheets in the excel
		int numberOfSheets = workBook.getNumberOfSheets();

		// Scanning all the sheets
		for (int i = 0; i < numberOfSheets; i++) {

			// Access sheet with name "credentials"
			if (workBook.getSheetName(i).equals(fileName)) {

				// Create sheet object
				XSSFSheet sheet = workBook.getSheetAt(i);

				// Fetch all rows
				Iterator<Row> rows = sheet.rowIterator();

				// Scan each row
				while (rows.hasNext()) {
					ArrayList<String> rowData = new ArrayList<String>();

					// Get present row
					Row row = rows.next();

					// Fetch all cells
					Iterator<Cell> cells = row.cellIterator();

					// Scan each cell
					while (cells.hasNext()) {

						// Get present cell
						Cell cell = cells.next();

						// Save the cell value
						rowData.add(cell.getCellType() == CellType.STRING ? cell.getStringCellValue()
								: NumberToTextConverter.toText(cell.getNumericCellValue()));
					}

					// Save the row value
					data.add(rowData);
				}
			}
		}

		// return data from excel
		return data;

	}

}
