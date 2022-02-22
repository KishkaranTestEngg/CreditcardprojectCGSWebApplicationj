package CreditcardprojectAutomation.CreditCardProject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class login 
{
WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void Appdriverhit() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://172.16.10.74:8186/StarCreditApp/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}
	
    @Test(priority =0)
	public void loginfunctionality() 
	{
		WebElement Usernamekeyin = driver.findElement(By.xpath("//input[@type='text']"));
		Usernamekeyin.sendKeys("TestingM");
		WebElement Passwordkeyin = driver.findElement(By.xpath("//input[@type='password']"));
		Passwordkeyin.sendKeys("Vinoth@12");
	    WebElement Submit= driver.findElement(By.xpath("//button[@type='submit']"));
	    Submit.click();
	    System.out.println("Login function completed"); // This is committed by gokul
    }
   @Test(priority =1)
  public void afterlogincheckwhethercorrecturl()
  {
	String Expected="http://172.16.10.74:8186/StarCreditApp/#/login";   
    String CurrentUrl = driver.getCurrentUrl();
    Assert.assertEquals(Expected, CurrentUrl);
    System.out.println("pass");
    {
    	System.out.println("fail"); // URL check done gokul on 17/02/2022 // Rechecked by kishore lead on 22/02/2022
    }
  }
    @AfterMethod
    public void driverclose()
    {
	 driver.close();
    }
    }
