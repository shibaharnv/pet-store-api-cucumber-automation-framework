package DirectTest.apiFramework;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PatchPartialUpdate {

    public static void main(String[] args) {

        String payload= "{\n" +
                "    \"firstname\" : \"test123\",\n" +
                "    \"lastname\" : \"123\"\n" +
                "}";

        Response response=given().baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .header("Cookie","token="+"8f2ebad433f9d38")
                .body(payload)
                .when()
                .patch("/booking/1049").then().log().all().extract().response();

    }
}
