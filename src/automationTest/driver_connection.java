package automationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class driver_connection {

	public WebDriver driver;
	
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\KASHYAP_RAJYAGURU\\eclipse-workspace\\automationTest\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		return driver;
	}
}
