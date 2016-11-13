package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.malanyuk.test.model.ContactData;

import java.util.concurrent.TimeUnit;

/**
 * Created by ahomia on 12.11.2016.
 */
public class ApplicationManager extends ContactHelper{
    FirefoxDriver wd;
    private GroupHelper groupHelper ;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper=new GroupHelper(wd);
        login("admin", "secret");
    }

    public void login(String username, String password) {
       wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void stop() {
        wd.quit();
    }

    public void fillContactForm(ContactData contactData) {
      wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
       wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("theform")).click();
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
        wd.findElement(By.name("work")).click();
       wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
        wd.findElement(By.name("email")).click();
       wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + contactData.getBithdayDay() + "]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + contactData.getBithdayDay() + "]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[" + contactData.getBithdayMounth() + "]")).isSelected()) {
            .wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[" + contactData.getBithdayMounth() + "]")).click();
        }
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(contactData.getBithdayYear());
    }

    public void initAddContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void sumbitContactCreating() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
