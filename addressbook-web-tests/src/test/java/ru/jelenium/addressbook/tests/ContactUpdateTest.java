package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactUpdateTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(new ContactData().withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }


  @Test
  public void updateRecordTest() {

    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    ContactData changed = before.iterator().next();
    app.contact().edit(changed);
    ContactData newInfo = new ContactData()
            .withFirstname("UpdatedТест")
            .withMiddlename("UpdatedТестович")
            .withLastname("UpdatedТестовый" + unicDate)
            .withTitle("UpdatedДорогой")
            .withNickname("Updatedттт")
            .where(new ContactTextInfo()
                    .address1("UpdatedРФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13")
                    .address2("UpdatedТестовый район, с. Тестовое, 1я тестовая улица, д. 23")
                    .company("Тест продакшн")//нужно же что-то и оставить как есть
                    .notes("Помрешь, пока заполнишь"))
            .withNumbersOf(new ContactPhone()
                    .phoneHome1("465464611263112")
                    .phoneHome2("+1245 54 545 68595489")
                    .mobilePhone("+132(464) 54651 1564651 31")
                    .workPhone("3546131564631")
                    .fax("2345464"))
            .and(new ContactEData()
                    .email1(null)
                    .email2("test.testowy@gmail.com")
                    .email3("testy_1987@mail.ru")
                    .homepage("http://localhost/addressbook"))
            .withAnniversary(new DatesData()
                    .day(12)
                    .month(5)
                    .year("1987"))
            .withBirth(new DatesData()
                    .day(25)
                    .month(11)
                    .year("2011"));
    app.contact().updateTo(newInfo);
    app.goTo().homePage();
    Contacts after = app.contact().getAll();
    assertThat(before.size(), equalTo(after.size()));
    assertThat(app.contact().findDifference(before, after), equalTo(newInfo.withId(changed.getId())));//проверяем, что изменная группа такая же что и данные для изменений+меняем ид
    assertThat(after, equalTo(before.change(changed, newInfo)));
  }
}
