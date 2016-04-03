package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by mikhail.evseev on 31.03.2016.
 */
public class CompareWithUpdatePage extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(app.contact().getQty(), new ContactData().withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }

  @Test
  public void contactCheckEditPage() {
    app.goTo().homePage();
    Contacts homePage = app.contact().getAll();
    ContactData homePageInfo = homePage.iterator().next();
    app.contact().goToEdit(homePageInfo);
    ContactData editPageInfo = app.contact().getInfoFromEditPage(homePageInfo).makeAllEmails().makeAllPhones();
    assertThat(homePageInfo.getAllEmails(), equalTo(editPageInfo.getAllEmails()));
//    выяснилось,что пробел в конце адреса удаляется на хомяке
    assertThat(homePageInfo.getAddress1().replaceAll("\\s", ""), equalTo(editPageInfo.getAddress1().replaceAll("\\s", "")));
    assertThat(homePageInfo.getAllPhones(), equalTo(editPageInfo.getAllPhones()));
    assertThat(editPageInfo, equalTo(homePageInfo));
  }
}
