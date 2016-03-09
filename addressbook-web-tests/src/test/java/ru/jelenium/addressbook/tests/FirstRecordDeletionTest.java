package ru.jelenium.addressbook.tests;


import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.ContactEData;
import ru.jelenium.addressbook.model.ContactPhone;
import ru.jelenium.addressbook.model.ContactTextInfo;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */



public class FirstRecordDeletionTest extends TestBase {

  @Test
  public void firstRecordDelete() {
    app.getNavigationHelper().gotoHomePage();
    //передаем номер записи
    app.getHomeNav().gotoDetails(1);
    app.getNavigationHelper().gotoRecordEditorThrViewRecordPage();
    app.getContactHelper().deleteGroup();
  }

}
