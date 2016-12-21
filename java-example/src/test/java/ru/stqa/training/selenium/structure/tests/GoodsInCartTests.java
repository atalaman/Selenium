package ru.stqa.training.selenium.structure.tests;

import org.junit.Assert;
import org.junit.Test;

public class GoodsInCartTests extends PageTestBase {

  @Test
  public void goodsAddDeleteTest() {
    app.addProductToCart("purple-duck");
    app.addProductToCart("green-duck");
    app.addProductToCart("blue-duck");

    String after = app.home().quantityOnCart();
    Assert.assertTrue("3".equals(after));

    app.cart().open();
    for(int i = 0; i < 3; i++) {
      app.cart().selectFirstProductInCart();
      app.cart().removeProduct();
      app.cart().removeProductConfirmatuon();
    }
  }
}
