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
    app.getGroupHelper().chooseGroup(1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().gotoGroupPageThrAnswerLink();
    //создаем список после
    //сравниваем длины списокв
    //находим группу которая есть в до и нет в после
    //удаляем из списка групп найденную
    //сортируем списки
    //сравниваем списки групп

  }
}
