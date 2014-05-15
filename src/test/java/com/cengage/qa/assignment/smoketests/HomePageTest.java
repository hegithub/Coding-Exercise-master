package com.cengage.qa.assignment.smoketests;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cengage.qa.assignment.pages.HomePage;

public class HomePageTest {

	protected HomePage homePage;
	protected static String HOME_PAGE_TITLE = "Cengage Learning - Learning solutions, training and educational publishing";

	@Before
	public void setUp() {
		homePage = new HomePage();
	}

	@After
	public void tearDown() {
		homePage.closeSession();
	}

	@Test
	public void verifyHomePageContainsCorrectDisplayElements() {
		assertThat(homePage.getTitle(), is(HOME_PAGE_TITLE));
	}

	/*
	 * Tests the number of links present for Product Information
	 */
	@Test
	public void testProductInformationForCount() {
		assertEquals(8, homePage.countMainTableColumnHeaders(
				"product-info-content", "a"));
	}

	/*
	 * Tests the number of links present for Connect
	 */
	@Test
	public void testConnectCount() {
		assertEquals(7,
				homePage.countMainTableColumnHeaders("connect-content", "a"));
	}

	/*
	 * Test if carousel are correctly displayed Match with the tiles below
	 */
	@Test
	public void testCarousel() {
		homePage.carousel();
	}

}
