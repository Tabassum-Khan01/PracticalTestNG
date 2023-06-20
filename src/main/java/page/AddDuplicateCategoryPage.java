//Test 2: Validate a user is not able to add a duplicated category. 
//If it does then the following message will display: "The category you want to add already exists: <duplicated category name>."

package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddDuplicateCategoryPage extends BasePage {
	WebDriver driver;

	public AddDuplicateCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[1]")
	WebElement ADD_CATAGORY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[5]")
	WebElement CATAGORY_COLOR_DROP_DOWN;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")
	WebElement ADD_CATAGORY_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'The category you want to add')]")
	WebElement DUPLICATE_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Nevermind']")
	WebElement NEVERMIND_LINK;

	public void insertCatagory(String category) {
		ADD_CATAGORY_ELEMENT.sendKeys(category);
		System.out.println("New category inserted is: " + category);
	}

	public void selectCategoryColor(String color) {
		selectFromDropDown(CATAGORY_COLOR_DROP_DOWN, color);
	}

	public void clickAddCatagoryButton() {
		ADD_CATAGORY_BUTTON.click();
	}

	public void validateDuplicateHeaderMessage() {
		waitForElement(driver, 10, DUPLICATE_HEADER_ELEMENT);
		Assert.assertTrue(DUPLICATE_HEADER_ELEMENT.isDisplayed(), "Duplicate header element is not displayed.");
		
	}

	public void neverMindLink() {
		NEVERMIND_LINK.click();
	}
}
