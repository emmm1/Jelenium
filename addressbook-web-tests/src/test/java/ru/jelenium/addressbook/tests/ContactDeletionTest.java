package ru.jelenium.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */


public class ContactDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(app.contact().getQty(), new ContactData()
            .withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }

  @Test
  public void firstRecordDelete() {
    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    ContactData deleted = before.iterator().next();
    app.contact().details(deleted);
    app.contact().modify();
    app.contact().deleteRecord();
    app.goTo().homePage();
    assertThat(app.contact().getQty(), equalTo(before.size() - 1));
    Contacts after = app.contact().getAll();
    assertThat(after, equalTo(before.without(deleted)));
  }

}
