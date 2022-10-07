package DirectTest.apiFramework;

import io.restassured.path.json.JsonPath;

public class NestedJsonExtraction {

    public static void main(String[] args) {

        String payload ="{\n" +
                "    \"firstname\": \"testffd\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        JsonPath js = new JsonPath(payload);
        String value=js.getString("bookingdates.checkin");
        System.out.println(value);
    }
}
