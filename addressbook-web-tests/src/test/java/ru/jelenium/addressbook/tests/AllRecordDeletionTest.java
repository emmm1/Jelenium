package ru.jelenium.addressbook.tests;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.appmanager.AppManger;
import ru.jelenium.addressbook.model.*;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */



public class AllRecordDeletionTest extends TestBase {

  @Test
  public void allRecordDelete() {
    if (!browserType.equals("HU")) {
      throw new Error("такой тип броузера использровать нельзя");
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createWhenNoContact(new ContactData("ForAllRecDelТест", "ForAllRecDel" + unicDate));
    app.getHomeNav().selectAll();
    app.getHomeNav().pushDelete();
    app.getHomeNav().closeAlarm();
    app.getNavigationHelper().gotoHomePage();
  }
}

