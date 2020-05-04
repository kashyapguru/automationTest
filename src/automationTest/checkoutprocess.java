package automationTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutprocess {

	WebDriver driver;

	public checkoutprocess(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	WebElement womanLink;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
	WebElement productLink;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[2]")
	WebElement quickViewLink;
	
	@FindBy(xpath = "//*[@id='our_price_display']")
	WebElement productPrice;
	
	@FindBy(xpath = "//*[@id='quantity_wanted_p']/a[2]/span/i")
	WebElement increaseQuantity;
	
	@FindBy(name = "Submit")
	WebElement addToCart;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[1]/span")
	WebElement verifyPrice1;
	
	@FindBy(xpath = "//*[@id='layer_cart_product_price']")
	WebElement verifyPrice2;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement proceedToCheckoutCart;
	
	@FindBy(id = "total_product")
	WebElement verifyPrice3;
	
	@FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]/span")
	WebElement proceedToCheckoutAddress;
	
	@FindBy(xpath = "//*[@id='center_column']/form/p/button/span")
	WebElement proceedToCheckoutAddress2;
	
	@FindBy(name = "cgv")
	WebElement termsCheckbox;
	
	@FindBy(xpath = "//*[@id='form']/p/button/span")
	WebElement proceedToCheckoutShipping;
	
	@FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
	WebElement payByBankWire;
	
	@FindBy(xpath = "//*[@id='cart_navigation']/button/span")
	WebElement confirmOrder;
	
	@FindBy(xpath = "//*[@id='center_column']/div/p/strong")
	WebElement orderConfirmText;
	
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")
	WebElement myAccountLink;
	
	@FindBy(xpath = "//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")
	WebElement orderHistoryLink;
	
	@FindBy(xpath = "//*[@id='order-list']/tbody/tr/td[3]/span")
	WebElement orderPrice;
	
	public void waitForElement(WebElement element, Integer time) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public Float calculatePrice(String price) {
		
		String newword = price.substring(1);
		Float num1 = Float.parseFloat(newword);
		Float total = num1*2 ;
		
		return total;
	}
	
	public void verifyPrice(WebElement element, Float value) {
		
		String price1 = element.getText();
		Float num1 = Float.parseFloat(price1.substring(1));
		value.equals(num1);
	}
	
	public void switchToWindow() {
		driver.switchTo().defaultContent();
	}
	
	public void switchToFrame() {
		Integer size = driver.findElements(By.tagName("iframe")).size();
		if (size != 0) {
			driver.switchTo().frame(0);
		}
	}
	
	public void checkoutProcess() {
		womanLink.click();
		Actions action = new Actions(driver);
		action.moveToElement(productLink).perform();
		quickViewLink.click();
		switchToFrame();
		waitForElement(productPrice, 5);
		String price = productPrice.getText();
		Float total = calculatePrice(price);
		increaseQuantity.click();
		addToCart.click();
		switchToWindow();
		verifyPrice(verifyPrice1, total);
		verifyPrice(verifyPrice2, total);
		proceedToCheckoutCart.click();
		verifyPrice(verifyPrice3, total);
		proceedToCheckoutAddress.click();
		proceedToCheckoutAddress2.click();
		termsCheckbox.click();
		proceedToCheckoutShipping.click();
		payByBankWire.click();
		confirmOrder.click();
		orderConfirmText.isDisplayed();
		myAccountLink.click();
		orderHistoryLink.click();
		verifyPrice(orderPrice, total);
	}

}
