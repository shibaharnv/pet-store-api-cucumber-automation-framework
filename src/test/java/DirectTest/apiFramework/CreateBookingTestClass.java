package DirectTest.apiFramework;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateBookingTestClass {

    public static void main(String[] args) {

            String payload= "{\n" +
                    "    \"firstname\" : \"test1\",\n" +
                    "    \"lastname\" : \"test2\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : true,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2018-01-01\",\n" +
                    "        \"checkout\" : \"2019-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}";

        Response response=given().baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/booking").then().log().all().extract().response();


    }
}
