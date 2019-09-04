package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateBanners  {
	
	
	@FindBy(xpath="//span[text()="+"\""+"New Banner Uploader"+"\""+"]")
	WebElement NewBannerUploader;
	@FindBy(xpath="//a[@href='https://uat-oms.licious.app/newbanner/upload']")
	WebElement upLoadBanner;
	
	@FindBy(xpath="//input[@id='banner_title']")
	WebElement BannerTitle;
	@FindBy(xpath="//input[@id='banner_desc']")
	WebElement Banner_desc;
	@FindBy(xpath="//h6[@id='thumb_img']")
	WebElement ThumbImg;
	@FindBy(xpath="//h6[@id='web_img']")
	WebElement WebImg;
	@FindBy(xpath="//h6[@id='app_img']")
	WebElement AppImg;
	@FindBy(xpath="//h6[@id='msite_img']")
	WebElement MsiteImg;
	
	@FindBy(xpath="//input[@id='utm_source']")
	WebElement UtmSource;
	@FindBy(xpath="//input[@id='utm_medium']")
	WebElement UtmMedium;
	@FindBy(xpath="//input[@id='utm_content']")
	WebElement UtmContent;
	@FindBy(xpath="//input[@id='web_url']")
	WebElement WebUrl;
	@FindBy(xpath="//input[@id='msite_url']")
	WebElement MsiteUrl;
	@FindBy(xpath="//input[@id='appdeeplink']")
	WebElement AppDeppLink;
	@FindBy(xpath="//select[@id='status']")
	WebElement Status;
	@FindBy(xpath="//input[@id='btn-submit']")
	WebElement Submit;
	
	@FindBy(xpath="//h6[@id='app_img']//a[@class='dz-remove']")
	WebElement remove;
	
	
	
	
	public WebElement getRemove() {
		return remove;
	}


	public WebElement getUpLoadBanner() {
		return upLoadBanner;
	}


	public CreateBanners(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	public WebElement getNewBannerUploader() {
		return NewBannerUploader;
	}


	public WebElement getBannerTitle() {
		return BannerTitle;
	}


	public WebElement getBanner_desc() {
		return Banner_desc;
	}


	public WebElement getThumbImg() {
		return ThumbImg;
	}


	public WebElement getWebImg() {
		return WebImg;
	}


	public WebElement getAppImg() {
		return AppImg;
	}


	public WebElement getMsiteImg() {
		return MsiteImg;
	}


	public WebElement getUtmSource() {
		return UtmSource;
	}


	public WebElement getUtmMedium() {
		return UtmMedium;
	}


	public WebElement getUtmContent() {
		return UtmContent;
	}


	public WebElement getWebUrl() {
		return WebUrl;
	}


	public WebElement getMsiteUrl() {
		return MsiteUrl;
	}


	public WebElement getAppDeppLink() {
		return AppDeppLink;
	}


	public WebElement getStatus() {
		return Status;
	}


	public WebElement getSubmit() {
		return Submit;
	}
	

	
}
