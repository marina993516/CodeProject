package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

  public CheckoutPage(WebDriver driver) {
    super(driver);
  }

  By firstNameBy = By.id("first-name");
  By lastNameBy = By.id("last-name");
  By postalCodeBy = By.id("postal-code");
  By checkoutButtonBy = By.id("checkout");
  By continueButtonBy = By.id("continue");
  By itemTotalBy = By.className("summary_subtotal_label");
  By taxLabelBy = By.className("summary_tax_label");
  By totalLabelBy = By.className("summary_total_label");
  By shoppingCartLink = By.className("shopping_cart_link");
  By finishButtonBy = By.id("finish");
  By completeHeaderBy = By.className("complete-header");


  public CheckoutPage clickOnCartLink() {
    click(shoppingCartLink);
    return this;
  }

  public CheckoutPage clickOnCheckoutButton() {
    click(checkoutButtonBy);
    return this;
  }

  public CheckoutPage fillCheckoutStepOne(String firstName, String lastName, String postalCode) {
    writeText(firstNameBy, firstName);
    writeText(lastNameBy, lastName);
    writeText(postalCodeBy, postalCode);
    click(continueButtonBy);
    return this;
  }

  public CheckoutPage verifyTotalPrice() {
    String itemTotalText = readText(itemTotalBy).replaceAll("\\D+","");
    String taxLabelText = readText(taxLabelBy).replaceAll("\\D+","");
    String totalLabelText = readText(totalLabelBy).replaceAll("\\D+","");
    Double itemTotal = Double.parseDouble(itemTotalText);
    Double taxLabel = Double.parseDouble(taxLabelText);
    Double totalLabel = Double.parseDouble(totalLabelText);
    assertDoubleEquals(itemTotal + taxLabel, totalLabel);
    return this;
  }

  public CheckoutPage clickOnFinishButton() {
    click(finishButtonBy);
    return this;
  }
  
  public CheckoutPage verifyCompleteHeader(String expectedMessage){
    String actualMessage = readText(completeHeaderBy);
    assertTextEquals(expectedMessage, actualMessage);
    return this;
  }

}