

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test24 {	
	static WebDriver driver = new ChromeDriver();

// FlightsHeadTest https://www.phptravels.net/flights

//	ZADATAK:TestRoundTrip (Conditions: RoundTrip is click, class Economy is click and Person is 1)

	@BeforeClass
	public static void setChromedriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		driver.manage().window().maximize();
		String url = "https://www.phptravels.net/flights";
		driver.get(url);
		// Round Trip is click
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[9]/div[2]/div/div/ins")).click();	
	}

	@AfterClass
	public static void closeDriver() {
		driver.close();
	}
	
	@Test
	// 4.KOREKTAN UNOS OBA DATUMA DOLASKA. OSTALA POLJA BEZ UNOSA I clik na Search

	public void test4()  {
//		datum polaska
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[3]/div/input")).sendKeys("tomorrow");  
	
//		datum povratka
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[4]/div/input")).sendKeys("2019-12-22");   
		
//		pretraga
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[6]/button")).click();
		                      
	}
}