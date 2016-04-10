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


public class HomePageContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    app.contact().createWhenNoContact(app.contact().getQty(), new ContactData().withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
    if (browserType.equals("HU")) {
      throw new Error("такой тип броузера использровать нельзя");
    }
  }

  @Test
  public void homePageRecordDelete() {

    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    ContactData deleted = before.iterator().next();
    app.onHomepage().chooseContact(deleted);
    app.onHomepage().pushDelete();
    app.contact().closeAlarm();
    app.goTo().homePage(); //Chrome слишком быстро все делает и список не успевает вывестись - нужно его чем-то занять
    assertThat(app.contact().getQty(), equalTo(before.size() - 1));
    Contacts after = app.contact().getAll();
    assertThat(after, equalTo(before.without(deleted)));
  }

}
