package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class ReqresBaseUrl {

    protected RequestSpecification specReqres;

    @BeforeMethod
    public void setup(){
        specReqres =new RequestSpecBuilder()
                .setContentType(ContentType.JSON) //giden yani request JSon formatinda olsun
                .setAccept(ContentType.JSON)  //gelen yani response JSon formatinda olsun
                .setBaseUri("https://reqres.in/api").build();
    }

}
