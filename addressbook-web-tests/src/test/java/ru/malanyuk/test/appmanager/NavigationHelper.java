package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by ahomia on 13.11.2016.
 */
public class NavigationHelper extends HelperBase{
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {
        if(isElementPresent(By.tagName("h1"))
                &&wd.findElement(By.tagName("h1")).getText().equals("Groups")
                &&isElementPresent(By.name("new"))) {
        return;
        }else{
                click(By.linkText("groups"));
            }
        }
    public void goHomePage() {
        if(isElementPresent(By.id("maintable"))){

            return;
        }else{
            click(By.linkText("home"));
        }
    }


}



