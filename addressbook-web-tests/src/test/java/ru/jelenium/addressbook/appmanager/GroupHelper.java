package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.jelenium.addressbook.model.GroupData;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillOutFields(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
    click(By.name("submit"));
  }

  public void initNewGroup() {
    click(By.name("new"));
  }


}
