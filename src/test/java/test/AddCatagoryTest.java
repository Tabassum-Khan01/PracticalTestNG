//Test 1: Validate a user is able to add a category and once the category is added it should display.

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import util.BrowserFactory;

public class AddCatagoryTest{
	WebDriver driver;
	
	String catagory = "Jenkins";
	String color = "Green";
	
	@Test
	public void userCanAddCatagory() {
		driver = BrowserFactory.init();
		
		AddCategoryPage addCategoryPage = PageFactory.initElements(driver, AddCategoryPage.class);
		addCategoryPage.insertCatagory(catagory);
		addCategoryPage.selectCategoryColor(color);
		addCategoryPage.clickAddCatagoryButton();
		addCategoryPage.validateCatagoryAdded();
	}
}
