package demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddToCart {
public static void main(String[] args) {
		
		AddToCart add = new AddToCart();
		add.addToCartTest();
	}
	
	@Test
	public void addToCartTest() {
		
		ExtentReports extent;
		ExtentTest test;
		
		extent = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\AutomationTesting\\test_reports\\AddToCartTest.html",true);
		test = extent.startTest("Add To Cart Test");
		
		
		System.setProperty("webdriver.gecko.driver","D:\\firefoxDriver\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
	
		test.log(LogStatus.INFO, "Browser is been opened");
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("mdefgy34567@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("abc1234");
		test.log(LogStatus.PASS, "User login credentials are entered");
		driver.findElement(By.id("SubmitLogin")).click();
		test.log(LogStatus.PASS, "Logged into the user account");
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
		test.log(LogStatus.PASS, "Select the required product to add in your cart");
		driver.findElement(By.name("submit_search")).click();
		WebElement img = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[src='http://automationpractice.com/img/p/1/1-home_default.jpg']")));
		img.click();
		 
		test.log(LogStatus.PASS, "Select the AddToCart option");
		
		WebElement add = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		add.click();
		
		test.log(LogStatus.PASS, "Your cart is been updated");
		
		extent.endTest(test);
		extent.flush();
}
	}
