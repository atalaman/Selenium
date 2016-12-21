package ru.stqa.training.selenium.structure.tests;

import org.junit.After;
import org.junit.Before;
import ru.stqa.training.selenium.structure.app.Application;

public abstract class PageTestBase {

  public Application app;

  @Before
  public void start() {
    app = new Application();
    app.init();
  }


  @After
  public void stop() {
    app.stop();
  }
}

