package DirectTest.apiFramework;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateToken
{
    public static void main(String[] args) {


        String payLoad="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        Response response=given().baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .body(payLoad)
                .when()
                .post("/auth").then().log().all().extract().response();

        String token= response.jsonPath().getString("token");
        System.out.println("Token "+token);


    }
}
