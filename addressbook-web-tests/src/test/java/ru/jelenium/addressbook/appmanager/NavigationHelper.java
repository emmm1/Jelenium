package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class NavigationHelper {
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {

    this.wd = wd;
  }

  public void gotoGroupPageThrAnswerLink() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoAddNewPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}
