package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.jelenium.addressbook.model.ContactData;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class ContactHelperSIDE {
  //private WebDriver driver;
  private FirefoxDriver driver;

  public ContactHelperSIDE(FirefoxDriver driver) {
    this.driver = driver;
  }

  public void fillOutForm(ContactData contactData) {
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    driver.findElement(By.name("nickname")).clear();
    driver.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
    driver.findElement(By.name("title")).clear();
    driver.findElement(By.name("title")).sendKeys(contactData.getTitle());
    driver.findElement(By.name("company")).clear();
    driver.findElement(By.name("company")).sendKeys(contactData.getTextInfo().getCompany());
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(contactData.getTextInfo().getAddress1());
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(contactData.getPhone().getHome1());
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(contactData.getPhone().getMobile());
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(contactData.getPhone().getWork());
    driver.findElement(By.name("fax")).clear();
    driver.findElement(By.name("fax")).sendKeys(contactData.getPhone().getFax());
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(contactData.getContactEData().getEmail1());
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys(contactData.getContactEData().getEmail2());
    driver.findElement(By.name("email3")).clear();
    driver.findElement(By.name("email3")).sendKeys(contactData.getContactEData().getEmail3());
    driver.findElement(By.name("homepage")).clear();
    driver.findElement(By.name("homepage")).sendKeys(contactData.getContactEData().getHomepage());
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("13");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("October");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("1984");
    new Select(driver.findElement(By.name("aday"))).selectByVisibleText("27");
    new Select(driver.findElement(By.name("amonth"))).selectByVisibleText("October");
    driver.findElement(By.name("ayear")).clear();
    driver.findElement(By.name("ayear")).sendKeys("2001");
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("Test group for Selenium Builder");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(contactData.getTextInfo().getAddress2());
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys(contactData.getPhone().getHome2());
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys(contactData.getTextInfo().getNotes());
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }
}
