package ru.jelenium.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.Contacts;

import java.util.Date;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */


public class AllRecordDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().createWhenNoContact(app.contact().getQty(), new ContactData()
            .withFirstname("ForAllRecDelТест").withLastname("ForAllRecDel" + unicDate))) {
      for (int i = 0; i < 3; i++) {
        app.goTo().homePage();
        app.contact().create((new ContactData().withFirstname("ForAllRecDelТест")
                .withLastname("ForAllRecDel" + " " + browserType + " " + new Date(System.currentTimeMillis()))));
      }
    }
    if (browserType.equals("HU")) {
      throw new Error("такой тип броузера использровать нельзя");
    }
  }

  @Test
  public void allRecordDelete() {
    app.goTo().homePage();
    app.onHomepage().selectAll();
    app.onHomepage().pushDelete();
    app.contact().closeAlarm();
    app.goTo().homePage();//для Chrome
    Assert.assertEquals(app.contact().getQty(), 0);

  }
}

