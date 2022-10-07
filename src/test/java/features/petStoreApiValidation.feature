Feature: Validating pet-store Apis

  @CreatePetWithPayload @Regression
  Scenario Outline: Create a pet with payload

    Given Setting up the pet request sepecification
    When  User creates a pet with below values
      | "<Id>" | "<Name>" | "<Status>" | "<Photo_Url>" | "<Tags_Id>" | "<Tags_Name>" | "<Category_Id>" | "<Category_Name>" |
    Then Store the petId from the response body

    Examples:
      | Id | Name  | Status    | Photo_Url                     | Tags_Id | Tags_Name | Category_Id | Category_Name |
      | 6  | Micky | Sold      | https://image1;https://image2 | 91      | Good      | 1           | mouse         |
      | 7  | Test  | Available | https://image3;https://image4 | 56      | Good      | 6           | cat           |



  @UpdatePetwithPayload @Regression
  Scenario Outline: Update a pet with payload

    Given Setting up the pet request sepecification
    When  User updates a pet with below values
      | "<Name>" | "<Status>" | "<Photo_Url>" | "<Tags_Id>" | "<Tags_Name>" | "<Category_Id>" | "<Category_Name>" |
    Then Verify the updated values
      | "<Name>" | "<Status>" | "<Photo_Url>" | "<Tags_Id>" | "<Tags_Name>" | "<Category_Id>" | "<Category_Name>" |
    And Validate the <statuscode> from response

    Examples:
      | Name        | Status | Photo_Url                     | Tags_Id | Tags_Name | Category_Id | Category_Name | statuscode |
      | updatedName | sold   | https://image1;https://image2 | 43      | Good      | 13          | dog           | 200        |





  @PetGetAndDelete @Regression
  Scenario Outline: Validate pet Get and delete methods

    Given Setting up the pet request sepecification
    When  User hits the endpoint for "<httpmethod>"
    Then Validate the <statuscode> from response

    Examples:
      | httpmethod | statuscode |
      | GET        | 200        |
      | DELETE     | 200        |


