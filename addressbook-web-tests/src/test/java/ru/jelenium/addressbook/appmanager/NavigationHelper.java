package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementHere(By.cssSelector("div#content h1")) && isElementHere(By.name("new")) && wd.findElement(By.cssSelector("div#content h1")).getText().equals("Groups")) {
      return;
    }
    click(By.linkText("groups"));
  }


  public void gotoHomePage() {
    if (isElementHere(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

}
