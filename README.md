# pet-store-api-cucumber-automation-framework

Pet Store API testing using rest-assured

This is a  Rest API test automation solution for endpoints available in https://petstore.swagger.io/


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
      + files                       image file
      + logs                        logs file 
      + resources                   property files,Testdata build and common utility methods for testcases.
      + stepdefinitions             Step definitions for the BDD feature
      + logs                        logs.txt for capturing logs 
      
```      

## Installation and Test Execution

- Clone the repository with below command

```
git clone -b main https://github.com/shibaharnv/pet-store-api-cucumber-automation-framework.git

```


Open the project in any IDE Eclipse/IntelliJ.

Navigate to "pet-store-api-automation-framework" folder where we have pom.xml

## Execute Tests in Local:

Run the below command where "-DRecipientList" parameter value can be updated to your email id.

Test results report link will be sent to the mentioned email id.

### After running the below command please wait for less than a minute for the execution to complete since all the maven logs are captured in project basedir/mavenlogs.txt file location.

```mvn -Dcucumber.filter.tags="@Regression" test verify --log-file mavenlogs.txt -DRecipientList="shibaharn@gmail.com"```


```bash
  - Tags.                       -Usage
  CreatePetWithPayload         Create Pet With Payload
  UpdatePetwithPayload         Update the pet with payload
  PetGetAndDelete              Get details of Pet and delete pet with ID.
  Regression                   All the testcases 
```

##  Executing testcases in CI/CD Gitlab integration for CI CT (.gitlab-ci.yml)

- CI CD Pipeline in configured in Gitlab .Navigate to below url and click on run pipeline button



```bash
            https://gitlab.com/shibaharn/pet-store-api-cucumber-automation-framework/-/pipelines/new

```

### one improvement point for Calliope.pro platform ###

While creating group and profile multiple error messages are displayed.

Selecting group  while uploading the report can be more user friendly.


![Screenshot 2022-10-07 at 12 54 24](https://user-images.githubusercontent.com/65211677/194496474-72526f94-31c4-4dc9-a264-ba9094370c02.png)


### one new feature for the Calliope.pro platform ###

          In the Login page of calliope.pro platform "forgot password" feature can be added.


### What you used to select the test scenarios, what was your approach ###

          I have selected the testcases for pet store apis  by considering the following approaches. i.e) end to end flows,
          and creation,updatation ,get and delete apis.



### Why are testcases the most important; ###     

      These testcases ensure end to end coverage of creation,updatation ,get and delete pet storeapis.     




## Automatic email Generation

Once the execution is done you must be receiving an email with test results link

![email](https://user-images.githubusercontent.com/65211677/193441907-1cbc4e07-af7f-4049-8853-753d8251fe25.png)

After clicking the link you should be able to see the report .please refer below screenshot

![Screenshot 2022-10-07 at 22 31 39](https://user-images.githubusercontent.com/65211677/194611575-259c659a-18db-44a8-b03c-ac0393c254ae.png)


## Another Detailed report in project directory

Detailed report can be found in /restful-booker-api-automation-framework/target/cucumber-html-reports location

![Screenshot 2022-10-07 at 22 33 13](https://user-images.githubusercontent.com/65211677/194611897-5da7210e-84e1-40af-a13f-f8d609b7f843.png)

![Screenshot 2022-10-07 at 22 33 26](https://user-images.githubusercontent.com/65211677/194611828-afb58b11-d310-4a5b-9cc3-b09b9aa660d4.png)




Thanks.

Incase of any queries reach out to shibaharn@gmail.com











