package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EducationPage {
	private final By HEADER_SELECTOR = By.xpath("//html/body/main/div[2]/div/div/div[2]/div[2]/article/div/div[1]/h1[3]/span");
	private final By SIDE_PANEL_SELECTOR = By.className("side-panel");
	WebDriver driver;
	
	public EducationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String findHeaderText() {
		return driver.findElement(HEADER_SELECTOR).getText();
	}
	
	public List<WebElement> educationElementsList() {
	
		WebElement subjectsArea = driver.findElement(SIDE_PANEL_SELECTOR);
		List <WebElement> subjectsItemsList = new ArrayList <WebElement> (subjectsArea.findElements(By.tagName("li")));
		
		return subjectsItemsList;
	}
	
}
