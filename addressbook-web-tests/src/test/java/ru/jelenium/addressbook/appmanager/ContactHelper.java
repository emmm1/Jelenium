package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.jelenium.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillOutForm(ContactData cDate, boolean isUpdate) {
    type(By.name("firstname"), cDate.getFirstname());
    type(By.name("middlename"), cDate.getMiddlename());
    type(By.name("lastname"), cDate.getLastname());
    type(By.name("nickname"), cDate.getNickname());
    type(By.name("title"), cDate.getTitle());
    type(By.name("company"), cDate.getTextInfo().getCompany());
    type(By.name("address"), cDate.getTextInfo().getAddress1());
    type(By.name("home"), cDate.getPhone().getHome1());
    type(By.name("mobile"), cDate.getPhone().getMobile());
    type(By.name("work"), cDate.getPhone().getWork());
    type(By.name("fax"), cDate.getPhone().getFax());
    type(By.name("email"), cDate.getContactEData().getEmail1());
    type(By.name("email2"), cDate.getContactEData().getEmail2());
    type(By.name("email3"), cDate.getContactEData().getEmail3());
    type(By.name("homepage"), cDate.getContactEData().getHomepage());
    chooseDate(cDate.getBirthDate().getDay(), cDate.getBirthDate().getMonth(), cDate.getBirthDate().getYear(), true);
    chooseDate(cDate.getAnnDate().getDay(), cDate.getAnnDate().getMonth(), cDate.getAnnDate().getYear(), false);
    if (!isUpdate) {
      if (cDate.getGroupNum() != null) {
        chooseGroup(cDate.getGroupNum());
      }
    }
    type(By.name("address2"), cDate.getTextInfo().getAddress2());
    type(By.name("phone2"), cDate.getPhone().getHome2());
    type(By.name("notes"), cDate.getTextInfo().getNotes());
  }


  public void chooseDate(Integer day, Integer month, String year, Boolean isBirthday) {
    //оставить как было - первая позиция
    Integer sel;
    String yearLocator;
    if (isBirthday) {
      sel = 1;
      yearLocator = "byear";
    } else {
      sel = 3;
      yearLocator = "ayear";
    }

    if (day != null) {
      day = day + 2;
      choose(By.xpath("//div[@id='content']/form/select[" + sel + "]//option[" + day + "]"));
    }

    if (month != null) {
      month = month + 2;
      choose(By.xpath("//div[@id='content']/form/select[" + (sel + 1) + "]//option[" + month + "]"));
    }

    type(By.name(yearLocator), year);
  }


  public void chooseGroup(Integer groupNum) {
    //xpath .//*[@id='content']/form/select[5]/option[3] - последний элемент - номер группы в выпадающем списке
    choose(By.xpath("//div[@id='content']/form/select[5]//option[" + groupNum + "]"));
  }

  public void deleteRecord() {
    click(By.xpath(".//*[@id='content']/form[2]/input[2]"));
  }

  public void createRecord(ContactData cDate, boolean isUpdate) {
    gotoAddNewPage();
    fillOutForm(cDate, isUpdate);
    pushEnterAddNewPage();
  }

  public void gotoAddNewPage() {
    if (isElementHere(By.cssSelector("div#content h1")) && wd.findElement(By.cssSelector("div#content h1")).getText().equals("Edit / add address book entry")
            && wd.findElement(By.cssSelector("#content>form>input")).getAttribute("Value").equals("Enter")) {
      // && isElementHere(By.name("Submit"))
      return;
    }
    click(By.linkText("add new"));
  }

  public void pushEnterAddNewPage() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void createWhenNoContact(ContactData cDate) {
    if (!isThereAContact()) {
      createRecord(cDate, false);
      gotoHomePage();
    }
  }

  private boolean isThereAContact() {
    return isElementHere(By.name("selected[]"));
  }


  public void pushUpdateEditPage() {
    click(By.xpath(".//*[@id='content']/form[1]/input[22]"));
  }

  public void gotoRecordEditorThrViewRecordPage() {
    click(By.name("modifiy"));
  }

  public List<ContactData> getContacts() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      contacts.add(new ContactData(row.findElements(By.tagName("td")).get(2).getText(), row.findElements(By.tagName("td")).get(1).getText()));
    }
    return contacts;
  }
}
