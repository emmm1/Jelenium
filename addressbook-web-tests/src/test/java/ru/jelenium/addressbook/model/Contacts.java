package ru.jelenium.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Idea on 26.03.2016.
 */
public class Contacts extends ForwardingSet<ContactData> {

  private Set<ContactData> delegate;

  public Contacts (Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate);
  }

  public Contacts () {
    this.delegate = new HashSet<>();
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate;
  }

  public Contacts with(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts change(ContactData old, ContactData newInfo) {
    Contacts contacts = new Contacts(this);
    contacts.remove(old);
    contacts.add(newInfo);
    return contacts;
  }

  public Object without(ContactData deleted) {
    Contacts contacts = new Contacts(this);
    contacts.remove(deleted);
    return contacts;

  }
}
