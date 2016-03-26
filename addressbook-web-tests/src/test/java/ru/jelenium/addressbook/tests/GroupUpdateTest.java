package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;
import ru.jelenium.addressbook.model.Groups;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupUpdateTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    app.group().createWhenNo(new GroupData()
            .withName("Create 2del" + unicDate)
            .withName("For delete header")
            .withFooter("For delete footer"));
  }

  @Test
  public void testGroupUpdate() {
    app.goTo().groupPage();
    Groups before = app.group().list();
    GroupData changed = before.iterator().next();
    app.group().choose(changed);
    GroupData newData = new GroupData()
            .withId(changed.getId())
            .withName("Updated test group, browser type" + " " + browserType + " " + new Date(System.currentTimeMillis()))
            .withHeader("Updated header")
            .withFooter("Updated footer");
    app.group().edit(newData);
    Groups after = app.group().list();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.withChangedGroup(((app.group().findDiff(after, before))), newData)));
  }
}
