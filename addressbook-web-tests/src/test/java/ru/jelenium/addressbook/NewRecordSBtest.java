package ru.jelenium.addressbook;

import org.testng.annotations.Test;

public class NewRecordSBtest extends SBBase{



  @Test
  public void NewRecordSBtest() {

    app.gotoAddNewPage();
        app.fillOutForm(new ContactData("Тест", "Тестович", "Тестовый", "ттт", "Дорогой",
                new ContactTextInfo("Тест продакшн", "РФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13", "Тестовый район, с. Тестовое, 1я тестовая улица, д. 23",
                        "Помрешь, пока заполнишь"),
                new ContactPhone("465464611263112", "+1245 54 545 68595489", "3546131564631", "+132(464) 54651 1564651 31", "2345464"),
                new ContactEData("test.testowy@testPro.com", "test.testowy@gmail.com","testy_1987@mail.ru", "http://localhost/addressbook")));
  }

}
