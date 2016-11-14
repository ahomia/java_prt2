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
         click(By.linkText("groups"));
     }
}
