package get;

import baseUrl.ReqresBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get_09_PathParams extends ReqresBaseUrl {


    @Test
    public void testName() {
 /*
        Given
            https://reqres.in/api/users/5
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "application/json; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
       And
            email should be "charles.morris@reqres.in",
       And
            text should be "To keep ReqRes free, contributions towards server costs are appreciated!"
     */


        //1- set the url --ENDPOINT OLUSTURACAGIM--
        specReqres.pathParams("path1","users","path2",5);

        //2- set the expected data

        //3- send the request and get the response
        Response response =given(specReqres).get("{path1}/{path2}");
        response.prettyPrint();

        //4-do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .body("data.email", equalTo("charles.morris@reqres.in"),
                        "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")
                        );

        ;
    }
}
