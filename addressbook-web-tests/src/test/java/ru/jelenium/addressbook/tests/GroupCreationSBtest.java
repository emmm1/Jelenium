package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

public class GroupCreationSBtest extends SBBase {

  @Test
  public void testGroupCreationSB() {
    app.getNavigationHelperSB().gotoGroupPage();
    app.getGroupHelperSB().initNewGroup();
    app.getGroupHelperSB().fillOutFields(new GroupData("Test group for Selenium Builder", "SB header", "SB footer"));
    app.getNavigationHelperSB().gotoGroupPageThrAnswerLink();
  }

}
