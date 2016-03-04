package ru.jelenium.addressbook;

public class ContantData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final ContactTextInfo textInfo;
  private final ContactPhone phone;
  private final ContactEData ContactEData;

  public ContantData(String firstname, String middlename, String lastname, String nickname, String title, ContactTextInfo textInfo, ContactPhone phone, ContactEData ContactEData) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.textInfo = textInfo;
    this.phone = phone;
    this.ContactEData = ContactEData;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public ContactTextInfo getTextInfo() {
    return textInfo;
  }

  public ContactPhone getPhone() {
    return phone;
  }

  public ContactEData getContactEData() {
    return ContactEData;
  }
}
