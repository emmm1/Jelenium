package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewRecordTest extends TestBase {

  @Test
  public void newRecordTest() {

    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    //хочу посмотреть как будут выглядеть все данные
    ContactData contact = new ContactData()
            .withFirstname("Тест")
            .withMiddlename("Тестович")
            .withLastname("Тестовый" + unicDate)
            .withTitle("Дорогой")
            .withNickname("ттт")
            .withGroupNum(1)
            .where(new ContactTextInfo()
                    .address1("РФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13")
                    .address2("Тестовый район, с. Тестовое, 1я тестовая улица, д. 23")
                    .company("Тест продакшн")
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
    app.contact().create(contact);
    app.goTo().homePage();
    Contacts after = app.contact().getAll();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.with(contact.withId((app.contact().findDifference(before, after)).getId()))));
  }
}
