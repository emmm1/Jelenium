package ru.jelenium.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.jelenium.addressbook.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Idea on 10.04.2016.
 */
public class ContactDataGenerator {
  @Parameter(names = "-qty", description = "quantity of contacts")
  private int qty;
  @Parameter(names = "-file", description = "path to file")
  private String file;
  @Parameter(names = "-type", description = "format csv, json")
  private String type = "csv";

  public static void main(String[] args) throws IOException {
    init(args);
  }

  protected static void init(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }

    if (args.length == 0) {
      jCommander.usage();
      return;
    }
    generator.run(generator);
  }

  public void run(ContactDataGenerator generator) throws IOException {
    if (type.toLowerCase().equals("csv")) {
      saveCSV(generate(qty), new File(file));
    } else if (type.toLowerCase().equals("json")) {
      saveJSON(generate(qty), new File(file));
    } else {
      System.out.println("Incorrect file format");
    }
  }


  private List<ContactData> generate(int qty) {
    String unicDate = new Date(System.currentTimeMillis()).toString();
    List<ContactData> contacts = new ArrayList<>();
    for (; qty > 0; qty = qty - 1) {
      contacts.add(new ContactData()
              .withFirstname("Тест" + qty)
              .withMiddlename("Тестович")
              .withLastname("Тестовый" + " " + qty + " " + unicDate)
              .withTitle("Дорогой")
              .withNickname("ттт")
              .withGroupNum(1)
              .withAddress1("РФ, Тестовая область, г. Тестовск, тестовый тупик, д. 26, кв 13")
              .withImage(new File("src/test/resources/macronomica.png"))
              .where(new ContactTextInfo()
                      .address2("Тестовый район, с. Тестовое, 1я тестовая улица, д. 23")
                      .company("Тест продакшн")
                      .notes(String.format("Помрешь, пока заполнишь, %s, %s", qty, unicDate)))
              .withNumbersOf(new ContactPhone()
                      .phoneHome1("465464611263112")
                      .phoneHome2("+1245 54 545 68595489")
                      .mobilePhone("+132(464) 54651 1564651 31")
                      .workPhone("3546131564631")
                      .fax("2345464"))
              .and(new ContactEData()
                      .email1(null)
                      .email2("test.testowy@gmail.com")
                      .email3("testy_1987@mail.ru")
                      .homepage("http://localhost/addressbook"))
              .withBirth(new DatesData()
                      .day(12)
                      .month(5)
                      .year("1987"))
              .withAnniversary(new DatesData()
                      .day(25)
                      .month(11)
                      .year("2011")));
    }
    return contacts;
  }

  private void saveJSON(List<ContactData> generate, File file) throws IOException {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.setPrettyPrinting().create();
    try (Writer writer = new FileWriter(file + ".json")) {
      writer.write(gson.toJson(generate));
    }
  }

  private void saveCSV(List<ContactData> generate, File file) throws IOException {
//    System.out.println(file.getAbsolutePath());
    try (Writer writer = new FileWriter(file + ".csv")) {
      for (ContactData cDate : generate) {
        writer.write(cDate.getFirstname() + ";" +
                cDate.getMiddlename() + ";" +
                cDate.getLastname() + ";" +
                cDate.getNickname() + ";" +
                cDate.getTitle() + ";" +
                cDate.getPhoto() + ";" +
                cDate.getTextInfo().getCompany() + ";" +
                cDate.getAddress1() + ";" +
                cDate.getPhone().getHome1() + ";" +
                cDate.getPhone().getMobile() + ";" +
                cDate.getPhone().getWork() + ";" +
                cDate.getPhone().getFax() + ";" +
                cDate.getContactEData().getEmail1() + ";" +
                cDate.getContactEData().getEmail2() + ";" +
                cDate.getContactEData().getEmail3() + ";" +
                cDate.getContactEData().getHomepage() + ";" +
                cDate.getBirthDate().getDay() + ";" +
                cDate.getBirthDate().getMonth() + ";" +
                cDate.getBirthDate().getYear() + ";" +
                cDate.getAnnDate().getDay() + ";" +
                cDate.getAnnDate().getMonth() + ";" +
                cDate.getAnnDate().getYear() + ";" +
                cDate.getTextInfo().getAddress2() + ";" +
                cDate.getPhone().getHome2() + ";" +
                cDate.getTextInfo().getNotes() + ";\n");
      }
    }
  }


}