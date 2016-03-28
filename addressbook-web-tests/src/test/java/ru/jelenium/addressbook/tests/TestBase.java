package ru.jelenium.addressbook.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.jelenium.addressbook.appmanager.AppManger;

import java.util.Date;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class TestBase {

  protected static String browserType = "JB";
  protected static AppManger app = new AppManger(browserType);

  //Чтобы лучше контролировать результат работы HTMLUnit
  // сделать тестовые записи уникальными
  //Date curDate = new Date(System.currentTimeMillis());
  String unicDate = " " + browserType + " " + new Date(System.currentTimeMillis());


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
