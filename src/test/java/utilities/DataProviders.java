package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//Data Provider 1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testdata\\Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("sheet1");
		int totalcols=xlutil.getCellcount("sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for (int i=1; i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j);
			}
		}
		
		return logindata;
	}
	
	//Data Provider 2
	
	//Data Provider 3

}
