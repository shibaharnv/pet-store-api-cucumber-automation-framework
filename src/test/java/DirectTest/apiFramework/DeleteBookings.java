package DirectTest.apiFramework;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookings {

    public static void main(String[] args) {

        Response response=given().baseUri("https://restful-booker.herokuapp.com")
               // .contentType("application/json")
                .header("Cookie","token="+"d3a29955aa7409a")
                .when()
                .delete("/booking/4946").
                then().log().all().extract().response();
    }
}
