package get;

import baseUrl.JsonPlaseHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get_04_List_Hard_Assertion extends JsonPlaseHolderBaseUrl {

    @Test //BaseUrl icindeki metot Junit anatosyonlu oldugu icin Test metodu da JUnit ten import edildi
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
And
    completed is false
*/

        // 1- Set the url
        spec.pathParam("first", "todos");

        // 2- Set the expected data

        // 3- Send the request and get the response
        Response response=given(spec).get("{first}");
        response.prettyPrint();

        // Respons icindeki elemanlari saydirip size'ini bulacagim
        JsonPath jsonPath=response.jsonPath();
        List<Object> userIds= jsonPath.getList("userId");
        int expecteTodos=userIds.size();
        System.out.println("userIdCount = " + expecteTodos);

        //4- Do assertion
        //hard assertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId",hasSize(expecteTodos))
                .body("title", hasItem("quis eius est sint explicabo")) //list icindeki tek bir elemani hasItem ile dogrulariz
                .body("userId",hasItems(2, 7, 9) ) //list icindeki birden cok elemani hasItems ile dogrulariz
                .body("completed", hasItem(false));

    }
}
