package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.jelenium.addressbook.model.ContactData;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class ContactHelperSB extends HelperBase{
//  private FirefoxDriver wd;

  public ContactHelperSB(FirefoxDriver wd) {
//    this.wd = wd;
  super(wd);
  }


  public void fillOutForm(ContactData cDate) {
    type(By.name("firstname") ,cDate.getFirstname());
    type(By.name("middlename") ,cDate.getMiddlename());
    type(By.name("lastname") ,cDate.getLastname());
    type(By.name("nickname") ,cDate.getNickname());
    type(By.name("title") ,cDate.getTitle());
    type(By.name("company") ,cDate.getTextInfo().getCompany());
    type(By.name("address") ,cDate.getTextInfo().getAddress1());
    type(By.name("home") ,cDate.getPhone().getHome1());
    type(By.name("mobile") ,cDate.getPhone().getMobile());
    type(By.name("work") ,cDate.getPhone().getWork());
    type(By.name("fax") ,cDate.getPhone().getFax());
    type(By.name("email") ,cDate.getContactEData().getEmail1());
    type(By.name("email2") ,cDate.getContactEData().getEmail2());
    type(By.name("email3") ,cDate.getContactEData().getEmail3());
    type(By.name("homepage") ,cDate.getContactEData().getHomepage());
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
        }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[15]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[15]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).click();
    }
    type(By.name("byear") ,"1987");
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[14]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[10]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[10]")).click();
    }
    type(By.name("ayear") ,"2001");
      if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
    }
    type(By.name("address2") ,cDate.getTextInfo().getAddress2());
    type(By.name("phone2"), cDate.getPhone().getHome2());
    type(By.name("notes"), cDate.getTextInfo().getNotes());
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }
}
