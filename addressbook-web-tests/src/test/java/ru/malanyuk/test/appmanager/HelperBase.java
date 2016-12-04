package ru.malanyuk.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ahomia on 13.11.2016.
 */
public class HelperBase {
    public WebDriver wd;
    protected WebDriverWait wait;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
        this.wait = new WebDriverWait(wd, 10);
    }



    public void selectDropdown(By locator, String text) {
        if (isElementPresent(locator)) {
            new Select(wd.findElement(locator)).selectByValue(text);
        }
    }

   /* private WebElement findElement(String parameter) {
        return wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + parameter + "]"));
    }
*/
    public void type(By locator, String text) {

        if (text != null) {
            WebElement element=wd.findElement(locator);
            String existingText = element.getAttribute("value");
            if (!text.equals(existingText)) {
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void closeAlert() {

        wd.switchTo().alert().accept();
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
