package CreditcardprojectAutomation.CreditCardProject;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	@Test(priority=3)
	public void clickApplicationdatacaptureoption() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/nav/div[2]/perfect-scrollbar/div/div[1]/div[2]/ul[2]/li/ul/li[1]/a/span[2]")));
	    driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/nav/div[2]/perfect-scrollbar/div/div[1]/div[2]/ul[2]/li/ul/li[1]/a/span[2]")).click();
	    System.out.println("Successfully able to open application data capture option"); // Today worked code datacapture by kishore team lead 03/03/2022
	    //Thread.sleep(1000);
	
	}
	
	@Test(priority=4)
	public void OpenNewApplicationfilldetails() throws InterruptedException
	{
	     Thread.sleep(3000);
	     Actions actions = new Actions(driver);
	     WebElement NewApplication = driver.findElement(By.xpath("//*[@id='nav-appl-tab']"));
	     actions.moveToElement(NewApplication).moveToElement(driver.findElement(By.xpath("//*[@id='nav-appl-tab']"))).build().perform();
	     ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id='nav-appl-tab']")));
	     System.out.println("In applicationdatacapturepage New application opened");
	}

	@Test(priority=5)
    public void afteropeningapplicationfillbankdetails() throws InterruptedException
	{
	Thread.sleep(3000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,50)");
    Thread.sleep(3000);
    Actions actions = new Actions(driver);
    WebElement fillbankappnumber = driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/app-application-data/div[2]/div/div/div/div[1]/app-card/div/div/div/form/div[1]/div[1]/input"));
    actions.moveToElement(fillbankappnumber).moveToElement(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/app-application-data/div[2]/div/div/div/div[1]/app-card/div/div/div/form/div[1]/div[1]/input")));
    ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/app-application-data/div[2]/div/div/div/div[1]/app-card/div/div/div/form/div[1]/div[1]/input")));
    fillbankappnumber.sendKeys("BICABC0412");
    System.out.println("BankAppnofilled"); // Today upto bank fill details code done by kishore lead  07/03/2022
    Select Selectbranchname =new Select (driver.findElement(By.xpath("//select[@placeholder='Branch Name']")));	
    Selectbranchname.selectByVisibleText("Egmore");
    System.out.println("Bank branch name Selected");
    WebElement Givebatchno = driver.findElement(By.xpath("//input[@placeholder='Batch Number']"));
    Givebatchno.sendKeys("BranchnoBIC248");
    System.out.println("BankbatchnogivenSuccessfully");
    JavascriptExecutor js1 = (JavascriptExecutor) driver;
    js1.executeScript("window.scrollBy(0,200)");
    Thread.sleep(1000);
    Select bankproductcode= new Select (driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/app-application-data/div[2]/div/div/div/div[1]/app-card/div/div/div/form/div[1]/div[4]/select")));
    bankproductcode.selectByVisibleText("Visa Platinum Customer");
    System.out.println("Branch product code is selected Successfully"); // Today done upto Branchcode by kishore lead 08/03/2022
    
}
}
	
//	@Test(priority =4)
//	public void driverclose() {
//		driver.close();
//		System.out.println("Chrome driver closed");
//	}
//}
