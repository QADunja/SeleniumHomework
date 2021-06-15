package POMdomaci3Jun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pages {

	WebDriver driver;
	WebElement signInButton;
    WebElement emailOrUsernameInputField;
    WebElement continueButton;
	WebElement passwordInputField;
	WebElement logInButton;
	WebElement logOut;
	WebElement wrongEmailAddressText;
	WebElement wrongPasswordText;
	
	public Pages(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("masterbar"));
	}

	public WebElement getEmailOrUsernameInputField() {
		return driver.findElement(By.id("usernameOrEmail"));
	}

	public WebElement getContinueButton() {
		return driver.findElement(By.id("primary"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getLogInButton() {
		return driver.findElement(By.id("primary"));
	}
	
	public void insertEmailOrUsername(String username) {
		this.getEmailOrUsernameInputField().sendKeys(username);
	}
	public void insertPassword(String password) {
		this.getPasswordInputField().sendKeys(password);
	}
	public void clickOnSignInButton() {
		this.getSignInButton().click();
	}
	public void clickOnContinueButton() {
		this.getContinueButton().click();
	}
	public void clickOnLogInButton() {
		this.getLogInButton().click();
	}
	public String signInWelcomeText() {
		return  this.getLogInButton().getText();
	}
	public String wrongEmailAddressText() {
		return this.getContinueButton().getText();
	}
	public String wrongPasswordText() {
		return this.getContinueButton().getText();
	}
}

