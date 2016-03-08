package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class NavigationHelper extends HelperBase {
//  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
//    this.wd = wd;
  }

  public void gotoGroupPageThrAnswerLink() {
    click(By.linkText("group page"));
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoAddNewPage() {
    click(By.linkText("add new"));
  }

}
