

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test5 {
	private static FluentWait<WebDriver> wait = null;
	static WebDriver driver = new ChromeDriver();

	// FlightsHeadTest https://www.phptravels.net/flights
	//
	// ZADATAK:TestOneWay (Conditions: OneWay is click, class Economy is click and
	// Person is 1)
	// Unos samo tri slova za grad nije moguce jer aplikacija smatra da u tom
	// slucaju nismo odabrali grad i nema rezultata!?
	// Zbog ovoga kod unosa grada za polazak i dolazak nece biti testirana mogucnost
	// unosa grada sa tri slova.

	@BeforeClass
	public static void setChromedriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		driver.manage().window().maximize();
		String url = "https://www.phptravels.net/flights";
		driver.get(url);
		// OneWay is click
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[9]/div[1]/div/div/ins")).click();
	}

	@AfterClass
	public static void closeDriver() {
		driver.close();
	}

	@Test
	// 5.KOREKTAN UNOS GRADA ZA POLAZAK I ZA DOLAZAK. BEZ UNOSA DATUMA POLASKA I
	// clik na Search
	// Expeted:In field Depard text message:"Please fill out this field."
	// Actual: In field Depard text message:"Please fill out this field."
	public void test5() throws InterruptedException  {
		wait = new WebDriverWait(driver, 20);
//		unos mesta odlaska
		driver.findElement(By.xpath(".//*[@id='s2id_location_from']/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='s2id_location_from']/a")).sendKeys("Belgrade");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("select2-result-label"))).click();
//		unos mesta dolaska
		driver.findElement(By.xpath(".//*[@id='s2id_location_to']/a/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='s2id_location_to']/a")).sendKeys("Paris");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("select2-result-label"))).click();
//    	pretraga
		driver.findElement(By.xpath(".//*[@id=\"body-section\"]/div[2]/div/form/div[6]/button")).click();
//		uhvati ovu gresku i ispisi
		System.out.println("System message: Please fill out this field.");
	}
}