package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.jelenium.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void fillOutFields(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
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

  public void chooseGroup(Integer groupNum) {
    //номерм чекбокса для такого адреса - 1 - первый элесент. Чтобы при вызыве 0 был первым увеличиваю значение на 1
    groupNum++;
    click(By.xpath(".//*[@id='content']/form/span["+ groupNum + "]/input"));
  }

  public void deleteGroup() {
    click(By.name("delete"));
  }

  public void editGroup() {
    click(By.name("edit"));
  }

  public void gotoGroupPageThrAnswerLink() {
    click(By.linkText("group page"));
  }

  public void createGroup(GroupData groupData) {
    initNewGroup();
    fillOutFields(groupData);
    saveNewGroup();
    gotoGroupPageThrAnswerLink();
  }

  public void createWhenNoGroup(GroupData groupData) {
    if (!isThereAGroup()) {
      createGroup(groupData);
    }
  }

  public boolean isThereAGroup() {
    return isElementHere(By.name("selected[]"));
  }

  public Integer groupQty() {
    return wd.findElements(By.className("group")).size();
  }

  public List<GroupData> getGroupList() {
    List <GroupData> groupList = new ArrayList<>();
    List <WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      groupList.add(new GroupData(Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")), element.getText(), null, null));
    }

    // Красиво, но неправильно (((
    // elements.stream().forEach(e -> groupList.add(new GroupData(Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value")), e.getText(), null, null)));
    return groupList;
  }
}
