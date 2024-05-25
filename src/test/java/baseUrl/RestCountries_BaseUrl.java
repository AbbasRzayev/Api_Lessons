package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class RestCountries_BaseUrl {


    protected RequestSpecification specRestCountries;

    @BeforeClass
    public void setup(){
        specRestCountries=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("https://restcountries.com/v3.1").build();


    }
}
