package cucumber.Options;


import utilities.Email;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,features="src/test/java/features",plugin ="json:target/jsonReports/cucumber-report.json",glue= {"stepDefinitions"},tags="@Test")

//CreatePetWithPayload or DeletePetWithId

public class TestRunner {

    @BeforeClass
    public static void setUp(){
        System.out.println("This is set up method.");
    }

    @AfterClass
    public static void tearDown() throws IOException {

        String recipient=System.getProperty("RecipientList");

        Email.emailTrigger(recipient);
    }
}