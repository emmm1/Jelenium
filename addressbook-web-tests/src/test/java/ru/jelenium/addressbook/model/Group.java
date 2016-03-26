package ru.jelenium.addressbook.model;


public class Group {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String header;
  private String footer;

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  public int getId() {
    return id;
  }

  public Group withId(int id) {
    this.id = id;
    return this;
  }

  public Group withName(String name) {
    this.name = name;
    return this;
  }

  public Group withHeader(String header) {
    this.header = header;
    return this;
  }

  public Group withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Group group = (Group) o;

    if (id != group.id) return false;
    return name != null ? name.equals(group.name) : group.name == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
  @Override
  public String toString() {
    return "Group{" +
            "name='" + name + '\'' +
            ", id=" + id +
            '}';
  }

}
