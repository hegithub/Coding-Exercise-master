package com.cengage.qa.assignment.smoketests;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cengage.qa.assignment.pages.ConventionsPage;

public class ConventionsPageTest {

	protected ConventionsPage conventionsPage;
	protected static String CONVENTIONS_PAGE_TITLE = "Conventions Finder";

	@Before
	public void setUp() {
		conventionsPage = new ConventionsPage();
	}

	@After
	public void tearDown() {
		conventionsPage.closeSession();
	}

	/*
	 * Test title of the page. Check if the correct page is opened
	 */
	@Test
	public void verifyConventionsPageContainsCorrectDisplayElements() {
		assertThat(conventionsPage.getTitle(), is(CONVENTIONS_PAGE_TITLE));
	}

	/*
	 * 
	 */
	@Test
	public void testPaginationLinks() {
		conventionsPage.paginationLinks();
	}

}
