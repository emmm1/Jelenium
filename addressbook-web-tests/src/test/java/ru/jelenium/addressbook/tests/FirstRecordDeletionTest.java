package ru.jelenium.addressbook.tests;


import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */



public class FirstRecordDeletionTest extends TestBase {

  @Test
  public void firstRecordDelete() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createWhenNoContact(new ContactData("ForDeleteТест", "ForDeleteТестовый"));
    app.getHomeNav().gotoDetails(1);
    app.getContactHelper().gotoRecordEditorThrViewRecordPage();
    app.getContactHelper().deleteRecord();
  }

}
