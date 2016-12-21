package ru.stqa.training.selenium.structure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.training.selenium.structure.pages.Page;

public class ProductPage extends Page {

  public ProductPage(WebDriver driver){
    super(driver);
  }

  public void navigateFromMain(String good) {
    driver.findElement(By.cssSelector("div#box-most-popular a:not(.fancybox)[href*='" + good + "']")).click();
  }

  public void addGoodToCart() {
    driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
  }
}
