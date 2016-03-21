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
    Assert.assertEquals(after.size(), before.size() + 1);
    //узнать ИД добавленной группы, сортировка групп, специально срываем тест и создаем тустринг для более понятного выввода данных об ошибке
    //находим максимальный элемент в списке ид и предполагаем, что он и есть последний.
    //int newId = after.stream().max(ById).get().getId();


    /* //проверяем есть ли элемент с таким ид в списке бефоре и если нет - то он и есть искомый элемент и проверяем
    int newId = 0;
    for (GroupData groupNew : after) {
      if (before.indexOf(groupNew) == -1) {
        if (newId != 0) {
          throw new Error("Что-то странное");
        }
        newId = groupNew.getId();
      }
    }
    before.add(new GroupData(newId, group.getName(), group.getHeader(), group.getFooter()));
    */

    //Самый воспроизводимый для меня метод, но использующий дыру в жаве
    /*
    after.stream().forEach((g) -> {
      if (!before.contains(g)) {
        before.add(g);
      }
    });
    */

    GroupData newGroup = after.stream().filter((g) -> !before.contains(g)).findFirst().get();
    before.add(newGroup);

    Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(after, before);
  }
}
