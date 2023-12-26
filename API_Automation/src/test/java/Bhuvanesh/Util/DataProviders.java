package Bhuvanesh.Util;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="data")

	public String[][] getAllData() throws IOException{

	String path=System.getProperty("user.dir")+File.separator+"Input"+File.separator+"UserTestdata.xlsx"; 
	XLUtility xl=new XLUtility(path);

	int rownum=xl.getRowCount("Sheet1");

	int colcount=xl.getCellCount("Sheet1",1);

	String apidata[][]=new String[rownum][colcount];

	for(int i=1;i<=rownum;i++) {
		
	

	for(int j=0;j<colcount;j++) {
      if(xl.getCellData("Sheet1",j, i).equals("") ||xl.getCellData("Sheet1",j, i).isEmpty() || xl.getCellData("Sheet1",j, i)==null) {
    	  continue;
      }
	apidata[i-1][j]= xl.getCellData("Sheet1",j, i).split("\\.")[0];
	System.out.print("cell data"+xl.getCellData("Sheet1",j, i));

	}
	}
	for(int i=0;i<rownum;i++) {
		for(int j=0;j<colcount;j++) {
			System.out.println(apidata[i][j]);
		}
		System.out.println();
	}
	
	return apidata;

	
	}
	
	@DataProvider (name="UserNames")
	public String[] getUserNames() throws IOException
	{
	String path=System.getProperty("user.dir")+File.separator+"Input"+File.separator+"UserTestdata.xlsx";
	XLUtility xl=new XLUtility (path);
	int rownum=xl.getRowCount ("Sheet1");
	String apidata[]=new String[rownum];
	for (int i=1;i<=rownum; i++)
	{
	apidata[i-1]= xl.getCellData("Sheet1", 1, i);
	}
	return apidata;
}
}
