package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CountrySortTests extends TestBase{

  @Test
  public void countrySortTest () {
    loginAdmin();
    driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='countries']")).click();
    List<WebElement> elements = driver.findElements(By.cssSelector(".row td:nth-child(5)"));
    List<String> countries = new ArrayList<String>();
    for (WebElement element : elements) {
      String country = element.getAttribute("textContent");
      countries.add(country);
    }

    List<String> sortedCountries = new ArrayList<String>(countries);
    Collections.sort(sortedCountries);

    Assert.assertEquals(countries, sortedCountries);
  }

  @Test
  public void zoneInCountrySortTest () {
    loginAdmin();
    driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='countries']")).click();
    List<WebElement> elements = driver.findElements(By.cssSelector(".row td:nth-child(5)"));
    int length = elements.size();
      for (int i = 1; i <= length; i++) {
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='countries']")).click();
        driver.findElement(By.cssSelector("tr:nth-child(" + i + ") td:nth-child(5) a")).click();
        List<WebElement> zones = driver.findElements(By.cssSelector(".dataTable td:nth-child(3)"));
        if (zones.size() > 1) {
          List<String> zonnes = new ArrayList<String>();
          for (WebElement zone : zones) {
            String zonn = zone.getAttribute("textContent");
            if (!zonn.isEmpty()) {
              zonnes.add(zonn);
            }
          }
          List<String> sortedZones = new ArrayList<String>(zonnes);
          Collections.sort(sortedZones);
          Assert.assertEquals(zonnes, sortedZones);
        }
      }
    }

  @Test
  public void geoZoneSortTest () {
    loginAdmin();
    driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='geo_zones']")).click();
    List<WebElement> elements = driver.findElements(By.cssSelector("[class=row] td:nth-child(3)"));
    int length = elements.size();
    List<String> zones = new ArrayList<String>();
    for (int i = 2; i <= (length+1); i++) {
      driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='geo_zones']")).click();
      driver.findElement(By.cssSelector("tr:nth-child(" + i + ") td:nth-child(3) a")).click();
      List<WebElement> zonnes = driver.findElements(By.cssSelector("td select[name*='zone_code'] option[selected='true']"));
      for (WebElement zonne : zonnes) {
        String zone = zonne.getAttribute("textContent");
        zones.add(zone);
      }
    }
    List<String> sortedZones = new ArrayList<String>(zones);
    Collections.sort(sortedZones);
    Assert.assertEquals(zones, sortedZones);
  }
}
