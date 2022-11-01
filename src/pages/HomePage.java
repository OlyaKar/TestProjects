package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import TestPackage.Utils;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private final By WHO_WE_SERVE_CLASS = By.className("who-we-serve-block");
	private final By SEARCH_BAR_ID = By.id("js-site-search-input");
	private final By SEARCH_BUTTON_CLASS = By.className("input-group-btn");
	private final By SEARCH_RELATED_CONTENT_CLASS = By.className("search-related-content");
	private final By WHO_WE_SERVE_TITLE_CLASS = By.className("who-we-serve-block-title");
	
	private final By NAV_BAR_XPATH = By.xpath("//*[@id='main-header-navbar']/ul[1]/li[2]/a");
	private final By EDUCATION_XPATH = By.xpath("//*[@id=\"Level1NavNode2\"]/ul/li[9]/a");
	
	public int getWhoWeServeSize() {
		return driver.findElements(WHO_WE_SERVE_CLASS).size();
	}
	
	public List<WebElement> whoWeServed_elemTitle() {
		return driver.findElements(WHO_WE_SERVE_TITLE_CLASS);
	}
	
	public void fillSearchBar(String text) {
		driver.findElement(SEARCH_BAR_ID).sendKeys(text);
	}
	
	public WebElement getRelatedContent() {
		return driver.findElement(SEARCH_RELATED_CONTENT_CLASS);
	}
	
	public void clickSearchButton(String text) {
		fillSearchBar(text);
		WebElement btnSearch = driver.findElement(SEARCH_BUTTON_CLASS);
		btnSearch.click();
	}

	public void clickEducation(){
		WebElement elemSubjects = driver.findElement(NAV_BAR_XPATH);
		
		Actions builder = new Actions(driver);
		builder.moveToElement(elemSubjects).build().perform();
		
		Utils.waitForSomeTime(2);
		
		WebElement elemEducation = driver.findElement(EDUCATION_XPATH);
		elemEducation.click();
	}
}
