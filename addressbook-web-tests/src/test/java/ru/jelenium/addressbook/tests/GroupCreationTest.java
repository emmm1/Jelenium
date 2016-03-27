package ru.jelenium.addressbook.tests;


import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;
import ru.jelenium.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().getAll();
    GroupData group = new GroupData()
            .withName("Test group for" + unicDate)
            .withHeader("SB header")
            .withFooter("SB footer");
    app.group().create(group);
    Groups after = app.group().getAll();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.with(group.withId(app.group().findDiff(before, after).getId()))));
  }

}
