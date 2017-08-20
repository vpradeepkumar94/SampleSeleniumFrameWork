/**
 * 
 */
package com.excels.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

   @SuppressWarnings("unused")
    private static final void readExcelFile(String filePath) {
		
		try(FileInputStream fis = new FileInputStream(new  File (filePath));
			Workbook workBook = new  XSSFWorkbook(fis); ) {
			
			Sheet sheet = workBook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.rowIterator();
			
			while (rowIterator.hasNext()) {
				
				Row currentRow = rowIterator.next();
				
				Iterator<Cell> cellIterator = currentRow.cellIterator();
				
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					Object val =   getCellValue(currentCell);
					System.out.println(currentCell.getRowIndex() + "---" + currentCell.getColumnIndex() + "--" + val + "|");
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
	private static final HashMap<String, Integer> readExcelFileByRow(String filePath,String id, String colName) {
		
		HashMap<String,Integer> cellInfo = new HashMap<String,Integer>();
		try(FileInputStream fis = new FileInputStream(new  File (filePath));
			Workbook workBook = new  XSSFWorkbook(fis); ) {
			
			Sheet sheet = workBook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.rowIterator();
			
			while (rowIterator.hasNext()) {
				
				Row currentRow = rowIterator.next();
				
				Iterator<Cell> cellIterator = currentRow.cellIterator();
				
			  	  while (cellIterator.hasNext()) {
				 	Cell currentCell = cellIterator.next();
					
					  if(currentCell.getCellTypeEnum() == CellType.STRING) {
						  boolean isRowMatches = ((String) getCellValue(currentCell)).equalsIgnoreCase(id);
						  if(isRowMatches){
								 cellInfo.put("RowNumber", currentCell.getRowIndex());
								 System.out.print("TestCase ID for : " + id + " "+ currentCell.getRowIndex());
						  } // Row number will be identified in this step
						  boolean isColMatches = ((String) getCellValue(currentCell)).equalsIgnoreCase(colName);
						  if(isColMatches){
								 cellInfo.put("ColNumber", currentCell.getColumnIndex());
								 System.out.print("TestCase ID for: " + colName + " " + currentCell.getColumnIndex());
						  } 
					  } // end of finding the cell index
				  } // end of cell Iterator
			 } // end of row Iterator
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		return cellInfo;
	}

	private final static Object getCellValue (Cell cell) {
		Object value;
		switch(cell.getCellTypeEnum()) {
			case BOOLEAN:  value  = cell.getBooleanCellValue();break;
			case NUMERIC:  value  = (int ) (cell.getNumericCellValue()); break;
			case STRING: 	 value  = cell.getStringCellValue();break;
			default: 		 value = 0;
		}
		return value;
	}
	
	@SuppressWarnings("unused")
	private final static  CellType getCellType (Cell cell) {
		return cell.getCellTypeEnum();
	}
	
	private final static void writeDataToExcel(String filePath, int sheetID, String TestCaseID,
			String colName,Object Value) {
		
		Workbook workBook = null;
		
		try(FileInputStream fis = new FileInputStream(new  File (filePath));) {
			
			workBook = new  XSSFWorkbook(fis);
		
			if( sheetID <= workBook.getNumberOfSheets() ) {
		    	Sheet sheet = workBook.getSheetAt(sheetID);
		    	
		    	 HashMap<String, Integer> rowInfo = readExcelFileByRow(filePath,TestCaseID,colName);
		    	 if( Value instanceof String) {
		    		 sheet.getRow(rowInfo.get("RowNumber")).createCell(rowInfo.get("ColNumber")).setCellType(CellType.STRING);
			    	 sheet.getRow(rowInfo.get("RowNumber")).createCell(rowInfo.get("ColNumber")).setCellValue((String) Value);
			    } else if (Value instanceof Integer) {
		    		 sheet.getRow(rowInfo.get("RowNumber")).createCell(rowInfo.get("ColNumber")).setCellType(CellType.NUMERIC);
			    	 sheet.getRow(rowInfo.get("RowNumber")).createCell(rowInfo.get("ColNumber")).setCellValue((int) Value);
		    	 } else if (Value instanceof Boolean) {
		    		 sheet.getRow(rowInfo.get("RowNumber")).createCell(rowInfo.get("ColNumber")).setCellType(CellType.BOOLEAN);
			    	 sheet.getRow(rowInfo.get("RowNumber")).createCell(rowInfo.get("ColNumber")).setCellValue((boolean) Value);
		    	 }
		    	
			} else {
				System.out.println("No such sheet exists in the " + filePath.substring(filePath.lastIndexOf(".")));
			}
		 } catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(FileOutputStream fos = new FileOutputStream(new File ("C:\\Users\\Vamsi\\Documents\\SampleData.xlsx"))) {
    		workBook.write(fos);
    	}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 static public  void main(String[] args) {
		final String fileName = "C:\\Users\\Vamsi\\Documents\\SampleData.xlsx";
		//readExcelFile(fileName);
		//readExcelFileByRow(fileName,"TC002","Status");
		writeDataToExcel(fileName,0,"TC001","Status","Pass");
		writeDataToExcel(fileName,0,"TC002","Status", 200);
		writeDataToExcel(fileName,0,"TC003","Status",true);
		writeDataToExcel(fileName,0,"TC004","Status","Passed");
	}

}
