package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.Contacts;

import java.util.Arrays;
import java.util.stream.Collectors;

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
    ContactData homePageInfo = getContactData();
    app.contact().goToEdit(homePageInfo);
    ContactData editPageInfo = app.contact().getInfoFromEditPage(homePageInfo.getId());
    app.goTo().homePage();
    app.contact().details(homePageInfo);
    String[] detailsBlocks = app.contact().fromDetailsPage();
    assertThat(detailsBlocks[0], equalTo(editPageInfo.fisrtBlock()));
    assertThat(detailsBlocks[1].replaceAll("H: |M: |W: |F: ", ""), equalTo(editPageInfo.phoneBlock()));
    assertThat(detailsBlocks[2].replaceAll("\\(.*?\\)","").replaceAll(" \n", "\n").replaceAll("Homepage:", ""),
            equalTo(editPageInfo.emailsBlock()));
    assertThat(detailsBlocks[4], equalTo(editPageInfo.getTextInfo().getAddress2()));
    assertThat(detailsBlocks[5].replaceAll("P: ", ""), equalTo(editPageInfo.getPhone().getHome2()));
    assertThat(detailsBlocks[6], equalTo(editPageInfo.getTextInfo().getNotes()));

  }

}
