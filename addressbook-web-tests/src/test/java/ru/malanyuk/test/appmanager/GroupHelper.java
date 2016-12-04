package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.malanyuk.test.model.GroupDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahomia on 12.11.2016.
 */
public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {
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

    public void selectGroup(int index) {
wd.findElements(By.name("selected[]")).get(index).click();
       // click(By.name("selected[]"));
    }


    public void initGroupModification() {
        
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        
        click(By.name("update"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup(GroupDate group) {
        initGroupCreating();
        fillGroupForm(group);
    submitGroupCreating();
        returnGroupPage();
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupDate> getGroupList() {
        List<GroupDate> groups=new ArrayList<GroupDate>();
        List<WebElement> elements=wd.findElements(By.cssSelector("span.group"));
        for (WebElement l: elements){
            String name=l.getText();
            int id=Integer.parseInt(l.findElement(By.tagName("input")).getAttribute("value"));
            GroupDate group=new GroupDate(id,name,null,null);
            groups.add(group);
        }
        return groups;
    }
}
