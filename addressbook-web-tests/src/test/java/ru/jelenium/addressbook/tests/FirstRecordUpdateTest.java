package ru.jelenium.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class FirstRecordUpdateTest extends TestBase {


  @Test
  public void updateRecordTest() {

    app.goTo().gotoHomePage();
    app.getContactHelper().createWhenNoContact(new ContactData("ForUpdateТест", "ForUpdate" + unicDate));
    //список до
    List<ContactData> before = app.getContactHelper().getContacts();
    //определить изменяемую группу
    int checkBoxNum = 0;
    app.getHomeNav().gotoEdit(checkBoxNum);
    ContactData contactBefore = before.get(checkBoxNum);
    app.getContactHelper().fillOutForm(new ContactData("UТест", "UТестович", "UТестовый" + " " + browserType + " " + new Date(System.currentTimeMillis()), "Uttt", "UДорогой",
            null, new ContactTextInfo("UТест продакшн", "UРФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13", "UТестовый район, с. Тестовое, 1я тестовая улица, д. 23",
            "UПомрешь, пока заполнишь"),
            new ContactPhone("++465464611263112", "++1245 54 545 68595489", "++3546131564631", "++132(464) 54651 1564651 31", "++2345464"),
            new ContactEData("Utest.testowy@testPro.com", "Utest.testowy@gmail.com", "Utesty_1987@mail.ru", "Uhttp://localhost/addressbook"),
            new DataData(9, 3, "2016"), new DataData(9, 3, "2016")), true);
    app.getContactHelper().pushUpdateEditPage();
    app.getContactHelper().gotoHomePage();
    //список после
    List<ContactData> after = app.getContactHelper().getContacts();
    //сравнить размеры
    Assert.assertEquals(before.size(), after.size());
    //вычислить несовпадающий контакт в списке до и сравнить с данными контакта до изменения
    Assert.assertEquals(app.getContactHelper().findDiff(after, before), contactBefore);
    //Меняем измененный контакт на первоначальный вариант в списке после
    after.set(after.indexOf(app.getContactHelper().findDiff(before, after)), contactBefore);
    //для разнообразия превращаем списки в коллекции и сравниваем. Сравнение идет с учетом ид. В других тестах уже упорядочивал
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
