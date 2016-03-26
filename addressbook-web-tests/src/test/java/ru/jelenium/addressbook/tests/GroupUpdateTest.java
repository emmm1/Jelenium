package ru.jelenium.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.Group;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class GroupUpdateTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    app.group().createWhenNo(new Group().withName("Create 2del" + unicDate).withName("For delete header").withFooter("For delete footer"));
  }

  @Test
  public void testGroupUpdate() {
    app.goTo().groupPage();
    Set<Group> before = app.group().list();
    int groupNum = before.size() - 1;
    app.group().chooseCheckBox(groupNum);
    int groupId = app.group().getGroupId(groupNum);
    Group group = new Group().withId(groupId).withName("Updated test group, browser type" + " " + browserType + " " + new Date(System.currentTimeMillis())).withHeader("Updated header")
            .withFooter("Updated footer");
    app.group().editGroup(group);
    Set<Group> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());
    /*Переделать обновление данных о группе
    before.set((before.indexOf(app.group().getDiff(after, before))),group);
    */
    //before.sort(app.group().getById());
    //after.sort(app.group().getById());
    Assert.assertEquals(after, before);
  }
}
