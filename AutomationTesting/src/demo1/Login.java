package demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login {
	public static void main(String[] args) {
		
		Login login = new Login();
		login.loginTest();;
		}

	@Test
	public void loginTest() {
		ExtentReports extent;
		ExtentTest test;
		
		extent = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\AutomationTesting\\test_reports\\\\loginTest.html",true);
		test = extent.startTest("Login Test");
		System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver.exe" );
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		test.log(LogStatus.INFO, "Browser is been opened");
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		test.log(LogStatus.PASS, "Navigates into the Login page");
		driver.findElement(By.id("email")).sendKeys("mdefgy34567@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("abc1234");
		test.log(LogStatus.PASS, "User login credentials are entered");
		driver.findElement(By.id("SubmitLogin")).click();
		test.log(LogStatus.PASS, "Logged into the user account");
		
		extent.endTest(test);
		extent.flush();
		
}
}
