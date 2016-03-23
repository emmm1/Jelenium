package ru.jelenium.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createWhenNoGroup(new GroupData("Create 2del" + unicDate, "For delete header", "For delete footer"));
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().chooseCheckBox(before.size() - 1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().gotoGroupPageThrAnswerLink();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(app.getGroupHelper().getDiff(after, before));
    before.sort(app.getGroupHelper().getById());
    after.sort(app.getGroupHelper().getById());
    Assert.assertEquals(after, before);
  }
}
