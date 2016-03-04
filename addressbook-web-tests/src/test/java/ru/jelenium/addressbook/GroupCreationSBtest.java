package ru.jelenium.addressbook;

import org.testng.annotations.Test;

public class GroupCreationSBtest extends SBBase {

  @Test
  public void testGroupCreationSB() {
    gotoGroupPage();
    initNewGroup();
    fillOutFields(new GroupData("Test group for Selenium Builder", "SB header", "SB footer"));
    gotoGroupPageThrAnswerLink();
  }

}
