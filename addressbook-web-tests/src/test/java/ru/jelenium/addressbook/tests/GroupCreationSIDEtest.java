package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

public class GroupCreationSIDEtest extends SIDEBase {


  @Test
  public void testGroupCreationSIDE() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillOutGroupForm((new GroupData("Test group for Selenium IDE", "SIDE logo", "footer SIDE")));
    app.gotoGroupPage();
  }


}
