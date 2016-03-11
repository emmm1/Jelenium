package ru.jelenium.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.jelenium.addressbook.appmanager.AppManger;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class TestBase {


  protected final AppManger app = new AppManger("Chrome");

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
