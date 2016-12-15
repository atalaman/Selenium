package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StickersCloud {

  public static final String USERNAME = "annatal1";
  public static final String AUTOMATE_KEY = "1afb5uaDAfNpLx4rK7AN";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public WebDriver driver;
  public WebDriverWait wait;

  @Before
  public void start() throws Exception{
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "IE");
    caps.setCapability("browser_version", "7.0");
    //caps.setCapability("os", "Windows");
    //caps.setCapability("os_version", "XP");
    caps.setCapability("browserstack.debug", "true");
    caps.setCapability("browserstack.local", "true");
    driver = new RemoteWebDriver(new URL(URL), caps);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    wait = new WebDriverWait(driver, 10);
  }

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
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
