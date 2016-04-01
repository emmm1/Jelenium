package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.Contacts;

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
  public void contactCheck() {
    app.goTo().homePage();
    //берем список контактов, выбираем один и идем на страницу редактирования
    //надо расширить количество данных получаемых с хомяка
    Contacts homePage = app.contact().getAll();
    ContactData homePageContact = homePage.iterator().next();
    app.contact().edit(homePageContact);
    //создаем второй контакт собрав те же поля со страницы редактирования
    ContactData editPageContact = app.contact().fromEditPage(homePageContact.getId());
    homePageContact.makeAllEmails();
    homePageContact.makeAllPhones();
    //сравниваем

  }

}
