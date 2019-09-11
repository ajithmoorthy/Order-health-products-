package org.atmecs.practo.helper;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PractoHelper {
	public void click(String locators, WebDriver webdriver) {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locators)));
		WebElement click_operation = webdriver.findElement(By.xpath(locators));
		click_operation.click();
	}
	public WebDriver winhandler(WebDriver driver) {
		String window_array[]=new String[5];
		Set<String> windows=driver.getWindowHandles();
		int initial=0;
		for (String win:windows)
		{
			window_array[initial]=win;
		}
		driver=driver.switchTo().window(window_array[0]);
		return driver;
	}
	public void validater(WebDriver driver,String locators,String locator1,String prodname,String prodprice,String no_ofprod,String total) { 
		  try {
		  WebElement list=driver.findElement(By.xpath(locators));	 
		  String[] array=list.getText().split("\n"); 
		  String[] no_of_productstring=array[1].split(" ");
		  String no_of_product=no_of_productstring[2];
		  String productname=array[2]; 
		  String[] price1=array[5].split("");
		  String price2=price1[1]+price1[2]+price1[3];
		  String[] totelstring=array[10].split(" ");
		  String[] totalprices=totelstring[2].split("");
		  String totalprice=totalprices[1]+totalprices[2]+totalprices[3];
		  Assert.assertEquals(no_of_product,no_ofprod);
		  System.out.println("Successfully Verified the no of Products");
		  Assert.assertEquals(productname,prodname);
		  System.out.println("Successfully Verified the Product Name");
		  Assert.assertEquals(price2,prodprice);
		  System.out.println("Successfully Verified the Poduct Price");
		  Assert.assertEquals(totalprice,total);
		  System.out.println("Successfully Verified the Total Price");
		  
		  }
		  catch(AssertionError e) {
			  System.out.println("assertion error");
		  }
	  }
	public void correctUrlchecker(WebDriver driver,String expectedurl) {
		try {
		Assert.assertEquals(driver.getCurrentUrl(),expectedurl);
		System.out.println("User landed or Reached the correct webpage");
	}
		catch(AssertionError e) {
			System.out.println("Navigate to wrong Webpage");
		}	
		}
//	public void afterremove(WebDriver driver,String locators) {
//		try {
//			 WebElement ele=driver.findElement(By.xpath(locators));
//		ele.getText();
//		Assert.assertEquals(,prodnum);
//		  System.out.println("Successfully Verified the no of Products");
//		  Assert.assertEquals(productname,productname);
//		  System.out.println("Successfully Verified the Product Name");
//		  Assert.assertEquals(price2,prodprice);
//		  System.out.println("Successfully Verified the Poduct Price");
//		  Assert.assertEquals(totalprice,total);
//		  System.out.println("Successfully Verified the Total Price");
//		}
//		catch(AssertionError e)
//		{
//			
//			
//		}
//		
//	}
}
