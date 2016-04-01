package ru.jelenium.addressbook.model;

public class ContactTextInfo {
  private String company;
  private String address2;
  private String notes;


  public ContactTextInfo notes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactTextInfo address2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactTextInfo company(String company) {
    this.company = company;
    return this;
  }


  public String getCompany() {
    return company;
  }

  public String getAddress2() {
    return address2;
  }

  public String getNotes() {
    return notes;
  }
}
