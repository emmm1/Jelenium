package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Idea on 08.03.2016.
 */
public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected boolean isSelected(By locator) {
    return wd.findElement(locator).isSelected();
  }


  protected void choose(By locator) {
    if (!isSelected(locator)) {
      click((locator));
    }
  }


  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      if (!wd.findElement(locator).getAttribute("value").equals(text)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected boolean isElementHere(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void gotoHomePage() {
    if (isElementHere(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
}
