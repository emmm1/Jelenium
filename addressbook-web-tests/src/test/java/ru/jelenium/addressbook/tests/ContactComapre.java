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
public class ContactComapre extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(app.contact().getQty(), new ContactData().withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }

  @Test
  public void contactCheckEditPage() {
    app.goTo().homePage();
    //берем список контактов, выбираем один и идем на страницу редактирования
    //надо расширить количество данных получаемых с хомяка
    Contacts homePage = app.contact().getAll();
    ContactData homePageContact = homePage.iterator().next();
    app.contact().edit(homePageContact);
    //создаем второй контакт собрав те же поля со страницы редактирования
    ContactData editPageContact = app.contact().fromEditPage(homePageContact.getId());
    editPageContact.makeAllEmails();
    editPageContact.makeAllPhones();
    //сравниваем
    assertThat(homePageContact.getAllEmails(), equalTo(editPageContact.getAllEmails()));
    assertThat(homePageContact.getAddress1(), equalTo(editPageContact.getAddress1()));
    assertThat(homePageContact.getAllPhones(), equalTo(editPageContact.getAllPhones()));
    assertThat(editPageContact, equalTo(homePageContact));
  }

  @Test
  public void contactCheckDetailsPage() {
    app.goTo().homePage();
    Contacts homePage = app.contact().getAll();
    ContactData homePageContact = homePage.iterator().next();
    app.contact().details(homePageContact);
//    ContactData detailsPageContact = app.contact().fromDetailsPage(homePageContact.getId());
//    editPageContact.makeAllEmails();
//    editPageContact.makeAllPhones();
//    //сравниваем
//    assertThat(homePageContact.getAllEmails(), equalTo(editPageContact.getAllEmails()));
//    assertThat(homePageContact.getAddress1(), equalTo(editPageContact.getAddress1()));
//    assertThat(homePageContact.getAllPhones(), equalTo(editPageContact.getAllPhones()));
//    assertThat(editPageContact, equalTo(homePageContact));
  }

}
