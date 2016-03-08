package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Idea on 08.03.2016.
 */
public class SessionHelper {
    private FirefoxDriver wd;

    public SessionHelper(FirefoxDriver wd) {

        this.wd = wd;
    }
    public void login(String user, String passwd) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(user);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(passwd);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }
}

