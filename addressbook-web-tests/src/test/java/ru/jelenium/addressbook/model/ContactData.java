package ru.jelenium.addressbook.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactData {

  private int id;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String address1;
  private String title;
  private String allEmails;
  private String allPhones;
  private String fullName;
  private Integer groupNum;
  private ContactPhone phone;
  private ContactEData contactEData;
  private DatesData birthDate;
  private DatesData annDate;
  private ContactTextInfo textInfo;

  public ContactData(int id, String firstname, String lastname) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phone = new ContactPhone();
    this.contactEData = new ContactEData();
    this.textInfo = new ContactTextInfo();
    this.birthDate = new DatesData();
    this.annDate = new DatesData();
  }

  public ContactData() {
    this.id = 0;
    this.phone = new ContactPhone();
    this.contactEData = new ContactEData();
    this.textInfo = new ContactTextInfo();
    this.birthDate = new DatesData();
    this.annDate = new DatesData();

  }

  public ContactData where(ContactTextInfo textInfo) {
    this.textInfo = textInfo;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNumbersOf(ContactPhone phone) {
    this.phone = phone;
    return this;
  }

  public ContactData and(ContactEData contactEData) {
    this.contactEData = contactEData;
    return this;
  }

  public ContactData withAnniversary(DatesData annDate) {
    this.annDate = annDate;
    return this;
  }

  public ContactData withBirth(DatesData birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public ContactData withGroupNum(Integer groupNum) {
    this.groupNum = groupNum;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


//  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, Integer groupNum,
//                     ContactTextInfo textInfo, ContactPhone phone, ContactEData contactEData, DatesData birthDate,
//                     DatesData annDate) {
//    //Сделал отключения ненужных блоков информации
//    this.firstname = firstname;
//    this.middlename = middlename;
//    this.lastname = lastname;
//    this.nickname = nickname;
//    this.title = title;
//    this.groupNum = (Integer) notNull(groupNum, null);
//    this.textInfo = (ContactTextInfo) notNull(textInfo, new ContactTextInfo(null, null, null, null));
//    this.phone = (ContactPhone) notNull(phone, new ContactPhone(null, null, null, null, null));
//    this.contactEData = (ContactEData) notNull(contactEData, new ContactEData(null, null, null, null));
//    this.birthDate = (DatesData) notNull(birthDate, new DatesData(null, null, null));
//    this.annDate = (DatesData) notNull(annDate, new DatesData(null, null, null));
//  }
//
//  public ContactData(String firstname, String lastname) {
//    //Минимальный конструктор
//    this.firstname = firstname;
//    this.middlename = null;
//    this.lastname = lastname;
//    this.nickname = null;
//    this.title = null;
//    this.groupNum = null;
//    this.textInfo = new ContactTextInfo(null, null, null, null);
//    this.phone = new ContactPhone(null, null, null, null, null);
//    this.contactEData = new ContactEData(null, null, null, null);
//    this.birthDate = new DatesData(null, null, null);
//    this.annDate = new DatesData(null, null, null);
//  }
//
//  public ContactData(int id, String firstname, String lastname) {
//    //Минимальный конструктор с ид
//    this.id = id;
//    this.firstname = firstname;
//    this.middlename = null;
//    this.lastname = lastname;
//    this.nickname = null;
//    this.title = null;
//    this.groupNum = null;
//    this.textInfo = new ContactTextInfo(null, null, null, null);
//    this.phone = new ContactPhone(null, null, null, null, null);
//    this.contactEData = new ContactEData(null, null, null, null);
//    this.birthDate = new DatesData(null, null, null);
//    this.annDate = new DatesData(null, null, null);
//  }


  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public Integer getGroupNum() {
    return groupNum;
  }

  public ContactTextInfo getTextInfo() {
    return textInfo;
  }

  public ContactPhone getPhone() {
    return phone;
  }

  public ContactEData getContactEData() {
    return contactEData;
  }

  public DatesData getBirthDate() {
    return birthDate;
  }

  public DatesData getAnnDate() {
    return annDate;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public String getAddress1() {
    return address1;
  }


  public String getFullName() {
    return fullName;
  }

  public ContactData withFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public ContactData withAddress1(String address1) {
    this.address1 = address1;
    return this;

  }

  public ContactData makeAllEmails() {
    allEmails = Arrays.asList(new String[]{contactEData.getEmail1(), contactEData.getEmail2(), contactEData.getEmail3()})
            .stream().filter(email -> !email.equals(""))
//            .map(e -> e.replaceAll("\\s", "").replaceAll("-()", ""))
            .collect(Collectors.joining("\n"));
    return this;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", address1='" + address1 + '\'' +
            ", title='" + title + '\'' +
            ", allEmails='" + allEmails + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", fullName='" + fullName + '\'' +
            ", groupNum=" + groupNum +
            ", phone=" + phone +
            ", contactEData=" + contactEData +
            ", birthDate=" + birthDate +
            ", annDate=" + annDate +
            ", textInfo=" + textInfo +
            '}';
  }

  public ContactData makeAllPhones() {
    //удаляем лишнее через регулярные выражения и клеим в одно
    allPhones = Arrays.asList(new String[]{phone.getHome1(), phone.getMobile(), phone.getWork(), phone.getHome2()})
            .stream().filter(p -> !p.equals(""))
            .map(e -> e.replaceAll("\\s", "").replaceAll("[-()]", ""))
            .collect(Collectors.joining("\n"));
    return this;
  }

  public ContactData makeFullName() {
    //клеим first & last в одно
    fullName = Arrays.asList(new String[]{firstname, lastname})
            .stream().filter(p -> !p.equals(""))
            .collect(Collectors.joining("\n"));
    firstname = null;
    lastname = null;
    return this;
  }
}
