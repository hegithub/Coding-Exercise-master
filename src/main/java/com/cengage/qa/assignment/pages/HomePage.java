package com.cengage.qa.assignment.pages;

import static com.cengage.qa.assignment.Environment.PRODUCT_URL;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage() {
		super(PRODUCT_URL);
	}

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage(String url) {
		super(url);
	}

	public AwardsRewardedPage gotoAwardsReceivedPage() {
		driver.findElement(By.linkText("News")).click();
		driver.findElement(By.partialLinkText("Awards Received")).click();
		return new AwardsRewardedPage(driver);
	}

	/*
	 * Comments are where the code was giving an error The corrected code is
	 * written to make the test run successfully
	 */
	public AwardsGivenPage gotoAwardsGivenPage() {
		// driver.findElement(By.linkText("Awards Given")).click();
		driver.findElement(By.partialLinkText("Awards Given")).click();
		return new AwardsGivenPage(driver);
	}

	/*
	 * Test the carousel count, and test if they are correctly displayed
	 */
	public void carousel() {
		int carouselCount = countByClassName("carousel-indicators", "a");
		for (int i = 1; i <= carouselCount; i++) {
			String linkText = driver
					.findElement(
							By.xpath("//*[@id='super-hero']/section/ol/li[" + i
									+ "]/a")).getText();
			driver.findElement(
					By.xpath("//*[@id='super-hero']/section/ol/li[" + i + "]/a"))
					.click();
			String classAttribute = driver.findElement(
					By.xpath("//*[@id='super-hero']/section/ol/li[" + i + "]"))
					.getAttribute("class");
			if (classAttribute.equals("active")) {
				String carouselText = driver.findElement(
						By.xpath("//*[@id='super-hero']/div/div[" + i
								+ "]/div/div/h1/a")).getText();
				Assert.assertTrue("Carousel and Tile do not match",
						carouselText.equalsIgnoreCase(linkText));
			}
		}
	}

}
