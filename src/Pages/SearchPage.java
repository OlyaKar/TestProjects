package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends HomePage {
	private final By PRODUCT_CLASS = By.className("product-item");
	private final By PRODUCT_TITLE_CLASS = By.className("product-title").tagName("a");
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public List <WebElement> getFoundItems() {
		List <WebElement> javaTitleList = new ArrayList <WebElement> (driver.findElements(PRODUCT_CLASS));
		
		return javaTitleList;
	}
	
	public List <WebElement> findProductTitles() {
		List <WebElement> javaTitleList = getFoundItems();
		List <WebElement> elemTitleList = new ArrayList<>();
		
		for(int i=0; i< javaTitleList.size(); i++) {
			elemTitleList.add(javaTitleList.get(i).findElement(PRODUCT_TITLE_CLASS));	
		}
		
		return elemTitleList;
	}
	
	
	
}
