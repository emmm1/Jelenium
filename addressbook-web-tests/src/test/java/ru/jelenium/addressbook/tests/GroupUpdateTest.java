package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

public class GroupUpdateTest extends TestBase {

  @Test
  public void testGroupUpdate() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createWhenNoGroup(new GroupData("Create 2up" + unicDate, "For update header", "For update footer"));
    //создаем список групп до
    app.getGroupHelper().chooseGroup(1);
    app.getGroupHelper().editGroup();
    app.getGroupHelper().fillOutFields(new GroupData("Updated test group, browser type" + unicDate, "USB header", "USB footer"));
    app.getGroupHelper().saveUpdatedGroup();
    app.getGroupHelper().gotoGroupPageThrAnswerLink();
    //создаем список после
    //сравниваем длину
    //сотируем списки
    //сравниваем списки
  }

}
