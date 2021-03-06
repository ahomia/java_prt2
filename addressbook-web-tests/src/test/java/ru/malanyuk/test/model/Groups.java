package ru.malanyuk.test.model;

import com.google.common.collect.ForwardingSet;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ahomia on 05.12.2016.
 */
public class Groups extends ForwardingSet<GroupDate> {
    private Set<GroupDate> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupDate>(groups.delegate());
    }


    public Groups(Collection<GroupDate> groups) {
        this.delegate = new HashSet<GroupDate>(groups);
    }
    @ManyToMany(mappedBy = "groups")
    private Set<ContactData> contacts=new HashSet<ContactData>();

    public Set<ContactData> getContacts() {
        return new Contacts(contacts);
    }

    @Override
    protected Set<GroupDate> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupDate group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupDate group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
