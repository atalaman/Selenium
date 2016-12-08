package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CountryPageLinksTests extends TestBase {

  @Test
  public void countryPageLinksTest () {
    loginAdmin();
    driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='countries']")).click();
    driver.findElement(By.cssSelector("a.button[href*='edit_country']")).click();
    List<WebElement> elements = driver.findElements(By.cssSelector("form a[target='_blank']"));
    List<String> links = new ArrayList<String>();
    for (WebElement element : elements){
      String link = element.getAttribute("href");
      links.add(link);
    }
    for (String link:links){
      String originalWindow = driver.getWindowHandle();
      Set<String> oldWindows = driver.getWindowHandles();
      int quantity = oldWindows.size();
      String selector = "a[href='" + link + "']";
      driver.findElement(By.cssSelector(selector)).click();
      //Set<String> newWindows = driver.getWindowHandles();
      wait.until(ExpectedConditions.numberOfWindowsToBe(quantity + 1));
      Set<String> newWindows = driver.getWindowHandles();
      newWindows.removeAll(oldWindows);
      String newWindow = newWindows.iterator().next();
      driver.switchTo().window(newWindow);
      driver.close();
      driver.switchTo().window(originalWindow);
    }
  }
}
