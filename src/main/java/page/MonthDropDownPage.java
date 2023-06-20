//Test 3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.

package page;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MonthDropDownPage extends BasePage{
	WebDriver driver;
	
	public MonthDropDownPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[3]")
	WebElement MONTH_DROP_DOWN;
	
	public void validateMonthDropDown() {
		List<String> expectedMonths = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"); 
		//asList method converts an array to a fixed size list object,
		
		Select sel = new Select(MONTH_DROP_DOWN);
		List<WebElement> actualMonthOptions = sel.getOptions(); 
		//getOptions() gets all options belonging to a select tag
		
		for (WebElement optionAppears : actualMonthOptions) {
			System.out.println(optionAppears.getText());
		}

		for(String month : expectedMonths) {
			boolean monthFound = false;
			
			for(WebElement optionAppears : actualMonthOptions) {
				if (optionAppears.getText().equals(month)) {		
					monthFound = true;
					break;
				}					
			}
			Assert.assertTrue(monthFound, "Month not found: " + month);
		}	
	}
	
	public void selectMonth(String month) {
		selectFromDropDown(MONTH_DROP_DOWN, month);
	}
}
