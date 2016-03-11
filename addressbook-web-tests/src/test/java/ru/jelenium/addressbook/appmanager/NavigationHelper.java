package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  //Сюда всю основную навигацию и со страниц где будет только один элемент для тестирования
  public void gotoGroupPageThrAnswerLink() {
    click(By.linkText("group page"));
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoAddNewPage() {
    click(By.linkText("add new"));
  }

  public void gotoHomePage() {
    click(By.linkText("home"));
  }

  public void gotoRecordEditorThrViewRecordPage() {
    click(By.name("modifiy"));
  }

  public void pushEnterAddNewPage() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void pushUpdateEditPage() {
    click(By.xpath(".//*[@id='content']/form[1]/input[22]"));
  }

}
