package ru.jelenium.addressbook.model;

public class ContactData {

  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final Integer groupNum;
  private final ContactTextInfo textInfo;
  private final ContactPhone phone;
  private final ContactEData contactEData;
  private final DataData birthDate;
  private final DataData annDate;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title, Integer groupNum,
                     ContactTextInfo textInfo, ContactPhone phone, ContactEData contactEData, DataData birthDate,
                     DataData annDate) {
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
    this.birthDate = (DataData) notNull(birthDate, new DataData(null, null, null));
    this.annDate = (DataData) notNull(annDate, new DataData(null, null, null));
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
    this.birthDate = new DataData(null, null, null);
    this.annDate = new DataData(null, null, null);
  }

  public Object notNull(Object toCheckObj, Object defObj) {
    if (toCheckObj != null) {
      return toCheckObj;
    }
    return defObj;
  }

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

  public DataData getBirthDate() {
    return birthDate;
  }

  public DataData getAnnDate() {
    return annDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
