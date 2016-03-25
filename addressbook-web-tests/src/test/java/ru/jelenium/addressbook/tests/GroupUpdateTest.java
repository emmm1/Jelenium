package ru.jelenium.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

import java.util.Date;
import java.util.List;

public class GroupUpdateTest extends TestBase {

  @Test
  public void testGroupUpdate() {
    app.goTo().groupPage();
    app.group().createWhenNo(new GroupData("Create 2up" + unicDate, "For update header", "For update footer"));
    List<GroupData> before = app.group().getGroupList();
    int groupNum = before.size() - 1;
    app.group().chooseCheckBox(groupNum);
    int groupId = app.group().getGroupId(groupNum);
    GroupData group = new GroupData(groupId, "Updated test group, browser type" + " " + browserType + " " + new Date(System.currentTimeMillis()), "USB header", "USB footer");
    app.group().editGroup();
    app.group().fillOutFields(group);
    app.group().saveUpdatedGroup();
    app.group().confirm();
    List<GroupData> after = app.group().getGroupList();
    Assert.assertEquals(after.size(), before.size());
    before.set((before.indexOf(app.group().getDiff(after, before))),group);
    before.sort(app.group().getById());
    after.sort(app.group().getById());
    Assert.assertEquals(after, before);
  }

}
