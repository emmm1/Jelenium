package ru.jelenium.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

import java.util.List;

public class NewRecordTest extends TestBase {

  @Test
  public void newRecordTest() {

    app.goTo().gotoHomePage();
    //получаем список до
    List<ContactData> before = app.getContactHelper().getContacts();
    app.getContactHelper().createRecord(new ContactData("Тест", "Тестович", "Тестовый" + unicDate, "ттт", "Дорогой", 1,
            new ContactTextInfo("Тест продакшн", "РФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13", "Тестовый район, с. Тестовое, 1я тестовая улица, д. 23",
                    "Помрешь, пока заполнишь" + unicDate),
            new ContactPhone("465464611263112", "+1245 54 545 68595489", "3546131564631", "+132(464) 54651 1564651 31", "2345464"),
            new ContactEData(null, "test.testowy@gmail.com", "testy_1987@mail.ru", "http://localhost/addressbook"),
            new DataData(12, 5, "1987"), new DataData(25, 11, "2011")), false);
    app.goTo().gotoHomePage();
    //получаем список после
    List<ContactData> after = app.getContactHelper().getContacts();
    //сравиваем длины
    Assert.assertEquals(before.size(), after.size() - 1);
    //добавляем в список до отсутвующее
    before.add(app.getContactHelper().findDiff(before, after));
    //сортируем списки - вынести ById в HelperBase
    before.sort(app.getContactHelper().ById);
    after.sort(app.getContactHelper().ById);
    //сравниваем
    Assert.assertEquals(after, before);

  }
}
