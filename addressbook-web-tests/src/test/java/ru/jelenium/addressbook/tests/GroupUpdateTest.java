package ru.jelenium.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

import java.util.List;

public class GroupUpdateTest extends TestBase {

  @Test
  public void testGroupUpdate() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createWhenNoGroup(new GroupData("Create 2up" + unicDate, "For update header", "For update footer"));
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int groupNum = before.size() - 1;
    app.getGroupHelper().chooseCheckBox(groupNum);
    int groupId = app.getGroupHelper().getGroupId(groupNum);
    GroupData group = new GroupData(groupId, "Updated test group, browser type" + unicDate, "USB header", "USB footer");
    app.getGroupHelper().editGroup();
    app.getGroupHelper().fillOutFields(group);
    app.getGroupHelper().saveUpdatedGroup();
    app.getGroupHelper().gotoGroupPageThrAnswerLink();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
    before.set((before.indexOf(app.getGroupHelper().getDiff(after, before))),group);
    before.sort(app.getGroupHelper().getById());
    after.sort(app.getGroupHelper().getById());
    Assert.assertEquals(after, before);
  }

}
