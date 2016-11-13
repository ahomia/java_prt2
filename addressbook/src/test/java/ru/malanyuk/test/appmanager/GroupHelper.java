package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.malanyuk.test.model.GroupDate;

/**
 * Created by ahomia on 12.11.2016.
 */
public class GroupHelper {
    private FirefoxDriver wd;
 public GroupHelper(FirefoxDriver wd){
     this.wd=wd;
 }
    public void returnGroupPage() {
         wd.findElement(By.linkText("group page")).click();
     }

    public void submitGroupCreating() {
         wd.findElement(By.name("submit")).click();
     }

    public void fillGroupForm(GroupDate groupDate) {
         wd.findElement(By.name("group_name")).click();
         wd.findElement(By.name("group_name")).clear();
         wd.findElement(By.name("group_name")).sendKeys(groupDate.getGroupName());
         wd.findElement(By.name("group_header")).click();
         wd.findElement(By.name("group_header")).click();
         wd.findElement(By.name("group_header")).clear();
         wd.findElement(By.name("group_header")).sendKeys(groupDate.getHeader());
         wd.findElement(By.name("group_footer")).click();
         wd.findElement(By.name("group_footer")).clear();
         wd.findElement(By.name("group_footer")).sendKeys(groupDate.getFooter());

     }

    public void initGroupCreating() {
         wd.findElement(By.name("new")).click();
     }

    public void goToGroupPage() {
         wd.findElement(By.linkText("groups")).click();
     }

    public void deleteSelectedGroups() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }
}
