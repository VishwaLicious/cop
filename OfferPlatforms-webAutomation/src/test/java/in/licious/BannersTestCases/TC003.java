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

public class TC003 extends BaseTest{
	
	@Test
	public void TC_003() throws IOException, FindFailed{
		
		// Vefiy the banner should not create when banner size more than 1Mb
		
		ReadExcelData r=new ReadExcelData();
		Map<String, String> data=r.getheaderinfo(properties.getProperty("BannersCreationSheet"), "TC003");
		
		
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
		 h.customWait(3);
	
		
		Alert alert = driver.switchTo().alert();
		h.customWait(3);
		String error=alert.getText();
		alert.accept();
		Assert.assertEquals(error, "File size above 1 MB not allowed");
	
		h.customWait(5);
	}

}
