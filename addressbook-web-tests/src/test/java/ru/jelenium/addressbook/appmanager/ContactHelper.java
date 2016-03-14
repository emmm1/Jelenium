package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.jelenium.addressbook.model.*;

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
    chooseBirthday(cDate.getBirthDate().getDay(), cDate.getBirthDate().getMonth(), cDate.getBirthDate().getYear());
    chooseAnniversary(cDate.getAnnDate().getDay(), cDate.getAnnDate().getMonth(), cDate.getAnnDate().getYear());
    if (!isUpdate) {
      if (cDate.getGroupNum() != null) {
        chooseGroup(cDate.getGroupNum());
      }
    }
    type(By.name("address2"), cDate.getTextInfo().getAddress2());
    type(By.name("phone2"), cDate.getPhone().getHome2());
    type(By.name("notes"), cDate.getTextInfo().getNotes());
  }

  //как выучим работу с условиями - вынесу в общий метод и добавлю в параметры тип даты
  public void chooseBirthday(Integer day, Integer month, String year) {
    //оставить как было - первая позиция
    day = day + 2;
    month = month + 2;
    choose(By.xpath("//div[@id='content']/form/select[1]//option[" + day + "]"));
    choose(By.xpath("//div[@id='content']/form/select[2]//option[" + month + "]"));
    type(By.name("byear"), year);
  }

  public void chooseAnniversary(Integer day, Integer month, String year) {
    //оставить как было - первая позиция
    day = day + 2;
    month = month + 2;
    choose(By.xpath("//div[@id='content']/form/select[3]//option[" + day + "]"));
    choose(By.xpath("//div[@id='content']/form/select[4]//option[" + month + "]"));
    type(By.name("ayear"), year);
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

  public void createWhenNoContact(ContactData cDate, boolean isUpdate) {
    if (!isThereAContact()) {
      createRecord(cDate, isUpdate);
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

}
