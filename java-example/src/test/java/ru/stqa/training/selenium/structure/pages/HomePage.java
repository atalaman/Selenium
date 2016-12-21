package ru.stqa.training.selenium.structure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page {

  public HomePage(WebDriver driver){
    super(driver);
  }

  public HomePage open(){
    driver.navigate().to("http://localhost/litecart/en/");
    return this;
  }

  public String quantityOnCart() {
    return driver.findElement(By.cssSelector("span[class='quantity']")).getAttribute("textContent");
  }

  public void addingProductConfirmation(String quantityBefore) {
    int i = Integer.parseInt(quantityBefore) + 1;
    String quantityAfter = String.valueOf(i);
    wait.until(ExpectedConditions.attributeToBe
            (By.cssSelector("span[class='quantity']"), "textContent", (quantityAfter)));
  }
}
