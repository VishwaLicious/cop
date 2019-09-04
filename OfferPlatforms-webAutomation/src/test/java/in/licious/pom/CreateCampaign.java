package in.licious.pom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaign {
	
	@FindBy(xpath="//span[text()='Campaigns']")
	WebElement Campaign;
	@FindBy(xpath="//a[@href='https://uat-oms.licious.app/offermodule/add']")
		WebElement CreateCampaign;
	@FindBy(xpath="//select[@id='campaign_type']")
	WebElement CampaignType;
	@FindBy(xpath="//select[@id='campaign_objective']")
	WebElement CampaignObjective;
	@FindBy(xpath="//input[@id='campaign_name']")
	WebElement CampaignName;
	@FindBy(xpath="//input[@id='campaign_desc']")
	WebElement CampaignDesc;
	@FindBy(xpath="//select[@id='city']")
	WebElement City;
	@FindBy(xpath="//input[@id='all']")
	WebElement PlatformAll;
	@FindBy(xpath="//input[@id='plat_form_andriod']")
	WebElement AndriodPlatform;
	@FindBy(xpath="//input[@id='plat_form_ios']")
	WebElement IOSPlatform;
	@FindBy(xpath="//input[@id='plat_form_website']")
	WebElement webSitePlatform;
	@FindBy(xpath="//input[@id='plat_form_msite']")
	WebElement MsitePlatform;
	
	@FindBy(xpath="//input[@id='campaign_start_date'] ")
	//@FindBy(xpath="//div[@class='input-group date form_datetime bs-datetime']//button[@class='btn default date-set'][1]")
	WebElement StartDate;
	
	@FindBy(xpath="//input[@id='campaign_end_date'] ")
	WebElement EndDate;
	
	
	
	
	
	@FindBy(xpath="//input[@id='select_web_banner']")
	WebElement WebBanner;
	
	
	//@FindBy(xpath="//div[@banner_title='test143']//input[@type='checkbox'][1]")
	@FindBy(xpath="//div[@banner_title='test143']//div[@class='checker'][1]")
	WebElement SelecWebtBanner;
	
	@FindBy(xpath="//input[@id='select_app_banner']")
	WebElement SelectAppBanner;
	
	@FindBy(xpath="//input[@id='select_msite_banner']")
	WebElement SelectMsiteBanner;
	
	
	@FindBy(xpath="//input[@id='web_banner_popup_close']")
	WebElement WebBannerClose;
	
	@FindBy(xpath="//input[@id='app_banner_popup_close']")
	WebElement AppBannerClose;
	
	@FindBy(xpath="//input[@id='msite_banner_popup_close']")
	WebElement MsiteBannerClose;
	
	
	@FindBy(xpath="//div[@id='selected_web_banners']//input[@class='banner-order-input']")
	List<WebElement> WebBannerOrder;
	@FindBy(xpath="//div[@id='selected_app_banners']//input[@class='banner-order-input']")
	List<WebElement> AppBannerOrder;	
	@FindBy(xpath="//div[@id='selected_msite_banners']//input[@class='banner-order-input']")
	List<WebElement> MsiteBannerOrder;
	
	@FindBy(xpath="//input[@id='coupon_code']")
	WebElement EnterCouponCode;
	@FindBy(xpath="//input[@id='coupon_add']")
	WebElement AddCouponCode;
	
	@FindBy(xpath="//input[@id='btn-submit']")
	WebElement Submit;
	
	@FindBy(xpath="//div[@id='campaign_exist_success']")
	WebElement campaign_exist_success;
	
	@FindBy(xpath="//div[@id='campaign_exist_error']")
	WebElement campaign_exist_error;
	
	@FindBy(xpath="//p[text()='Campaign Name already exists, please enter a different name.']")
	WebElement campainErrorMsg;
	
	@FindBy(xpath="//div[@id='date_error']")
	WebElement DateError;
	
	@FindBy(xpath="//p[text()='Coupon code is already expired']")
	WebElement CopuonCodeExpire;
	
	@FindBy(xpath="//p[text()='Unable to find specific coupon for given city']")
	WebElement CouponCodeNotBelongsToCity;
	
	
	
public WebElement getCouponCodeNotBelongsToCity() {
		return CouponCodeNotBelongsToCity;
	}

public WebElement getCopuonCodeExpire() {
		return CopuonCodeExpire;
	}

public WebElement getDateError() {
		return DateError;
	}

public WebElement getCampainErrorMsg() {
		return campainErrorMsg;
	}

public WebElement getCampaign_exist_success() {
		return campaign_exist_success;
	}

	public WebElement getCampaign_exist_error() {
		return campaign_exist_error;
	}

public CreateCampaign(WebDriver driver){
	PageFactory.initElements(driver, this);
}

public WebElement getCampaign() {
	return Campaign;
}

public WebElement getCreateCampaign() {
	return CreateCampaign;
}

public WebElement getCampaignType() {
	return CampaignType;
}

public WebElement getCampaignObjective() {
	return CampaignObjective;
}

public WebElement getCampaignName() {
	return CampaignName;
}

public WebElement getCampaignDesc() {
	return CampaignDesc;
}

public WebElement getCity() {
	return City;
}

public WebElement getPlatformAll() {
	return PlatformAll;
}

public WebElement getAndriodPlatform() {
	return AndriodPlatform;
}

public WebElement getIOSPlatform() {
	return IOSPlatform;
}

public WebElement getWebSitePlatform() {
	return webSitePlatform;
}

public WebElement getMsitePlatform() {
	return MsitePlatform;
}

public WebElement getWebBanner() {
	return WebBanner;
}

public WebElement getSelecWebtBanner() {
	return SelecWebtBanner;
}

public WebElement getSelectAppBanner() {
	return SelectAppBanner;
}

public WebElement getSelectMsiteBanner() {
	return SelectMsiteBanner;
}




public WebElement getWebBannerClose() {
	return WebBannerClose;
}

public WebElement getAppBannerClose() {
	return AppBannerClose;
}

public WebElement getMsiteBannerClose() {
	return MsiteBannerClose;
}

public List<WebElement> getWebBannerOrder() {
	return WebBannerOrder;
}

public List<WebElement> getAppBannerOrder() {
	return AppBannerOrder;
}

public List<WebElement> getMsiteBannerOrder() {
	return MsiteBannerOrder;
}

public WebElement getEnterCouponCode() {
	return EnterCouponCode;
}

public WebElement getAddCouponCode() {
	return AddCouponCode;
}

public WebElement getSubmit() {
	return Submit;
}

public WebElement getStartDate() {
	return StartDate;
}

public WebElement getEndDate() {
	return EndDate;
}
	
public Map<String,List<WebElement>> CreateBannersElements(String name,WebDriver driver){
	Map<String, List<WebElement>> elements=new HashMap<String,List<WebElement>>();
	
	String str[]=null;
	 if(name.contains(","))
	 {
		 str=name.split(",");
		  for(int i=0;i<str.length;i++){
			  String s2 = new String('"' + str[i] + '"');
			  elements.put(str[i],driver.findElements(By.xpath("//div[@banner_title="+s2+"]//div[@class='checker']")));
			  
			 }
	 }
		 else{ 
			
			 String s2 = new String('"' + name + '"');
			  elements.put(name,driver.findElements(By.xpath("//div[@banner_title="+s2+"]//div[@class='checker']")));
	 }
	
	
	
	
	//String s2 = new String('"' + name + '"');
	
	//List<WebElement> b2=driver.findElements(By.xpath("//div[@banner_title="+s2+"]//div[@class='checker']"));
	return elements;
}
	
	
	

}
