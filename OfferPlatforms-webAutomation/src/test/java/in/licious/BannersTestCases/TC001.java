package in.licious.BannersTestCases;

import java.awt.AWTException; 
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import in.licious.pom.BasePage;
import in.licious.pom.CreateBanners;
import in.licious.util.Helper;
import in.licious.util.ReadExcelData;

public class TC001 extends BaseTest{
	
	@Test
	public void TC_001() throws IOException, AWTException, FindFailed{
		
		// Verify the banner should be create with entered value in required fileds
		
		ReadExcelData r=new ReadExcelData();
		Map<String, String> data=r.getheaderinfo(properties.getProperty("BannersCreationSheet"), "TC001");
		
		
		BasePage login=new BasePage(driver);
		Helper h=new Helper();
		CreateBanners banner=new CreateBanners(driver);
		h.enterText(driver, login.getUsernameTextBox(), userName);
		h.enterText(driver, login.getPasswordTextBox(), passWord);
		h.clickOnElement(driver, login.getClickLoginBtn());
		h.customWait(5);
		h.ScrollBarIntoView(driver, banner.getNewBannerUploader());
		h.clickOnElement(driver, banner.getNewBannerUploader());
		h.clickOnElement(driver, banner.getUpLoadBanner());
		h.enterText(driver, banner.getBannerTitle(), "ttt"+data.get("BannerTitle"));
		h.enterText(driver, banner.getBanner_desc(),data.get("BannerDescription"));
		
		h.ScrollBarIntoView(driver, banner.getThumbImg());
		
		 h.clickOnElement(driver, banner.getThumbImg());
		 h.uploadImageFile(driver, data.get("ThumbnailImageName"));
		
		 
		 
		 
		 h.clickOnElement(driver, banner.getWebImg());
		 h.uploadImageFile(driver,data.get("ThumbnailImageName"));
		 
		 
		 h.clickOnElement(driver, banner.getAppImg());
		 h.uploadImageFile(driver,data.get("ThumbnailImageName"));
		 
		 h.clickOnElement(driver, banner.getMsiteImg());
		 h.uploadImageFile(driver, data.get("ThumbnailImageName"));
				
		h.customWait(5);
		h.ScrollBarIntoView(driver, banner.getUtmSource());
		h.enterText(driver, banner.getUtmSource(), data.get("UTMSource"));
		h.enterText(driver, banner.getUtmMedium(), data.get("UTMMedium"));
		h.enterText(driver, banner.getUtmContent(), data.get("UTMContent"));
		h.enterText(driver, banner.getWebUrl(),data.get("WebURL"));
		h.enterText(driver, banner.getMsiteUrl(), data.get("MsiteURL"));
		h.enterText(driver, banner.getAppDeppLink(), data.get("DeepLink"));
		h.selectDropDown(driver, banner.getStatus(), data.get("Status"));
		h.clickOnElement(driver, banner.getSubmit());
		h.customWait(10);
		
	}

}
