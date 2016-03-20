package ru.jelenium.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("Test group for" + unicDate, "SB header", "SB footer");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //сранвиваем количество и если оно увеличеилось на 1 упорядочиваем и сравниваем группы
    Assert.assertEquals(after.size(),before.size() + 1);
    //узнать ИД добавленной группы, сортировка групп, специально срываем тест и создаем тустринг для более понятного выввода данных об ошибке
    Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    int newId = after.stream().max(ById).get().getId();
/*    for (GroupData groupNew : after) {
      for (GroupData groupOld : before) {
        if (groupNew.getId() == groupOld.getId()) {

        }
      }
    }

*/
    before.add(new GroupData(newId, group.getName(), group.getHeader(), group.getFooter()));
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(after, before);
  }

}
