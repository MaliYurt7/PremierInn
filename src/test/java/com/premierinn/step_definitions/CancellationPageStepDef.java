package com.premierinn.step_definitions;

import com.premierinn.pages.ManageBookingPage;
import com.premierinn.utilities.BrowserUtils;
import com.premierinn.utilities.ConfigurationReader;
import com.premierinn.utilities.Driver;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;


import java.text.ParseException;
import java.util.ArrayList;

public class CancellationPageStepDef {

    ManageBookingPage manageBookingPage = new ManageBookingPage();
    ArrayList<String> cars = new ArrayList<String>();
    public static ArrayList<String> variableYouWantToUse = new ArrayList<String>();

    @Given("the customer should be able to access home page")
    public void the_customer_should_be_able_to_access_home_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @Given("the customer should be able to click manage booking")
    public void the_customer_should_be_able_to_click_manage_booking() {
        manageBookingPage.setAcceptCookies();
        manageBookingPage.manageBookingBtn.click();
    }

    @Given("the customer should be able to enter {string} {string} {string} and click the search button")
    public void the_customer_should_be_able_to_enter_and_click_the_search_button(String BookingReference, String LastName, String ArrivalDate) throws ParseException {
        manageBookingPage.bookingRefInput.sendKeys(BookingReference);
        manageBookingPage.bookingSurnameInput.sendKeys(LastName);
        manageBookingPage.arrivalDateInput.click();
        int numberOfclicking = BrowserUtils.cancellationCal(BrowserUtils.integerParsingDate(ArrivalDate), BrowserUtils.integerParsingDate());
        for (int i = 0; i < numberOfclicking; i++) {
            manageBookingPage.calendarArrowRight.click();
        }
        manageBookingPage.navigateToModule(BrowserUtils.integerParsingDate1(ArrivalDate));
        manageBookingPage.searchBtn.click();


    }


    @Then("the customer should be able to access the {string} page and see {string} {string} {string}")
    public void the_customer_should_be_able_to_access_the_page_and_see(String bookingInfoPage, String FirstName, String LastName, String BookingRef) {
        BrowserUtils.waitFor(1);
        assertEquals(bookingInfoPage, manageBookingPage.bookingInfoPage.getText());
        String fullname = FirstName + " " + LastName;
        assertEquals(fullname, manageBookingPage.setFullName(fullname).getText());
        assertEquals(BookingRef, manageBookingPage.setBookingRef(BookingRef).getText());


    }

    @Then("the customer should be able to click Cancel booking button")
    public void the_customer_should_be_able_to_click_Cancel_booking_button() {
        manageBookingPage.cancelBookingBtn.click();
        manageBookingPage.cancelYourBookingBtn.click();
    }




    @Then("the customer should be able to see the {string} {string} and capture the {string} storing to a {string}")
    public void the_customer_should_be_able_to_see_the_and_capture_the_storing_to_a(String FirstName, String LastName, String cancellationNumber, String fileName) {
        cancellationNumber=manageBookingPage.cancellationNumber.getText();
        variableYouWantToUse.add(cancellationNumber);
        BrowserUtils.writeToCSVFile(fileName,variableYouWantToUse);
        String fullname = FirstName + " " + LastName;
        assertEquals("Booker:"+fullname, manageBookingPage.bookerName.getText());
    }

}