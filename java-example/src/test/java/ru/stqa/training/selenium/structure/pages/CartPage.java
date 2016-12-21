package ru.stqa.training.selenium.structure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends Page {

  public CartPage(WebDriver driver){
    super(driver);
  }

  public void open() {
    driver.findElement(By.cssSelector("a[href*='checkout'][class='link']")).click();
  }

  public void removeProduct() {
    driver.findElement(By.cssSelector("button[name='remove_cart_item']")).click();
  }

  public void removeProductConfirmatuon() {
    wait.until(ExpectedConditions.stalenessOf(driver.findElement
            (By.cssSelector("div#order_confirmation-wrapper tr:nth-child(2)"))));
  }

  public void selectFirstProductInCart() {
    if (areElementsPresent(driver, By.cssSelector("ul[class='shortcuts']"))) {
      driver.findElement(By.cssSelector("ul[class='shortcuts'] li:nth-child(1)")).click();
    }
  }
}
