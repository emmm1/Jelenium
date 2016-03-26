package ru.jelenium.addressbook.model;

public class ContactEData {
  private String email1;
  private String email2;
  private String email3;
  private String homepage;

  public ContactEData homepage(String homepage) {
    this.homepage = homepage;
    return this;
  }


/*  public ContactEData() {
    this.email1 = null;
    this.email2 = null;
    this.email3 = null;
    this.homepage = null;
  }

    public ContactEData(String email1, String email2, String email3, String homepage) {
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
  }
  */

  public ContactEData email1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactEData email2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactEData email3(String email3) {
    this.email3 = email3;
    return this;
  }


  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }
}
