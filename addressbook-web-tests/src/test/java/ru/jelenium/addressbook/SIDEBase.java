package ru.jelenium.addressbook;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class SIDEBase {

  protected final AppMangerSIDE app = new AppMangerSIDE();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
