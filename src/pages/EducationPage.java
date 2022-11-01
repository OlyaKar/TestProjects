package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EducationPage extends HomePage {
	private final By HEADER_XPATH = By.xpath("//html/body/main/div[2]/div/div/div[2]/div[2]/article/div/div[1]/h1[3]/span");
	private final By SIDE_PANEL_CLASS = By.className("side-panel");
	
	public EducationPage(WebDriver driver) {
		super(driver);
	}
	
	public String findHeaderText() {
		return driver.findElement(HEADER_XPATH).getText();
	}
	
	public List<WebElement> educationElementsList() {
		clickEducation();		
		WebElement subjectsArea = driver.findElement(SIDE_PANEL_CLASS);
		List <WebElement> subjectsItemsList = new ArrayList <WebElement> (subjectsArea.findElements(By.tagName("li")));
		
		return subjectsItemsList;
	}
	
}
