package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

  public WebDriver driver;
  public WebDriverWait wait;

  @Before
  public void start() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(FirefoxDriver.MARIONETTE, false);
    FirefoxBinary bin = new FirefoxBinary(new File("d:\\Programs\\Mozilla Firefox\\firefox.exe"));
    //FirefoxBinary bin = new FirefoxBinary(new File("d:\\Programs\\Nightly\\firefox.exe"));
    driver = new FirefoxDriver(bin, new FirefoxProfile(), caps);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void myFirstTest() {
    driver.navigate().to("http://www.google.com");
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
