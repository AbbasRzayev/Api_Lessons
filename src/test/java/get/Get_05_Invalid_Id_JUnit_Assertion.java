package get;

import baseUrl.HerokuAppBaseUrl;
import baseUrl.JsonPlaseHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get_05_Invalid_Id_JUnit_Assertion extends JsonPlaseHolderBaseUrl {
       /*
    https://jsonplaceholder.typicode.com/todos/0
    User send GET Request to the URL
    Response format should be “application/json”
    HTTP Status Code should be 404
    todos should be empty
     */

    @Test //BaseUrl icindeki metot Junit anatosyonlu oldugu icin Test metodu da JUnit ten import edildi
    public void negativeTest() {
        //1- set the url
        spec.pathParams("first", "todos", "second",0);

        //2- set the expected data

        //3- Send the request and get the response
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();

        //4- Do assertion
        response.then()
                .statusCode(404)
                .contentType("application/json");

        assertTrue(response.asString().contains(""));


    }


}
