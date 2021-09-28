package com.premierinn.pages;

import com.premierinn.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;

    @FindBy(id = "pi-menu-button")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[text()='Manage booking']")
    public WebElement manageBookingBtn;

    @FindBy(id = "booking-reference-input")
    public WebElement bookingRefInput;

    @FindBy(id = "booking-surname-input")
    public WebElement bookingSurnameInput;

    @FindBy(xpath = "//div[text()='Arrival date *']/../input")
    public WebElement arrivalDateInput;

    @FindBy(xpath = "//img[@aria-label='Next Month']")
    public WebElement nextMonth;

    @FindBy(id = "find-booking-form-button")
    public WebElement searchBtn;



    @FindBy(xpath = "//button[@style='display: block;']/img[@class='calendar_arrow-right']")
    public WebElement calendarArrowRight;

    public void navigateToModule(String date) {
        Driver.get().findElement(By.id("date-picker-day-"+ date)).click();

    }

    public void setAcceptCookies() {

        if(Driver.get().findElement(By.id("accept-all-cookies-button")).isDisplayed()){
            Driver.get().findElement(By.id("accept-all-cookies-button")).click();
            Driver.get().findElement(By.id("pi-menu-button")).click();
        }else{
            Driver.get().findElement(By.id("pi-menu-button")).click();
        }

    }


}
