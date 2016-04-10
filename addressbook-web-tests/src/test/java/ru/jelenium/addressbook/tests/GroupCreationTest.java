package ru.jelenium.addressbook.tests;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.GroupData;
import ru.jelenium.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> groupListCSV() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] value = line.split(";");
      list.add(new Object[] {new GroupData().withName(value[0]).withHeader(value[1]).withFooter(value[2])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> groupListJSON() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    Type jgroups = new TypeToken<List<GroupData>>(){}.getType();
    List<GroupData> groups = gson.fromJson(json, jgroups);
//    List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }



  @Test(dataProvider = "groupListJSON")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().getAll();
    app.group().create(group);
    assertThat(app.group().getQty(), equalTo(before.size() + 1));
    Groups after = app.group().getAll();
    assertThat(after, equalTo(before.with(group.withId(app.group().findDiff(before, after).getId()))));
  }


  @Test(enabled = false)
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().getAll();
    GroupData group = new GroupData()
            .withName("Test group for" + unicDate)
            .withHeader("SB header")
            .withFooter("SB footer");
    app.group().create(group);
    assertThat(app.group().getQty(), equalTo(before.size() + 1));
    Groups after = app.group().getAll();
    assertThat(after, equalTo(before.with(group.withId(app.group().findDiff(before, after).getId()))));
  }

}
