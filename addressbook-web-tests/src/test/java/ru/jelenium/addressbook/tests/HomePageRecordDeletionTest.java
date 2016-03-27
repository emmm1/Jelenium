package ru.jelenium.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */


public class HomePageRecordDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(new ContactData().withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }

  public void checkBrowser() {
    if (browserType.equals("HU")) {
      throw new Error("такой тип броузера использровать нельзя");
    }
  }

  @Test
  public void homePageRecordDelete() {

    app.goTo().homePage();
    app.contact().createWhenNoContact(new ContactData().withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
    //список до
    Set<ContactData> before = app.contact().getAll();
    //переделать вызов по номеру как в группах
    app.onHomepage().chooseCheckBox(before.size() - 1);
    app.onHomepage().pushDelete();
    app.onHomepage().closeAlarm();
    app.goTo().homePage();
    //список после
    Set<ContactData> after = app.contact().getAll();
    //сравнить размеры списков
    Assert.assertEquals(after.size(), before.size() - 1);
    //удалить из до удаленную группу
    before.remove(app.contact().findDifference(after, before));
    //сравнить
    Assert.assertEquals(after, before);
  }

}
