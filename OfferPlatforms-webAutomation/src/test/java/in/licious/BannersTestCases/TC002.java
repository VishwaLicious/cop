package in.licious.BannersTestCases;

import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;
import in.licious.pom.BasePage;
import in.licious.pom.CreateBanners;
import in.licious.util.Helper;
import in.licious.util.ReadExcelData;

public class TC002 extends BaseTest{
	
	@Test
	public void TC_002() throws FindFailed, IOException{
		
		// Verify the banner should not able to create wthout uploading the website banner
		
		ReadExcelData r=new ReadExcelData();
		Map<String, String> data=r.getheaderinfo(properties.getProperty("BannersCreationSheet"), "TC002");
		
		
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
		h.enterText(driver, banner.getBannerTitle(), "ramesh"+data.get("BannerTitle"));
		h.enterText(driver, banner.getBanner_desc(),data.get("BannerDescription"));
		
		h.ScrollBarIntoView(driver, banner.getThumbImg());
		
		 h.clickOnElement(driver, banner.getThumbImg());
		 h.uploadImageFile(driver, data.get("ThumbnailImageName"));
		 		 
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
		
		Alert alert = driver.switchTo().alert();
		h.customWait(3);
		String error=alert.getText();
		alert.accept();
		Assert.assertEquals(error, "Please upload an image for Web to proceed.");
	
		h.customWait(10);
	}

}
