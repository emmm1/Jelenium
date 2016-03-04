package ru.jelenium.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class SBBase {


  protected final AppMangerSB app = new AppMangerSB();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
