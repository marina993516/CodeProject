package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

  public LoginPage loginPage;

  String standardUsername = "standard_user";
  String lockedOutUser = "locked_out_user";
  String password = "secret_sauce";
  String expectedText = "PRODUCTS";
  String emptyPassword = "";
  String badUsername = "greska";
  String lockedUserError = "Epic sadface: Sorry, this user has been locked out.";
  String emptyPasswordError = "Epic sadface: Password is required";
  String badUsernameError = "Epic sadface: Username and password do not match any user in this service";

  @Test
  public void verifySuccesfulLogin() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.openBasePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(expectedText);

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void verifyUnsuccesfulLogin() {
    LoginPage loginPage = new LoginPage(driver);

    loginPage.openBasePage();
    loginPage.login(lockedOutUser, password);
    loginPage.verifyUnsuccesfulLogin(lockedUserError);

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void verifyUnsuccesfulLoginWithEmptyPassword() {
    LoginPage loginPage = new LoginPage(driver);

    loginPage.openBasePage();
    loginPage.login(standardUsername, emptyPassword);
    loginPage.verifyUnsuccesfulLogin(emptyPasswordError);

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void verifyUnsuccesfulLoginWithBadUsername() {
    LoginPage loginPage = new LoginPage(driver);

    loginPage.openBasePage();
    loginPage.login(badUsername, password);
    loginPage.verifyUnsuccesfulLogin(badUsernameError);

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  

}
