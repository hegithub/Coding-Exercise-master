package com.cengage.qa.assignment.pages;

//import static com.cengage.qa.assignment.Environment.DEFAULT_WAIT_TIME;

//import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.WebElement;

public class AwardsGivenPage extends BasePage {

	protected AwardsGivenPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Initially corrected the method for
	 * verifyNumberOfColumnsInAwardsGivenTable() in AwardsReceivedPageTest Class
	 * As the same method was used for HomePageTest also, moved it to BasePge
	 * Class
	 * 
	 * 
	 * public void waitForPageToLoad() {
	 * getSeleniumHandle().waitForPageToLoad(Long.toString(DEFAULT_WAIT_TIME));
	 * }
	 * 
	 * 
	 * // public String countMainTableColumnHeaders() { public int
	 * countMainTableColumnHeaders() {
	 * 
	 * // String count; int count;
	 * 
	 * WebElement tableArticles = driver.findElement(By.id("articles"));
	 * 
	 * // added List<WebElement> tableAtriclesTotal =
	 * tableArticles.findElements(By.tagName("tr"));
	 * 
	 * // count = tableArticles.getSize().toString(); count =
	 * tableAtriclesTotal.size();
	 * 
	 * return count; }
	 */
}
