package com.ss.greencity.util;

import java.util.Set;
import com.ss.greencity.EcoNewsTestRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class GoogleWindowSwitch extends EcoNewsTestRunner  {

    public static String  WindowsHandling(Set<String> oldWindowsSet){
        return (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver1) {
                               Set<String> newWindowsSet = driver1.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
    }

}
