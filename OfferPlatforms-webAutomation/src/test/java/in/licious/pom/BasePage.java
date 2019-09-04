package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class BasePage {
	
	@FindBy(xpath="//input[@name='email']")
	WebElement UsernameTextBox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement PasswordTextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement ClickLoginBtn;
	
	@FindBy(xpath="//a[@class='nav-link nav-toggle']//span[@class='title'][contains(text(),'Coupons')]")
	//@FindBy(xpath="//span[contains(text(),'Pending Inward')]")
	WebElement coupons;
	
	@FindBy(xpath="//li[@class='nav-item open']//ul[@class='sub-menu']//li[1]//a[1]")
	WebElement createCoupon;
	@FindBy(xpath="//li[contains(@class,'nav-item open')]//ul[contains(@class,'sub-menu')]//li[2]//a[1]")
	WebElement viewCoupon;
	
	public WebElement getCoupons() {
		return coupons;
	}

	public WebElement getCreateCoupon() {
		return createCoupon;
	}

	public WebElement getViewCoupon() {
		return viewCoupon;
	}

	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTextBox() {
		return UsernameTextBox;
	}

	public WebElement getPasswordTextBox() {
		return PasswordTextBox;
	}

	public WebElement getClickLoginBtn() {
		return ClickLoginBtn;
	}
	
	
	
/*	@FindBy(xpath="//span[@class='location-name']")
	private WebElement selectLocation;
	
	@FindBy(xpath="//a[contains(.,'Login')]")
	private WebElement login;
	
	@FindBy(xpath="//p[@class='city-select']//span[contains(.,'Bengaluru')]")
	private WebElement bengaluruDeliveryLocation;
	
	@FindBy(id="location_pop")
	private WebElement loactionTxtBox;
	
	@FindBy(xpath="//span[.='Cart']")
	private WebElement cart;
	//span[@class='location-name']
	
	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSelectLocation(){
		return selectLocation;
	}
	public WebElement getLogin(){
		return login;
	}
	public WebElement getbengaluruDeliveryLocation(){
		return bengaluruDeliveryLocation;
	}
	public WebElement getLoactionTxtBox(){
		return loactionTxtBox;
	}
	
	public WebElement getCart(){
		return cart;
	}*/
}
