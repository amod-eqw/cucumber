package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class Dlearn_Loging {
	
	public static WebDriver driverChrome;
	
	
	
	@BeforeClass
	public void Setup() throws Exception {
		
  	  	
        System.setProperty("webdriver.chrome.driver","C:\\webDrivers\\chromedriver.exe");
	       ChromeOptions options = new ChromeOptions();
	       options.addArguments("--test-type");
	       driverChrome = new ChromeDriver(options);
	}
	
  @Given("^User opens Dlearn CMS application$")
  public void user_opens_dlearn_cms_application() throws Throwable {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\webDrivers\\chromedriver.exe");
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--test-type");
      driverChrome = new ChromeDriver(options);
	  
	  driverChrome.get("http://10.0.0.92:4444/CMS/#/");
		driverChrome.manage().window().maximize();
		Thread.sleep(5000);
//		throw new PendingException();
  }

  @And("^user enters valid username and password$")
  public void user_enters_valid_username_and_password() throws Throwable {
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/div[1]/input")).click();
		Thread.sleep(5000);
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/div[1]/input")).sendKeys("rtarwade@deloitte.com");
		Thread.sleep(5000);
		
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/div[2]/input")).click();
		Thread.sleep(5000);
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/div[2]/input")).sendKeys("admin@123");
		Thread.sleep(5000);
		
//		throw new PendingException();
  }

  @When("^Clicks on Login button$")
  public void clicks_on_login_button() throws Throwable {
		driverChrome.findElement(By.xpath("//*[@id='contentdiv']/div[2]/form/button")).click();
		Thread.sleep(5000);
		
//		throw new PendingException();
  }

  @Then("^User is able to view SuperAdmin Dashboard$")
  public void user_is_able_to_view_SuperAdmin_dashboard() throws Throwable {
	    Thread.sleep(10000);
		String currentURL = driverChrome.getCurrentUrl();
		System.out.println("current URL after login:"+currentURL);
		Assert.assertEquals("http://10.0.0.92:4444/CMS/#/superAdminDashboard", currentURL);
		
		
//		throw new PendingException();
  }

}
