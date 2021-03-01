package resources;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataForEditField()
	{
		//two sets of data "hello", "@#$"
		Object[][] obj=new Object[][]
		{
		  {"hello"},{"#$%"}
			
		};
	return obj;
		
	}
}
