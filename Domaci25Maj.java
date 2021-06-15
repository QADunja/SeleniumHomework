package seleniumOsnove;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Domaci25Maj {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/");
		//driver.manage().window().maximize();
		
		WebElement Elements = driver.findElement(By.id("app"));
		Elements.click();
		
		WebElement Elements1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div/div[1]"));
		Elements1.click();
		
		WebElement TextBox = driver.findElement(By.id("item-0"));
		TextBox.click();
		
		WebElement FullName = driver.findElement(By.id("userName"));
		FullName.clear();
		FullName.sendKeys("Dunja Ivezic");
		FullName.click();
		
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
		Email.sendKeys("ivezicdunja@gmail.com");
		Email.click();
		
		WebElement CheckBox = driver.findElement(By.xpath("//*[@id=\"item-1\"]/span"));
		CheckBox.click();
		
	//	Select select = new Select(driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button/svg")));
	//	WebElement firstSelectedOption = select.getFirstSelectedOption();
		
	//	WebElement DropDown = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button/svg"));  
	//	Select dropdown = new Select(DropDown);  
		
// Puca mi kod dropdown-a, ne znam kako da selektujem tu strelicu.
		
		WebElement Dropdown = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button/svg/path"));
		Dropdown.click(); 
		
		WebElement DesktopSelect = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[1]/svg"));
		DesktopSelect.click();
		
		WebElement Elements2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div/div[1]"));
		Elements2.click();
		
		Thread.sleep(5000);
		driver.close();
	}

}

/*Napisati automatski test koji:
**Ocitava stranicu https://demoqa.com/ (inace stranica je namenjena za automatsko testiranje i
**odlicna je za pocetak pa mozete ako zelite proci kroz sve delove stranice)
**Klikne na "Elements"
**Klikne na "Text Box"
**Polje "Full name" ocisti pa unese vase ime - ciscenje se radi tako sto napisete ime elementa
kako ste ga nazvali i dodate .clear() na primer za element username bi bilo username.clear();
**U polje "Email" unesite vas email
**Kliknete na "Check Box"
Kliknete na strelicu da se spusti dropdown lista (levo od "Home" dugme)
**Selektujete samo "Desktop"
**Kliknete ponovo na "Elements" da se zatvori spisak
Na kraju stavite sleep 5 sekundi i zatvorite program */

