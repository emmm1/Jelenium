package ru.jelenium.addressbook;

import org.testng.annotations.Test;

public class GroupCreationSIDEtest extends SIDEBase {


  @Test
  public void testGroupCreationSIDE() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillOutGroupForm((new GroupData("Test group for Selenium IDE", "SIDE logo", "footer SIDE")));
    gotoGroupPage();
  }


}
