package org.atmecs.practo.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.practo.contstants.FileConstants;
import org.atmecs.practo.helper.PractoHelper;
import org.atmecs.practo.testbase.TestBase;
import org.atmecs.practo.utils.ExcelReader;
import org.atmecs.practo.utils.PropertiesReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PractoHome extends TestBase {
	ExcelReader excelread=new ExcelReader();
	PropertiesReader propread=new PropertiesReader();
	PractoHelper practohelp=new PractoHelper(); 
	@DataProvider(name = "pharmacy")
	public String[][] getfinal() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.returnLocator(FileConstants.expecteddata_file);
		return Excelarray;
	}
	
	@Test(priority=0,dataProvider="pharmacy")
	void practohome(String expectedurl,String prodname,String prodprice,String noofProd,String total) throws IOException, InterruptedException {
		Properties prop=propread.property(FileConstants.config_file);
		Properties prop1=propread.property(FileConstants.pharmacy_file);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		practohelp.click(prop1.getProperty("loc.menu.pharmacy.xpath"), driver);
		practohelp.click(prop1.getProperty("loc.imglink.painrelief.xpath"), driver);
		driver.close();
		driver=practohelp.winhandler(driver);
		practohelp.correctUrlchecker(driver,expectedurl);
		practohelp.click(prop1.getProperty("loc.submenu.fitness&wellness.xpath"), driver);
		practohelp.click(prop1.getProperty("loc.imglink.prodB-protein.xpath"), driver);
		driver.close();
		practohelp.winhandler(driver);
		practohelp.click(prop1.getProperty("loc.btn.addtocart.xpath"), driver);
		practohelp.click(prop1.getProperty("loc.btn.viewcart.xpath"), driver);
		practohelp.validater(driver,prop1.getProperty("loc.panel.proddetails.xpath"),prop1.getProperty("loc.panel.cart.xpath"),prodname,prodprice,noofProd,total);
		practohelp.click(prop1.getProperty("loc.linktxt.location.xpath"), driver);
		Thread.sleep(3000);
		practohelp.click(prop1.getProperty("loc.btn.removeitem.xpath"), driver); 
		//practohelp.afterremove(driver,prop.getProperty("loc.panel.proddetails.xpath"));
		driver.quit();
		
	}
}
