package automationTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registration {

	WebDriver driver;

	public registration(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signInlink;
	
	@FindBy(id="email_create")
	WebElement createemail;
	
	@FindBy(id="SubmitCreate")
	WebElement signUpLink;
		
	@FindBy(id="uniform-id_gender1")
	WebElement gender_male;

	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement Password;

	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="firstname")
	WebElement addressfirstname;
	
	@FindBy(id="lastname")
	WebElement addresslastname;
	
	@FindBy(id="address1")
	WebElement addressaddress1;
	
	@FindBy(id="city")
	WebElement addresscity;

	@FindBy(id="id_state")
	WebElement addressstate;
	
	@FindBy(id="postcode")
	WebElement addresspostcode;
	
	@FindBy(id="id_country")
	WebElement addresscountry;
	
	@FindBy(id="phone_mobile")
	WebElement addressmobile;
	
	@FindBy(id="alias")
	WebElement addressalias;
	
	@FindBy(id="submitAccount")
	WebElement registerbutton;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	@FindBy(id="CustomerEmail")
	WebElement loginEmail;
	
	@FindBy(xpath=".//*[@id='CustomerPassword']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='customer_login']/p[1]/input")
	WebElement clickOnSignIn;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	WebElement logout;
	
	@FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
	WebElement myaccountBreadcrum;
	
	public void selectDropdownValue(WebElement element, String value ) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}
	
	public void registorUser(String firstName, String lastName, String emailAddress, String password){
		
		signInlink.click();
		
		createemail.clear();
		createemail.sendKeys(emailAddress);
		signUpLink.click();
		waitForElement(gender_male, 10);
		gender_male.click();
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		email.clear();
		email.sendKeys(emailAddress);
		Password.clear();
		Password.sendKeys(password);
		days.sendKeys("10");
		months.sendKeys("October");
		years.sendKeys("1992");
		addressfirstname.sendKeys(firstName);
		addresslastname.sendKeys(lastName);
		addressaddress1.sendKeys("address1");
		addresscity.sendKeys("city");
		selectDropdownValue(addressstate, "Colorado");
		addresspostcode.sendKeys("24526");
		selectDropdownValue(addresscountry, "United States");
		addressmobile.sendKeys("6521452365");
		addressalias.sendKeys("address1");
		registerbutton.click();
		assertEquals(true, myaccountBreadcrum.isDisplayed());
	}
	
	public void waitForElement(WebElement element, Integer time) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
	public void loginToApplication(String emailAddress, String password){
		signInlink.click();
		loginEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(password);
		submitButton.click();
	}
	
	public void clickOnNavigationMenu(String menuName){
		driver.findElement(By.xpath("//button[contains(text(),'"+menuName+"') and @aria-expanded='false']")).click();
	}
	
	public void clickOnProductInMensSection(String product){
		
		driver.findElement(By.xpath(".//button[contains(text(),'Mens') and @aria-expanded='true']/following-sibling::ul/child::li/child::a[contains(text(),'"+product+"')]")).click();
	}
	
	public void clickOnProductInWomensSection(String product){
		driver.findElement(By.xpath(".//button[contains(text(),'Womens') and @aria-expanded='true']/following-sibling::ul/child::li/child::a[contains(text(),'"+product+"')]")).click();
	}
	
	public void switchToDefaultContent(){
		driver.switchTo().defaultContent();
	}
}
