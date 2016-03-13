package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  //Сюда всю основную навигацию и со страниц где будет только один элемент для тестирования


  public void gotoGroupPage() {
    if (isElementHere(By.cssSelector("div#content h1")) && isElementHere(By.name("new")) && wd.findElement(By.cssSelector("div#content h1")).getText().equals("Groups")) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void gotoAddNewPage() {
    if (isElementHere(By.cssSelector("div#content h1")) && wd.findElement(By.cssSelector("div#content h1")).getText().equals("Edit / add address book entry")
        && wd.findElement(By.cssSelector("#content>form>input")).getAttribute("Value").equals("Enter")) {
      // && isElementHere(By.name("Submit"))
      return;
    }
    click(By.linkText("add new"));
  }

  public void gotoHomePage() {
    if (isElementHere(By.id("maintable"))) {
      return;
    }
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
