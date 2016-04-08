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
    attach(By.name("photo"), cDate.getPhoto());
    System.out.println(cDate.getPhoto().getAbsolutePath());
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

  public void gotoAddNewPage() {
    if (isElementHere(By.cssSelector("div#content h1"))
            && wd.findElement(By.cssSelector("div#content h1")).getText().equals("Edit / add address book entry")
            && wd.findElement(By.cssSelector("#content>form>input")).getAttribute("Value").equals("Enter") && isElementHere(By.name("Submit"))
            ) {
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

  public void goToEdit(ContactData contact) {
    wd.findElement(By.cssSelector(String.format("a[href=\"edit.php?id=%s\"]", contact.getId()))).click();
  }

  public void details(ContactData contact) {
    wd.findElement(By.cssSelector(String.format("a[href=\"view.php?id=%s\"]", contact.getId()))).click();
  }

  public ContactData getInfoFromEditPage(ContactData cont) {
    return new ContactData()
            .withId(cont.getId())
            .withFirstname(wd.findElement(By.name("firstname")).getAttribute("value"))
            .withMiddlename(wd.findElement(By.name("middlename")).getAttribute("value"))
            .withLastname(wd.findElement(By.name("lastname")).getAttribute("value"))
            .withNickname(wd.findElement(By.name("nickname")).getAttribute("value"))
            .where(new ContactTextInfo()
                    .company(wd.findElement(By.name("company")).getAttribute("value"))
                    .address2(wd.findElement(By.name("address2")).getAttribute("value"))
                    .notes(wd.findElement(By.name("notes")).getAttribute("value"))
            )
            .withTitle(wd.findElement(By.name("title")).getAttribute("value"))
            .withAddress1(wd.findElement(By.name("address")).getAttribute("value"))
            .and(new ContactEData()
                    .email1(wd.findElement(By.name("email")).getAttribute("value"))
                    .email2(wd.findElement(By.name("email2")).getAttribute("value"))
                    .email3(wd.findElement(By.name("email3")).getAttribute("value"))
                    .homepage(wd.findElement(By.name("homepage")).getAttribute("value"))
            )
            .withNumbersOf(new ContactPhone()
                    .phoneHome1(wd.findElement(By.name("home")).getAttribute("value"))
                    .mobilePhone(wd.findElement(By.name("mobile")).getAttribute("value"))
                    .workPhone(wd.findElement(By.name("work")).getAttribute("value"))
                    .fax(wd.findElement(By.name("fax")).getAttribute("value"))
                    .phoneHome2(wd.findElement(By.name("phone2")).getAttribute("value"))
            )
            .withBirth(new DatesData()
                            .day(Integer.parseInt(wd.findElement(By.name("bday"))
                                    .findElement(By.cssSelector("option[selected=\"selected\"]"))
                                    .getAttribute("value")))
// на досуге надо дописать функцию преобразования имен в номера месяца.month(Integer.parseInt(wd.findElement(By.name("bmonth")).findElement(By.cssSelector("option[selected=]\"selected\"")).getText()))
                            .year(wd.findElement(By.name("byear")).getAttribute("value"))
            )
            .withAnniversary(new DatesData()
                    .day(Integer.parseInt(wd.findElement(By.name("aday"))
                            .findElement(By.cssSelector("option[selected=\"selected\"]"))
                            .getAttribute("value")))
                    .year(wd.findElement(By.name("ayear")).getAttribute("value"))
            );
  }


  public String[] fromDetailsPage() {
    return wd.findElement(By.id("content")).getText().split("\n\n");
  }
}
