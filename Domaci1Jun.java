package testNG;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tests.BaseTests;

public class Domaci1Jun extends Domaci1JunGlavna {
		
		@BeforeMethod
		public void preSvakogTesta() {
			driver.navigate().to("http://cms.demo.katalon.com/");
			driver.manage().window().maximize();
		}
		@Test(priority = 0)
		public void addProductToCartTest() {
			shopPage.addFlyingNinjaToCartButtonClick();
			shopPage.flyingNinjaViewCartButtonClick();
			String actualText = cartPage.textFromitem1ProductName();
			assertEquals(actualText, "Flying Ninja");
		}
		
		@Test(priority = 5)
		public void removeProductFromCartTest() {
			addProductToCartTest();
			cartPage.removeItem1ButtonClick();
			String actualText = cartPage.getFromEmptyCartLabel();
			assertEquals(actualText, "Your cart is currently empty.");
		}
	//-----------------------------------------------------------------
		@Test(priority = 0)
		public void addProductToCartTest1() {
			shopPage.addHappyNinjaToChartButtonClick();;
			shopPage.happyNinjaViewCartButton();
			String actualText = cartPage.textFromitem1ProductName();
			assertEquals(actualText, "Happy Ninja");
		}
	//-------------------------------------------------------------
		@Test(priority = 10)
		public void addProductTCard10Times() throws InterruptedException {
			for (int i = 0; i < 10; i++) {
				shopPage.addFlyingNinjaToCartButtonClick();
				Thread.sleep(200);
			}
			shopPage.flyingNinjaViewCartButtonClick();
			String actualText = cartPage.textFromTotalPriceForItem();
			assertEquals(actualText, "$120.00");
		}
	//--------------------------------------------------------------
		@Test (priority = 0)
		public void viewPremiumQualityProduct() {
			shopPage.addClickOnPremiumQualityProductSale();
			shopPage.clickOnPremiumQualityProductSaletPage();
		}
		
		@AfterMethod
		public void posleSvakogTesta() throws InterruptedException {		
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
		}
	} 


/*Dodati jos 2 zahteva (slicni onim sto vam je Milovan zadao iznad) po sopstvenom izboru
 *  vezano za danasnje predavanje.*/