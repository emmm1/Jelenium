package ru.jelenium.addressbook.model;

public class ContactFIODate {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;

  public ContactFIODate(String firstname, String middlename, String lastname, String nickname, String title) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
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
}
