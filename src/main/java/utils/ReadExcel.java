package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] readData(String fileName) throws IOException {
		// TODO Auto-generated method stub
		//Get into the Worksheet location
		XSSFWorkbook wb=new XSSFWorkbook("./data/"+fileName+".xlsx");
		//get into the sheet
		XSSFSheet sheet=wb.getSheet("Sheet1");
		//get into the row
		//XSSFRow row=sheet.getRow(1);
	int rowcount = sheet.getLastRowNum();
	short cellcount = sheet.getRow(0).getLastCellNum();
	String[][] data=new String[rowcount][cellcount];
	for (int i=1;i<=rowcount;i++)
	{
		for(int j=0;j<cellcount;j++)
		{
			String cellvalue=sheet.getRow(i).getCell(j).getStringCellValue();
			data[i-1][j]=cellvalue;
			System.out.println(cellvalue);
		}
	}
	
	
	wb.close();
	return data;
	
	}

}
