package ru.jelenium.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mikhail.evseev on 04.03.2016.
 */
public class HomePageNavigationHelper extends HelperBase {

  public HomePageNavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  //Навигация по значкам напротив каждой группы
  //Номер элемента минус один - .//*[@id='maintable']/tbody/tr[2]/td[7]/a/img - первая строка, .//*[@id='maintable']/tbody/tr[3]/td[7]/a/img - вторая
  public void gotoDetails(Integer position) {
    String recordXpath;
    position++;
    recordXpath = (".//*[@id='maintable']/tbody/tr[" + position + "]/td[7]/a/img");
    click(By.xpath(recordXpath));
  }

  public void gotoEdit(Integer position) {
    String recordXpath;
    position++;
    recordXpath = (".//*[@id='maintable']/tbody/tr[" + position + "]/td[8]/a/img");
    click(By.xpath(recordXpath));
  }

  public void selectAll() {
    click(By.xpath(".//*[@id='MassCB']"));
  }

  public void selectFirst() {
    click(By.name("selected[]"));
  }

  public void pushDelete() {
    click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
  }

  public void closeAlarm() {
    wd.switchTo().alert().accept();
  }

}
