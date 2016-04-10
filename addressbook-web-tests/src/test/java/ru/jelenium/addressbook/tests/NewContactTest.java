package ru.jelenium.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewContactTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> contactListCSV() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] value = line.split(";");
      list.add(new Object[]{new ContactData()
              .withFirstname(value[0])
              .withMiddlename(value[1])
              .withLastname(value[2])
/*Лень всю кучу делать, да и не буду этим форматом пользоваться.
              .withTitle("Дорогой")
              .withNickname("ттт")
              .withGroupNum(1)
              .withAddress1("РФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13")
              .withImage(new File("src/test/resources/macronomica.png"))
              .where(new ContactTextInfo()
                      .address2("Тестовый район, с. Тестовое, 1я тестовая улица, д. 23")
                      .company("Тест продакшн")
                      .notes(String.format("Помрешь, пока заполнишь, %s, %s", qty, unicDate)))
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
              .withBirth(new DatesData()
                      .day(12)
                      .month(5)
                      .year("1987"))
              .withAnniversary(new DatesData()
              .day(25)
              .month(11)
              .year("2011"))))*/
      });
      line = reader.readLine();
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> contactListJSON() throws IOException {
    File tmp = new File(".");
    System.out.println(tmp.getAbsolutePath());
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
//    Type jcontacts = new TypeToken<List<ContactData>>() {}.getType();
    List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {}.getType());
    return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }


  @Test(dataProvider = "contactListJSON")
  public void newRecordTest(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().getQty(), equalTo(before.size() + 1));
    Contacts after = app.contact().getAll();
    assertThat(after, equalTo(before.with(contact.withId((app.contact().findDifference(before, after)).getId()))));
  }


  @Test(enabled = false)
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
            .withAddress1("РФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13")
            .withImage(new File("src/test/resources/macronomica.png"))
            .where(new ContactTextInfo()
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
            .withBirth(new DatesData()
                    .day(12)
                    .month(5)
                    .year("1987"))
            .withAnniversary(new DatesData()
                    .day(25)
                    .month(11)
                    .year("2011"));
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().getQty(), equalTo(before.size() + 1));
    Contacts after = app.contact().getAll();
    assertThat(after, equalTo(before.with(contact.withId((app.contact().findDifference(before, after)).getId()))));
  }
}
