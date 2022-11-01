package TestSuite;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Pages.HomePage;
import TestPackage.Utils;

public class CheckWhoWeServeItemsAmount {
	private int WHO_WE_SERVE_EXPECTED_ITEMS = 11;
	
	@Before 
	public void beforeTest() {
		Base.loadPage();
	}
	
	@After
	public void afterTest() {
		Base.closePage();
	}
	
	@Test
	public void checkWhoWeServeItemsAmount() {
		HomePage homePage = new HomePage(Base.driver);
		
		Utils.waitForSomeTime(2);
		
		assertEquals(WHO_WE_SERVE_EXPECTED_ITEMS, homePage.getWhoWeServeSize());
	}
}
