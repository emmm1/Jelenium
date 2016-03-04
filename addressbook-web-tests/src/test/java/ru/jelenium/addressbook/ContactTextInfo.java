package ru.jelenium.addressbook;

public class ContactTextInfo {
  private final String company;
  private final String address1;
  private final String address2;
  private final String notes;

  public ContactTextInfo(String company, String address1, String address2, String notes) {
    this.company = company;
    this.address1 = address1;
    this.address2 = address2;
    this.notes = notes;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress1() {
    return address1;
  }

  public String getAddress2() {
    return address2;
  }

  public String getNotes() {
    return notes;
  }
}
