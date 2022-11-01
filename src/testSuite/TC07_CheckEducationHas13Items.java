package TestSuite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Pages.EducationPage;

public class CheckEducationHas13Items {

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
		EducationPage educationPage = new EducationPage(Base.driver);
		
		assertEquals(EXPECTED_EDUCATION_ITEMS_COUNT, educationPage.educationElementsList().size());
	}
}
