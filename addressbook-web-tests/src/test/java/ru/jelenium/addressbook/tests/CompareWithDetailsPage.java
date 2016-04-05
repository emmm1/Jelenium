package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.Contacts;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompareWithDetailsPage extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.contact().createWhenNoContact(app.contact().getQty(), new ContactData()
            .withFirstname("ForHomePageDeleteТест").withLastname("2HPRDel" + unicDate));
  }

  @Test
  public void contactCheckDetailsPage() {
    app.goTo().homePage();
    Contacts homePage = app.contact().getAll();
//ЗАмаял неитерирующий итератор надо потом вернуть
//    ContactData contact = homePage.iterator().next();
    ContactData contact = homePage.stream().filter(c -> c.getId() == 116).findFirst().get();
    app.contact().goToEdit(contact);
    ContactData editPageInfo = app.contact().getInfoFromEditPage(contact);
    app.goTo().homePage();
    app.contact().details(contact);
    String[] detailsBlocks = app.contact().fromDetailsPage();
    int shift = 0;
    String tmp1 = editPageInfo.fisrtBlock();
    System.out.println(detailsBlocks.length);
    if (!tmp1.equals("")) {
      System.out.println(tmp1);
      System.out.println(detailsBlocks[0]);
      assertThat(detailsBlocks[0], equalTo(editPageInfo.fisrtBlock()));
    } else shift = shift+1;

    String tmp2 = editPageInfo.phoneBlock();
    if (!tmp2.equals("")) {
      System.out.println(tmp2);
      System.out.println(detailsBlocks[1 - shift]);
      assertThat(detailsBlocks[1 - shift].replaceAll("H: |M: |W: |F: ", ""), equalTo(editPageInfo.phoneBlock()));
    } else shift = shift + 1;

    String tmp3 = editPageInfo.emailsBlock();
    System.out.println(tmp3);
    System.out.println(detailsBlocks[2 - shift]);
    if (!tmp3.equals("")) {
      System.out.println(tmp3);
      System.out.println(detailsBlocks[2 - shift]);
      assertThat(detailsBlocks[2 - shift].replaceAll("\\s\\(.*?\\)", "").replaceAll(" \n", "\n").replaceAll("Homepage:", ""),
              equalTo(editPageInfo.emailsBlock()));
    }
//    оставил на будущее
//    assertThat(detailsBlocks[4], equalTo(editPageInfo.getTextInfo().getAddress2()));
//    assertThat(detailsBlocks[5].replaceAll("P: ", ""), equalTo(editPageInfo.getPhone().getHome2()));
//    assertThat(detailsBlocks[6], equalTo(editPageInfo.getTextInfo().getNotes()));

  }

}
