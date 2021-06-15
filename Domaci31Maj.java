package testNG;

	import static org.testng.Assert.assertEquals;
    import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Domaci31Maj {
		
		WebDriver driver;
		
		@BeforeClass
		public void preSihTestova() {
			System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		}
		@BeforeMethod
		public void preSvakogTesta() throws InterruptedException {
			driver.navigate().to("http://cms.demo.katalon.com/my-account/");
			driver.manage().window().maximize();
		}
		
		@Test (priority = 0)
		public void LogovanjeSaDobrimKredencijalima() {
			WebDriverWait cekanje = new WebDriverWait(driver, 10);
			WebElement username = cekanje.until(ExpectedConditions.elementToBeClickable(By.id("username")));
			username.sendKeys("customer");
			WebDriverWait cekanje1 = new WebDriverWait(driver, 10);
			WebElement password = cekanje1.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			password.sendKeys("123456789");
			WebDriverWait cekanje2 = new WebDriverWait(driver, 10);
			WebElement logIn = cekanje2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-10\"]/div/div/form/p[3]/button")));
			logIn.click();
			String actualText = driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/p[1]/a")).getText();
			assertEquals(actualText, "Log out");
		}
		
		@Test (priority = 5)
		public void LogovanjeSaPogresnimUsername() {
			WebDriverWait cekanje = new WebDriverWait(driver, 10);
			WebElement username = cekanje.until(ExpectedConditions.elementToBeClickable(By.id("username")));
			username.sendKeys("Dunja");
			WebDriverWait cekanje1 = new WebDriverWait(driver, 10);
			WebElement password = cekanje1.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			password.sendKeys("123456789");
			WebDriverWait cekanje2 = new WebDriverWait(driver, 10);
			WebElement logIn = cekanje2.until(ExpectedConditions.elementToBeClickable(By.name("login")));
			logIn.click();
			String actualText = driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/ul")).getText();
			assertEquals(actualText, "ERROR: Invalid username. Lost your password?");
		}
		
		@Test (priority = 10)
		public void LogovanjeSaPogresnimPassword() {
			WebDriverWait cekanje = new WebDriverWait(driver, 10);
			WebElement username = cekanje.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"username\"]")));
			username.sendKeys("customer");
			WebDriverWait cekanje1 = new WebDriverWait(driver, 10);
			WebElement password = cekanje1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]")));
			password.sendKeys("Dunja");
			WebDriverWait cekanje2 = new WebDriverWait(driver, 10);
			WebElement logIn = cekanje2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-10\"]/div/div/form/p[3]/button")));
			logIn.click();
			String actualText = driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/ul/li")).getText();
			assertEquals(actualText, "ERROR: The password you entered for the username customer is incorrect. Lost your password?");
		}
		
		@Test (priority = 15)
		public void LogovanjeBezKredencijala() {
			WebDriverWait cekanje = new WebDriverWait(driver, 10);
			WebElement login = cekanje.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-10\"]/div/div/form/p[3]/button")));
			login.click();
			String actualText = driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/ul/li")).getText();
			assertEquals(actualText, "Error: Username is required.");
		}
		
		@Test (priority = 20)
		public void logout () {
			LogovanjeSaDobrimKredencijalima();		
			WebDriverWait cekanje = new WebDriverWait(driver, 15);
			WebElement logOut = cekanje.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-10\"]/div/div/div/p[1]/a")));
			logOut.click();
			String actualText = driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/form/p[3]/button")).getText();
			assertEquals(actualText, "LOG IN");
		}
		
		@AfterMethod
		public void posleSvakogTesta() {
			driver.manage().deleteAllCookies();
		}
		
		@AfterClass
		public void posleSvihTestova() {
			driver.close();
		}	
} 