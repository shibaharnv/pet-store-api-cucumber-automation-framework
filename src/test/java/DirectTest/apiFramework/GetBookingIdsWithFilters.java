package DirectTest.apiFramework;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingIdsWithFilters {

    public static void main(String[] args) {


        Response response=given().baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .queryParam("firstname","test1")
                .queryParam("lastname","test2")
                .when()
                .get("/booking")
                .then()
                .log().all().extract().response();

    }
}
