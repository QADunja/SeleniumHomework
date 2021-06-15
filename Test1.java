package POMdomaci3Jun;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends BaseClass {
	
    WebDriver driver;
    
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	@Test  (priority = 0)
	public void SignInInValidCredentials() {
		pages.clickOnSignInButton();
		String username = citacIzExcela.getStringData("LogIn", 4, 2);
		String password = citacIzExcela.getStringData("LogIn", 6, 2);
		pages.insertEmailOrUsername("ivezicdunja@gmail.com");
		pages.clickOnContinueButton();
		pages.insertPassword("AuVCw^VA(q*w5Z-");
		pages.clickOnLogInButton();

		String actualText = pages.signInWelcomeText();
		assertEquals(actualText, "Welcome!");
	}
	
	@Test (priority = 0)
	public void WrongEmailGoodPassword() {
		pages.clickOnSignInButton();
		String username = citacIzExcela.getStringData("LogIn", 4, 2);
		pages.clickOnContinueButton();
	
		String actualText = pages.wrongEmailAddressText();
		assertEquals(actualText, "User does not exist. Would you like to create a new account?");
	}
	
	@Test (priority = 0)
	public void GoodEmailWrongPassword() {
		pages.clickOnSignInButton();
		String username = citacIzExcela.getStringData("LogIn", 4, 2);
		pages.clickOnContinueButton();
		String password = citacIzExcela.getStringData("LogIn", 6, 2);
		pages.clickOnLogInButton();
	
		String actualText = pages.wrongPasswordText();
		assertEquals(actualText, "Oops, that's not the right password. Please try again!");
	}
	
	
	
	
	
	@AfterMethod
	public void posleSvakogTesta() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	
	
}
