//Test 1: Validate a user is able to add a category and once the category is added it should display.

package page;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCategoryPage extends BasePage {

	WebDriver driver;
	static String insertedCatagory;

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[1]")
	WebElement ADD_CATAGORY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[5]")
	WebElement CATAGORY_COLOR_DROP_DOWN;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")
	WebElement ADD_CATAGORY_BUTTON;

	public static String getInsertedCatagory() {
		return insertedCatagory;
	}

	public void insertCatagory(String catagory) {
		insertedCatagory = catagory + generateRandomNum(99);
		ADD_CATAGORY_ELEMENT.sendKeys(insertedCatagory);
		System.out.println("New catagory inserted is: " + insertedCatagory);
	}
	
	public void selectCategoryColor(String color) {
		selectFromDropDown(CATAGORY_COLOR_DROP_DOWN, color);
	}

	public void clickAddCatagoryButton() {
		ADD_CATAGORY_BUTTON.click();
	}

	String before_xpath = "/html/body/div[3]/a[";
	String after_xpath_name = "]/span";
	String displayedCategory = null;

	public void validateCatagoryAdded() {
		for (int i = 2;; i++) {
			try {
				displayedCategory = driver.findElement(By.xpath(before_xpath + i + after_xpath_name)).getText();
			} catch (NoSuchElementException e) {
				break;
			}			
		}
		System.out.println("Last added category shows on screen: " + displayedCategory);
		Assert.assertEquals(displayedCategory, insertedCatagory, "Catagory does not match.");

	}
}
