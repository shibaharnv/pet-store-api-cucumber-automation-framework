package DirectTest.apiFramework;

import static io.restassured.RestAssured.given;

public class GetBookingIds {

    public static void main(String[] args) {


        int bookingId=given().baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .when()
                .get("/booking")
                .then()
                .log().all().extract().response()
                        .path("bookingid[0]");
        System.out.println("bookingId "+bookingId);
    }
}
