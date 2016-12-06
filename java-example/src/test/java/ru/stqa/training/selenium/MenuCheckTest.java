package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuCheckTest extends TestBase {

  @Test
  public void menuCheckTest() {
    loginAdmin();
    List<WebElement> menuItems = driver.findElements(By.cssSelector("#app-"));
    int length = menuItems.size();
    for (int i = 1; i <= length; i++) {
      WebElement menuItem = driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-child(" + i + ")"));
      System.out.println(menuItem.getText());
      menuItem.click();
      List<WebElement> subMenuItems = driver.findElements(By.cssSelector("li#app-.selected .name"));
      if (subMenuItems.size() > 1) {
        int steps = subMenuItems.size();
        for (int j = 1; j < steps; j++) {
          WebElement subMenuItem = driver.findElement
                  (By.cssSelector("li#app-.selected li:nth-child(" + j + ")"));
          System.out.println(subMenuItem.getText());
          subMenuItem.click();
          Assert.assertTrue(areElementsPresent(driver, By.xpath("//h1")));
         }
      } else {
        Assert.assertTrue(areElementsPresent(driver, By.xpath("//h1")));
      }
    }
  }

  boolean isElementPresent(WebDriver driver, By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  boolean areElementsPresent(WebDriver driver, By locator)
    {
     return driver.findElements(locator).size() > 0;
    }
}