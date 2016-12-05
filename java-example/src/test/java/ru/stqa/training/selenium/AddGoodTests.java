package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AddGoodTests extends TestBase{

  @Test
  public void addGoodTest () {
    loginAdmin();
    driver.findElement(By.cssSelector("ul#box-apps-menu li#app->a[href*='catalog']")).click();
    driver.findElement(By.cssSelector("a[href*='edit_product']")).click();
    driver.findElement(By.cssSelector("input[name='status'][value='1']")).click();
    String name = "Gray Duck";
    driver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys(name);
    driver.findElement(By.cssSelector("input[name='code']")).sendKeys("gd005");
    String general = driver.findElement(By.cssSelector("input[data-name='Root']")).getAttribute("checked");
    if(general.equals("true")) {
      driver.findElement(By.cssSelector("input[data-name='Root']")).click();
    }
    driver.findElement(By.cssSelector("input[data-name='Rubber Ducks']")).click();
    driver.findElement(By.cssSelector("input[name='product_groups[]'][value='1-3']")).click();
    driver.findElement(By.cssSelector("input[name='quantity']")).clear();
    driver.findElement(By.cssSelector("input[name='quantity']")).sendKeys("2");
    driver.findElement(By.cssSelector("input[name='new_images[]']"))
            .sendKeys("D:\\StudyTesting\\grayDuck.jpg");
    driver.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("11112016");
    driver.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("15122017");

    driver.findElement(By.cssSelector("ul[class='index'] a[href*='information']")).click();
    Select manufacturer = new Select(driver.findElement(By.cssSelector("select[name='manufacturer_id']")));
    manufacturer.selectByValue("1");
    driver.findElement(By.cssSelector("input[name='keywords']")).sendKeys("Gray, Duck");
    driver.findElement(By.cssSelector("input[name='short_description[en]']"))
            .sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ant");
    driver.findElement(By.cssSelector("div[dir='ltr']"))
            .sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ante massa, " +
                    "eget ornare libero porta congue. Cras scelerisque dui non consequat sollicitudin. " +
                    "Sed pretium tortor ac auctor molestie. Nulla facilisi. Maecenas pulvinar nibh vitae lectus vehicula semper. " +
                    "Donec et aliquet velit. Curabitur non ullamcorper mauris. In hac habitasse platea dictumst. " +
                    "Phasellus ut pretium justo, sit amet bibendum urna. Maecenas sit amet arcu pulvinar, facilisis quam at, " +
                    "viverra nisi. Morbi sit amet adipiscing ante. Integer imperdiet volutpat ante, sed venenatis urna volutpat a. " +
                    "Proin justo massa, convallis vitae consectetur sit amet, facilisis id libero.");
    driver.findElement(By.cssSelector("input[name='head_title[en]']")).sendKeys("GrayDuck");
    driver.findElement(By.cssSelector("input[name='meta_description[en]']")).sendKeys("GrayDuckNewOne");

    driver.findElement(By.cssSelector("ul[class='index'] a[href*='prices']")).click();
    driver.findElement(By.cssSelector("input[name='purchase_price']")).clear();
    driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("23");
    Select currency = new Select(driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")));
    currency.selectByValue("USD");
    driver.findElement(By.cssSelector("input[name='prices[USD]']")).sendKeys("23");
    driver.findElement(By.cssSelector("button[name='save']")).click();

    driver.findElement(By.cssSelector("ul#box-apps-menu li#app->a[href*='catalog']")).click();
    driver.findElement(By.cssSelector("a[href*='category_id=1']:not([title='Edit'])")).click();

    List<WebElement> elements = driver.findElements(By.cssSelector(".row td:nth-child(3)"));
    List<String> goods = new ArrayList<String>();
    for (WebElement element : elements) {
      String good = element.getAttribute("textContent");
      goods.add(good);
    }
    int len = goods.size();
    boolean presence = false;
    for(int i = 0; i < len; i++) {
      String res = goods.get(i);
      if (res.equals(" " + name)){
        presence = true;
        break;
      }
    }
    Assert.assertEquals(presence,true);
  }
}
