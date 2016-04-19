package ru.jelenium.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.jelenium.addressbook.appmanager.AppManger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static String browserType = "Firefox";
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


  @BeforeMethod(alwaysRun = true)
  public void logStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logStop(Method m) {
    logger.info("Stop test " + m.getName());
  }
}