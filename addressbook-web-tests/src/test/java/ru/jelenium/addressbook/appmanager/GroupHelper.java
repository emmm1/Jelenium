package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.jelenium.addressbook.model.GroupData;
import ru.jelenium.addressbook.model.Groups;

import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void fillOutFields(GroupData group) {
    type(By.name("group_name"), group.getName());
    type(By.name("group_header"), group.getHeader());
    type(By.name("group_footer"), group.getFooter());
  }

  public void saveNewGroup() {
    click(By.name("submit"));
  }

  public void saveUpdatedGroup() {
    click(By.name("update"));
  }

  public void initNewGroup() {
    click(By.name("new"));
  }

  public void delete() {
    click(By.name("delete"));
    groupsCashe = null;
  }

  public void edit(GroupData group) {
    click(By.name("edit"));
    fillOutFields(group);
    saveUpdatedGroup();
    confirm();
    groupsCashe = null;
  }

  public void create(GroupData group) {
    initNewGroup();
    fillOutFields(group);
    saveNewGroup();
    confirm();
    groupsCashe = null;
  }

  public void createWhenNo(Groups before, GroupData group) {

    if (before.size() == 0) {
      create(group);
    }
  }

  public boolean isThereAGroup() {
    return isElementHere(By.name("selected[]"));
  }

  private Groups groupsCashe = null;

  public Groups getAll() {
    if (groupsCashe == null){
      groupsCashe = wd.findElements(By.cssSelector("span.group")).stream()
              .map(e -> new GroupData().withId(Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"))).withName(e.getText()))
              .collect(Collectors.toCollection(Groups::new));
      return groupsCashe;
    }
    return new Groups(groupsCashe);
  }

  public GroupData findDiff(Set<GroupData> small, Set<GroupData> full) {
    return full.stream().filter((g) -> !small.contains(g)).findFirst().get();
  }



  public void confirm() {
    click(By.linkText("group page"));
  }

  /*
    Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());

    public Comparator<? super GroupData> getById() {
    return ById;
  }

  public int getGroupId(int groupNum) {
    groupNum++;
    return Integer.parseInt(wd.findElement(By.xpath(".//*[@id='content']/form/span[" + groupNum + "]/input")).getAttribute("value"));
  }*/

  public void choose(GroupData group) {
    wd.findElement(By.cssSelector(String.format("input[value='%s']", group.getId()))).click();
  }

  public int getQty() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
