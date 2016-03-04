package ru.jelenium.addressbook;

import org.testng.annotations.Test;

public class NewRecordSIDEtest extends SIDEBase {

  @Test
  public void testNewRecordSIDE() throws Exception {
    app.gotoAddNewPage();
    app.fillOutForm(
            new ContactData("dfsdafsdf", "dsfasdf", "asdfsdf", "dfdf", "dfasdf", new ContactTextInfo("fasd dsfdff", "fzsdfasxdfsf sdf zfzxdffd  dzfzxd",
                    "sdfsd,fkjlkjdsfjdfsl;jf ;ljsdf;lj sadl;fj l;kjla; fdsjlsa;dfj", "dsfsdafasdfk;l;<f;alks fd'k;lasdf;l,ksdaf;lk SIDE"),
                    new ContactPhone("6464165", "41616468721", "4654463416514", "41646161", "65468515451"),
                    new ContactEData("dfsdafsdf.asdffasdf@fasd-dsfdff", "dfsdfasdf@dsf.sdfsd", "sdfa@sdfs.adf", "htttp://ldjkflasdjfsdflj/asdlkfj")));
  }

}
