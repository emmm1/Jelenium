package ru.jelenium.addressbook.tests;


import org.testng.annotations.Test;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */



public class HomePageRecordDeletionTest extends TestBase {

  @Test
  public void homePageRecordDelete() {
    app.getNavigationHelper().gotoHomePage();
    //передаем номер записи
    app.getHomeNav().selectFirst();
    app.getHomeNav().pushDelete();
    app.getHomeNav().closeAlarm();

  }

}
