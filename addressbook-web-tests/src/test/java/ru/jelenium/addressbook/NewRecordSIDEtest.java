package ru.jelenium.addressbook;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewRecordSIDEtest {
//  private WebDriver driver;
  private FirefoxDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/addressbook/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login();
  }

  private void login() {
    driver.get(baseUrl);
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
  }

  @Test
  public void testNewRecordSIDE() throws Exception {
    gotoAddNewPage();
    fillOutForm(
            new ContantData("dfsdafsdf", "dsfasdf", "asdfsdf", "dfdf", "dfasdf", new ContactTextInfo("fasd dsfdff", "fzsdfasxdfsf sdf zfzxdffd  dzfzxd",
                    "sdfsd,fkjlkjdsfjdfsl;jf ;ljsdf;lj sadl;fj l;kjla; fdsjlsa;dfj", "dsfsdafasdfk;l;<f;alks fd'k;lasdf;l,ksdaf;lk SIDE"),
                    new ContactPhone("6464165", "41616468721", "4654463416514", "41646161", "65468515451"),
                    new ContactEData("dfsdafsdf.asdffasdf@fasd-dsfdff", "dfsdfasdf@dsf.sdfsd", "sdfa@sdfs.adf", "htttp://ldjkflasdjfsdflj/asdlkfj")));
  }

  //new ContactFIODate("dfsdafsdf", "dsfasdf", "asdfsdf", "dfdf", "dfasdf"),
  private void fillOutForm(ContantData contantData) {
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(contantData.getFirstname());
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name("middlename")).sendKeys(contantData.getMiddlename());
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(contantData.getLastname());
    driver.findElement(By.name("nickname")).clear();
    driver.findElement(By.name("nickname")).sendKeys(contantData.getNickname());
    driver.findElement(By.name("title")).clear();
    driver.findElement(By.name("title")).sendKeys(contantData.getTitle());
    driver.findElement(By.name("company")).clear();
    driver.findElement(By.name("company")).sendKeys(contantData.getTextInfo().getCompany());
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(contantData.getTextInfo().getAddress1());
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(contantData.getPhone().getHome1());
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(contantData.getPhone().getMobile());
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(contantData.getPhone().getWork());
    driver.findElement(By.name("fax")).clear();
    driver.findElement(By.name("fax")).sendKeys(contantData.getPhone().getFax());
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(contantData.getContactEData().getEmail1());
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys(contantData.getContactEData().getEmail2());
    driver.findElement(By.name("email3")).clear();
    driver.findElement(By.name("email3")).sendKeys(contantData.getContactEData().getEmail3());
    driver.findElement(By.name("homepage")).clear();
    driver.findElement(By.name("homepage")).sendKeys(contantData.getContactEData().getHomepage());
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("13");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("October");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("1984");
    new Select(driver.findElement(By.name("aday"))).selectByVisibleText("27");
    new Select(driver.findElement(By.name("amonth"))).selectByVisibleText("October");
    driver.findElement(By.name("ayear")).clear();
    driver.findElement(By.name("ayear")).sendKeys("2001");
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("Test group for Selenium Builder");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(contantData.getTextInfo().getAddress2());
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys(contantData.getPhone().getHome2());
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys(contantData.getTextInfo().getNotes());
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void gotoAddNewPage() {
    driver.findElement(By.linkText("add new")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
