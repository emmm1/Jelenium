package ru.jelenium.addressbook.tests;


import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */



public class HomePageRecordDeletionTest extends TestBase {

  @Test
  public void homePageRecordDelete() {
    if (browserType.equals("HU")) {
      throw new Error("такой тип броузера использровать нельзя");
      }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createWhenNoContact(new ContactData("ForHomePageDeleteТест", "2HPRDel" + unicDate));
    app.getHomeNav().selectFirst();
    app.getHomeNav().pushDelete();
    app.getHomeNav().closeAlarm();
    app.getNavigationHelper().gotoHomePage();
  }

}
