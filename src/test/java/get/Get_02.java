package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get_02 {
    /*
   Given
       https://restful-booker.herokuapp.com/booking/0
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "Bob"
   And
       Server is "Cowboy"
*/

    @Test
    public void get02() {

        // 1- Set the url
        String url="https://restful-booker.herokuapp.com/booking/0";

        // 2- Set the expected data BU KISMI GET İŞLEMİNDE YAPMIYORUZ

        // 3-Send the request and get the response
                Response response=given().get(url);
               response.prettyPrint();

        // 4- Do assertion
        int statusCode=404;
        String statusLine="HTTP/1.1 404 Not Found";
        response.then() //then ile assertion başlıyor
                .statusCode(statusCode)
                .statusLine(statusLine);


        String expectedBody="Not Found";
        assertTrue(response.asString().contains(expectedBody));

        String expectedName="Bob";
        assertFalse(response.asString().contains(expectedName));

        String expectedServer= "Cowboy";
        String actualServer=response.header("Server");
        assertEquals(expectedServer, actualServer);



    }
}
