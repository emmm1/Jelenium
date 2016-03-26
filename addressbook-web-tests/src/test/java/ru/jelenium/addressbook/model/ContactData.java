package ru.jelenium.addressbook.model;

public class ContactData {

  private int id;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String title;
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

/*
  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, Integer groupNum,
                     ContactTextInfo textInfo, ContactPhone phone, ContactEData contactEData, DatesData birthDate,
                     DatesData annDate) {
    //Сделал отключения ненужных блоков информации
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.groupNum = (Integer) notNull(groupNum, null);
    this.textInfo = (ContactTextInfo) notNull(textInfo, new ContactTextInfo(null, null, null, null));
    this.phone = (ContactPhone) notNull(phone, new ContactPhone(null, null, null, null, null));
    this.contactEData = (ContactEData) notNull(contactEData, new ContactEData(null, null, null, null));
    this.birthDate = (DatesData) notNull(birthDate, new DatesData(null, null, null));
    this.annDate = (DatesData) notNull(annDate, new DatesData(null, null, null));
  }

  public ContactData(String firstname, String lastname) {
    //Минимальный конструктор
    this.firstname = firstname;
    this.middlename = null;
    this.lastname = lastname;
    this.nickname = null;
    this.title = null;
    this.groupNum = null;
    this.textInfo = new ContactTextInfo(null, null, null, null);
    this.phone = new ContactPhone(null, null, null, null, null);
    this.contactEData = new ContactEData(null, null, null, null);
    this.birthDate = new DatesData(null, null, null);
    this.annDate = new DatesData(null, null, null);
  }

  public ContactData(int id, String firstname, String lastname) {
    //Минимальный конструктор с ид
    this.id = id;
    this.firstname = firstname;
    this.middlename = null;
    this.lastname = lastname;
    this.nickname = null;
    this.title = null;
    this.groupNum = null;
    this.textInfo = new ContactTextInfo(null, null, null, null);
    this.phone = new ContactPhone(null, null, null, null, null);
    this.contactEData = new ContactEData(null, null, null, null);
    this.birthDate = new DatesData(null, null, null);
    this.annDate = new DatesData(null, null, null);
  }

*/


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

  public ContactData setId(int id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
}
