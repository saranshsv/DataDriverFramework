package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class AddCustomerTest extends TestBase{

	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode) {
		log.debug("Inside Add Customer Test");
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
	}
	
	@DataProvider
	public Object[][] getData(){
		String sheetName="AddCustomerTest";
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		
		Object[][] data=new Object[rows-1][cols];
		
		for(int rowNum=2;rowNum<=rows;rowNum++) {
			for(int colNum=0;colNum<=cols;colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName,colNum,rowNum);
			}
		}
		return data;
	}
}
