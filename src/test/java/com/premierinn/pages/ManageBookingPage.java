package com.premierinn.pages;

import com.premierinn.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageBookingPage extends BasePage {



    @FindBy(xpath = "//h3[text()='Booking information']")
    public WebElement bookingInfoPage;

    public WebElement setBookingRef(String bookingRef){
        return Driver.get().findElement(By.xpath("//h3[text()='"+bookingRef+"']"));
    }

    public WebElement setFullName(String fullname){
        return Driver.get().findElement(By.xpath("//span[text()='"+fullname+"']"));
    }
    @FindBy(xpath = "//span[text()='Automation Tester']")
    public WebElement fullName;

    @FindBy(xpath = "//button[text()='Cancel booking']")
    public WebElement cancelBookingBtn;

    @FindBy(xpath = "(//button[text()='Cancel booking'])[2]")
    public WebElement cancelYourBookingBtn;

    @FindBy(xpath = "//div[@class='wb-notification-text']/span")
    public WebElement cancellationMssg;

    @FindBy(xpath = "//div[@class='wb-notification-text']/span/span")
    public WebElement cancellationNumber;

    @FindBy(xpath = "//span[@class='text-type--body wb-base-typography--semi-bold mr1']/..")
    public WebElement bookerName;

}
