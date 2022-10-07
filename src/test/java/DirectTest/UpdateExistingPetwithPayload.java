package DirectTest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdateExistingPetwithPayload {

    public static void main(String[] args) {
        String payload= "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"test1\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://user-images.githubusercontent.com/65211677/193443083-ecc9cb1f-a529-40a4-b967-eba7ad728533.png\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"CHECK\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        Response response=given().baseUri("https://petstore.swagger.io/v2/pet")
                .contentType("application/json")
                .body(payload)
                .when()
                .put().then().log().all().extract().response();


        int statuscode =response.getStatusCode();
        System.out.println(statuscode);
    }
}
