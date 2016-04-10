package ru.jelenium.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.io.IOException;

/**
 * Created by Idea on 10.04.2016.
 */
public class GeneratorBase {
  protected static void init(String[] args) throws IOException {
    GroupDataGenerator generator = new GroupDataGenerator();
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
    generator.run();
  }
}
