package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

public class GroupTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initNewGroup();
    app.getGroupHelper().fillOutFields(new GroupData("Test group for Selenium Builder", "SB header", "SB footer"));
    app.getGroupHelper().saveNewGroup();
    app.getNavigationHelper().gotoGroupPageThrAnswerLink();
  }

  @Test
  public void testGroupUpdate() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().chooseGroup(1);
    app.getGroupHelper().editGroup();
    app.getGroupHelper().fillOutFields(new GroupData("UTest group for Selenium Builder", "USB header", "USB footer"));
    app.getGroupHelper().saveUpdatedGroup();
    app.getNavigationHelper().gotoGroupPageThrAnswerLink();
  }

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().chooseGroup(1);
    app.getGroupHelper().deleteGroup();
    app.getNavigationHelper().gotoGroupPageThrAnswerLink();
  }
}
