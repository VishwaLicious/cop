package in.licious.pom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.licious.util.Helper;

public class CreateCouponPage {
	
	@FindBy(xpath="//select[@id='city']")
	WebElement SelectCity;
	
	@FindBy(xpath="//input[@id='errmssg']")
	WebElement CityErrorMsg;
	
	@FindBy(xpath="//input[@id='coupon_code']")
	WebElement coupon_code;
	
	@FindBy(xpath="//input[@id='coupon_desc']")
	WebElement coupon_desc;
	
	@FindBy(xpath="//input[@id='check_discounted']")
	WebElement ApplicableOnDiscountedProduct;
	
	@FindBy(xpath="//input[@id='check_Scheduled']")
	WebElement ApplicableOnScheduledOnlyAlso;
	
	@FindBy(xpath="//input[@id='check_firstorder']")
	WebElement ApplicableonlyOnFirstOrder;
	
	@FindBy(xpath="//input[@id='checktruenewproduct']")
	WebElement ApplicableOnNewlyLaunchedProducts;
	
	@FindBy(xpath="//input[@id='transaction_period']")
	WebElement ApplicableBetweenTransaction;
	
	@FindBy(xpath="//input[@id='app_after_transactions']")
	WebElement ApplicableAfterTransactions;
	
	// Applicable on Newly Launched Products dependency elements
	@FindBy(xpath="//input[@placeholder='Select new products']")
	WebElement ForProduct;
	
	@FindBy(xpath="//button[@id='add_new_products_down']")
	WebElement add_new_products_down;
	
	@FindBy(xpath="//input[@class='form-control new_prod_qty']")
	WebElement MinimumQuantityRequired;
	
	@FindBy(xpath="//input[@id='mincart_new_products']")
	WebElement mincart_new_products;
	@FindBy(xpath="//input[@id='errmssg_new_products']")
	WebElement errmssg_new_products;
	
	
	@FindBy(xpath="//input[@id='limit_use']")
	WebElement limit_use;
	
	//date elements
	@FindBy(xpath="//input[@id='coupon_start_date']")
	WebElement coupon_start_date;
	
	@FindBy(xpath="//input[@id='coupon_end_date']")
	WebElement coupon_end_date;
	// start time and end time
	@FindBy(xpath="//select[@id='transactional_start_hour']")
	WebElement transactional_start_hour;
	@FindBy(xpath="//select[@id='transactional_start_min']")
	WebElement transactional_start_min;
	@FindBy(xpath="//select[@id='transactional_end_hour']")
	WebElement transactional_end_hour;
	@FindBy(xpath="//select[@id='transactional_end_min']")
	WebElement transactional_end_min;
	
	// Applicable number of transcation limit
	@FindBy(xpath="//input[@id='min_customer_transactions']")
	WebElement min_customer_transactions;
	
	
	//Discount Type
	@FindBy(xpath="//select[@id='discount']")
	WebElement discount;
	@FindBy(xpath="//input[@id='per_value']")
	WebElement PercentageValue;
	@FindBy(xpath="//input[@id='check_extra_discount']")
	WebElement GiveExtraCashbackDiscount;
	@FindBy(xpath="//input[@id='mincart_value']")
	WebElement mincart_value;
	@FindBy(xpath="//input[@id='discount_value']")
	WebElement max_discount_value;
	@FindBy(xpath="//input[@id='success_message']")
	WebElement success_message;
	@FindBy(xpath="//input[@id='errmssg_overide']")
	WebElement errmssg_overide;
	
	// percentage webelements
	@FindBy(xpath="//input[@id='per_cash']")
	WebElement PercentCashback;
	@FindBy(xpath="//input[@id='max_cash']")
	WebElement MaxCashback;
	@FindBy(xpath="//input[@id='licious_cash']")
	WebElement LiciousCash;
	@FindBy(xpath="//input[@id='perlicious_cash']")
	WebElement LiciousCashPlus;
	
	// complementory product
	@FindBy(xpath="//input[@placeholder='Please select products'][1]")
	WebElement SelectComplementoryProduct;
	@FindBy(xpath="//button[@id='add_products_complementory']")
	WebElement AddComplementoryProduct;
	@FindBy(xpath="//input[@class='form-control prod_comp_qty']")
	WebElement ComplementoryProductQuantity;
	
	//flatvalue
	@FindBy(xpath="//input[@id='flat_value']")
	WebElement FaltValue;
	
