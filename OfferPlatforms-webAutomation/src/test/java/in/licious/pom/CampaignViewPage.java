package in.licious.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignViewPage {
	
	@FindBy(xpath="//a[@href='https://uat-oms.licious.app/offermodule/list']")
	WebElement campaignView;
	@FindBy(xpath="//select[@id='campaign_status']")
	WebElement campaignStatus;
	@FindBy(xpath="//input[@id='list_campaigns']")
	WebElement ListCampaign;
	@FindBy(xpath="//table[@id='recipe']//th[2]//p")
	List<WebElement>cname;
	
	@FindBy(xpath="//select[@name='campaign_type']")
	List<WebElement>CampaignAction;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement UpdateCampaign;
	
	@FindBy(xpath="//button[@id='update_campaign ']")
	WebElement EditCampaign;
	
	
	
	public WebElement getEditCampaign() {
		return EditCampaign;
	}


	public WebElement getUpdateCampaign() {
		return UpdateCampaign;
	}


	public CampaignViewPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	public WebElement getCampaignView() {
		return campaignView;
	}


	public WebElement getCampaignStatus() {
		return campaignStatus;
	}


	public WebElement getListCampaign() {
		return ListCampaign;
	}


	public List<WebElement> getCname() {
		return cname;
	}


	public List<WebElement> getCampaignAction() {
		return CampaignAction;
	}
	
	
	
}
