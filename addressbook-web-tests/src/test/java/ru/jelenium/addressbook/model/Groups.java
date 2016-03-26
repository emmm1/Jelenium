package ru.jelenium.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Idea on 26.03.2016.
 */
public class Groups extends ForwardingSet<GroupData> {

  private Set<GroupData> delagate;

  public Groups(Groups groups) {
    this.delagate = new HashSet<>(groups.delagate);
  }

  public Groups() {
    this.delagate = new HashSet<>();
  }

  public Groups with(GroupData group) {
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups without(GroupData group) {
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }

  public Groups withChangedGroup(GroupData oldData, GroupData newData) {
    Groups groups = new Groups(this);
    groups.remove(oldData);
    groups.add(newData);
    return groups;
  }

  @Override
  protected Set<GroupData> delegate() {
    return delagate;
  }
}