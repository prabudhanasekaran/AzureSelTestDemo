//Azure DevOps takes the code only from Git
//

package azureTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	
	public WebDriver driver=null;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void awsTest(String browser) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities cap = null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("Browser Selected - "+browser);
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			cap = new DesiredCapabilities();
//			cap.setCapability("browserName", "chrome");
//			
//			try {
//				//RemoteWebDriver 
//				URL url = new URL("http://ec2-13-234-48-218.ap-south-1.compute.amazonaws.com:4444/wd/hub");		 
//				driver = new RemoteWebDriver(url,cap);
//			}
//		    catch(MalformedURLException e) {
//		    	e.printStackTrace();
//		    }
		
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("Browser Selected - "+browser);
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
//			cap = new DesiredCapabilities();
//			cap.setCapability("browserName", "firefox");
//			
//			try {
//				//RemoteWebDriver 
//				URL url = new URL("http://ec2-13-234-48-218.ap-south-1.compute.amazonaws.com:4444/wd/hub");		 
//				driver = new RemoteWebDriver(url,cap);
//			}
//		    catch(MalformedURLException e) {
//		    	e.printStackTrace();
//		    }
		}

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void googleTypeTest() throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Hello Chrome");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}





//<test name="Test for IE">
//<parameter name="browser" value="iexplore"></parameter>
//    <classes>
//        <class name="awsTesting.GoogleTest" ></class> 
//        

/*
 * else if(browser.equalsIgnoreCase("iexplore")) {
 * WebDriverManager.iedriver().setup(); driver = new InternetExplorerDriver();
 * cap = new DesiredCapabilities(); cap.setCapability("browserName",
 * "iexplore"); }
 */
//    </classes>
//</test>
