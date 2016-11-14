package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.malanyuk.test.model.GroupDate;

/**
 * Created by ahomia on 12.11.2016.
 */
public class GroupHelper extends HelperBase {
    private FirefoxDriver wd;


    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnGroupPage() {

        click(By.linkText("group page"));
    }

    public void submitGroupCreating() {

        click(By.name("submit"));
    }

    public void fillGroupForm(GroupDate groupDate) {
        type(By.name("group_name"),groupDate.getGroupName());
        type(By.name("group_footer"),groupDate.getFooter());

    }

    public void initGroupCreating() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectGroup() {

        click(By.name("selected[]"));
    }


    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
