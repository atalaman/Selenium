package ru.stqa.training.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTestCloud {

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
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "XP");
    caps.setCapability("browserstack.debug", "true");
    driver = new RemoteWebDriver(new URL(URL), caps);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    wait = new WebDriverWait(driver, 50);
  }

    @Test
    public void myFirstTest(){
      driver.get("http://www.google.com");
      driver.findElement(By.name("q")).sendKeys("gismeteo");
      driver.findElement(By.name("btnG")).click();
      wait.until(titleIs("gismeteo - Google Search"));
    }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}

