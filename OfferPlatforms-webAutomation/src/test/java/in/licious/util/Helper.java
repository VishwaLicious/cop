package in.licious.util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Helper {
	public static String SCREEN_SHOT_PATH;
	public static String dateAndTimeStamp(){
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy-HH-mm-ss");
		 return sdf.format(new Date());
	}
	public  void customWait(long seconds){
		try{
			Thread.sleep(seconds*1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	private static WebDriver explicitWait(WebDriver driver,long timeOutInSecond,ExpectedCondition<WebDriver> expectedCondition){
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSecond);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(expectedCondition);
			}
	private static WebElement explicitWait(WebDriver driver,ExpectedCondition<WebElement> expectedCondition,long timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(expectedCondition);
	}
	public  void clickOnElement(WebDriver driver,WebElement element){
		explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10).click();
	}
	public  void clickOnElement(WebDriver driver,WebElement element,long timeOutInSecond){
		explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond).click();
	}
	public  void enterText(WebDriver driver,WebElement element,CharSequence text,long timeOutInSecond){
		
			if(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond).isDisplayed()){
				element.clear();
				element.sendKeys(text);
			}
	}
	public  void enterText(WebDriver driver,WebElement element,CharSequence text){
		
		if(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10).isDisplayed()){
			element.clear();
			element.sendKeys(text);
		}
}
	 public static String takeScreenShot(String sname){
		 try {
			Robot robot=new Robot();
			BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			SCREEN_SHOT_PATH=System.getProperty("user.dir")+"/ScreenShots/"+sname+"-"+dateAndTimeStamp()+".png";
			try {
				ImageIO.write(image, "png", new File(SCREEN_SHOT_PATH));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}	
		 return SCREEN_SHOT_PATH;
	 }
	 public  WebDriver switchToFrame(WebDriver driver,WebElement element,long timeOutInSecond){
		 return  explicitWait(driver,timeOutInSecond, ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		 }
	 public  WebDriver switchBackFromFrame(WebDriver driver){
		return driver.switchTo().defaultContent();
	 }
	 /**switchToChildWindow() method works properly only when there is two window opened
	  */
	 public  void switchToChildWindow(WebDriver driver){
		 Iterator<String> itr = driver.getWindowHandles().iterator();
		 itr.next();
		 driver.switchTo().window(itr.next());
	 }
	 /**switchBackToParentWindow() method works properly only when there is two window opened
	  */
	 public  void switchBackToParentWindow(WebDriver driver){
		 Iterator<String> itr = driver.getWindowHandles().iterator();
		 driver.switchTo().window(itr.next());
	 }
	 public  void selectDropDown(WebDriver driver,WebElement element,String text){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10));
		 select.selectByVisibleText(text);
	 }
	 public  void selectDropDown(WebDriver driver,WebElement element,String text,long timeOutInSecond){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond));
		 select.selectByVisibleText(text);
	 }
	 public  void deSelectDropDown(WebDriver driver,WebElement element,String text){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10));
		 select.deselectByVisibleText(text);
	 }
	 public  void deSelectDropDown(WebDriver driver,WebElement element,String text,long timeOutInSecond){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond));
		 select.deselectByVisibleText(text);
	 }
	 public  void mouseHover(WebDriver driver,WebElement element){
		 Actions action=new Actions(driver);
		 action.moveToElement(element);
	 }
	 public  Alert switchToAlert(WebDriver driver){
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.alertIsPresent());
	 }
	 
 public void scrollBar(WebDriver driver,WebElement elementToFind)
	 {
		 while(true)
	        {
	            try
	            {	
	            	//elementToFind.click();
	            	
	            	// Added to click the product which is behind the view order
	            	JavascriptExecutor jse = (JavascriptExecutor) driver;
	            	jse.executeScript("arguments[0].click()", elementToFind);
	            	
	            	
	                break;
	            }
	            catch(Throwable t)
	            {
	            	
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	                System.out.println("hi this java");
	                js.executeAsyncScript(" ", "Window.scrollBy(0,50)");
	            }
	        }
	 }
 
 public void ScrollBarIntoView(WebDriver driver,WebElement element){
	 JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(true);", element);
 }
 
 public void uploadImageFile(WebDriver driver,String imgname) throws  FindFailed{
		/*StringSelection ss = new StringSelection(System.getProperty("user.dir")+ "\\BannerImages\\"+imgname);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//robot.delay(50);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		
		robot.keyRelease(KeyEvent.VK_ENTER);
	//customWait(5);
		robot=null;*/
	 
	 Pattern fileNameInput = new Pattern("C:\\Users\\Ramesh\\workspace\\OfferPlatforms-webAutomation\\BannerImages\\filename.JPG");
     Pattern openButton = new Pattern("C:\\Users\\Ramesh\\workspace\\OfferPlatforms-webAutomation\\BannerImages\\open.jpg");
    
     customWait(5);
     Screen screen = new Screen();
     screen.type(fileNameInput, "C:\\Users\\Ramesh\\workspace\\OfferPlatforms-webAutomation\\BannerImages\\"+imgname);
     screen.click(openButton);
		
 
 
		
 
 }
 
 
 
 public void uploadImageFile2(String imgname) throws AWTException{
		StringSelection ss = new StringSelection(System.getProperty("user.dir")+ "\\BannerImages\\"+imgname);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//robot.delay(50);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(50);
		
		robot.keyRelease(KeyEvent.VK_ENTER);
	//customWait(5);
		
 }
 
 
 public void setBannerOrder(WebDriver driver,List<WebElement>Bannerorder){
	 int i=1;
		for(WebElement web:Bannerorder){
			String temp=""+i;
			enterText(driver, web, temp);
			i++;
		}
	 
 }
 
 public int  SelectCampaign(WebDriver driver,List<WebElement> cnameWebElements,String Cname){
	 int i=0;
		for(WebElement wd:cnameWebElements){
		if(wd.getText().equals(Cname)){
			System.out.println(wd.getText());
			break;
		}
		else{
			i++;
		}
		}
		//ScrollBarIntoView(driver, getCampaignAction().get(i));
		//selectDropDown(driver, getCampaignAction().get(i),"View");
		return i;
 }
 
 
 public String  GetCreatedCampiagnName(WebDriver driver,List<WebElement> cnameWebElements,String Cname){
	 String i=null;
		for(WebElement wd:cnameWebElements){
		if(wd.getText().equals(Cname)){
			//System.out.println(wd.getText());
			i=wd.getText();
			break;
		}
		
		}
		//ScrollBarIntoView(driver, getCampaignAction().get(i));
		//selectDropDown(driver, getCampaignAction().get(i),"View");
		return i;
 }
 
 
 public void Selectplatforms(WebDriver driver,Map<String, WebElement>platfoms,String name){
	 
	String str[]=null;
	 if(name.contains(","))
	 {
		  str=name.split(",");
		  for(int i=0;i<str.length;i++){
				 WebElement wb=platfoms.get(str[i]);
				 wb.click();
			 }
	 }
		 else{ 
			// str=name.split("");
			 platfoms.get(name).click();
			 
	 }
	
	 
	 
 }
 
 
 public void uploadWebBanners(WebDriver driver, Map<String, List<WebElement>> ele,String name){
	 
	 String str[]=null;
	 if(name.contains(","))
	 {
		 str=name.split(",");
		  for(int i=0;i<str.length;i++){
			  List<WebElement>el=ele.get(str[i]);
				 clickOnElement(driver,el.get(0));
			  
			 }
	 }
		 else{ 
			
			 List<WebElement>el=ele.get(name);
			 clickOnElement(driver,el.get(0));
	 }
	 
	 

	 
	 
	 
	 /*for(int i=0;i<ele.size();i++){
		 List<WebElement>el=ele.get(str[i]);
		 clickOnElement(driver,el.get(0));
		 
	 }*/
	 
 }
 
 
 
 public void uploadAppBanners(WebDriver driver, Map<String, List<WebElement>> ele,String name){
	 
	 String str[]=null;
	 if(name.contains(","))
	 {
		 str=name.split(",");
		  for(int i=0;i<str.length;i++){
			  List<WebElement>el=ele.get(str[i]);
				 clickOnElement(driver,el.get(1));
			  
			 }
	 }
		 else{ 
			
			 List<WebElement>el=ele.get(name);
			 clickOnElement(driver,el.get(1));
	 }
}
 
 
 
public void uploadMsiteBanners(WebDriver driver, Map<String, List<WebElement>> ele,String name){
	 
	 String str[]=null;
	 if(name.contains(","))
	 {
		 str=name.split(",");
		  for(int i=0;i<str.length;i++){
			  List<WebElement>el=ele.get(str[i]);
				 clickOnElement(driver,el.get(2));
			  
			 }
	 }
		 else{ 
			
			 List<WebElement>el=ele.get(name);
			 clickOnElement(driver,el.get(2));
	 }
}



}