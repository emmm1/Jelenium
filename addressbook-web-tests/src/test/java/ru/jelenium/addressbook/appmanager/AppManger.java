package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.jelenium.addressbook.model.AuthData;

import java.util.concurrent.TimeUnit;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class AppManger {
  FirefoxDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private AuthData authData;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    navigationHelper = new NavigationHelper(wd);
    contactHelper = new ContactHelper(wd);
    groupHelper = new GroupHelper(wd);
    sessionHelper = new SessionHelper(wd);
    authData = new AuthData("admin", "secret");
    sessionHelper.login(authData.getLogin(), authData.getPass());
  }


  public void stop() {
    wd.quit();
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
