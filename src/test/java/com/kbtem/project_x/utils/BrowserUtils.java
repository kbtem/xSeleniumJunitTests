package com.kbtem.project_x.utils;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserUtils {

    public static boolean switchToWindowByIndex(WebDriver driver, int index) {
        Set<String> windowHandles = driver.getWindowHandles();
        if (index >= 0 && index < windowHandles.size()) {
            driver.switchTo().window((String) windowHandles.toArray()[index]);
            return true;
        } else {
            System.out.println("Window index " + index + " is out of range.");
            return false;
        }
    }

    public static boolean switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                return true;
            }
        }
        System.out.println("Window with title '" + title + "' not found.");
        return false;
    }

    public static void browserSleep(long second){
        try {
            Thread.sleep(second*1000); // 1 Second equals 1000 millis.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }








}
