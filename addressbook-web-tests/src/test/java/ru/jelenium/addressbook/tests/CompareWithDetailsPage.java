package ru.jelenium.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;
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
    app.goTo().homePage();
    Contacts homePage = app.contact().getAll();
    ContactData homePageInfo = homePage.iterator().next();
    app.contact().goToEdit(homePageInfo);
    ContactData editPageInfo = app.contact().getInfoFromEditPage(homePageInfo.getId());
    app.goTo().homePage();
    app.contact().details(homePageInfo);
    String detailsPage = app.contact().fromDetailsPage();
    String[] blocks = detailsPage.split("\n\n");
    String fullName = Arrays.asList(editPageInfo.getFirstname(), editPageInfo.getMiddlename(), editPageInfo.getLastname())
            .stream()
            .filter(s -> ! s.equals(""))
            .collect(Collectors.joining(" "));
    String firstBlock =
            Arrays.asList(fullName, editPageInfo.getNickname(), editPageInfo.getTitle(),
                    editPageInfo.getTextInfo().getCompany(), editPageInfo.getAddress1())
                    .stream()
                    .filter(s -> !s.equals(""))
                    .collect(Collectors.joining("\n"));

    String phonesBlock = Arrays.asList(editPageInfo.getPhone().getHome1(),
            editPageInfo.getPhone().getMobile(),
            editPageInfo.getPhone().getWork(),
            editPageInfo.getPhone().getFax())
            .stream()
            .filter(s -> !s.equals(""))
            .collect(Collectors.joining("\n"));

    assertThat(blocks[0], equalTo(firstBlock));

//    if (detailsPageInfo.getId() != Integer.MAX_VALUE) {
//      detailsPageInfo.makeAllEmails().makeAllPhones();
//      assertThat(homePageInfo.getAllEmails(), equalTo(detailsPageInfo.getAllEmails()));
//      assertThat(homePageInfo.getAllPhones(), equalTo(detailsPageInfo.getAllPhones()));
//      assertThat(detailsPageInfo, equalTo(homePageInfo));
//    }
  }

}
