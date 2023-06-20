package page;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public int generateRandomNum(int boundNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundNum);
		return generatedNum;

	}

	public void selectFromDropDown(WebElement element, String visibleText) {

		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	public void waitForElement(WebDriver driver, int waitTime, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	Date d = new Date(1);
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
	String date = formatter.format(d);
	String splitter[] = date.split("-");
	String month_year = splitter[1];
	String day = splitter[0];

}
