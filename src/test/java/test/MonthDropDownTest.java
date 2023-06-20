//Test 3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.MonthDropDownPage;
import util.BrowserFactory;

public class MonthDropDownTest {
	WebDriver driver;
	
	String month = "Jul";
	
	@Test
	public void userCanSelectMonth() {
		driver = BrowserFactory.init();
		
		MonthDropDownPage dateDropDownPage = PageFactory.initElements(driver, MonthDropDownPage.class);
		dateDropDownPage.validateMonthDropDown();
		dateDropDownPage.selectMonth(month);
	}
}
