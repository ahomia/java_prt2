package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ahomia on 13.11.2016.
 */
public class HelperBase {
    private WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void selectDropdown(String parameter) {
        if (!findElement(parameter).isSelected()) {
            findElement(parameter).click();
        }
    }

    private WebElement findElement(String parameter) {
        return wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + parameter + "]"));
    }

    public void type(By locator, String text) {

        if(text!=null){
            String existingText=wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public void click(By locator) {
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
    public void closeAlert(){
        wd.switchTo().alert().accept();
    }

}
