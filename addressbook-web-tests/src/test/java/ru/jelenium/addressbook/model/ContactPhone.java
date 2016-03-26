package ru.jelenium.addressbook.model;

public class ContactPhone {
  private String home1;
  private String mobile;
  private String work;
  private String fax;
  private String home2;

/*  public ContactPhone(String phoneHome1, String mobilePhone, String workPhone, String fax, String phoneHome2) {
    this.phoneHome1 = phoneHome1;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.fax = fax;
    this.phoneHome2 = phoneHome2;
  }
*/

  public ContactPhone phoneHome2(String home2) {
    this.home2 = home2;
    return this;
  }

  public ContactPhone workPhone(String work) {
    this.work = work;
    return this;
  }

  public ContactPhone mobilePhone(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactPhone phoneHome1(String home1) {
    this.home1 = home1;
    return this;
  }

  public ContactPhone fax(String fax) {
    this.fax = fax;
    return this;
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

