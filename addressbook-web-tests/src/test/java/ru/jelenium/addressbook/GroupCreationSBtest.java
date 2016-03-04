package ru.jelenium.addressbook;

import org.testng.annotations.Test;

public class GroupCreationSBtest extends SBBase {

  @Test
  public void testGroupCreationSB() {
    app.gotoGroupPage();
    app.initNewGroup();
    app.fillOutFields(new GroupData("Test group for Selenium Builder", "SB header", "SB footer"));
    app.gotoGroupPageThrAnswerLink();
  }

}
