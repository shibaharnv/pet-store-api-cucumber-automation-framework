package DirectTest;

import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetWithImage {

    public static void main(String[] args) {
//
//
//        request = given().spec(requestSpecification()).log().all().headers("Authorization",
//                        "Bearer " + new_access_token, "Content-type",
//                        "multipart/form-data; boundary=<calculated when request is sent>", "Accept", "*/*", "Accept-Encoding",
//                        "gzip, deflate, br", "Connection", "keep-alive")
//                .multiPart("client", jsonfile, "application/json")
//                .multiPart("clientLogo", imagefile, "multipart/form-data");

//        String payload= "{\n" +
//                "    \"firstname\" : \"test1\",\n" +
//                "    \"lastname\" : \"test2\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";
//

        String Path="/Users/snagarajan/Desktop/ApiTestAutomation/petstore/pet-store-api-automation-framework/src/test/java/files/test1.png";
        File fobj = new File(Path);


        Response response=given().baseUri("https://petstore.swagger.io/v2/pet")
                .multiPart("file",fobj)
                .when()
                .post("/123/uploadImage").then().log().all().extract().response();

        int statuscode =response.getStatusCode();
        System.out.println(statuscode);

        System.out.println(response.toString());

    }


}
