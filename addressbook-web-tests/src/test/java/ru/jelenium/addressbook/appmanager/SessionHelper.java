package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Idea on 08.03.2016.
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void login(String user, String passwd) {
    type(By.name("user"), user);
    type(By.name("pass"), passwd);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}

