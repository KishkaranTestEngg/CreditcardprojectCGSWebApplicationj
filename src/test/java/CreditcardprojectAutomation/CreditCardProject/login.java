package CreditcardprojectAutomation.CreditCardProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class login 
{
WebDriver driver;

	@BeforeTest
	public void Appdriverhit() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://172.16.10.74:8186/StarCreditApp/#/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@Test(priority = 0)
	public void loginfunctionality() throws InterruptedException {
		Thread.sleep(2000);
		WebElement Usernamekeyin = driver.findElement(By.xpath("//input[@type='text']"));
		Usernamekeyin.sendKeys("TestingM");
		WebElement Passwordkeyin = driver.findElement(By.xpath("//input[@type='password']"));
		Passwordkeyin.sendKeys("Vinoth@12");
		WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();
		System.out.println("Login function completed"); // This is committed by gokul
	}

	@Test(priority = 1)
	public void afterlogincheckwhethercorrecturl() throws InterruptedException {
		String Expected = "http://172.16.10.74:8186/StarCreditApp/#/login";
		String CurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(Expected, CurrentUrl); //Reconfirmed today 	by kishore lead 02march22
		Thread.sleep(2000);
		System.out.println("URl check completed");
	}
	@Test(priority =2)
	public void NavigatetoApplicationfullfillmentoption() throws InterruptedException
	{
		Thread.sleep(5000);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/nav/div[2]/perfect-scrollbar/div/div[1]/div[2]/ul[2]/li/a")));
		
		//WebElement clickapplicationfullfillment = driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/nav/div[2]/perfect-scrollbar/div/div[1]/div[2]/ul[2]/li/a"));
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/nav/div[2]/perfect-scrollbar/div/div[1]/div[2]/ul[2]/li/a")).click();
		System.out.println("Successfully clicked the Applicationfullfillmentoption"); // code reworked upto clickapplicationfullfillment option
	}
	
	@Test(priority =3)
	public void driverclose() {
		driver.close();
		System.out.println("Chrome driver closed");
	}
}
