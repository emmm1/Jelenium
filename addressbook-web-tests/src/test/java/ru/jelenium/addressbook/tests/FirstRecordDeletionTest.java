package ru.jelenium.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */


public class FirstRecordDeletionTest extends TestBase {

  @Test
  public void firstRecordDelete() {
    app.goTo().gotoHomePage();
    app.getContactHelper().createWhenNoContact(new ContactData("ForDeleteТест", "2Del" + unicDate));
    //список до
    List<ContactData> before = app.getContactHelper().getContacts();
    app.getHomeNav().gotoDetails(0);
    app.getContactHelper().gotoRecordEditorThrViewRecordPage();
    app.getContactHelper().deleteRecord();
    app.getContactHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContacts();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(app.getContactHelper().findDiff(after, before));
    before.sort(app.getContactHelper().ById);
    after.sort(app.getContactHelper().ById);
    Assert.assertEquals(after, before);
  }

}
