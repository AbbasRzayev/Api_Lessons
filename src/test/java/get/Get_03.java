package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get_03 {

    @Test
    public void get03() {
            /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be “application/json”
And
    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
And
    “completed” is false
And
    “userId” is 2
   */

        // 1- Set the url
        String url="https://jsonplaceholder.typicode.com/todos/23";

        // 2- Set the expected data

        // 3- Send request and get the response
        Response response=given().get(url);
        response.prettyPrint();

        // 4- Do assertion
        int statusCode=200;
        String contentType="application/json";
        String title="et itaque necessitatibus maxime molestiae qui quas velit";
        int userId=2;
        boolean completed=false;

        //1.yol HARD ASSERTION: hata veren satirda kalir. Asagideki kodlari kontrol ETMEZ
        response.then()
                .statusCode(statusCode)
                .contentType(contentType)
                .body("userId", equalTo(userId))
                .body("title", equalTo(title))
                .body("completed",equalTo(completed));

        // 2.yol SOFT ASSERTIN: Butun kodlar kontrol edilir. Butun fail satirlari verilir.
        response.then()
                .statusCode(statusCode)
                .contentType(contentType)
                .body("userId", equalTo(userId),
                        "title", equalTo(title),
                        "completed",equalTo(completed));

    }
}
