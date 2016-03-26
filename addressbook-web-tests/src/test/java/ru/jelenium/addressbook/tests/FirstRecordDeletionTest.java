package ru.jelenium.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */


public class FirstRecordDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(new ContactData().withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }

  @Test
  public void firstRecordDelete() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(new ContactData().withFirstname("ForDeleteТест").withLastname("2Del" + unicDate));
    //список до
    Set<ContactData> before = app.contact().list();
    app.onHomepage().gotoDetails(0);
    app.contact().gotoRecordEditorThrViewRecordPage();
    app.contact().deleteRecord();
    app.goTo().homePage();
    Set<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(app.contact().findDiff(after, before));
    Assert.assertEquals(after, before);
  }

}
