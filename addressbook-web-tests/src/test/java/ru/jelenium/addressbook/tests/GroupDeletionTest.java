package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createWhenNoGroup(new GroupData("Create 2del" + unicDate, "For delete header", "For delete footer"));
    //получаем список групп
    //посмотреть как реализован выбор группы и сравниить с моим и переделать, чтобы нумерация первого элемента была 0

    app.getGroupHelper().chooseGroup(1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().gotoGroupPageThrAnswerLink();
    //удаляем из списка групп нужную

    //сравниваем списки групп

  }
}
