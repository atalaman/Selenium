package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoodsInCartTests extends TestBase{

  @Test
  public void goodsAddDeleteTest() {
    driver.navigate().to("http://localhost/litecart/en/");
    String quantityBefore1 = driver.findElement(By.cssSelector("span[class='quantity']")).getAttribute("textContent");
    int i = Integer.parseInt(quantityBefore1) + 1;
    String quantity1 = Integer.toString(i);
    driver.findElement(By.cssSelector("div#box-most-popular a:not(.fancybox)[href*='purple-duck']")).click();
    driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
    wait.until(ExpectedConditions.attributeToBe
            (By.cssSelector("span[class='quantity']"), "textContent", (quantity1)));
    driver.navigate().to("http://localhost/litecart/en/");
    String quantityBefore2 = driver.findElement(By.cssSelector("span[class='quantity']")).getAttribute("textContent");
    int k = Integer.parseInt(quantityBefore2) + 1;
    String quantity2 = Integer.toString(k);
    driver.findElement(By.cssSelector("div#box-most-popular a:not(.fancybox)[href*='green-duck']")).click();
    driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
    wait.until(ExpectedConditions.attributeToBe
            (By.cssSelector("span[class='quantity']"), "textContent", (quantity2)));
    driver.navigate().to("http://localhost/litecart/en/");
    String quantityBefore3 = driver.findElement(By.cssSelector("span[class='quantity']")).getAttribute("textContent");
    int l = Integer.parseInt(quantityBefore3) + 1;
    String quantity3 = Integer.toString(l);
    driver.findElement(By.cssSelector("div#box-most-popular a:not(.fancybox)[href*='blue-duck']")).click();
    driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
    wait.until(ExpectedConditions.attributeToBe
            (By.cssSelector("span[class='quantity']"), "textContent", (quantity3)));
    String after = driver.findElement(By.cssSelector("span[class='quantity']")).getAttribute("textContent");
    Assert.assertTrue("3".equals(after));

    driver.findElement(By.cssSelector("a[href*='checkout'][class='link']")).click();
    for(i = 0; i < 3; i++) {
      if (areElementsPresent(driver, By.cssSelector("ul[class='shortcuts']"))) {
        driver.findElement(By.cssSelector("ul[class='shortcuts'] li:nth-child(1)")).click();
      }
      driver.findElement(By.cssSelector("button[name='remove_cart_item']")).click();
      wait.until(ExpectedConditions.stalenessOf(driver.findElement
              (By.cssSelector("div#order_confirmation-wrapper tr:nth-child(2)"))));
    }
  }

  boolean areElementsPresent(WebDriver driver, By locator)
  {
    return driver.findElements(locator).size() > 0;
  }
}
