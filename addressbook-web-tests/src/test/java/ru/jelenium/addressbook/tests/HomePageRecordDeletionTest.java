package ru.jelenium.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */


public class HomePageRecordDeletionTest extends TestBase {

  @Test
  public void homePageRecordDelete() {
    if (browserType.equals("HU")) {
      throw new Error("такой тип броузера использровать нельзя");
    }
    app.goTo().gotoHomePage();
    app.getContactHelper().createWhenNoContact(new ContactData("ForHomePageDeleteТест", "2HPRDel" + unicDate));
    //список до
    List<ContactData> before = app.getContactHelper().getContacts();
    //переделать вызов по номеру как в группах
    app.getHomeNav().chooseCheckBox(before.size() - 1);
    app.getHomeNav().pushDelete();
    app.getHomeNav().closeAlarm();
    app.goTo().gotoHomePage();
    //список после
    List<ContactData> after = app.getContactHelper().getContacts();
    //сравнить размеры списков
    Assert.assertEquals(after.size(), before.size() - 1);
    //удалить из до удаленную группу
    before.remove(app.getContactHelper().findDiff(after, before));
    //отсортировать списки
    before.sort(app.getContactHelper().ById);
    after.sort(app.getContactHelper().ById);
    //сравнить
    Assert.assertEquals(after, before);
  }

}
