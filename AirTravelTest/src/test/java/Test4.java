

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test4 {

	static WebDriver driver = new ChromeDriver();	
	
	// FlightsHeadTest https://www.phptravels.net/flights
	//
	// ZADATAK:TestOneWay (Conditions: OneWay is click, class Economy is click and Person is 1)
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
	// 4.KOREKTAN UNOS DATUMA POLASKA. OSTALA POLJA BEZ UNOSA I clik na Search
	// Expeted: Message:"Do you need to fill in the name city and time trip, but
	// look all available all flights."
	// Actual: Available all flights.
	public void test4()  {
		driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[3]/div/input")).click();
		driver.findElement(By.xpath(".//*[@id='s2id_location_from']/a")).sendKeys("tomorrow");   	                            	 	
//		pretraga
		driver.findElement(By.xpath(".//*[@id=\"body-section\"]/div[2]/div/form/div[6]/button")).click();
//		uhvati ovu gresku i ispisi
		System.out.println("System message: Please fill out this field.");
	}
}