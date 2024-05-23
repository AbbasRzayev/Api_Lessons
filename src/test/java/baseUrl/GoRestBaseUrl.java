package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class GoRestBaseUrl {

    protected RequestSpecification specification;

    @BeforeMethod
    public void setup(){
        specification=new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/v2")
                .build();


    }



}
