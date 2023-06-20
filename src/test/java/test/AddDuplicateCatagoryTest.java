//Test 2: Validate a user is not able to add a duplicated category. 
//If it does then the following message will display: "The category you want to add already exists: <duplicated category name>."

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddDuplicateCategoryPage;
import util.BrowserFactory;

public class AddDuplicateCatagoryTest {
	WebDriver driver;
	String catagory = "Duplicate";
	String color = "Purple";

	@Test
	public void noDuplicateCatagory() {
		driver = BrowserFactory.init();

		AddDuplicateCategoryPage addDuplicateCategoryPage = PageFactory.initElements(driver,
				AddDuplicateCategoryPage.class);
		addDuplicateCategoryPage.insertCatagory(catagory);
		addDuplicateCategoryPage.selectCategoryColor(color);
		addDuplicateCategoryPage.clickAddCatagoryButton();
		addDuplicateCategoryPage.insertCatagory(catagory);
		addDuplicateCategoryPage.clickAddCatagoryButton();
		addDuplicateCategoryPage.validateDuplicateHeaderMessage();
		addDuplicateCategoryPage.neverMindLink();
	}
}
