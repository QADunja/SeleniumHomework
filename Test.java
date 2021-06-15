package Domaci3Jun;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Test extends Base {

	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	private void logInFormFilling(Object email, Object password) {}
	String textForAssertion;
	
	@org.testng.annotations.Test  (priority = 0)
	public void SignInInValidCredentials() {
		String emailOrUsernameField = citacIzExcela.getStringData("LogIn", 4, 2);
		String passwordField = citacIzExcela.getStringData("LogIn", 6, 2);
		Object email;
		Object password;
		logInFormFilling("ivezicdunja@gmail.com", "AuVCw^VA(q*w5Z-");
		String actualText = pages.signInWelcomeText();
		assertEquals(actualText, textForAssertion);
	}

	@org.testng.annotations.Test (priority = 0)
	public void WrongEmailGoodPassword() {
		String textForAssertion = citacIzExcela.getStringData("LogIn", 4, 3);
		String actualText = pages.getwrongEmailAddressText().getText();
		assertEquals(actualText, textForAssertion);
	}
	
	@org.testng.annotations.Test (priority = 0)
	public void GoodEmailWrongPassword() {
		String emailOrUsernameField = citacIzExcela.getStringData("LogIn", 4, 2);
		String textForAssertion = citacIzExcela.getStringData("LogIn", 6, 3);
		String actualText = pages.getwrongPasswordText().getText();
		assertEquals(actualText, textForAssertion);
	}
	
	@AfterMethod
	public void posleSvakogTesta() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
}
