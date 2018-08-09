

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test27 {
	
	private static FluentWait<WebDriver> wait = null;
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
	
	public void test7() throws InterruptedException    {
		wait = new WebDriverWait(driver, 20);		
//		unos mesta odlaska
		driver.findElement(By.xpath(".//*[@id='s2id_location_from']/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='s2id_location_from']/a")).sendKeys("Belgrade");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("select2-result-label"))).click();
//		unos mesta dolaska
		driver.findElement(By.xpath(".//*[@id='s2id_location_to']/a/span[1]")).click();	
		driver.findElement(By.xpath(".//*[@id='s2id_location_to']/a")).sendKeys("Berlin");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("select2-result-label"))).click();   
//		datum polaska-2019-10-22
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[3]/div/input")).sendKeys("2018-10-22"); 
//		datum povratka-2019-12-22
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[4]/div/input")).sendKeys("2018-12-22");   
//		klik na pretragu
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[6]/button")).click();
//		driver.navigate().refresh();		
//		ocisti unete podatke datuma polaska
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[3]/div/input")).clear();		
//		ocisti unete podatke datuma povratka
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[4]/div/input")).clear();
		
	}
}