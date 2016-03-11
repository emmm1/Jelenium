package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.jelenium.addressbook.model.AuthData;

import java.util.concurrent.TimeUnit;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class AppManger {
  WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private AuthData authData;
  private HomePageNavigationHelper homeNav;
  private String browser;


  public AppManger(String browser){
    this.browser = browser;
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    if (browser.equals("Firefox")){
      wd = new FirefoxDriver();
    } else if (browser.equals("Chrome")){
      wd = new ChromeDriver();
    } else if (browser.equals("IE")){
      wd = new InternetExplorerDriver();
    }


    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    navigationHelper = new NavigationHelper(wd);
    contactHelper = new ContactHelper(wd);
    groupHelper = new GroupHelper(wd);
    sessionHelper = new SessionHelper(wd);
    homeNav = new HomePageNavigationHelper(wd);
    authData = new AuthData("admin", "secret");
    sessionHelper.login(authData.getLogin(), authData.getPass());
  }


  public void stop() {
    wd.quit();
  }

  public HomePageNavigationHelper getHomeNav() {
    return homeNav;
  };

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
