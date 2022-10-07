package DirectTest.apiFramework;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class RequestSpecificationtest {

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

        RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON).build();


//        Response response=given().baseUri("https://restful-booker.herokuapp.com")
//                .contentType("application/json")
//                .body(payload)
//                .when()
//                .post("/booking").then().log().all().extract().response();

        ResponseSpecification responseSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        RequestSpecification reqObj= given().spec(req).body(payload);

        Response res=reqObj.when().post("/booking").then().spec(responseSpec).log().all().extract().response();





    }
}
