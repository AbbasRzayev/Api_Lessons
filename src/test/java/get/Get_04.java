package get;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get_04 {

    @Test
    public void get04() {
  /*
   Given
       https://jsonplaceholder.typicode.com/todos
   When
  I send a GET request to the Url
And
    Accept type is "application/json"
Then
    HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    There should be 200 todos
And
    "quis eius est sint explicabo" should be one of the todos title
And
    2, 7, and 9 should be among the userIds
*/

        // 1- Set the url
        String url="/todos";

        // 2- Set the expected data

        // 3- Send the request and get the response
        given();



    }
}
