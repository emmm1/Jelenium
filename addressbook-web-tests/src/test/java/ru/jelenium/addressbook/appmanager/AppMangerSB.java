package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.jelenium.addressbook.model.AuthData;

import java.util.concurrent.TimeUnit;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class AppMangerSB {
  FirefoxDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelperSB navigationHelperSB;
  private GroupHelperSB groupHelperSB;
  private ContactHelperSB contactHelperSB;
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
    navigationHelperSB = new NavigationHelperSB(wd);
    contactHelperSB = new ContactHelperSB(wd);
    groupHelperSB = new GroupHelperSB(wd);
    sessionHelper = new SessionHelper(wd);
    authData = new AuthData("admin", "secret");
    sessionHelper.login(authData.getLogin(), authData.getPass());
  }


  public void stop() {
    wd.quit();
  }

  public ContactHelperSB getContactHelperSB() {
    return contactHelperSB;
  }

  public GroupHelperSB getGroupHelperSB() {
    return groupHelperSB;
  }

  public NavigationHelperSB getNavigationHelperSB() {
    return navigationHelperSB;
  }
}
