package testSuite;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.EducationPage;
import pages.HomePage;

public class TC06_CheckEducationHeaderIsDisplayed {
	
	private final String EXPECTED_STRING = "EDUCATION";
	
	@Before 
	public void beforeTest() {
		Base.loadPage();
	}
	
	@After
	public void afterTest() {
		Base.closePage();
	}
	
	@Test
	public void checkEducationHeaderIsDisplayed() {

		HomePage homePage = new HomePage(Base.driver);
		EducationPage educationPage = new EducationPage(Base.driver);
		
		homePage.clickEducation();
		
		assertTrue(educationPage.findHeaderText().equalsIgnoreCase(EXPECTED_STRING));
	}	
}