	//Coupon Conditions
		//paltforms
	
	
	@FindBy(xpath="//input[@id='checktrueplatform']")
	WebElement CheckPlatform;
	@FindBy(xpath="//input[@id='all']")
	WebElement AllPaltforms;
	@FindBy(xpath="//input[@id='plat_form_andriod']")
	WebElement AndriodPaltform;
	@FindBy(xpath="//input[@id='plat_form_ios']")
	WebElement IOSPaltform;
	@FindBy(xpath="//input[@id='plat_form_website']")
	WebElement WebSitePlatforms;
	@FindBy(xpath="//input[@id='plat_form_msite']")
	WebElement MsitePlatforms;
	@FindBy(xpath="//input[@id='plat_form_chc']")
	WebElement CHCPlatform;
	@FindBy(xpath="//input[@id='errplatf_message']")
	WebElement ErrorPlatformMsg;
	
			//Customer
	@FindBy(xpath="//input[@id='checktrue_customer']")
	WebElement CheckCustomer;
	@FindBy(xpath="//input[@id='fileupload']")
	WebElement FileUpload;
	@FindBy(xpath="//input[@id='limit_use_customer']")
	WebElement UsageLimitPerCustomer;
	@FindBy(xpath="//input[@id='errmssg_customer']")
	WebElement errmssg_customer;
	
		// category level
	@FindBy(xpath="//input[@id='checktruecategory']")
	WebElement Checkcategory;
	@FindBy(xpath="//input[@placeholder='Please select categories']")
	WebElement ForCategory;
	@FindBy(xpath="//button[@id='add_categorys_down']")
	WebElement AddCategory;
	@FindBy(xpath="//input[@class='form-control category_qty']")
	WebElement MinimumQuantityRequired_catogory;
	@FindBy(xpath="//input[@id='min_cart']")
	WebElement MinProductsInCart;
	@FindBy(xpath="//input[@id='errmssg_category']")
	WebElement errmssg_category;
	
	// product level
	
	@FindBy(xpath="//input[@id='checktrueproduct']")
	WebElement CheckProduct;
	@FindBy(xpath="//input[@id='mincart_products']")
	WebElement mincart_new_products_product;
	@FindBy(xpath="//input[@class='form-control prod_qty']")
	WebElement 	MinimumQuantityRequired_category;
	@FindBy(xpath="//input[@id='errmssg_products']")
	WebElement errmssg_products;
	
	
	//status
	@FindBy(xpath="//select[@id='status']")
	WebElement status;
	@FindBy(xpath="//a[@id='createbutton']")
	WebElement createbutton;
	
	@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
	WebElement  Done;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement serachCoupon;
	@FindBy(xpath="//table[@class='table table-striped table-bordered  table-hover dataTable no-footer']//td[2]")
	List<WebElement> checkCoupondCode;
	
	public CreateCouponPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectCity() {
		return SelectCity;
	}

	public WebElement getCityErrorMsg() {
		return CityErrorMsg;
	}

	public WebElement getCoupon_code() {
		return coupon_code;
	}

	public WebElement getCoupon_desc() {
		return coupon_desc;
	}

	public WebElement getApplicableOnDiscountedProduct() {
		return ApplicableOnDiscountedProduct;
	}

	public WebElement getApplicableOnScheduledOnlyAlso() {
		return ApplicableOnScheduledOnlyAlso;
	}

	public WebElement getApplicableonlyOnFirstOrder() {
		return ApplicableonlyOnFirstOrder;
	}

	public WebElement getApplicableOnNewlyLaunchedProducts() {
		return ApplicableOnNewlyLaunchedProducts;
	}

	public WebElement getApplicableBetweenTransaction() {
		return ApplicableBetweenTransaction;
	}

	public WebElement getApplicableAfterTransactions() {
		return ApplicableAfterTransactions;
	}

	public WebElement getForProduct() {
		return ForProduct;
	}

	public WebElement getAdd_new_products_down() {
		return add_new_products_down;
	}

	public WebElement getMinimumQuantityRequired() {
		return MinimumQuantityRequired;
	}

	public WebElement getMincart_new_products() {
		return mincart_new_products;
	}

	public WebElement getErrmssg_new_products() {
		return errmssg_new_products;
	}

	public WebElement getLimit_use() {
		return limit_use;
	}

	public WebElement getCoupon_start_date() {
		return coupon_start_date;
	}

	public WebElement getCoupon_end_date() {
		return coupon_end_date;
	}

	public WebElement getDiscount() {
		return discount;
	}

	public WebElement getGiveExtraCashbackDiscount() {
		return GiveExtraCashbackDiscount;
	}

	public WebElement getMincart_value() {
		return mincart_value;
	}

	public WebElement getMax_discount_value() {
		return max_discount_value;
	}

