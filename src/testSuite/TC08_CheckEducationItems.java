package testSuite;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import pages.EducationPage;
import pages.HomePage;

public class TC08_CheckEducationItems {

	private final int EXPECTED_EDUCATION_ITEMS_COUNT = 13;
	
	private final String[] EXPECTED_EducationList = {
			"Information & Library Science",
			"Education & Public Policy",
			"K-12 General",
			"Higher Education General",
			"Vocational Technology",
			"Conflict Resolution & Mediation (School settings)",
			"Curriculum Tools- General",
			"Special Educational Needs",
			"Theory of Education",
			"Education Special Topics",
			"Educational Research & Statistics",
			"Literacy & Reading",
			"Classroom Management"
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
	public void checkEducationContainsItems() {
		HomePage homePage = new HomePage(Base.driver);
		EducationPage educationPage = new EducationPage(Base.driver);
		
		homePage.clickEducation();
		
		List  <WebElement> subjectsItemsList = educationPage.educationElementsList();	
		
		for(int i=0; i< EXPECTED_EDUCATION_ITEMS_COUNT; i++)
		{
			assertTrue(subjectsItemsList.get(i).getText().equalsIgnoreCase(EXPECTED_EducationList[i]));
		}
	}
}
