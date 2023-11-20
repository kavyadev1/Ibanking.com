package Ibanking.com.utilities;

	import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;

	public class XLUtils  {
	    public static void main(String[] args) {
	        try {
	            // Specify the path to your Excel file
	            String filePath = "path/to/your/excel/file.xlsx";

	            // Create a FileInputStream to read the Excel file
	            FileInputStream fileInputStream = new FileInputStream(new File(filePath));

	            // Create a Workbook instance
	            Workbook workbook = WorkbookFactory.create(fileInputStream);

	            // Specify the sheet you want to work with (e.g., "Sheet1")
	            Sheet sheet = workbook.getSheet("Sheet1");

	            // Get the total number of rows in the sheet
	            int rowCount = sheet.getLastRowNum() + 1; // Adding 1 because rows are 0-based

	            // Get the total number of cells in the first row (assuming all rows have the same number of cells)
	            int cellCount = sheet.getRow(0).getLastCellNum();

	            System.out.println("Total Rows: " + rowCount);
	            System.out.println("Total Cells in the first row: " + cellCount);

	            // Close the file input stream
	            fileInputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static int getRowCount(String path, String searchString) {
	        int rowCount = 0;

	        try {
	            FileInputStream fileInputStream = new FileInputStream(path);
	            Workbook workbook = new XSSFWorkbook(fileInputStream); // Assuming you're working with .xlsx files

	            Sheet sheet = workbook.getSheetAt(0); // You can change the index or sheet name as needed

	            for (Row row : sheet) {
	                for (Cell cell : row) {
	                    if (cell.getCellType() == CellType.STRING) {
	                        String cellValue = cell.getStringCellValue();
	                        if (cellValue.contains(searchString)) {
	                            rowCount++;
	                            break; // No need to continue checking the remaining cells in this row
	                        }
	                    }
	                }
	            }

	            fileInputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return rowCount;

		
	}
	    public static int getColumnCount(String path, String sheetName) {
	        int columnCount = 0;

	        try {
	            FileInputStream fileInputStream = new FileInputStream(path);
	            Workbook workbook = new XSSFWorkbook(fileInputStream); // Assuming you're working with .xlsx files

	            Sheet sheet = workbook.getSheet(sheetName); // Specify the sheet name

	            if (sheet != null) {
	                // Find the row with the most columns, as Excel files may have different column counts
	                for (Row row : sheet) {
	                    int currentColumnCount = row.getPhysicalNumberOfCells();
	                    if (currentColumnCount > columnCount) {
	                        columnCount = currentColumnCount;
	                    }
	                }
	            }

	            fileInputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return columnCount;
	    }
	    public static int getCellCount(String path, String sheetName, int rowNum) {
	        int cellCount = 0;

	        try {
	            FileInputStream fileInputStream = new FileInputStream(path);
	            Workbook workbook = new XSSFWorkbook(fileInputStream); // Assuming you're working with .xlsx files

	            Sheet sheet = workbook.getSheet(sheetName); // Specify the sheet name

	            if (sheet != null) {
	                Row row = sheet.getRow(rowNum); // Get the specified row

	                if (row != null) {
	                    cellCount = row.getPhysicalNumberOfCells();
	                }
	            }

	            fileInputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return cellCount;
	    }

	    public static String getCellContent(String path, String sheetName, int rowIndex, int columnIndex) {
	        String cellContent = null;

	        try {
	            FileInputStream fileInputStream = new FileInputStream(path);
	            Workbook workbook = new XSSFWorkbook(fileInputStream); // Assuming you're working with .xlsx files

	            Sheet sheet = workbook.getSheet(sheetName); // Specify the sheet name

	            if (sheet != null) {
	                Row row = sheet.getRow(rowIndex); // Get the specified row

	                if (row != null) {
	                    Cell cell = row.getCell(columnIndex); // Get the specified cell

	                    if (cell != null) {
	                        // Depending on the cell type, retrieve and format the cell content
	                        switch (cell.getCellType()) {
	                            case STRING:
	                                cellContent = cell.getStringCellValue();
	                                break;
	                            case NUMERIC:
	                                cellContent = String.valueOf(cell.getNumericCellValue());
	                                break;
	                            case BOOLEAN:
	                                cellContent = String.valueOf(cell.getBooleanCellValue());
	                                break;
	                            case BLANK:
	                                cellContent = ""; // Empty cell
	                                break;
	                            // Handle other cell types as needed
	                            default:
	                                cellContent = "Cell type not supported";
	                        }
	                    }
	                }
	            }

	            fileInputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return cellContent;
	    }
	}

