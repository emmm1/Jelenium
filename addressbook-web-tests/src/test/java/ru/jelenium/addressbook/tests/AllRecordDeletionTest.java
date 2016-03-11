package ru.jelenium.addressbook.tests;


import org.testng.annotations.Test;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */



public class AllRecordDeletionTest extends TestBase {

  @Test
  public void allRecordDelete() {
    app.getNavigationHelper().gotoHomePage();
    //передаем номер записи
    app.getHomeNav().selectAll();
    app.getHomeNav().pushDelete();
    app.getHomeNav().closeAlarm();

  }

}
