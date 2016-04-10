package ru.jelenium.addressbook.generators;

import com.beust.jcommander.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.jelenium.addressbook.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;

/**
 * Created by Idea on 10.04.2016.
 */
public class ContactDataGenerator extends GeneratorBase {
  @Parameter(names = "-qty", description = "quantity of contacts")
  private int qty;
  @Parameter(names = "-file", description = "path to file")
  private String file;
  @Parameter(names = "-type", description = "format csv, json")
  private String type = "csv";

  public static void main(String[] args) throws IOException {
    init(args);
  }

  private List<ContactData> generate (int qty) {
    String unicDate = new Date(System.currentTimeMillis()).toString();
    List<ContactData> contacts = null;
    for (; qty > 0; qty = qty - 1) {
      contacts.add(new ContactData()
              .withFirstname("Тест" + qty)
              .withMiddlename("Тестович")
              .withLastname("Тестовый" + unicDate)
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
    Gson gson = builder.excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    Writer writer = new FileWriter(file);
    writer.write(gson.toJson(generate));
    writer.close();
  }

  private void saveCSV(List<ContactData> generate, File groupFile) throws IOException {
//    System.out.println(groupFile.getAbsolutePath());
    Writer writer = new FileWriter(groupFile);
    for (ContactData tmp : generate) {
      writer.write(String.format("%s;%s;%s\n", tmp.getFirstname(), tmp.getMiddlename(), tmp.getLastname()));
    }
    writer.close();
  }


}