package ru.jelenium.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.Group;

import java.util.List;
import java.util.Set;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    //сэт вместо листа
    Set<Group> before = app.group().list();
    Group group = new Group().withName("Test group for" + unicDate).withHeader("SB header").withFooter("SB footer");
    app.group().create(group);
    //сэт вместо листа
    Set<Group> after = app.group().list();
    //сравниваем сэты вместо листов
    Assert.assertEquals(after.size(), before.size() + 1);
    //расширяяем сэт и делаем методы withGroup withoutGroup
    before.add(app.group().getDiff(before, after));
    //before.sort(app.group().getById());
    //after.sort(app.group().getById());
    Assert.assertEquals(after, before);
  }

}
