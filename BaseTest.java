package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

  public WebDriver driver;

  // Otvoriti maksimiziran prozor browser-a i navigirati se na traženi URL
  @Before
  public void setup() {
    System.setProperty("webdriver.chromedriver",
        "//Users/milanvelickovic//Desktop//Project//Project//lib//chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @After
  public void teardown() {
    driver.quit();
  }

}
