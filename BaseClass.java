package POMdomaci3Jun;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import tests.ExcelReader;

public class BaseClass {

	WebDriver driver;
	Pages pages;
	Test1 test;
	ExcelReader citacIzExcela;
	String homeUrl;

	@BeforeClass
	public void preSihTestova() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		pages = new Pages(driver);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		citacIzExcela = new ExcelReader("data/Domaci3Jun.xlsx");
		homeUrl = "https://wordpress.com/";
	}

	@AfterClass
	public void posleSihTestova() {
		driver.close();
	}
}

