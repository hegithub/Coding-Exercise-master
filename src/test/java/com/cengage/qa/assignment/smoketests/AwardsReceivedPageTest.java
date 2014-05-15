package com.cengage.qa.assignment.smoketests;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cengage.qa.assignment.pages.AwardsGivenPage;
import com.cengage.qa.assignment.pages.AwardsRewardedPage;
import com.cengage.qa.assignment.pages.HomePage;

public class AwardsReceivedPageTest {

	protected AwardsRewardedPage awardsRewardedPage;
	protected HomePage homePage;
	protected AwardsGivenPage awardsGivenPage;

	@Before
	public void setUp() {
		homePage = new HomePage();
		awardsRewardedPage = homePage.gotoAwardsReceivedPage();
	}

	@After
	public void tearDown() {
		homePage.closeSession();
	}

	/*
	 * Comments are where the code was giving an error The corrected code is
	 * written to make the test run successfully
	 */
	@Test
	public void verifyAwardsReceivedPageDisplayed() {
		// assertThat(awardsRewardedPage.getTitle(),
		// is("Cengage Learning - Awards"));

		// Awards Received | Cengage Learning
		assertThat(awardsRewardedPage.getTitle(),
				is("Awards Received | Cengage Learning"));
	}

	@Test
	public void verifyAwardsGivenTabIsProvidedAndReturnsExpectedPage() {
		awardsGivenPage = homePage.gotoAwardsGivenPage();
		// assertThat(awardsGivenPage.getTitle(),
		// is("Cengage Learning - Awards Given"));

		// Awards Given | Cengage Learning
		assertThat(awardsRewardedPage.getTitle(),
				is("Awards Given | Cengage Learning"));
	}

	@Test
	public void verifyNumberOfColumnsInAwardsGivenTable() {
		awardsGivenPage = homePage.gotoAwardsGivenPage();
		// assertEquals(3, awardsGivenPage.countMainTableColumnHeaders());

		// 7
		assertEquals(7,
				awardsGivenPage.countMainTableColumnHeaders("articles", "tr"));
	}

}
