package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.jelenium.addressbook.model.ContactData;

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

  public void homePage() {
    if (isElementHere(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void details(ContactData deleted) {
    wd.findElement(By.cssSelector("a[href=\"view.php?id=" +deleted.getId()+ "\"")).click();
  }
}
