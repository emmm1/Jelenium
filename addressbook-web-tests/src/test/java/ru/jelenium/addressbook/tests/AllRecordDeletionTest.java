package ru.jelenium.addressbook.tests;


import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */



public class AllRecordDeletionTest extends TestBase {

  @Test
  public void allRecordDelete() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createWhenNoContact(new ContactData("ForAllRecDelТест", "ForAllRecDelТестовый"));
    app.getHomeNav().selectAll();
    app.getHomeNav().pushDelete();
    app.getHomeNav().closeAlarm();
    app.getNavigationHelper().gotoHomePage();
  }

}
