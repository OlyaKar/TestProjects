package testSuite;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.HomePage;
import utilsLib.Utils;

public class TC03_CheckSearchDisplaysRelatedContent {
	private String TEXT_TO_INPUT = "Java";

	@Before 
	public void beforeTest() {
		Base.loadPage();
	}
	
	@After
	public void afterTest() {
		Base.closePage();
	}
	
	@Test
	public void checkSearchDisplaysRelatedContent() {
		HomePage homePage = new HomePage(Base.driver);
		
		Utils.waitForSomeTime(2);
				
		homePage.fillSearchBar(TEXT_TO_INPUT);
		
		Utils.waitForSomeTime(2);							

		assertTrue(homePage.getRelatedContent().isDisplayed());
	}
}
