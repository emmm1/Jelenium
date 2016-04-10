package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.Contacts;

import java.util.List;

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
    ContactData contact = homePage.iterator().next();
//    ContactData contact = homePage.stream().filter(c -> c.getId() == 116).findFirst().get();
    app.contact().goToEdit(contact);
    ContactData editPageInfo = app.contact().getInfoFromEditPage(contact);
    app.goTo().homePage();
    app.contact().details(contact);
    String[] detailsBlocks = app.contact().fromDetailsPage();

    int shift = 0;
    String mainBlock = editPageInfo.fisrtBlock();

    if (!mainBlock.equals("")) {
      assertThat(detailsBlocks[0], equalTo(mainBlock));
    } else {
      shift = shift + 1;
    }

    String phones = editPageInfo.phoneBlock();
    if (!phones.equals("")) {
      assertThat(detailsBlocks[1 - shift].replaceAll("H: |M: |W: |F: ", ""), equalTo(phones));
    } else {
      shift = shift + 1;
    }

    String emials = editPageInfo.emailsBlock();
//    обнаружил, что иногда домен не создается - например для gmail.com, решил просто отрывать все, что в скобках
    if (!emials.equals("")) {
      assertThat(detailsBlocks[2 - shift].replaceAll("\\s\\(.*?\\)", "").replaceAll("Homepage:", "").replaceAll("\\n+", "\n"), equalTo(emials));
    }
  }
}
