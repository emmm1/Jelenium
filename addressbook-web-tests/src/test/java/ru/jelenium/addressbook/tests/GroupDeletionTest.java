package ru.jelenium.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    //здесь новый вид из каскада сеттеров
    app.group().createWhenNo(new GroupData("Create 2del" + unicDate, "For delete header", "For delete footer"));
  }

  @Test
  public void testGroupDeletion() {
    app.goTo().groupPage();
    //здесь будет сэт вместо листа
    List<GroupData> before = app.group().getGroupList();
    //вместо этого выбираем произвольную группу и ее ищем по Id
    app.group().chooseCheckBox(before.size() - 1);
    app.group().delete();
    app.group().confirm();
    //сэт вместо листа
    List<GroupData> after = app.group().getGroupList();
    //ну и тут hamcrest
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(app.group().getDiff(after, before));
    before.sort(app.group().getById());
    after.sort(app.group().getById());
    Assert.assertEquals(after, before);
  }
}
