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
    app.contact().createWhenNoContact(new ContactData().withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }

  @Test
  public void firstRecordDelete() {
    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    ContactData deleted = before.iterator().next();
    app.goTo().details(deleted);
    app.contact().modify();
    app.contact().deleteRecord();
    app.goTo().homePage();
    Contacts after = app.contact().getAll();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deleted)));
  }

}
