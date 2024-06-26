package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get_01 {
           /*
   Given
       https://restful-booker.herokuapp.com/booking/55
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be "application/json"
   And
       Status Line should be "HTTP/1.1 200 OK"
*/

    @Test
    public void get01() {
        // 1- Set the url
        String url="https://restful-booker.herokuapp.com/booking/55";

        // 2- Set the expected data  --> BU KISIM GET İŞLEMLERİNDE OLMAYACAK

        // 3- Send the request and get the response
        Response response= given().get(url);
        response.prettyPrint();

        // 4- Do assertion
        int statusCode=200;
        String statusLine="HTTP/1.1 404 Not Found";
        String contentType="application/json";
        response.then()
                .statusCode(statusCode)
                .contentType(contentType)
                .statusLine(statusLine);





    }
}
