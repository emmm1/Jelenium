package ru.jelenium.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().getGroupList();
    GroupData group = new GroupData("Test group for" + unicDate, "SB header", "SB footer");
    app.group().createGroup(group);
    List<GroupData> after = app.group().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(app.group().getDiff(before, after));
    before.sort(app.group().getById());
    after.sort(app.group().getById());
    Assert.assertEquals(after, before);
  }

}
