package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ahomia on 13.11.2016.
 */
public class HelperBase {
    private FirefoxDriver wd;

    public HelperBase(FirefoxDriver wd) {
        this.wd = wd;
    }

    protected void selectDropdown(String parameter) {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + parameter + "]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + parameter + "]")).click();
        }
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }
    public  boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
