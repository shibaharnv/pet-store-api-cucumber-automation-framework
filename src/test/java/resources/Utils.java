package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.io.*;
import java.util.List;
import java.util.Properties;


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


    public List getJsonPathList(String inputResponse, String keylist) {
        JsonPath js2 = new JsonPath(inputResponse);
        List jsonValueList = js2.getList(keylist);
        return jsonValueList;

    }

}
