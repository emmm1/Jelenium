package ru.jelenium.addressbook;

public class ContactPhone {
  private final String home1;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String home2;

  public ContactPhone(String home1, String mobile, String work, String fax, String home2) {
    this.home1 = home1;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.home2 = home2;
  }

  public String getHome1() {
    return home1;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getHome2() {
    return home2;
  }
}