	public WebElement getSuccess_message() {
		return success_message;
	}

	public WebElement getErrmssg_overide() {
		return errmssg_overide;
	}

	public WebElement getCheckPlatform() {
		return CheckPlatform;
	}

	public WebElement getAllPaltforms() {
		return AllPaltforms;
	}

	public WebElement getAndriodPaltform() {
		return AndriodPaltform;
	}

	public WebElement getIOSPaltform() {
		return IOSPaltform;
	}

	public WebElement getWebSitePlatforms() {
		return WebSitePlatforms;
	}

	public WebElement getMsitePlatforms() {
		return MsitePlatforms;
	}

	public WebElement getCHCPlatform() {
		return CHCPlatform;
	}

	public WebElement getErrorPlatformMsg() {
		return ErrorPlatformMsg;
	}

	
	
	public WebElement getFaltValue() {
		return FaltValue;
	}

	public WebElement getCheckCustomer() {
		return CheckCustomer;
	}

	public WebElement getFileUpload() {
		return FileUpload;
	}

	public WebElement getUsageLimitPerCustomer() {
		return UsageLimitPerCustomer;
	}

	public WebElement getErrmssg_customer() {
		return errmssg_customer;
	}

	public WebElement getStatus() {
		return status;
	}

	public WebElement getCreatebutton() {
		return createbutton;
	}

	public WebElement getTransactional_start_hour() {
		return transactional_start_hour;
	}

	public WebElement getTransactional_start_min() {
		return transactional_start_min;
	}

	public WebElement getTransactional_end_hour() {
		return transactional_end_hour;
	}

	public WebElement getTransactional_end_min() {
		return transactional_end_min;
	}

	public WebElement getMin_customer_transactions() {
		return min_customer_transactions;
	}

	public WebElement getCheckcategory() {
		return Checkcategory;
	}

	public WebElement getForCategory() {
		return ForCategory;
	}

	public WebElement getAddCategory() {
		return AddCategory;
	}

	public WebElement getMinimumQuantityRequired_catogory() {
		return MinimumQuantityRequired_catogory;
	}

	public WebElement getMinProductsInCart() {
		return MinProductsInCart;
	}

	public WebElement getErrmssg_category() {
		return errmssg_category;
	}

	public WebElement getCheckProduct() {
		return CheckProduct;
	}

	public WebElement getMincart_new_products_product() {
		return mincart_new_products_product;
	}

	public WebElement getMinimumQuantityRequired_category() {
		return MinimumQuantityRequired_category;
	}

	public WebElement getErrmssg_products() {
		return errmssg_products;
	}
	
	
	public WebElement getPercentCashback() {
		return PercentCashback;
	}

	public WebElement getMaxCashback() {
		return MaxCashback;
	}

	public WebElement getLiciousCash() {
		return LiciousCash;
	}

	public WebElement getLiciousCashPlus() {
		return LiciousCashPlus;
	}

	
	
	public WebElement getDone() {
		return Done;
	}

	
	
	
	
	
	public WebElement getPercentageValue() {
		return PercentageValue;
	}

	public WebElement getSerachCoupon() {
		return serachCoupon;
	}

	public List<WebElement> getCheckCoupondCode() {
		return checkCoupondCode;
	}

	
	
	public WebElement getSelectComplementoryProduct() {
		return SelectComplementoryProduct;
	}

	public WebElement getAddComplementoryProduct() {
		return AddComplementoryProduct;
	}

	public WebElement getComplementoryProductQuantity() {
		return ComplementoryProductQuantity;
	}

