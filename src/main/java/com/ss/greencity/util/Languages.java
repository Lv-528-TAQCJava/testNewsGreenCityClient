package com.ss.greencity.util;

import org.openqa.selenium.By;

public enum Languages {
    ENGLISH("En", By.xpath("//div[@class='switcher-wrapper']/ul/li[normalize-space()='Ru']")),
    UKRAINIAN("Uk", By.xpath("//div[@class='switcher-wrapper']/ul/li[normalize-space()='Uk']")),
    RUSSIAN("Ru", By.xpath("//div[@class='switcher-wrapper']/ul/li[normalize-space()='En']"));

    Languages(String langCode, By path) {
        this.code = langCode;
        this.path = path;
    }
    private String code;
    private By path;

    public String getCode() {
        return code;
    }

    public By getPath() {
        return path;
    }
}
