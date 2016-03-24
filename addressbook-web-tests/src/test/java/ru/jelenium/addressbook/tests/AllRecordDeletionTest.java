package ru.jelenium.addressbook.tests;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.appmanager.AppManger;
import ru.jelenium.addressbook.model.*;

import java.util.Date;
import java.util.List;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */



public class AllRecordDeletionTest extends TestBase {

  @Test
  public void allRecordDelete() {
    if (browserType.equals("HU")) {
      throw new Error("такой тип броузера использровать нельзя");
    }
    app.getNavigationHelper().gotoHomePage();
    if (app.getContactHelper().createWhenNoContact(new ContactData("ForAllRecDelТест", "ForAllRecDel" + unicDate))) {
      for (int i = 0; i < 3; i++) {
        app.getContactHelper().gotoHomePage();
        app.getContactHelper().createRecord((new ContactData("ForAllRecDelТест", "ForAllRecDel" + " " + browserType + " " + new Date(System.currentTimeMillis()))), false);
      }
    }
      //брать данные до нет смысла
      app.getContactHelper().gotoHomePage();
      app.getHomeNav().selectAll();
      app.getHomeNav().pushDelete();
      app.getHomeNav().closeAlarm();
      app.getNavigationHelper().gotoHomePage();
      Assert.assertEquals(app.getContactHelper().getContacts().size(), 0);

  }
}

