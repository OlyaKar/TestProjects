package TestPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class TestScript {
	public final String MAIN_PAGE_URL = "https://www.wiley.com/en-ie";
	public WebDriver driver;
	public final String DRIVER_PATH = "C:\\Users\\Olchik\\WebDriver\\chromedriver.exe";
	
	private final By SEARCH_BAR_ID = By.id("js-site-search-input");
	private final By SEARCH_BUTTON_CLASS = By.className("input-group-btn");
	private final By PRODUCT_CLASS = By.className("product-item");
	private final By NAV_BAR_XPATH = By.xpath("//*[@id='main-header-navbar']/ul[1]/li[2]/a");
	private final By EDUCATION_XPATH = By.xpath("//*[@id=\"Level1NavNode2\"]/ul/li[9]/a");
	private final By SIDE_PANEL_CLASS = By.className("side-panel");
	private final By WHO_WE_SERVE_CLASS = By.className("who-we-serve-block");
	private final By WHO_WE_SERVE_TITLE_CLASS = By.className("who-we-serve-block-title");
	private final By SEARCH_CONTENT_CLASS = By.className("search-highlight");
	private final By PRODUCT_TITLE_CLASS = By.className("product-title").tagName("a");
	private final By HEADER_XPATH = By.xpath("//html/body/main/div[2]/div/div/div[2]/div[2]/article/div/div[1]/h1[3]/span");
	private final By BTN_BOOKS_CLASS = By.className("productButtonGroupName");
	private final By BTN_ADD_TO_CARD_CLASS = By.className("add-to-cart-button");
	private final By BTN_LEARN_MORE_CLASS = By.className("learn-more-button");
	
	private final String EXPECTED_JAVA = "Java";
	private final String EXPECTED_EBOOK = "E-Book";
	private final String EXPECTED_PRINT = "Print";
	private final String EXPECTED_OBOOK = "O-Book";
	private final int EXPECTED_EDUCATION_ITEMS_COUNT = 13;
	private final String EXPECTED_STRING = "EDUCATION";
	private final String[] EducationList = {"Information & Library Science"
			, "Education & Public Policy"
			, "K-12 General"
			, "Higher Education General"
			, "Vocational Technology"
			, "Conflict Resolution & Mediation (School settings)"
			, "Curriculum Tools- General"
			, "Special Educational Needs"
			, "Theory of Education"
			, "Education Special Topics"
			, "Educational Research & Statistics"
			, "Literacy & Reading"
			, "Classroom Management"};
	
	public void waitForSomeTime(int seconds){
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Before 
	public void loadPage(){
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver();
		driver.get(MAIN_PAGE_URL);
	}
	
	@After
	public void closePage(){
		driver.close();
		driver.quit();
	}
	
	public void fillSearchBar(String text) {
		waitForSomeTime(2);
		WebElement searchInputIs = driver.findElement(SEARCH_BAR_ID);
		searchInputIs.sendKeys(text);
	} 
	
	public void clickSearchButton() {
		fillSearchBar(EXPECTED_JAVA);
		WebElement btnSearch = driver.findElement(SEARCH_BUTTON_CLASS);
		btnSearch.click();
	}
	
	public List <WebElement> getFoundItems() {
		List <WebElement> javaTitleList = new ArrayList <WebElement> (driver.findElements(PRODUCT_CLASS));
		
		return javaTitleList;
	}
	
	public void clickEducation(){
		WebElement elemSubjects = driver.findElement(NAV_BAR_XPATH);
		Actions builder = new Actions(driver);
		builder.moveToElement(elemSubjects).build().perform();
		waitForSomeTime(2);
		WebElement elemEducation = driver.findElement(EDUCATION_XPATH);
		elemEducation.click();
	}
	
	public List<WebElement> educationElementsList() {
		clickEducation();		
		WebElement subjectsArea = driver.findElement(SIDE_PANEL_CLASS);
		List <WebElement> subjectsItemsList = new ArrayList <WebElement> (subjectsArea.findElements(By.tagName("li")));
		
		return subjectsItemsList;
	}
	
	@Test
	public void checkWhoWeServeHas11Items() {
		int EXPECTED_ITEMS = 11;
		waitForSomeTime(2);
		List <WebElement> whoWeServed = new ArrayList <WebElement> (
				driver.findElements(WHO_WE_SERVE_CLASS));
		
		assertEquals(EXPECTED_ITEMS,whoWeServed.size());
	}
	
	@Test
	public void checkWhoWeServeContainsCertainItems() {
		String[] WhoWeServeList = {
				"Students"
				, "Instructors"
				, "Book Authors"
				, "Professionals"
				, "Researchers"
				, "Institutions"
				, "Librarians"
				, "Corporations"
				, "Societies"
				, "Journal Editors"
				, "Government"};
		int EXPECTED_ITEMS = 11;
		waitForSomeTime(2);
		List <WebElement> whoWeServed_elemTitle = new ArrayList <WebElement> (
				driver.findElements(WHO_WE_SERVE_TITLE_CLASS));
		
		for(int i=0; i< EXPECTED_ITEMS; i++) {
			assertEquals(WhoWeServeList[i].toUpperCase(),whoWeServed_elemTitle.get(i).getText().toUpperCase());
		}
	}

	@Test
	public void checkSearchResultsDisplayJava() {
		fillSearchBar(EXPECTED_JAVA);
		waitForSomeTime(2);							
		List <WebElement> searchJava_results = new ArrayList <WebElement> (
				driver.findElements(SEARCH_CONTENT_CLASS) );
		
		for(int i=0; i< searchJava_results.size(); i++) {
			assertTrue(searchJava_results.get(i).getText().equalsIgnoreCase(EXPECTED_JAVA));
		}
	}

	@Test
	public void checkContentDisplayedJava() {
		clickSearchButton();
		List <WebElement> javaTitleList = getFoundItems();
		
		for(int i=0; i< javaTitleList.size(); i++) {
			WebElement elemTitle = javaTitleList.get(i).findElement(PRODUCT_TITLE_CLASS);	
			assertTrue(elemTitle.getAttribute("href").contains(EXPECTED_JAVA));
		}
	}
	
	@Test
	public void checkContentDisplayed10Titles() {
		int EXPECTED_ITEMS = 10;		
		clickSearchButton();
		List <WebElement> javaTitleList = getFoundItems();
		
		assertEquals(EXPECTED_ITEMS, javaTitleList.size());
	}
	
	@Test
	public void checkListHasButtons() {
		clickSearchButton();
		
		List <WebElement> javaTitleList = getFoundItems();

		for(int i=0; i< javaTitleList.size(); i++) {
			List <WebElement> labelOnBtnForElemList = new ArrayList <WebElement> (
					javaTitleList.get(i).findElements(BTN_BOOKS_CLASS));
					
					for(int j=0; j<labelOnBtnForElemList.size(); j++)
					{
						if (labelOnBtnForElemList.get(j).getText().equalsIgnoreCase(EXPECTED_EBOOK) ||
								labelOnBtnForElemList.get(j).getText().equalsIgnoreCase(EXPECTED_PRINT))
						{
							try {
								javaTitleList.get(i).findElement(BTN_ADD_TO_CARD_CLASS);
								assertTrue(true);
							} 
							catch (NoSuchElementException e) {
								assertTrue(false);
							}
						}
						else if (labelOnBtnForElemList.get(j).getText().equalsIgnoreCase(EXPECTED_OBOOK))
						{
							try {
								javaTitleList.get(i).findElement(BTN_LEARN_MORE_CLASS);
								assertTrue(true);
							} 
							catch (NoSuchElementException e) {
								assertTrue(false);
							}
						}
						else continue;
					}
				}
	}
	
	@Test
	public void checkEducationHeaderIsDisplayed() {
		clickEducation();
		String findHeaderText = driver.findElement(HEADER_XPATH).getText();
		
		assertTrue(findHeaderText.equalsIgnoreCase(EXPECTED_STRING));
	}
	
	@Test
	public void checkEducationHas13ItemsUnder() {
		assertEquals(EXPECTED_EDUCATION_ITEMS_COUNT, educationElementsList().size());
	}
	
	@Test
	public void checkEducationContainsItems() {
		List  <WebElement> subjectsItemsList = educationElementsList();	
		
		for(int i=0; i< EXPECTED_EDUCATION_ITEMS_COUNT; i++)
		{
			assertTrue(subjectsItemsList.get(i).getText().equalsIgnoreCase(EducationList[i]));
		}
	}
}
