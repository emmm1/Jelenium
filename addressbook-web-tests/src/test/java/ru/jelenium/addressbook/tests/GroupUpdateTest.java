package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

public class GroupUpdateTest extends TestBase {

  @Test
  public void testGroupUpdate() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createWhenNoGroup(new GroupData("Test group for update", "For update header", "For update footer"));
    app.getGroupHelper().chooseGroup(1);
    app.getGroupHelper().editGroup();
    app.getGroupHelper().fillOutFields(new GroupData("UTest group for Selenium Builder", "USB header", "USB footer"));
    app.getGroupHelper().saveUpdatedGroup();
    app.getGroupHelper().gotoGroupPageThrAnswerLink();
  }

}
