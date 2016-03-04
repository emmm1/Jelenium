package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.jelenium.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class AppMangerSIDE {
  FirefoxDriver driver;
  private ContactHelperSIDE contactHelperSIDE;
  public String baseUrl;
  public boolean acceptNextAlert = true;
  public StringBuffer verificationErrors = new StringBuffer();

  public void init() {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/addressbook/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    contactHelperSIDE = new ContactHelperSIDE(driver);
    login("admin", "secret");
  }

  public void login(String user, String passwd) {
    driver.get(baseUrl);
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(user);
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(passwd);
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
  }

  public void gotoAddNewPage() {
    driver.findElement(By.linkText("add new")).click();
  }

  public void stop() {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public void fillOutGroupForm(GroupData groupData) {
    driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys(groupData.getFooter());
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    driver.findElement(By.name("submit")).click();
  }

  public void initGroupCreation() {
    driver.findElement(By.name("new")).click();
  }

  public void gotoGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

  public ContactHelperSIDE getContactHelperSIDE() {
    return contactHelperSIDE;
  }
}
