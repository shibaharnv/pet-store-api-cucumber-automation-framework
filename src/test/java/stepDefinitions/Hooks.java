package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;
import resources.TestDataBuild;

public class Hooks {

    public  static String firstName = "";
    public  static String lastName = "";

    public static String checkInDate="";

    public static String checkOutDate="";


    @Before("@UpdatePetwithPayload or @PetGetAndDelete")
    public void beforeScenario() throws IOException

    {
        // this code will be executed only when pet id is null

        StepDefinition m =new StepDefinition();

        if(StepDefinition.petID==null)
        {
            m.setting_up_the_request_sepecification_for_create_pet_with_payload();
            m.the_user_hits_the_pet_payload_endpoint_with("POST");
            m.store_the_pet_id_from_the_response_body();

        }

    }



}