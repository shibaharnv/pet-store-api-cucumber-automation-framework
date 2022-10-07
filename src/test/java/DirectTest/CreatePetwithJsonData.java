package DirectTest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreatePetwithJsonData {

    public static void main(String[] args) {


        String payload= "{\"id\":6,\"name\":\"Micky\",\"status\":\"Sold\",\"category\":{\"id\":1,\"name\":\"mouse\"},\"photoUrls\":[\"https://image1\"],\"tags\":[{\"id\":91,\"name\":\"Good\"}]}";

        Response response=given().baseUri("https://petstore.swagger.io/v2/pet")
                .contentType("application/json")
                .body(payload)
                .when()
                .post().then().log().all().extract().response();


        int statuscode =response.getStatusCode();
        System.out.println(statuscode);

    }

}
