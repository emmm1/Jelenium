package ru.jelenium.addressbook.model;

/**
 * Created by Idea on 08.03.2016.
 */
public class AuthData {
  private final String login;
  private final String pass;

  public AuthData(String login, String pass) {
    this.login = login;
    this.pass = pass;
  }

  public String getLogin() {
    return login;
  }

  public String getPass() {
    return pass;
  }
}
