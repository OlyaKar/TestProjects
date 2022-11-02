package testSuite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.HomePage;
import utilsLib.Utils;

public class TC02_CheckWhoWeServeContainsItems {
	
	
	private final String[] EXPECTED_WhoWeServeList = {
			"Students", 
			"Instructors",
			"Book Authors",
			"Professionals",
			"Researchers",
			"Institutions",
			"Librarians",
			"Corporations",
			"Societies",
			"Journal Editors",
			"Government"
		};
	
	@Before 
	public void beforeTest() {
		Base.loadPage();
	}

	@After
	public void afterTest() {
		Base.closePage();
	}
	
	@Test
	public void checkWhoWeServeContainsCertainItems() {
		
		int EXPECTED_ITEMS = 11;
		
		HomePage homePage = new HomePage(Base.driver);
		
		Utils.waitForSomeTime(2);
		
		for(int i=0; i< EXPECTED_ITEMS; i++) {
			assertEquals(EXPECTED_WhoWeServeList[i].toUpperCase(),homePage.whoWeServed_elemTitle().get(i).getText().toUpperCase());
		}
	}
}
