package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

public class GoodsPricesTests extends TestBase{

  @Test
  public void goodsPricesTest() {
    driver.navigate().to("http://localhost/litecart/en/");
    String nameMain = driver.findElement(By.cssSelector
            ("#box-campaigns [class=link][title='Yellow Duck'] [class='name']")).getAttribute("textContent");
    String regularPriceMain = driver.findElement(By.cssSelector
            ("#box-campaigns [class=link][title='Yellow Duck'] [class='regular-price']")).getAttribute("textContent");
    String campaignPriceMain = driver.findElement(By.cssSelector
            ("#box-campaigns [class=link][title='Yellow Duck'] [class='campaign-price']")).getAttribute("textContent");
    driver.findElement(By.cssSelector("#box-campaigns [class=link][title='Yellow Duck']")).click();
    String nameGoodPage = driver.findElement(By.cssSelector("h1")).getAttribute("textContent");
    String regularPriceGoodPage = driver.findElement(By.cssSelector("[class='regular-price']")).getAttribute("textContent");
    String campaignPriceGoodPage = driver.findElement(By.cssSelector("[class='campaign-price']")).getAttribute("textContent");

    Assert.assertEquals(nameMain, nameGoodPage);
    Assert.assertEquals(regularPriceMain, regularPriceGoodPage);
    Assert.assertEquals(campaignPriceMain, campaignPriceGoodPage);
  }

  @Test
  public void priceColorsMainTest() {
    driver.navigate().to("http://localhost/litecart/en/");

    String regularMainFont1 = driver.findElement(By.cssSelector
            ("#box-campaigns [class=link][title='Yellow Duck'] [class='regular-price']")).getCssValue("text-decoration");
    Assert.assertEquals(regularMainFont1,"line-through");
    String regularMainFont2 = driver.findElement(By.cssSelector
            ("#box-campaigns [class=link][title='Yellow Duck'] [class='regular-price']")).getCssValue("font-weight");
    Assert.assertEquals(regularMainFont2, "normal");
    String regularColorMain = driver.findElement(By.cssSelector
            ("#box-campaigns [class=link][title='Yellow Duck'] [class='regular-price']")).getCssValue("color");
    Assert.assertEquals(regularColorMain, "rgba(119, 119, 119, 1)");

    String campaignMainFont1 = driver.findElement(By.cssSelector
            ("#box-campaigns [class=link][title='Yellow Duck'] [class='campaign-price']")).getCssValue("text-decoration");
    Assert.assertEquals(campaignMainFont1, "none");
    String campaignMainFont2 = driver.findElement(By.cssSelector
            ("#box-campaigns [class=link][title='Yellow Duck'] [class='campaign-price']")).getCssValue("font-weight");
    Assert.assertEquals(campaignMainFont2, "bold");
    String campaignColorMain = driver.findElement(By.cssSelector
            ("#box-campaigns [class=link][title='Yellow Duck'] [class='campaign-price']")).getCssValue("color");
    Assert.assertEquals(campaignColorMain, "rgba(204, 0, 0, 1)");
  }

  @Test
  public void priceColorsGoodTest() {
    driver.navigate().to("http://localhost/litecart/en/");
    driver.findElement(By.cssSelector("#box-campaigns [class=link][title='Yellow Duck']")).click();

    String regularGoodFont1 = driver.findElement(By.cssSelector
            ("[class='regular-price']")).getCssValue("text-decoration");
    Assert.assertEquals(regularGoodFont1,"line-through");
    String regularGoodFont2 = driver.findElement(By.cssSelector
            ("[class='regular-price']")).getCssValue("font-weight");
    Assert.assertEquals(regularGoodFont2, "normal");
    String regularColorGood = driver.findElement(By.cssSelector
            ("[class='regular-price']")).getCssValue("color");
    Assert.assertEquals(regularColorGood, "rgba(102, 102, 102, 1)");

    String campaignGoodFont1 = driver.findElement(By.cssSelector
            ("[class='campaign-price']")).getCssValue("text-decoration");
    Assert.assertEquals(campaignGoodFont1, "none");
    String campaignGoodFont2 = driver.findElement(By.cssSelector
            ("[class='campaign-price']")).getCssValue("font-weight");
    Assert.assertEquals(campaignGoodFont2, "bold");
    String campaignColorGood = driver.findElement(By.cssSelector
            ("[class='campaign-price']")).getCssValue("color");
    Assert.assertEquals(campaignColorGood, "rgba(204, 0, 0, 1)");
  }
}
