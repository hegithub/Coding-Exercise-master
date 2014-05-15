package com.cengage.qa.assignment.pages;

import static com.cengage.qa.assignment.Environment.DEFAULT_WAIT_TIME;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

	public static final long ONE_SECOND = 1000;

	protected WebDriver driver;
	protected WebElement element;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
		// waitForPageToLoad();
	}

	protected BasePage(String url) {
		createWebDriver();

		/*
		 * use navigate to instead of get to use the back, forward methods also
		 * no need for waitForPageToLoad() method, delays the test run
		 */
		// driver.get("http://" + url);

		driver.navigate().to("http://" + url);
		// waitForPageToLoad();
	}

	private void createWebDriver() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public WebDriverBackedSelenium getSeleniumHandle() {
		return new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void goBack() {
		getSeleniumHandle().goBack();
	}

	public void closeSession() {
		driver.quit();
	}

	public void waitForPageToLoad() {
		getSeleniumHandle().waitForPageToLoad(Long.toString(DEFAULT_WAIT_TIME));
	}

	/*
	 * Initially corrected the method for
	 * verifyNumberOfColumnsInAwardsGivenTable() in AwardsReceivedPageTest Class
	 * As the same method was used for HomePageTest also, moved it to BasePge
	 * Class
	 */

	// public String countMainTableColumnHeaders() {
	public int countMainTableColumnHeaders(String elementId,
			String elementTagName) {

		// String count;
		int count;

		WebElement tableArticles = driver.findElement(By.id(elementId));

		// added
		List<WebElement> tableAtriclesTotal = tableArticles.findElements(By
				.tagName(elementTagName));

		// count = tableArticles.getSize().toString();
		count = tableAtriclesTotal.size();

		return count;
	}

	/*
	 * Method same as above, only difference is, it check for className
	 * elementID
	 */
	public int countByClassName(String elementClassName, String elementTagName) {
		int count;
		WebElement tableArticles = driver.findElement(By
				.className(elementClassName));
		List<WebElement> tableAtriclesTotal = tableArticles.findElements(By
				.tagName(elementTagName));
		count = tableAtriclesTotal.size();
		return count;
	}

	/*
	 * Method same as above, only difference is, it check for className
	 * elementID
	 */
	public int countByXpath(String elementXpath, String elementTagName) {
		int count;
		WebElement tableArticles = driver.findElement(By.xpath(elementXpath));
		List<WebElement> tableAtriclesTotal = tableArticles.findElements(By
				.tagName(elementTagName));
		count = tableAtriclesTotal.size();
		return count;
	}

}