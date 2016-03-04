package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class AppMangerSB {
  FirefoxDriver wd;
  private NavigationHelper navigationHelper;
  private GroupHelperSB groupHelperSB;
  private ContactHelperSB contactHelperSB;

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
    contactHelperSB = new ContactHelperSB(wd);
    groupHelperSB = new GroupHelperSB(wd);
    login("admin", "secret");
  }

  private void login(String user, String passwd) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(user);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(passwd);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void initNewGroup() {
    wd.findElement(By.name("new")).click();
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

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
