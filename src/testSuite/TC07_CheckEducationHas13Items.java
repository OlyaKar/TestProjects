package testSuite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.EducationPage;
import pages.HomePage;

public class TC07_CheckEducationHas13Items {

	private final int EXPECTED_EDUCATION_ITEMS_COUNT = 13;
	
	@Before 
	public void beforeTest() {
		Base.loadPage();
	}
	
	@After
	public void afterTest() {
		Base.closePage();
	}
	
	@Test
	public void checkEducationHas13ItemsUnder() {
		HomePage homePage = new HomePage(Base.driver);
		EducationPage educationPage = new EducationPage(Base.driver);
		
		homePage.clickEducation();
		
		assertEquals(EXPECTED_EDUCATION_ITEMS_COUNT, educationPage.educationElementsList().size());
	}
}
