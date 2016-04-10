package ru.jelenium.addressbook.generators;

import com.beust.jcommander.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.jelenium.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mikhail.evseev on 05.04.2016.
 */
public class GroupDataGenerator extends GeneratorBase {
  @Parameter(names = "-qty", description = "quantity of groups")
  private int qty;
  @Parameter(names = "-file", description = "path to file")
  private String file;
  @Parameter(names = "-type", description = "format csv, json")
  private String type = "csv";


//  -qty 10 -file src\test\resources\groups.csv

  public static void main(String[] args) throws IOException {
    init(args);
  }

  public void run() throws IOException {
    if (type.toLowerCase().equals("csv")) {
      saveCSV(generate(qty), new File(file));
    } else if (type.toLowerCase().equals("json")) {
      saveJSON(generate(qty), new File(file));
    } else {
      System.out.println("Incorrect file format");
    }
  }


  private void saveJSON(List<GroupData> generate, File file) throws IOException {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    Writer writer = new FileWriter(file);
    writer.write(gson.toJson(generate));
    writer.close();
  }

  private void saveCSV(List<GroupData> generate, File groupFile) throws IOException {
//    System.out.println(groupFile.getAbsolutePath());
    Writer writer = new FileWriter(groupFile);
    for (GroupData tmp : generate) {
      writer.write(String.format("%s;%s;%s\n", tmp.getName(), tmp.getHeader(), tmp.getFooter()));
    }
    writer.close();
  }



  private List<GroupData> generate(int qty) {
    List<GroupData> grp = new ArrayList<>();
    for (; qty > 0; qty = qty - 1) {
      String uniq = new Date(System.currentTimeMillis()).toString();
      grp.add(new GroupData().withName("group" + qty).withHeader("header" + qty).withFooter("footer" + uniq));
    }
    return grp;
  }
}
