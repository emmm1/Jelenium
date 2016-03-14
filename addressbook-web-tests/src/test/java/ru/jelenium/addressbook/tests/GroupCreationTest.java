package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("Test group for Selenium Builder", "SB header", "SB footer"));
  }

}
