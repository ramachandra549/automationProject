package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path =".//testData//Opencart_LoginData.xlsx";	//Taking xl file from the test data
		
		ExcelUtility xlUtil=new ExcelUtility(path);		//creating an object for Excel utility file
		int totalRows=xlUtil.getRowCount("Sheet1");
		int totalColo=xlUtil.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[totalRows][totalColo];		//created for two dimensional array
		
		for(int i=1;i<=totalRows;i++)	//1  	read the data xl 
		{
			for(int j=0;j<totalColo;j++)	//0 i is rows, j is columns
			{
				loginData[i-1][j]=xlUtil.getCellData("Sheet1", i, j);	//1,0
			}
		}
		
		return loginData;	//returns two dimension array
	}
	
	
	
	
	
}
