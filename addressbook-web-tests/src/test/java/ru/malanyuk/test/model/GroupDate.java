package ru.malanyuk.test.model;

public class GroupDate {
    private final String groupName;
    private final String header;
    private final String footer;

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    @Override
    public String toString() {
        return "GroupDate{" +
                "groupName='" + groupName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public GroupDate(int id, String groupName, String header, String footer) {
        this.groupName = groupName;
        this.header = header;
        this.footer = footer;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupDate groupDate = (GroupDate) o;

        return groupName != null ? groupName.equals(groupDate.groupName) : groupDate.groupName == null;

    }

    @Override
    public int hashCode() {
        return groupName != null ? groupName.hashCode() : 0;
    }

    public GroupDate(String groupName, String header, String footer) {
        this.id = Integer.MAX_VALUE;
        this.groupName = groupName;
        this.header = header;
        this.footer = footer;

    }

    public String getGroupName() {
        return groupName;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }


}
