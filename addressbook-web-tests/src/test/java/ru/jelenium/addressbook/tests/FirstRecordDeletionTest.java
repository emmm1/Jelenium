package ru.jelenium.addressbook.tests;


import org.testng.annotations.Test;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */



public class FirstRecordDeletionTest extends TestBase {

  @Test
  public void firstRecordDelete() {
    app.getNavigationHelper().gotoHomePage();
    //передаем номер записи
    app.getHomeNav().gotoDetails(1);
    app.getNavigationHelper().gotoRecordEditorThrViewRecordPage();
    app.getContactHelper().deleteRecord();
  }

}
