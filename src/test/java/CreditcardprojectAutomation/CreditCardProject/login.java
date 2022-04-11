package CreditcardprojectAutomation.CreditCardProject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
Logger log = LogManager.getLogger(login.class.getName());

	@BeforeTest
	public void Appdriverhit() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://172.16.10.74:8081/StarPGCreditApp/#/login");	
		System.out.println("Driver got iniated Successfully");
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
		String Expected = "http://172.16.10.74:8081/StarPGCreditApp/#/login"; // deployment code done kishore lead 05April2022
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
	    Thread.sleep(1000);
	
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
    Givebatchno.sendKeys("BK12");
    System.out.println("BankbatchnogivenSuccessfully");
    JavascriptExecutor js1 = (JavascriptExecutor) driver;
    js1.executeScript("window.scrollBy(0,200)");
    Thread.sleep(1000);
    Select bankproductcode= new Select (driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/app-application-data/div[2]/div/div/div/div[1]/app-card/div/div/div/form/div[1]/div[4]/select")));
    bankproductcode.selectByVisibleText("Visa Platinum Customer");
    System.out.println("Branch product code is selected Successfully"); // Today done upto Branchcode by kishore lead 08/03/2022
    }
  @Test(priority= 6)
  public void afteropeningapplicationfillpersonaldetails() throws InterruptedException
  {
	   Thread.sleep(2000);
	   JavascriptExecutor js2 = (JavascriptExecutor) driver;
	   js2.executeScript("window.scrollBy(0,250)");
	   WebElement fillfirstname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
	   fillfirstname.sendKeys("Venky"); 
	   System.out.println("Firstname got filled");
	   WebElement fillmiddlename = driver.findElement(By.xpath("//input[@placeholder='Middle Name']"));
	   fillmiddlename.sendKeys("kish");
	   System.out.println("Middlename got filled");
	   WebElement filllastname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
	   filllastname.sendKeys("karan");
	   System.out.println("Lastname got filled");
	   Thread.sleep(1000);
	   WebElement clickdobfield = driver.findElement(By.xpath("//input[@placeholder='DOB']"));
	   clickdobfield.click();
	   clickdobfield.sendKeys("10032022");
	   System.out.println("DOB field got selected");
	   Select selectgender = new Select (driver.findElement(By.xpath("//select[@placeholder='Gender']")));
	   selectgender.selectByVisibleText("Male");
	   WebElement GiveFatherdetails = driver.findElement(By.xpath("//input[@placeholder='Father Name']"));
	   GiveFatherdetails.sendKeys("Prabakaran");
	   System.out.println("Father name given");
	   JavascriptExecutor js3 = (JavascriptExecutor) driver;
	   js3.executeScript("window.scrollBy(0,250)");
	   Thread.sleep(1000);
	   WebElement GiveMotherdetails = driver.findElement(By.xpath("//input[@placeholder='Mother Name']"));
	   GiveMotherdetails.sendKeys("Indradevi");
	   System.out.println("Mother name given");
	   Thread.sleep(1000);
	   WebElement MotherMaidenname = driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/app-application-data/div[2]/div/div/div/div[1]/app-card/div/div/div/form/div[2]/div[8]/input"));
	   MotherMaidenname.sendKeys("Cmdevi");
	   Select Selectmartialstatus = new Select(driver.findElement(By.xpath("//select[@placeholder='Maritial Status']")));
	   Selectmartialstatus.selectByVisibleText("Married");
	   WebElement Enterspousename = driver.findElement(By.xpath("//input[@placeholder='Spouse Name']"));
	   Enterspousename.sendKeys("Divya");
	   System.out.println("The spouse name entered Successfully");
	   WebElement Keyinmobilenumber = driver.findElement(By.xpath("//input[@placeholder='20xxxxxx12']"));
	   Keyinmobilenumber.sendKeys("8794561235");
	   System.out.println("Mobile number keyedin Successfully");
	   WebElement EmailID = driver.findElement(By.xpath("//input[@placeholder='Email ID']"));
	   EmailID.sendKeys("kishtest@cashlinkglobal.com");
	   System.out.println("Emailid entered Successfully");
	   Thread.sleep(1000);
	   WebElement keyindependencies = driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/app-application-data/div[2]/div/div/div/div[1]/app-card/div/div/div/form/div[2]/div[13]/input"));
	   keyindependencies.sendKeys("23456789");
	   System.out.println("Adhar card no filled");
	   WebElement fillpancardno = driver.findElement(By.xpath("//input[@formcontrolname='panno']"));
	   fillpancardno.sendKeys("AWJ345");
	   System.out.println("Pancardno details filled Successfully");
	   WebElement Passportnofilled = driver.findElement(By.xpath("//input[@placeholder='Passport No']"));
	   Passportnofilled.sendKeys("PSD3456");
	   WebElement fillingdependencies = driver.findElement(By.xpath("//input[@formcontrolname='noofdependency']"));
	   fillingdependencies.sendKeys("2");
	   driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/app-application-data/div[2]/div/div/div/div[1]/app-card/div/div/div/div/button[1]")).click();
	   System.out.println("finally clicking the save proceed & Personal details completed"); // Completed Personal details in Application capture kishore lead on march1022
       }
	   @Test(priority= 7)
	   public void NeedtofillEmploymentdetails() throws InterruptedException
	   {
		   Thread.sleep(3000);
		   System.out.println("Need to select the Employment details");
		   Select SelectEmpdetails = new Select (driver.findElement(By.xpath("//select[@formcontrolname='employementType']")));
		   SelectEmpdetails.selectByValue("Self Employed Professional");
		   WebElement fillemployeename = driver.findElement(By.xpath("//*[contains(@placeholder,'Employer Name')]"));
		   fillemployeename.sendKeys("kishorekaran");
		   WebElement Filloccupationdetails = driver.findElement(By.xpath("//*[contains(@placeholder,'Occupation')]"));
		   Filloccupationdetails.sendKeys("Software Engineer");
		   WebElement Giveannualsalary = driver.findElement(By.xpath("//*[contains(@placeholder,'Annual Salary')]"));
		   Giveannualsalary.sendKeys("1000");
		   WebElement Otherincomesalary = driver.findElement(By.xpath("//*[contains(@placeholder,'Other Income Salary')]"));
		   Otherincomesalary.sendKeys("200");
		   WebElement Bussinessincome = driver.findElement(By.xpath("//*[contains(@placeholder,'Business Income')]"));
		   Bussinessincome.sendKeys("500");
		   WebElement Totalincome = driver.findElement(By.xpath("//*[contains(@placeholder,'Total Income')]"));
		   Totalincome.sendKeys("1700");
		   WebElement address1 = driver.findElement(By.xpath("//*[contains(@placeholder,'Address Line 1')]"));
		   address1.sendKeys("welcome to cgs street 1");
		   WebElement address2  = driver.findElement(By.xpath("//*[contains(@placeholder,'Address Line 2')]"));
		   address2.sendKeys("North street road");
		   driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[2]/div/div/div/div/div/div/div/app-application-data/div[2]/div/div/div/div[1]/app-card/div/div/div/div/button[1]")).click();
		   System.out.println("Employee details completed"); // Code done upto employee fill details 11 april 2022
	   }
	   
	   
	   
  }

	
//	@Test(priority =4)
//	public void driverclose() {
//		driver.close();
//		System.out.println("Chrome driver closed");
//	}
//}
