package ru.jelenium.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mikhail.evseev on 03.03.2016.
 */
public class AddressBookAssistantSD {
  public static void login(FirefoxDriver wd) {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
}
