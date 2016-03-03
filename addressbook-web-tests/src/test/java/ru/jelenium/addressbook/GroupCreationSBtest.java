package ru.jelenium.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
//import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
//import java.util.Date;
//import java.io.File;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
//import static org.openqa.selenium.OutputType.*;

public class GroupCreationSBtest {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    AddressBookAssistantSD.login(wd);
  }


  @Test
  public void testGroupCreationSB() {
    gotoGroupPage();
    initNewGroup();
    fillOutFields(new GroupData("Test group for Selenium Builder", "SB header", "SB footer"));
    gotoGroupPageThrAnswerLink();
  }

  private void gotoGroupPageThrAnswerLink() {
    wd.findElement(By.linkText("group page")).click();
  }

  private void fillOutFields(GroupData groupData) {
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

  private void initNewGroup() {
    wd.findElement(By.name("new")).click();
  }

  private void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
}
