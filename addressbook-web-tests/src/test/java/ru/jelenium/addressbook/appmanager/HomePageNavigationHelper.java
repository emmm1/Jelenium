package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.jelenium.addressbook.model.ContactData;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class HomePageNavigationHelper extends HelperBase {

  public HomePageNavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void selectAll() {
    click(By.xpath(".//*[@id='MassCB']"));
  }

  public void pushDelete() {
    click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
  }


  public void chooseContact(ContactData deleted) {
    String locator = "input[id=\"" + deleted.getId() + "\"]";
    wd.findElement(By.cssSelector(locator)).click();
  }

/*  public void clickEdit(Integer position) {
    String recordXpath;
    //позиция начинается с 2, метод нормально работает, переписывать не хочется
    position += 2;
    recordXpath = (".//*[@id='maintable']/tbody/tr[" + position + "]/td[8]/a/img");
    click(By.xpath(recordXpath));
  }

  public void closeAlarm() {
    wd.switchTo().alert().accept();
    contactsCashe = null;
  }

  public void gotoDetails(Integer position) {
  position += 2;
  wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + position + "]/td[7]/a/img")).click();
}

*/
}
