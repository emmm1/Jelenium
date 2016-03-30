package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;
import ru.jelenium.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    Groups before = app.group().getAll();
    app.group().createWhenNo(before, new GroupData().withName("Create 2del" + unicDate).withName("For delete header").withFooter("For delete footer"));
  }

  @Test
  public void testGroupDeletion() {
    app.goTo().groupPage();
    Groups before = app.group().getAll();
    GroupData group = before.iterator().next();
    app.group().choose(group);
    app.group().delete();
    app.goTo().groupPage();
    assertThat(app.group().getQty(), equalTo(before.size() - 1));
    Groups after = app.group().getAll();
    assertThat(after, equalTo(before.without(group)));
  }
}
