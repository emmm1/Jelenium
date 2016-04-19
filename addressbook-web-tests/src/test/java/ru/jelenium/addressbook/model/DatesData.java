package ru.jelenium.addressbook.model;

/**
 * Created by mikhail.evseev on 09.03.2016.
 */
public class DatesData {
  private Integer day;
  private Integer month;
  private String year;

  public DatesData day(Integer day) {
    this.day = day;
    return this;
  }

  public DatesData month(Integer month) {
    this.month = month;
    return this;
  }

  public DatesData year(String year) {
    this.year = year;
    return this;
  }
  //выпадающие списки с датами рождения и годовщин


  public Integer getDay() {
    return day;
  }

  public Integer getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }

  @Override
  public String toString() {
    return "DatesData{" +
            "day=" + day +
            ", month=" + month +
            ", year='" + year + '\'' +
            '}';
  }
}
