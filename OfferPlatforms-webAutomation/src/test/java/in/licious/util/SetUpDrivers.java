package in.licious.util;
import java.io.File;
import java.net.MalformedURLException; 
import java.net.URL;
import java.util.Locale;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//<<<<<<< HEAD
 import org.openqa.selenium.firefox.FirefoxDriver;
//=======
////import org.openqa.selenium.firefox.FirefoxDriver;
//>>>>>>> branch 'knockout' of https://github.com/VishwaLicious/Payments-Knockout.git
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.collect.ImmutableMap;


public class SetUpDrivers {
	public enum OSType {
	    Windows, MacOS, Linux, Other
	  };
	//private static OSType detectedOS;
	private  WebDriver driver;
	public  WebDriver launchFirefoxDriver(String url){
		String os=new String(getOSType().toString());
		System.out.println("Os is "+os);
		// This is for windows
		if(os.equals("Windows")){
			System.out.println("Os is "+os);
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
		}else if(os.equals("MacOS")){
		
			// This for mac
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/BrowserDrivers/geckodriver");
		
		}else if(os.equals("Linux")){
			System.out.println("Os is ");
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/BrowserDrivers/linux/geckodriver");
		}
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"C:\\Users\\Sriya\\git\\Payments-Knockout\\websiteautomation\\BrowserDrivers\\geckodriver.exe");
//<<<<<<< HEAD
//		driver=new FirefoxDriver();
//=======
		driver=new FirefoxDriver();
//>>>>>>> branch 'knockout' of https://github.com/VishwaLicious/Payments-Knockout.git
		driver.get(url);
		return driver;
	}
	
	// 
	public  WebDriver launchChromeDriver(String url){
		
		// This is for Windows os
	
		String os=new String(getOSType().toString());
		//os="Windows";
		System.out.println(" Current OS running is " + os);
		
			if(os.equals("Windows")){
				
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
				
	}else if(os.equals("MacOS")){
		
		
		System.out.println(" Current OS running is " + os);
		
		
		// This is for Mac os
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/BrowserDrivers/chromedriver");
	}else if(os.equals("Linux")){
		
		
		System.out.println(" Current OS running is " + os);
		
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/BrowserDrivers/linux/chromedriver");
		
		
          
            
          
 }
		
			ChromeOptions options = new ChromeOptions(); 
			
			//.addArguments("--port=4159");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-extensions");
/*			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
			options.addArguments("--start-maximized");
			options.addArguments("--headless");*/
			//options.setBinary(System.getProperty("user.dir")+"/BrowserDrivers/linux/chromedriver");
			/*options.addArguments("--headless", "--window-size=1920,1200","--ignore-certificate-errors");*/ 
			driver=new ChromeDriver(options);
			driver.get(url);
			return driver;
		
		
		// This is for Linux
		
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
	}
		
		
		// This is for Mac os
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/BrowserDrivers/chromedriver");
		
		
	//	System.setProperty("webdriver.chrome.driver",System.getProperty("/Users/Vishwa/Downloads/SeleniumWebDriver-master/BrowserDrivers/chromedriver"));

	
	
	public  WebDriver launchInternetExplorerDriver(String url){
		String os=new String(getOSType().toString());
		if(os.equals("Windows")){
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\IEDriverServer.exe");
	}else if(os.equals("MacOS")){
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/BrowserDrivers/IEDriverServe");
	}
		driver=new InternetExplorerDriver();
		driver.get(url);
		return driver;		
	}
	public  WebDriver launchEdgeDriver(String url){
		driver=new EdgeDriver();
		driver.get(url);
		return driver;		
	}
	public  WebDriver launchOperaDriver(String url){
		driver=new OperaDriver();
		driver.get(url);
		return driver;		
	}
	public  WebDriver launchSafariDriver(String url){
		driver=new SafariDriver();
		driver.get(url);
		return driver;		
	}
	
	
	public  WebDriver	launchRemoteDriver(String remoteAddress,String url,Capabilities capabilities){
		
		try {
			
			driver=new RemoteWebDriver(new URL(remoteAddress), capabilities);
			driver.get(url);
			return driver;
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static  OSType getOSType(){
		OSType detectedOS=null;
		 String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		 
	      if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
	        detectedOS = OSType.MacOS;
	        
	      } else if (OS.indexOf("win") >= 0) {
	        detectedOS = OSType.Windows;
	        
	      } else if (OS.indexOf("nux") >= 0) {
	        detectedOS = OSType.Linux;
	      } else {
	        detectedOS = OSType.Other;
	      }
		return detectedOS;
	}
}
