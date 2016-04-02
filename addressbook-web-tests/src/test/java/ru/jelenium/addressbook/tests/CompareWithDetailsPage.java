package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompareWithDetailsPage extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(app.contact().getQty(), new ContactData()
            .withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }

  @Test
  public void contactCheckDetailsPage() {
    app.goTo().homePage();
    Contacts homePage = app.contact().getAll();
    ContactData homePageInfo = homePage.iterator().next().makeFullName();
    app.contact().details(homePageInfo);
    ContactData detailsPageInfo = app.contact().fromDetailsPage(homePageInfo.getId()).makeAllEmails().makeAllPhones();
    assertThat(homePageInfo.getAllEmails(), equalTo(detailsPageInfo.getAllEmails()));
    assertThat(homePageInfo.getAllPhones(), equalTo(detailsPageInfo.getAllPhones()));
    assertThat(detailsPageInfo, equalTo(homePageInfo));
  }

}
