package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class UserRegistrationTests extends TestBase {

  @Test
  public void userRegistrationTest() {
    driver.navigate().to("http://localhost/litecart/en/");
    driver.findElement(By.cssSelector("#box-account-login a[href*=create_account]")).click();

    Random r = new Random();
    int i = r.nextInt();
    driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Ivan" + i);
    driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Ivanov" + i);
    driver.findElement(By.cssSelector("[name=address1]")).sendKeys("Sunset St. " + i);
    driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("25252");
    driver.findElement(By.cssSelector("[name=city]")).sendKeys("Berlin");
    Select countries = new Select(driver.findElement(By.cssSelector("select[name='country_code']")));
    countries.selectByValue("DE");
    driver.findElement(By.cssSelector("[name=email]")).sendKeys("ivanivanov" + i + i + "@mail.ru");
    driver.findElement(By.cssSelector("[name=phone]")).sendKeys("+49011223344" + i);
    driver.findElement(By.cssSelector("input[name='password']")).sendKeys("IvanIvanov" + i);
    driver.findElement(By.cssSelector("input[name='confirmed_password']")).sendKeys("IvanIvanov" + i);
    driver.findElement(By.cssSelector("button[name='create_account']")).click();

    driver.findElement(By.cssSelector("div#box-account a[href*='logout']")).click();
    driver.findElement(By.cssSelector("form[name='login_form'] input[name='email']")).sendKeys("ivanivanov" + i + i + "@mail.ru");
    driver.findElement(By.cssSelector("form[name='login_form'] input[name='password']")).sendKeys("IvanIvanov" + i );
    driver.findElement(By.cssSelector("form[name='login_form'] button[name='login']")).click();
    driver.findElement(By.cssSelector("div#box-account a[href*='logout']")).click();
  }
}
