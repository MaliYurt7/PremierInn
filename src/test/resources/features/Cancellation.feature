  @Cancellation
  Feature: The customers should be able to perform cancellation process

    Background:
      Given the customer should be able to access home page

    Scenario Outline: Different customers cancellation process
      And   the customer should be able to click manage booking
      And   the customer should be able to enter "<BookingReference>" "<LastName>" "<ArrivalDate>" and click the search button
      Then  the customer should be able to access the "Booking information" page and see "<FirstName>" "<LastName>" "<BookingReference>"
      And   the customer should be able to click Cancel booking button
      Then  the customer should be able to see the "<FirstName>" "<LastName>" and capture the "cancellation number" storing to a "cancellationNumber.csv"
      Examples:
        | BookingReference | FirstName  | LastName | ArrivalDate |
#        | AEGR786787       | Automation | Tester   | 11-Jan-22   |
#        | BKIR12833        | Automation | Tester   | 18-Jan-22   |
        | AKIR515045       | Automation | Tester   | 26-Jan-22   |
