package testSuite;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import pages.HomePage;
import pages.SearchPage;
import utilsLib.Utils;

public class TC05_CheckSearchContentDisplayed10Titles {
	private String TEXT_TO_INPUT = "Java";
	private int EXPECTED_ITEMS = 10;
	
	@Before 
	public void beforeTest() {
		Base.loadPage();
	}
	
	@After
	public void afterTest() {
		Base.closePage();
	}
	
	@Test
	public void checkContentDisplayed10Titles() {

		HomePage homePage = new HomePage(Base.driver);
		SearchPage searchPage = new SearchPage(Base.driver);
		
		homePage.fillSearchBar(TEXT_TO_INPUT);
		homePage.clickSearchButton();
		
		Utils.waitForSomeTime(2);

		List <WebElement> javaTitleList = searchPage.getFoundItems();
		
		assertEquals(EXPECTED_ITEMS, javaTitleList.size());
	}
}
