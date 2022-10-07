# restful-booker-api-cucumber-automation-framework 

Restful Booker API testing using rest-assured

This is a  Rest API test automation solution for endpoints available in http://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBookings
The APIs represent a booking system where user can create, get booking details, update ,delete and bookings.

## Technology Stack

- Java
- Cucumber
- Maven
- RestAssured

## Prerequisites
- Java - Version : 1.8 
- Maven - Version : 3.8.1

## The project directory structure

```bash
src
 + main
    + java                          
      + pojo                        pojos of all endpoints                 
      + utilities                   utility email class
 + test
    + java                          
      + cucumber.Options            Test runner and cucumber configurations
      + features                    feature file
      + resources                   property files,Testdata build and common utility methods for testcases.
      + stepdefinitions             Step definitions for the BDD feature
      + logs                        logs.txt for capturing logs 
      
```      

## Installation and Test Execution

- Clone the repository with below command

```
git clone -b main https://github.com/shibaharnv/restful-booker-api-cucumber-automation-framework.git

```


Open the project in any IDE Eclipse/IntelliJ.

Navigate to "restful-booker-api-cucumber-automation-framework" folder where we have pom.xml 

Run the following command in Terminal and build the project. It will automatically download all the required dependencies.

```
$ mvn clean install
```

## Execute Tests

Run the below command where "-DRecipientList" parameter value can be updated to your email id.

Test results report link will be sent to the mentioned email id.

### After running the below command please wait for less than a minute for the execution to complete since all the maven logs are captured in project basedir/mavenlogs.txt file location.

```mvn -Dcucumber.filter.tags="@CreateBooking" test verify --log-file mavenlogs.txt -DRecipientList="shibaharn@gmail.com"```


```bash
  - Tags.                       -Usage
  CreateBooking                Create the booking
  GetBookingDetailWithID       Fetching the booking details with id
  PartialUpdate                Partially updating the booking
  DeleteBooking                Delete the booking with id
  GetBookingIds                Fetching all the booking ids
  PartialUpdateNegative        Validating different errorcodes for partialupdate
  DeleteBookingNegative        Validating different errorcodes for deletebooking
  GetBookingIdsNegative        Validating different errorcodes for getbookingIDs
  GetAllBookingIdsNegative     Checking the error codes while fetching all ids
  Regression                   All the testcases 
```

## Automatic email Generation

Once the execution is done you must be receiving an email with test results link

![email](https://user-images.githubusercontent.com/65211677/193441907-1cbc4e07-af7f-4049-8853-753d8251fe25.png)

After clicking the link you should be able to see the report .please refer below screenshot

![Screenshot 2022-10-03 at 07 00 58](https://user-images.githubusercontent.com/65211677/193486845-829fba65-c3eb-43c6-93b1-558bb0235ee2.png)


## Another Detailed report in project directory

Detailed report can be found in /restful-booker-api-automation-framework/target/cucumber-html-reports location

![Screenshot 2022-10-02 at 12 37 10](https://user-images.githubusercontent.com/65211677/193442382-72102d96-a4cd-4d6c-bb91-9cc036bbb083.png)


![Screenshot 2022-10-02 at 12 37 28](https://user-images.githubusercontent.com/65211677/193442394-f72f1bfd-003b-493b-8f4d-be0683f113de.png)


##  Gitlab integration for CI CT (.gitlab-ci.yml)

- Gitlab source code (https://gitlab.com/shibaharn/restful-booker-api-cucumber-automation-framework) 

![Screenshot 2022-10-02 at 12 57 48](https://user-images.githubusercontent.com/65211677/193443083-ecc9cb1f-a529-40a4-b967-eba7ad728533.png)



Thanks.

Incase of any queries reach out to shibaharn@gmail.com











