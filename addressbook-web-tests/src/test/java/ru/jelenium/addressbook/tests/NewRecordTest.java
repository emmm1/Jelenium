package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

public class NewRecordTest extends TestBase {


  @Test
  public void newRecordTest() {

    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().fillOutForm(new ContactData("Тест", "Тестович", "Тестовый", "ттт", "Дорогой", null,
            new ContactTextInfo("Тест продакшн", "РФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13", "Тестовый район, с. Тестовое, 1я тестовая улица, д. 23",
                    "Помрешь, пока заполнишь"),
            new ContactPhone("465464611263112", "+1245 54 545 68595489", "3546131564631", "+132(464) 54651 1564651 31", "2345464"),
            new ContactEData(null, "test.testowy@gmail.com", "testy_1987@mail.ru", "http://localhost/addressbook"),
            new DataData(12, 5, "1987"), new DataData(25, 11, "2011")), true);
    //app.getContactHelper().chooseGroup(2);
    app.getNavigationHelper().pushEnterAddNewPage();

  }

}
