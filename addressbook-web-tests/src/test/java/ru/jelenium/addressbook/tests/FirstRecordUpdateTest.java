package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

public class FirstRecordUpdateTest extends TestBase {


  @Test
  public void updateRecordTest() {

    app.getNavigationHelper().gotoHomePage();
    app.getHomeNav().gotoEdit(2);
    app.getContactHelper().fillOutForm(new ContactData("UТест", "UТестович", "UТестовый", "Uttt", "UДорогой",
                    null, new ContactTextInfo("UТест продакшн", "UРФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13", "UТестовый район, с. Тестовое, 1я тестовая улица, д. 23",
                    "UПомрешь, пока заполнишь"),
            new ContactPhone("++465464611263112", "++1245 54 545 68595489", "++3546131564631", "++132(464) 54651 1564651 31", "++2345464"),
            new ContactEData("Utest.testowy@testPro.com", "Utest.testowy@gmail.com", "Utesty_1987@mail.ru", "Uhttp://localhost/addressbook"),
            new DataData(9, 3, "2016"), new DataData(9, 3, "2016")),
            true);
    //app.getNavigationHelper().pushUpdateEditPage();

  }

}
