package DirectTest.apiFramework;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingByID {

    public static void main(String[] args) {

        Response response=given().baseUri("https://restful-booker.herokuapp.com")
                .when()
                .get("/booking/4923").then().log().all().extract().response();
    }
}
