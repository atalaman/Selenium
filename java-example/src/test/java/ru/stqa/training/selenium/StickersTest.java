package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StickersTest extends TestBase {

  @Test
  public void stickersTest() {
    driver.navigate().to("http://localhost/litecart/en/");
    List<WebElement> popularProducts = driver.findElements
            (By.cssSelector("div#box-most-popular li.product.column.shadow.hover-light"));
    int length = popularProducts.size();
    for (int i = 1; i <= length; i++) {
      WebElement product = driver.findElement(By.cssSelector
              ("div#box-most-popular li.product.column.shadow.hover-light:nth-child(" + i + ")"));
      List<WebElement> stickers = product.findElements(By.cssSelector("div.sticker"));
      Assert.assertTrue(stickers.size() == 1);
      }

    List<WebElement> saleProducts = driver.findElements
          (By.cssSelector("div#box-campaigns li.product.column.shadow.hover-light"));
    int len = saleProducts.size();
    for (int i = 1; i <= len; i++) {
      WebElement product = driver.findElement(By.cssSelector
            ("div#box-campaigns li.product.column.shadow.hover-light:nth-child(" + i + ")"));
      List<WebElement> stickers = product.findElements(By.cssSelector("div.sticker"));
      Assert.assertTrue(stickers.size() == 1);
      }

    List<WebElement> latestProducts = driver.findElements
            (By.cssSelector("div#box-latest-products li.product.column.shadow.hover-light"));
    int leng = latestProducts.size();
    for (int i = 1; i <= leng; i++) {
      WebElement product = driver.findElement(By.cssSelector
              ("div#box-latest-products li.product.column.shadow.hover-light:nth-child(" + i + ")"));
      List<WebElement> stickers = product.findElements(By.cssSelector("div.sticker"));
      Assert.assertTrue(stickers.size() == 1);
    }
  }
}

