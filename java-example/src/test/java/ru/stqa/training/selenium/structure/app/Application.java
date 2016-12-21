package ru.stqa.training.selenium.structure.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.structure.pages.CartPage;
import ru.stqa.training.selenium.structure.pages.HomePage;
import ru.stqa.training.selenium.structure.pages.ProductPage;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Application {

  public WebDriver driver;
  public WebDriverWait wait;

  private HomePage homePage;
  private ProductPage productPage;
  private CartPage cartPage;

  public Application() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  public void init() {
    homePage = new HomePage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
  }

  public void stop() {
    driver.quit();
    driver = null;
  }

  public void addProductToCart(String good) {
    homePage.open();
    String quantityBefore = homePage.quantityOnCart();
    productPage.navigateFromMain(good);
    productPage.addGoodToCart();
    homePage.addingProductConfirmation(quantityBefore);

  }

  public void loginAdmin() {
    driver.navigate().to("http://localhost/litecart/admin/");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    wait.until(titleIs("My Store"));
  }

  public HomePage home() {
    return homePage;
  }

  public ProductPage good() {
    return productPage;
  }

  public CartPage cart() {
    return cartPage;
  }
}
