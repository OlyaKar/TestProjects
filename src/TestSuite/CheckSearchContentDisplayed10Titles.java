package TestSuite;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import Pages.SearchPage;
import TestPackage.Utils;

public class CheckSearchContentDisplayed10Titles {
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

		SearchPage searchPage = new SearchPage(Base.driver);
		
		searchPage.clickSearchButton(TEXT_TO_INPUT);
		
		Utils.waitForSomeTime(2);

		List <WebElement> javaTitleList = searchPage.getFoundItems();
		
		assertEquals(EXPECTED_ITEMS, javaTitleList.size());
	}
}
