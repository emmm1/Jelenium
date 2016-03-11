package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletionSB() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().chooseGroup(1);
    app.getGroupHelper().deleteGroup();
    app.getNavigationHelper().gotoGroupPageThrAnswerLink();
  }

}
