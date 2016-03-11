package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.jelenium.addressbook.model.GroupData;

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
    click(By.xpath(".//*[@id='content']/form/span["+ groupNum + "]/input"));
  }

  public void deleteGroup() {
    click(By.name("delete"));
  }

  public void editGroup() {
    click(By.name("edit"));
  }

}
