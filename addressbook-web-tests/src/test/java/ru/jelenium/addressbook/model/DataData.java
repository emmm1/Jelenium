package ru.jelenium.addressbook.model;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */
public class DataData {
  private Integer day;
  private Integer month;
  private String year;


  //выпадающие списки с датами рождения и годовщин
  public DataData(Integer day, Integer month, String year) {

    this.day = day;
    this.month = month;
    this.year = year;
  }

  public Integer getDay() {
    return day;
  }

  public Integer getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }
}
