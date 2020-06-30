package baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtilities {
	
	

	
	private static XSSFWorkbook  excelWB;
	private static XSSFSheet  excelWS;
	private static XSSFCell  cell;
	private static XSSFRow  row;
	
	
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		 
	    try {
	 
	 // Open the Excel file
	 
	 FileInputStream ExcelFile = new FileInputStream(Path);
	 
	 // Access the required test data sheet
	 
	 excelWB = new XSSFWorkbook(ExcelFile);
	 
	 excelWS = excelWB.getSheet(SheetName);
	 
	 } catch (Exception e){
	 
	 throw (e);
	 
	 }
	 
	 }
	
	public static  Object[][] exceldata(String testdatafile,String sheetname,int itestcaserow) throws Exception
	{
		Object [][]tabData=null;
		try 
		{
			FileInputStream file= new FileInputStream(testdatafile);
			excelWB =new XSSFWorkbook(file);
			excelWS= excelWB.getSheet(sheetname);

			//   int totalRows = 2;

			//   int totalCols = 5;
			   
		 	//   tabData=new String[totalRows][totalCols];
		      System.out.println("Row relevant "+itestcaserow);
			int ci=0;
			int cj=0;
			int j=0;
			int colcount=excelWS.getRow(itestcaserow).getLastCellNum();
			 tabData = new Object[1][1];

			
			   // Create Hashmap after every row iteration
			   HashMap<Object, Object> hm = new HashMap<Object, Object>();
			   for (int c = 0; c < colcount; c++) {
			    hm.put(excelWS.getRow(0).getCell(c).toString(), excelWS.getRow(itestcaserow).getCell(c).toString());

			   }

			   tabData[0][0] = hm;
		}
			   // Add every row in hashmap
		 catch (FileNotFoundException io)
		{
			System.out.println("Could not read the file");
		}
		catch(IOException io)
		{
			System.out.println("Could not read the file");
		}
		
		return tabData;
		//
		
	}
	
	public static  String getCellData(int i, int j) throws Exception
	{
		try {
			//System.out.println("Entering get cell data method");
			cell=excelWS.getRow(i).getCell(j);
			int datatype=cell.getCellType();
		//	System.out.println("Data type is " +datatype);
			if (datatype==3)
			{
				return "";
			}
			else
			{
				//System.out.println("Cell Value "+cell.getStringCellValue());
				return cell.getStringCellValue();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			throw e;
			
		}
		
	}
	
	
	public static  int getRowUsed() throws Exception
	{
		int rCount=excelWS.getLastRowNum();
		return rCount;
		
	}
	
/*	public static  String getTestCaseName(String sTestCase) throws Exception
	{
		String value=sTestCase;
		int posi=value.indexOf("@");
		value=value.substring(0, posi);
		System.out.println(value);
		posi=value.lastIndexOf(".");
		value=value.substring(posi+1);
		System.out.println(value);
				return value;
		
	}*/
	
	
	public static  int rowContains(String sTestCase,int colNum) throws Exception
	{
		int rCount=ExcelUtilities.getRowUsed();
		int m;
	
		for(m=0;m<=rCount;m++)
		{
			if ((ExcelUtilities.getCellData(m, colNum)).equalsIgnoreCase(sTestCase))
			{
				break;
			}
			
		}
		System.out.println("test case row num"+ m);
		return m;
		
	}
	
	

}
