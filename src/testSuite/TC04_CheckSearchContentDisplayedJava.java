package testSuite;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import pages.HomePage;
import pages.SearchPage;
import utilsLib.Utils;

public class TC04_CheckSearchContentDisplayedJava {
	private String TEXT_TO_INPUT = "Java";
	
	private final String EXPECTED_JAVA = "Java";
	
	@Before 
	public void beforeTest() {
		Base.loadPage();
	}
	
	@After
	public void afterTest() {
		Base.closePage();
	}
	
	@Test
	public void checkContentDisplayedJava() {

		HomePage homePage = new HomePage(Base.driver);
		SearchPage searchPage = new SearchPage(Base.driver);
		
		homePage.clickSearchButton();
		
		Utils.waitForSomeTime(2);	
		
		List <WebElement> elemsTitleList = searchPage.findProductTitles();
		
		for(int i=0; i< elemsTitleList.size(); i++) {
			
			assertTrue( elemsTitleList.get(i).getAttribute("href").contains(EXPECTED_JAVA) );
		}
	}
}
