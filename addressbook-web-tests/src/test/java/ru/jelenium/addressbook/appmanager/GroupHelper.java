package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.jelenium.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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

  public List<GroupData> getGroupList() {
    //List<GroupData> groupList = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    /* for (WebElement element : elements) {
       String tmp = element.getText();
      groupList.add(new GroupData(Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")), tmp, null, null));
    }
    */
    // Красиво, но типа нечестно (((
    //elements.stream().forEach(e -> groupList.add(new GroupData(Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value")), e.getText(), null, null)));
    //Function<? super WebElement,? extends GroupData> toGroupData = e -> (new GroupData(Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value")), e.getText(), null, null));
    //Stream<GroupData> streamGroups = elements.stream().map(e -> (new GroupData(Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value")), e.getText(), null, null)));
    List<GroupData> groupList = elements.stream().map(e -> (new GroupData(Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value")), e.getText(), null, null)))
            .collect(Collectors.toList());
    return groupList;
  }

  public int getGroupId(int groupNum) {
    groupNum++;
    return Integer.parseInt(wd.findElement(By.xpath(".//*[@id='content']/form/span[" + groupNum + "]/input")).getAttribute("value"));
  }

  public GroupData getDiff(List<GroupData> small, List<GroupData> full) {
    return full.stream().filter((g) -> !small.contains(g)).findFirst().get();
  }


  Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
  public Comparator<? super GroupData> getById() {
    return ById;
  }

}
