package ru.jelenium.addressbook.tests;

import org.testng.annotations.Test;
import ru.jelenium.addressbook.model.ContactData;
import ru.jelenium.addressbook.model.ContactEData;
import ru.jelenium.addressbook.model.ContactPhone;
import ru.jelenium.addressbook.model.ContactTextInfo;

public class NewRecordSIDEtest extends SIDEBase {

  @Test
  public void testNewRecordSIDE() throws Exception {
    app.gotoAddNewPage();
    app.getContactHelperSIDE().fillOutForm(
            new ContactData("dfsdafsdf", "dsfasdf", "asdfsdf", "dfdf", "dfasdf", new ContactTextInfo("fasd dsfdff", "fzsdfasxdfsf sdf zfzxdffd  dzfzxd",
                    "sdfsd,fkjlkjdsfjdfsl;jf ;ljsdf;lj sadl;fj l;kjla; fdsjlsa;dfj", "dsfsdafasdfk;l;<f;alks fd'k;lasdf;l,ksdaf;lk SIDE"),
                    new ContactPhone("6464165", "41616468721", "4654463416514", "41646161", "65468515451"),
                    new ContactEData("dfsdafsdf.asdffasdf@fasd-dsfdff", "dfsdfasdf@dsf.sdfsd", "sdfa@sdfs.adf", "htttp://ldjkflasdjfsdflj/asdlkfj")));
  }

}