	public void filldate(WebDriver driver, String dateAndTime,Properties properties) {

		String str[] = dateAndTime.split(" ");
		//System.out.println("hour is "+str[1]);
	//	String str3="10:00";
		String date[] = str[0].split("-");
		String hour[] = str[1].split(":");
		//System.out.println(date[1] + "  " + hour[0] + "  " + str[1]);
		Helper h = new Helper();
		WebElement days = driver.findElement(By.xpath("//div[@class='datetimepicker-days']//th[@class='switch']"));
		h.clickOnElement(driver, days);
		WebElement month = driver.findElement(By.xpath("//div[@class='datetimepicker-months']//th[@class='switch']"));
		h.clickOnElement(driver, month);
		WebElement year = driver
				.findElement(By.xpath("//div[@class='datetimepicker-years']//span[@class='year active']"));
		//h.customWait(5);
		h.clickOnElement(driver, year);
		//String dat1 = properties.getProperty(date[1]);//"Aug";
		String s1 = new String('"' + properties.getProperty(date[1]) + '"');
		WebElement selectmont = driver
				.findElement(By.xpath("//div[@class='datetimepicker-months']//span[text()=" + s1 + "]"));
		h.clickOnElement(driver, selectmont);
		WebElement slectday = driver
				.findElement(By.xpath("//div[@class='datetimepicker-days']//td[text()=" + date[2] + "]"));
		h.clickOnElement(driver, slectday);
		String dat2 = hour[0] + ":00";
		String s2 = new String('"' + dat2 + '"');
		List<WebElement> selecthour = driver.findElements(By.xpath("//div[@class='datetimepicker-hours']//span[ (@class='hour' and text()="+s2+")]"));
		for(WebElement hours:selecthour){
			//System.out.println(hours.isDisplayed());
			if(hours.isDisplayed()){
			h.clickOnElement(driver, hours);
			break;
			}
		}
		
		//h.clickOnElement(driver, selecthour);
		String s = new String('"' + str[1] + '"');
		//h.customWait(5);
		WebElement selectmiutes = driver
				.findElement(By.xpath("//div[@class='datetimepicker-minutes']//span[text()="+s+"]"));
		h.clickOnElement(driver, selectmiutes);
	}

	public void FillEndDate(WebDriver driver, String DateAndTime,Properties properties) {

		Helper h = new Helper();
		WebElement daypicker = driver
				.findElement(By.xpath("(//div[@class='datetimepicker-days']//th[@class='switch'])[2]"));
		h.clickOnElement(driver, daypicker);
		WebElement monthPicker = driver
				.findElement(By.xpath("(//div[@class='datetimepicker-months']//th[@class='switch'])[2]"));
		h.clickOnElement(driver, monthPicker);
		WebElement yearpicker = driver
				.findElement(By.xpath("(//div[@class='datetimepicker-years']//span[@class='year active'])[2]"));
		h.clickOnElement(driver, yearpicker);
		String str[] = DateAndTime.split(" ");
		String date[] = str[0].split("-");
		String hour[] = str[1].split(":");
		//System.out.println(date[2] + "  " + hour[0] + "  " + str[1]);

		//String dat1 = "Aug";
		
		String s1 = new String('"' + properties.getProperty(date[1]) + '"');
		
		WebElement selectmont = driver
				.findElement(By.xpath("(//div[@class='datetimepicker-months']//span[text()=" + s1 + "])[2]"));
		
		h.clickOnElement(driver, selectmont);
		
		h.customWait(5);
		System.out.println("elect day "+date[2]);
	/*List<WebElement> slectday = driver
			
				.findElements(By.xpath("//div[@class='datetimepicker-days']//td[text()=" + date[2] + "]"));*/
	List<WebElement> slectday=	driver.findElements(By.xpath("//div[@class='datetimepicker-days']//td[text()="+date[2]+" and @class='day']"));
		for(WebElement wel:slectday ){
			if(wel.isDisplayed() & wel.isEnabled() ){
		h.clickOnElement(driver, wel);
		break;
			}
		}

				String dat2 = hour[0] + ":00";
		String s2 = new String('"' + dat2 + '"');
	h.customWait(5);
		// (//div[@class='datetimepicker-hours']//span[ (@class='hour' and text()="+s2+")or(@class='hour active')])[2]
		List<WebElement> selecthour = driver.findElements(By.xpath("//div[@class='datetimepicker-hours']//span[ (@class='hour' and text()="+s2+")]"));
		//selecthour.click();
		for(WebElement hours:selecthour){
			//System.out.println(hours.isDisplayed() & hours.isEnabled());
			if(hours.isDisplayed()){
			h.clickOnElement(driver, hours);
			break;
			}
		}
			
	//	h.customWait(5);
	String s = new String('"' + str[1] + '"');
		List<WebElement> selectmiutes = driver.findElements(By.xpath("//div[@class='datetimepicker-minutes']//span[text()="+s+"]"));
		for(WebElement wel:selectmiutes){
			if(wel.isDisplayed() & wel.isEnabled()){
			h.clickOnElement(driver, wel);
			break;
			}
		}
		

	}
	
	public Map<String,WebElement> GetPlatforms(){
		Map<String, WebElement> dataMap=new HashMap<String, WebElement>();
		dataMap.put("All",getAllPaltforms());
		dataMap.put("IOS",getIOSPaltform());
		dataMap.put("Andriod",getAndriodPaltform());
		dataMap.put("Msite", getMsitePlatforms());
		dataMap.put("WebSite", getWebSitePlatforms());
		dataMap.put("CHC", getCHCPlatform());
		return dataMap;
		
	}

}
