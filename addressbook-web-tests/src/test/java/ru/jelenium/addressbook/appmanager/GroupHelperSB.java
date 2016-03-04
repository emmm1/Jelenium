package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.jelenium.addressbook.model.GroupData;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class GroupHelperSB {
  private FirefoxDriver wd;

  public GroupHelperSB(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void fillOutFields(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    wd.findElement(By.name("submit")).click();
  }
}
