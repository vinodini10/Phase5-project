package demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Searchproduct {
public static void main(String[] args) {
		
		Searchproduct searchTest = new Searchproduct();
		searchTest.search();
		
}
	@Test
	public void search() {
		ExtentReports extent;
		ExtentTest test;
		
		extent = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\AutomationTesting\\test_reports\\\\SearchTest.html",true);
		test = extent.startTest("Product Search Test ");
		System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver.exe" );
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
		test.log(LogStatus.PASS, "Navigates into Search TextBox");
		
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
		
		test.log(LogStatus.PASS, "The product to be searched is entered");
		driver.findElement(By.name("submit_search")).click();
		test.log(LogStatus.PASS, "Displays the productslist related to search item");
		
		extent.endTest(test);
		extent.flush();


}
}
