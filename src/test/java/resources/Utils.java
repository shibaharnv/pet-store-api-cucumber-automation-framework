package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.*;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Utils {

    public static RequestSpecification req;

    public RequestSpecification requestSpecificationMethod() throws IOException {

        if(req==null) {

            PrintStream log = new PrintStream(new FileOutputStream("src/test/java/logs/logs.txt"));

            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
            return req;
        }
        return req;

    }

    public String tokenGeneration() throws IOException {


        String payLoad="{\n" +
                "    \"username\" : \""+getGlobalValue("username")+"\",\n" +
                "    \"password\" : \""+getGlobalValue("password")+"\"\n" +
                "}";

        Response response=given().baseUri(getGlobalValue("baseUrl"))
                .contentType("application/json")
                .body(payLoad)
                .when()
                .post("/auth").then().log().all().extract().response();

        String token= response.jsonPath().getString("token");
        return token;
    }


    public static String getGlobalValue(String key) throws IOException {

        Properties prop = new Properties();
        String path =System.getProperty("user.dir");
        String end="/src/test/java/resources/global.properties";
        String fullPath =path.concat(end);
        FileInputStream fis =new FileInputStream(fullPath);
        prop.load(fis);
        return prop.getProperty(key);

    }


    public String getJsonPath(Response response,String key)
    {
        String resp=response.asString();
        JsonPath   js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public JSONObject getJsonObjectPath(String response, String key)
    {
        JSONObject jsonObject = new JSONObject(response);
        JSONObject getJsonObject = jsonObject.getJSONObject(key);
        return getJsonObject;
    }


    //{            JSONObject jsonObject = new JSONObject(res);
    //            JSONObject getCategory = jsonObject.getJSONObject("category");}

    public List getJsonPathList(String inputResponse, String keylist) {
        JsonPath js2 = new JsonPath(inputResponse);
        List jsonValueList = js2.getList(keylist);
        return jsonValueList;

    }

    public boolean isStringOnlyAlphabet(String str)
    {

        return ((str != null) && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }

    public boolean isStringOnlyDate(String str)
    {

        return str.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})");
    }

    public boolean isStringOnlyDigits(String str)
    {

        return str.matches("[0-9]+" );
    }






//    public static String getGlobalValue(String key) throws IOException
//    {
//        Properties prop =new Properties();
//
//        String path =System.getProperty("user.dir");
//
//        String end="/src/test/java/resources/global.properties";
//
//        String fullPath =path.concat(end);
//        //FileInputStream fis =new FileInputStream("/Users/snagarajan/Desktop/ApiTestAutomation/APIFramework/src/test/java/resources/global.properties");
//        FileInputStream fis =new FileInputStream(fullPath);
//        prop.load(fis);
//        return prop.getProperty(key);
//
//    }
}
