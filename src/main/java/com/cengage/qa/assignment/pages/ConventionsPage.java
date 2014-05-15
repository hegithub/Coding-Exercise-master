package com.cengage.qa.assignment.pages;

import static com.cengage.qa.assignment.Environment.CONVENTIONS_URL;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConventionsPage extends BasePage {

	public ConventionsPage() {
		super(CONVENTIONS_URL);
	}

	public ConventionsPage(WebDriver driver) {
		super(driver);
	}

	public ConventionsPage(String url) {
		super(url);
	}

	public void paginationLinks() {
		int countTr = countByXpath(
				"//*[@id='content']/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody",
				"tr");
		String startXpath = "//*[@id='content']/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody/tr[";
		String endXpath = "]/td/a";
		for (int i = 4; i < countTr; i = i + 3) {
			String titles = driver.findElement(
					By.xpath(startXpath + i + endXpath)).getText();
			driver.findElement(By.xpath(startXpath + i + endXpath)).click();
			String title = driver
					.findElement(
							By.xpath("//*[@id='content']/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td/span"))
					.getText();
			Assert.assertTrue("Links do not match",
					titles.equalsIgnoreCase(title));
			driver.navigate().back();
		}
	}
}
