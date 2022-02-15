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
    }
    @AfterMethod
    public void driverclose()
    {
	 driver.close();
    }
    }
