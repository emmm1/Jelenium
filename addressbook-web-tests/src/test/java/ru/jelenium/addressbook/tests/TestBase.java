package ru.jelenium.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.jelenium.addressbook.appmanager.AppManger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class TestBase {

  public final String browserType = "Chrome";
  protected AppManger app = new AppManger(browserType);

  //Чтобы лучше контролировать результат работы HTMLUnit
  // сделать тестовые записи уникальными
  //Date curDate = new Date(System.currentTimeMillis());
  String unicDate = " " + browserType + " " + new Date(System.currentTimeMillis());


  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
