package in.licious.OfferesTestCases;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.licious.BannersTestCases.BaseTest;
import in.licious.pom.BasePage;
import in.licious.pom.CampaignViewPage;
import in.licious.pom.CreateCampaign;
import in.licious.pom.CreateCouponPage;
import in.licious.util.Helper;
import in.licious.util.ReadExcelData;

public class TC003 extends BaseTest{
	
	@Test
	public void Tc_003() throws IOException{
		
		/* Verify the campaign should not be created when start date is greater than the end date */
		
		
		ReadExcelData r=new ReadExcelData();
		Map<String, String> data=r.getheaderinfo(properties.getProperty("offersCreationSheet"), "TC003");
		
		BasePage login=new BasePage(driver) ;
		Helper h=new Helper();
		
		h.enterText(driver, login.getUsernameTextBox(), userName);
		h.enterText(driver, login.getPasswordTextBox(), passWord);
		h.clickOnElement(driver, login.getClickLoginBtn());
		h.customWait(5);
		
		CreateCampaign camp=new CreateCampaign(driver);
		h.ScrollBarIntoView(driver, camp.getCampaign());
		h.clickOnElement(driver, camp.getCampaign());
		
		h.clickOnElement(driver, camp.getCreateCampaign());
		h.selectDropDown(driver, camp.getCampaignType(), data.get("CampaignType "));
		h.selectDropDown(driver, camp.getCampaignObjective(), data.get("CampaignObjective"));
		h.enterText(driver, camp.getCampaignName(), data.get("CampaignName"));
		h.customWait(5);
		Assert.assertEquals(camp.getCampaign_exist_success().getText(), "Yay! Campaign Name is unique.");
		h.enterText(driver, camp.getCampaignDesc(),data.get("CampaignDescription"));
		h.selectDropDown(driver, camp.getCity(),data.get("SelectCity"));
		h.scrollBar(driver, camp.getPlatformAll());
		
		h.customWait(5);
		CreateCouponPage c=new CreateCouponPage(driver);
		h.scrollBar(driver, camp.getStartDate());
		h.clickOnElement(driver, camp.getStartDate());
		System.out.println(camp.getStartDate());
		
		c.filldate(driver, data.get("StartDateTime"),properties);

		h.clickOnElement(driver, camp.getEndDate());
		c.FillEndDate(driver, data.get("EndDateTime"),properties);
		h.clickOnElement(driver, camp.getWebBanner());
		
		h.customWait(5);
		
		Map<String, List<WebElement>> elements= camp.CreateBannersElements(data.get("BannerName"),driver);
	
		h.uploadWebBanners(driver,elements,data.get("BannerName"));
		h.clickOnElement(driver, camp.getWebBannerClose());
		h.setBannerOrder(driver, camp.getWebBannerOrder());
		h.customWait(5);
		h.clickOnElement(driver, camp.getSelectAppBanner());
		h.customWait(5);
		h.uploadAppBanners(driver, elements, data.get("BannerName"));
		h.clickOnElement(driver, camp.getAppBannerClose());
		h.setBannerOrder(driver, camp.getAppBannerOrder());
		
		h.customWait(5);
		h.clickOnElement(driver, camp.getSelectMsiteBanner());
		h.customWait(5);
		h.uploadMsiteBanners(driver, elements, data.get("BannerName"));
		h.clickOnElement(driver, camp.getMsiteBannerClose());
		h.setBannerOrder(driver, camp.getMsiteBannerOrder());
		h.customWait(5);
		
		h.enterText(driver, camp.getEnterCouponCode(), data.get("CouponCode"));
		h.clickOnElement(driver, camp.getAddCouponCode());
		h.customWait(5);
		h.clickOnElement(driver, camp.getSubmit());
		
		h.customWait(2);
		Assert.assertEquals(camp.getDateError().getText(), "Start date time should not be greater than or equal to End date time");
		h.customWait(5);
		
				
	}

}
