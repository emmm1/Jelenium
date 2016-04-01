package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.jelenium.addressbook.model.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public Contacts contactsCashe = null;

  public void fillOutForm(ContactData cDate) {
    type(By.name("firstname"), cDate.getFirstname());
    type(By.name("middlename"), cDate.getMiddlename());
    type(By.name("lastname"), cDate.getLastname());
    type(By.name("nickname"), cDate.getNickname());
    type(By.name("title"), cDate.getTitle());
    type(By.name("company"), cDate.getTextInfo().getCompany());
    type(By.name("address"), cDate.getAddress1());
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
    choose(By.xpath(String.format("//div[@id='content']/form/select[5]//option[%s]", groupNum)));
  }

  public void deleteRecord() {
    click(By.xpath(".//*[@id='content']/form[2]/input[2]"));
    contactsCashe = null;
  }

  public void create(ContactData cDate) {
    gotoAddNewPage();
    fillOutForm(cDate);
    if (cDate.getGroupNum() != null) {
      chooseGroup(cDate.getGroupNum());
    }
    pushEnterAddNewPage();
    contactsCashe = null;
  }

  public void updateTo(ContactData cDate) {
    fillOutForm(cDate);
    pushUpdateEditPage();
    contactsCashe = null;
  }


  public void pushEnterAddNewPage() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public boolean createWhenNoContact(int qty, ContactData cDate) {
    if (qty == 0) {
      create(cDate);
      return true;
    }
    return false;
  }

  private boolean isThereAContact() {
    return isElementHere(By.name("selected[]"));
  }

  public void closeAlarm() {
    wd.switchTo().alert().accept();
    contactsCashe = null;
  }

  public void pushUpdateEditPage() {
    click(By.xpath(".//*[@id='content']/form[1]/input[22]"));
  }

  public Contacts getAll() {
    //Set<ContactData> contacts = new HashSet<>();
    if (contactsCashe == null) {
      List<WebElement> rows = wd.findElements(By.name("entry"));
      contactsCashe = (rows.stream()
              .map(r -> new ContactData()
                      .withId(Integer.parseInt(r.findElements(By.tagName("td")).get(0).findElement(By.tagName("input")).getAttribute("id")))
                      .withFirstname(r.findElements(By.tagName("td")).get(2).getText())
                      .withLastname(r.findElements(By.tagName("td")).get(1).getText())
                      .withAddress1(r.findElements(By.tagName("td")).get(3).getText())
                      .withEmails(r.findElements(By.tagName("td")).get(4).getText())
                      .withPhones(r.findElements(By.tagName("td")).get(5).getText())
              )
              .collect(Collectors.toCollection(Contacts::new)));
      return contactsCashe;
    }
    return new Contacts(contactsCashe);
  }

  public ContactData findDifference(Set<ContactData> small, Set<ContactData> full) {
    return full.stream().filter(f -> !small.contains(f)).findFirst().get();
  }

//  public Comparator<? super ContactData> ById = (c1, c2) -> (Integer.compare(c1.getId(), c2.getId()));


  public void gotoAddNewPage() {
    if (isElementHere(By.cssSelector("div#content h1")) && wd.findElement(By.cssSelector("div#content h1")).getText().equals("Edit / add address book entry")
            && wd.findElement(By.cssSelector("#content>form>input")).getAttribute("Value").equals("Enter")) {
      // && isElementHere(By.name("Submit"))
      return;
    }
    click(By.linkText("add new"));
  }

  public int getQty() {
  return wd.findElements(By.name("entry")).size();
  }

  public void modify() {
    click(By.name("modifiy"));
  }

  public void edit(ContactData contact) {
    wd.findElement(By.cssSelector(String.format("a[href=\"edit.php?id=%s\"]", contact.getId()))).click();
  }

  public void details(ContactData contact) {
    wd.findElement(By.cssSelector(String.format("a[href=\"view.php?id=%s\"]", contact.getId()))).click();
  }

  public ContactData fromEditPage(int id) {
    return new ContactData()
            .withId(id)
            .withFirstname(wd.findElement(By.name("firstname")).getAttribute("value"))
            .withLastname(wd.findElement(By.name("lastname")).getAttribute("value"))
            .withAddress1(wd.findElement(By.name("address")).getAttribute("value"))
            .and(new ContactEData()
                    .email1(wd.findElement(By.name("email")).getAttribute("value"))
                    .email2(wd.findElement(By.name("email2")).getAttribute("value"))
                    .email3(wd.findElement(By.name("email3")).getAttribute("value")))
            .withNumbersOf(new ContactPhone()
                    .phoneHome1(wd.findElement(By.name("home")).getAttribute("value"))
                    .mobilePhone(wd.findElement(By.name("mobile")).getAttribute("value"))
                    .workPhone(wd.findElement(By.name("work")).getAttribute("value"))
                    .phoneHome2(wd.findElement(By.name("phone2")).getAttribute("value")));
  }


  public ContactData fromDetailsPage(int id) {
    return new ContactData()
            .withId(id)
            //надо видимо склеивать строки ласт и ферстнэйм в одну и так проверять. Еще одно поле?
            //content <b>first last</b>
            .withFirstname(wd.findElement(By.name("firstname")).getAttribute("value"))
            .withLastname(wd.findElement(By.name("lastname")).getAttribute("value"))
            //content после первого блока <br></br>
            .withAddress1(wd.findElement(By.name("address")).getAttribute("value"))
            .and(new ContactEData()
                    // седьмой с a href
                    .email1(wd.findElement(By.name("email")).getAttribute("value"))
                    // восьмой с a href
                    .email2(wd.findElement(By.name("email2")).getAttribute("value"))
                    // девятый с a href
                    .email3(wd.findElement(By.name("email3")).getAttribute("value")))
            .withNumbersOf(new ContactPhone()
                    // после третьего блока <br></br>
                    .phoneHome1(wd.findElement(By.name("home")).getAttribute("value"))
                    // после четвертого блока <br></br>
                    .mobilePhone(wd.findElement(By.name("mobile")).getAttribute("value"))
                    // после пятого
                    .workPhone(wd.findElement(By.name("work")).getAttribute("value"))
                    //после 13го
                    .phoneHome2(wd.findElement(By.name("phone2")).getAttribute("value")));
  }
}
