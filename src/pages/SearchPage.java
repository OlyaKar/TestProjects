package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	private final By PRODUCT_SELECTOR = By.className("product-item");
	private final By PRODUCT_TITLE_SELECTOR = By.className("product-title").tagName("a");
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List <WebElement> getFoundItems() {
		List <WebElement> javaTitleList = new ArrayList <WebElement> (driver.findElements(PRODUCT_SELECTOR));
		
		return javaTitleList;
	}
	
	public List <WebElement> findProductTitles() {
		List <WebElement> javaTitleList = getFoundItems();
		List <WebElement> elemTitleList = new ArrayList<>();
		
		for(int i=0; i< javaTitleList.size(); i++) {
			elemTitleList.add(javaTitleList.get(i).findElement(PRODUCT_TITLE_SELECTOR));	
		}
		
		return elemTitleList;
	}
	
	
	
}
