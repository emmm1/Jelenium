package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

public class RecordTests extends TestBase {


  @Test
  public void newRecordCreate() {

    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().fillOutForm(new ContactData("Тест", "Тестович", "Тестовый", "ттт", "Дорогой",
            new ContactTextInfo("Тест продакшн", "РФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13", "Тестовый район, с. Тестовое, 1я тестовая улица, д. 23",
                    "Помрешь, пока заполнишь"),
            new ContactPhone("465464611263112", "+1245 54 545 68595489", "3546131564631", "+132(464) 54651 1564651 31", "2345464"),
            new ContactEData("test.testowy@testPro.com", "test.testowy@gmail.com", "testy_1987@mail.ru", "http://localhost/addressbook"),
            new DataData(12, 5, "1987"), new DataData(25, 11, "2011")));
    app.getContactHelper().chooseGroup(2);
    app.getNavigationHelper().pushEnterAddNewPage();

  }

  @Test
  public void recordUpdate() {

    app.getNavigationHelper().gotoHomePage();
    app.getHomeNav().gotoEdit(2);
    app.getContactHelper().fillOutForm(new ContactData("UТест", "UТестович", "UТестовый", "Uттт", "UДорогой",
            new ContactTextInfo("UТест продакшн", "UРФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13", "UТестовый район, с. Тестовое, 1я тестовая улица, д. 23",
                    "UПомрешь, пока заполнишь"),
            new ContactPhone("++465464611263112", "++1245 54 545 68595489", "++3546131564631", "++132(464) 54651 1564651 31", "++2345464"),
            new ContactEData("Utest.testowy@testPro.com", "Utest.testowy@gmail.com", "Utesty_1987@mail.ru", "Uhttp://localhost/addressbook"),
            new DataData(9, 3, "2016"), new DataData(9, 3, "2016")));
    app.getNavigationHelper().pushUpdateEditPage();

  }

  @Test
  public void homePageRecordDelete() {
    app.getNavigationHelper().gotoHomePage();
    //передаем номер записи
    app.getHomeNav().selectFirst();
    app.getHomeNav().pushDelete();
    app.getHomeNav().closeAlarm();

  }
  /*
  @Test
  public void firstRecordDelete() {
    app.getNavigationHelper().gotoHomePage();
    //передаем номер записи
    app.getHomeNav().gotoDetails(1);
    app.getNavigationHelper().gotoRecordEditorThrViewRecordPage();
    app.getContactHelper().deleteRecord();
  }

  /*
  @Test
  public void allRecordDelete() {
    app.getNavigationHelper().gotoHomePage();
    //передаем номер записи
    app.getHomeNav().selectAll();
    app.getHomeNav().pushDelete();
    app.getHomeNav().closeAlarm();
  }
  */

}
