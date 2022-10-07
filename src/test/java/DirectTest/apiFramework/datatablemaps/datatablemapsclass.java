package DirectTest.apiFramework.datatablemaps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.*;

public class datatablemapsclass {

    @When("I partially Update the booking with the values mentioned below")
    public void i_partially_update_the_booking_with_the_values_mentioned_below(DataTable dataTable) throws IOException {

//        newToken = tokenGeneration();
//        System.out.println(newToken);

        //Check if the partial updates required for Names or price or dates

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        System.out.println(rows);
        System.out.println(rows.toString());
        ArrayList al = new ArrayList();

        for (Map<String, String> s : rows) {
            System.out.println(s);
            System.out.println("entry set " + s.entrySet());
            Set mySet = s.entrySet();
            Iterator itr = mySet.iterator();
            while (itr.hasNext()) {
                Map.Entry entry = (Map.Entry) itr.next();
                System.out.println("key " + entry.getKey() + " value " + entry.getValue());
                if (entry.getKey().toString().contains("firstname")) {
                    //firstName=firstNameValue
                    //secondName=secondNameValue
                    al.add(entry.getKey());
                }
                if (entry.getKey().toString().contains("price")) {
                    al.add(entry.getKey());
                }
            }
            System.out.println("al " + al);
            if (al.contains("price")) {
                System.out.println("Call price Payload");
            }
            if (al.contains("firstname")) {
                System.out.println("call the partial update name payload");
            }
        }


    }





    @When("I UPDATE a bookingsmap")
    public void i_update_a_bookingsmap(DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        ArrayList al = new ArrayList();

        for (Map<String, String> s : rows) {
            System.out.println(s);
            System.out.println("entry set " + s.entrySet());

            Set mySet = s.entrySet();

            Iterator itr = mySet.iterator();

            while (itr.hasNext()) {
                Map.Entry entry = (Map.Entry) itr.next();

                System.out.println("key " + entry.getKey() + " value " + entry.getValue());

                if (entry.getKey().toString().contains("firstname")) {

                    al.add(entry.getKey());
                }

                if (entry.getKey().toString().contains("price")) {

                    al.add(entry.getKey());
                }
            }

            System.out.println("al " + al);

            if (al.contains("price")) {
                System.out.println("Call price Payload");
            }

            if (al.contains("firstname")) {
                System.out.println("call the partial update name payload");
            }
        }

        al.clear();


    }


    @When("I UPDATE a booking")
    public void i_update_a_booking(DataTable dataTable) {
        String firstName = null;
        String lastName = null;
        List<List<String>> dataList = dataTable.asLists(String.class);

        for (List<String> s : dataList) {
            System.out.println(s);
            System.out.println(s.get(0));
            System.out.println(s.get(1));
            firstName = s.get(0);
            lastName = s.get(1);

        }

//        Response response = given().baseUri("https://restful-booker.herokuapp.com")
//                .contentType("application/json")
//                .header("Cookie", "token=" + "9f69d40895e1c60");
                //.body(data.partialUpdateNamesPayload(firstName, lastName))
               // .when();
              //  .patch("/booking/" + bookingID + "").then().log().all().extract().response();


    }

}
