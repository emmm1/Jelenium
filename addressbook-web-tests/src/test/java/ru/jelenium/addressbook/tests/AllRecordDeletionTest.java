package ru.jelenium.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;

import java.util.Date;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */


public class AllRecordDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    app.getContactHelper().createWhenNoContact(new ContactData("ForHomePageDeleteТест", "2HPRDel" + unicDate));
  }

  public void checkBrowser() {
    if (browserType.equals("HU")) {
      throw new Error("такой тип броузера использровать нельзя");
    }
  }


  @Test
  public void allRecordDelete() {
    app.goTo().gotoHomePage();
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
    app.goTo().gotoHomePage();
    Assert.assertEquals(app.getContactHelper().getContacts().size(), 0);

  }
}

