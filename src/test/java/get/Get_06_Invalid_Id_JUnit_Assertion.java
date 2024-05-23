package get;

import baseUrl.HerokuAppBaseUrl;
import baseUrl.JsonPlaseHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get_06_Invalid_Id_JUnit_Assertion extends HerokuAppBaseUrl{

    @Test
    public void negativeTest2() {
       /*
    https://restful-booker.herokuapp.com/booking/123437
    User send GET Request to the URL
    Response format should be “text/plain”
    HTTP Status Code should be 404
    HTTP Status Line should be "HTTP/1.1 404 Not Found"
    todos should be "Not Found"
     */
        //1- Set the url
         specHeroku.pathParams("a", "booking", "b", 123437);

        //2- set the expected data

        //3- Send the request and get the response
        Response response=given(specHeroku).get("{a}/{b}");
        response.prettyPrint();

        //4- Do assertion
        response.then()
                .statusCode(404)
                .contentType("text/plain")
                .statusLine("HTTP/1.1 404 Not Found");

        String expectedResponse="Not Found";
        assertTrue(response.asString().contains(expectedResponse));

    }
}
