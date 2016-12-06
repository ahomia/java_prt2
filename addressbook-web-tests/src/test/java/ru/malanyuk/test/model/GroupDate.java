package ru.malanyuk.test.model;

public class GroupDate {


    private String groupName;
    private String header;
    private String footer;
    private int id = Integer.MAX_VALUE;

    public GroupDate withId(int id) {
        this.id = id;
        return this;
    }

    public GroupDate withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupDate withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupDate withFooter(String footer) {
        this.footer = footer;
        return this;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupDate groupDate = (GroupDate) o;

        if (id != groupDate.id) return false;
        return groupName != null ? groupName.equals(groupDate.groupName) : groupDate.groupName == null;

    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + id;
        return result;
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
