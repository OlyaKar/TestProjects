package TestSuite;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Pages.EducationPage;

public class CheckEducationHeaderIsDisplayed {
	
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
		
		EducationPage educationPage = new EducationPage(Base.driver);
		educationPage.clickEducation();
		
		assertTrue(educationPage.findHeaderText().equalsIgnoreCase(EXPECTED_STRING));
	}	
}
