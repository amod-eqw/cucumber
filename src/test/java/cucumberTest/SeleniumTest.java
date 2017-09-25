package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	public WebDriver driverChrome;
	
	
	@BeforeClass
	public void Setup() throws Exception {
		
  	  	
        System.setProperty("webdriver.chrome.driver","C:\\webDrivers\\chromedriver.exe");
	       ChromeOptions options = new ChromeOptions();
	       options.addArguments("--test-type");
	       driverChrome = new ChromeDriver(options);

  
    
        //rtarwade@deloitte.com/admin@123

// Reporter.log("Test Setup Complete", true); 
}
	@Test
	
	public void TC1_Login() throws InterruptedException
	{
		//Actions builderChrome = new Actions(driverChrome);
		driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverChrome.get("http://10.0.0.92:4444/CMS/#/");
		driverChrome.manage().window().maximize();
		Thread.sleep(5000);
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/div[1]/input")).click();
		Thread.sleep(5000);
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/div[1]/input")).sendKeys("rtarwade@deloitte.com");
		Thread.sleep(5000);
		
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/div[2]/input")).click();
		Thread.sleep(5000);
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/div[2]/input")).sendKeys("admin@123");
		Thread.sleep(5000);
		
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/button")).click();
		Thread.sleep(5000);
		
		String currentURL = driverChrome.getCurrentUrl();
		Assert.assertEquals("http://10.0.0.92:4444/CMS/#/superAdminDashboard", currentURL);
		System.out.println("current URL after login:"+currentURL);

	}
	
 
}
