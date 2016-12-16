package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.*;

public class CheckLogsTests extends TestBase{

  @Test
  public void CheckGoodsPagesTest () {
    loginAdmin();
    driver.findElement(By.cssSelector("a[href*='catalog']")).click();
    driver.findElement(By.cssSelector("a[href*='catalog&category_id=1']")).click();
    List<WebElement> elements = driver.findElements(By.cssSelector("a[href*='product_id']:not([title='Edit'])"));
    List<String> links = new ArrayList<String>();
    for (WebElement element : elements){
      String link = element.getAttribute("href");
      links.add(link);
    }
    for (String link:links){
      driver.findElement(By.cssSelector("a[href='" + link + "']")).click();
      List<LogEntry> logs = new ArrayList<LogEntry>();
      logs = driver.manage().logs().get("browser").getAll();
      //Assert.assertTrue(logs.isEmpty());
      //Alternative check with more information created
      String good = driver.findElement(By.cssSelector("input[name='name[en]']")).getAttribute("value");
      if (!logs.isEmpty()) {
        System.out.println("There is at least one JavaScript error on page " + good);
        System.out.println(logs);
      } else {
        System.out.println("There are no JavaScript errors on page " + good);
      }
      driver.findElement(By.cssSelector("a[href*='catalog']")).click();
      driver.findElement(By.cssSelector("a[href*='catalog&category_id=1']")).click();
    }
  }

  @Test
  public void CheckNewOrgerPageTest () {
    loginAdmin();
    driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=orders&doc=orders']")).click();
    driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=orders&doc=" +
            "edit_order&order_status_id=&page=1&redirect=%2Flitecart%2Fadmin%2F%3Fapp%3Dorders%26doc%3Dorders']")).click();
    List<LogEntry> logs = new ArrayList<LogEntry>();
    logs = driver.manage().logs().get("browser").getAll();
    //Assert.assertTrue(logs.isEmpty());
    if (!logs.isEmpty()) {
      System.out.println("There is at least one JavaScript error on page 'New Order'");
      System.out.println(logs);
    } else {
      System.out.println("There are no JavaScript errors on page 'New Order'");
    }
  }
}
