package ru.jelenium.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final ContactTextInfo textInfo;
  private final ContactPhone phone;
  private final ContactEData contactEData;
  private final DataData birthDate;
  private final DataData annDate;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, ContactTextInfo textInfo, ContactPhone phone, ContactEData contactEData, DataData birthDate,
                     DataData annDate) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.textInfo = textInfo;
    this.phone = phone;
    this.contactEData = contactEData;
    this.birthDate = birthDate;
    this.annDate = annDate;
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
    return contactEData;
  }

  public DataData getBirthDate() {
    return birthDate;
  }

  public DataData getAnnDate() {
    return annDate;
  }
}
