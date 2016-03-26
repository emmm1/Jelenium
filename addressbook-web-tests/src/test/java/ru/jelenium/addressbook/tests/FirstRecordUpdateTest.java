package ru.jelenium.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class FirstRecordUpdateTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(new ContactData().withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }


  @Test
  public void updateRecordTest() {

    app.goTo().homePage();
    //список до
    Contacts before = app.contact().list();
    //определить изменяемую группу
    ContactData changed = before.iterator().next();
    /*тут нужно азменить на выбор случайной группы и сохранять изменяемую группу
    app.onHomepage().clickEdit(checkBoxNum);
    ContactData contactBefore = before.get(checkBoxNum);*/
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
    Contacts after = app.contact().list();
    assertThat(before.size(), equalTo(after.size()));
    //вычислить несовпадающий контакт в списке до и сравнить с данными контакта до изменения
    assertThat(app.contact().findDiff(before,after), equalTo(newInfo.setId(changed.getId())));
    assertThat(after, equalTo(before.withChangedTO(changed,newInfo.setId(app.contact().findDiff(before,after).getId()))));
  }
}
