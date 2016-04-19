package ru.jelenium.addressbook.appmanager;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import ru.jelenium.addressbook.model.AuthData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
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
  private Properties properties;


  public AppManger(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public static boolean isAlertPresent(WebDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() throws IOException {
    String target = System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    browser = properties.getProperty("browser");

    if (browser.equals("Firefox")) {
      wd = new FirefoxDriver();
    } else if (browser.equals("Chrome")) {
      wd = new ChromeDriver();
    } else if (browser.equals("IE")) {
      wd = new InternetExplorerDriver();
    } else if (browser.equals("HU")) {
      wd = new HtmlUnitDriver();
    } else if (browser.equals("Phantom")) {
      wd = new PhantomJSDriver();
    } else if (browser.equals("JB")) {
      wd = new JBrowserDriver();
    } else if (browser.equals("EDGE")) {
      wd = new EdgeDriver();
    } else {
      wd = new ChromeDriver();
    }

    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.BaseUrl"));
    navigationHelper = new NavigationHelper(wd);
    contactHelper = new ContactHelper(wd);
    groupHelper = new GroupHelper(wd);
    sessionHelper = new SessionHelper(wd);
    homeNav = new HomePageNavigationHelper(wd);
    authData = new AuthData(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPass"));
    sessionHelper.login(authData.getLogin(), authData.getPass());
  }


  public void stop() {
    wd.quit();
  }

  public HomePageNavigationHelper onHomepage() {
    return homeNav;
  }

  public ContactHelper contact() {
    return contactHelper;
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

}
