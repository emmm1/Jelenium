package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createWhenNoGroup(new GroupData("Create 2del" + unicDate, "For delete header", "For delete footer"));
    app.getGroupHelper().chooseGroup(1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().gotoGroupPageThrAnswerLink();
  }
}
