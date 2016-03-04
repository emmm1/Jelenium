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

public class NewRecordSBtest {
  FirefoxDriver wd;


  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    login();
  }

  private void login() {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
  public void NewRecordSBtest() {

    gotoAddNewPage();
    fillOutForm(new FullContactDate("Тест", "Тестович", "Тестовый", "ттт", "Дорогой", "Тест продакшн", "РФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13",
            "465464611263112", "+1245 54 545 68595489", "3546131564631", "+132(464) 54651 1564651 31", "test.testowy@testPro.com", "test.testowy@gmail.com",
            "testy_1987@mail.ru", "http://localhost/addressbook", "25" ,"October", "1987", "12", "July", "2001", "[none]",
            "РФ, Тестовая область, Тестовый район, с. Тестовое, 1я тестовая улица, д. 23",
            "2345464", "Помрешь, пока заполнишь"));
    gotoMainPage();
  }

  private void gotoMainPage() {
    wd.findElement(By.linkText("home")).click();
  }

  private void fillOutForm(FullContactDate cDate) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(cDate.getFirstname());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(cDate.getMiddlename());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(cDate.getLastname());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(cDate.getNick());
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(cDate.getTitle());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(cDate.getCompany());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(cDate.getAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(cDate.getHomephone());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(cDate.getMobile());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(cDate.getWorkphone());
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(cDate.getFax());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(cDate.getEmail());
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(cDate.getEmail2());
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(cDate.getEmail3());
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys(cDate.getHomepage());
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
        }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[15]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[15]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).click();
    }
/*    String tmp = cDate.getBday();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(tmp);
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(cDate.getBmonth()); */
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(cDate.getByear());
/*    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(cDate.getAday());
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(cDate.getAmonth());*/
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[10]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[10]")).click();
    }

    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys(cDate.getAyear());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
    }

    //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(cDate.getAddToGroup());

    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(cDate.getAddress2());
    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys(cDate.getHomephone2());
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(cDate.getNotes());
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void gotoAddNewPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
    

}
