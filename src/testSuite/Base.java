package testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static final String MAIN_PAGE_URL = "https://www.wiley.com/en-ie";
	public static final String DRIVER_PATH = "C:\\Users\\User\\eclipse-workspace\\WebDriver\\chromedriver.exe";

	public static WebDriver driver;
	
	public static void closePage() {
		driver.close();
		driver.quit();
	}
	
	public static void loadPage() {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver();
		driver.get(MAIN_PAGE_URL);
	}
}
