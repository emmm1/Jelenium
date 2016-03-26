package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.jelenium.addressbook.model.Group;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void fillOutFields(Group group) {
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
  }

  public void editGroup(Group group) {
    click(By.name("edit"));
    fillOutFields(group);
    saveUpdatedGroup();
    confirm();
  }

  public void create(Group group) {
    initNewGroup();
    fillOutFields(group);
    saveNewGroup();
    confirm();
  }

  public void createWhenNo(Group group) {
    
    if (!isThereAGroup()) {
      create(group);
    }
  }

  public boolean isThereAGroup() {
    return isElementHere(By.name("selected[]"));
  }

  public Set<Group> list() {
    //List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    Set<Group> groupList = wd.findElements(By.cssSelector("span.group")).stream()
            .map(e -> (new Group().withId(Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"))).withName(e.getText())))
            .collect(Collectors.toSet());
    return groupList;
  }

  public int getGroupId(int groupNum) {
    groupNum++;
    return Integer.parseInt(wd.findElement(By.xpath(".//*[@id='content']/form/span[" + groupNum + "]/input")).getAttribute("value"));
  }

  public Group getDiff(Set<Group> small, Set<Group> full) {
    return full.stream().filter((g) -> !small.contains(g)).findFirst().get();
  }

  Comparator<? super Group> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());

  public Comparator<? super Group> getById() {
    return ById;
  }

  public void confirm() {
    click(By.linkText("group page"));
  }
}
