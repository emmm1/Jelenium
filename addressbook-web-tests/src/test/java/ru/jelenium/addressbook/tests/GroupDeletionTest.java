package ru.jelenium.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.Group;

import java.util.List;
import java.util.Set;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    app.group().createWhenNo(new Group().withName("Create 2del" + unicDate).withName("For delete header").withFooter("For delete footer"));
  }

  @Test
  public void testGroupDeletion() {
    app.goTo().groupPage();
    //здесь будет сэт вместо листа
    Set<Group> before = app.group().list();
    //вместо этого выбираем произвольную группу и ее ищем по Id
    app.group().chooseCheckBox(before.size() - 1);
    app.group().delete();
    app.group().confirm();
    //сэт вместо листа
    Set<Group> after = app.group().list();
    //ну и тут hamcrest
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(app.group().getDiff(after, before));
    //before.sort(app.group().getById());
    //after.sort(app.group().getById());
    Assert.assertEquals(after, before);
  }
}
