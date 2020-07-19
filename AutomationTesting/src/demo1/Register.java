package demo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Register {
	public static void main(String[] args) throws InterruptedException {
		
		Register registerTest = new Register();
		registerTest.registrationTest();
	}
	@Test
	public void registrationTest() throws InterruptedException {
		
		ExtentReports extent;
		ExtentTest test;
		extent = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\AutomationTesting\\test_reports\\\\RegistrationTest.html",true);
		test = extent.startTest("New Account Registration Test");
		System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver.exe" );
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		test.log(LogStatus.INFO, "Browser is been opened");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
	
		driver.findElement(By.id("email_create")).sendKeys("mdefgy34567@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		test.log(LogStatus.PASS, "Enter the valid information in the registration form");
		WebElement radio = driver.findElement(By.id("id_gender2"));
		radio.click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Sanjana");
		driver.findElement(By.id("customer_lastname")).sendKeys("sri");
		driver.findElement(By.id("passwd")).sendKeys("abc1234");
		test.log(LogStatus.PASS, "User Password is confirmed");
		driver.findElement(By.id("company")).sendKeys("ABC Pvt Ltd");
		driver.findElement(By.id("address1")).sendKeys("10,Rajiv Street");
		driver.findElement(By.id("address2")).sendKeys("Golden apartment,1st floor");
		driver.findElement(By.id("city")).sendKeys("Pune");
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Indiana");
		driver.findElement(By.id("postcode")).sendKeys("60045");
		driver.findElement(By.id("phone_mobile")).sendKeys("9876545678");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("Chennai");
		test.log(LogStatus.PASS, "Before hitting register button,check your details that have been entered");
		Thread.sleep(10000);
		driver.findElement(By.id("submitAccount")).click();
		test.log(LogStatus.PASS, "Account has been successfully created");
		
		extent.endTest(test);
		extent.flush();
	}
}
