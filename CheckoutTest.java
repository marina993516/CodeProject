package tests;

import org.junit.Test;
import org.openqa.selenium.By;

import pages.HomePage;
import pages.LoginPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

  public LoginPage LoginPage;
  public HomePage HomePage;
  public CheckoutPage CheckoutPage;

  By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
  String standardUsername = "standard_user";
  String password = "secret_sauce";
  String firstName = "Marina";
  String lastName = "Petrovic";
  String postCode = "18000";
  String successfulMessage ="THANK YOU FOR YOUR ORDER";

  
  @Test
  public void verifyCorrectTotalPrice() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    loginPage.openBasePage();
    loginPage.login(standardUsername, password);
    homePage.addProductToCart(addToCartButton1By);
    checkoutPage.clickOnCartLink();
    checkoutPage.clickOnCheckoutButton();
    checkoutPage.fillCheckoutStepOne(firstName, lastName, postCode);
    checkoutPage.verifyTotalPrice();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void verifySuccessfulPurcase() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    
    loginPage.openBasePage();
    loginPage.login(standardUsername, password);
    homePage.addProductToCart(addToCartButton1By);
    checkoutPage.clickOnCartLink();
    checkoutPage.clickOnCheckoutButton();
    checkoutPage.fillCheckoutStepOne(firstName, lastName, postCode);
    checkoutPage.clickOnFinishButton();
    checkoutPage.verifyCompleteHeader(successfulMessage);
    
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
