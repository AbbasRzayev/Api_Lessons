package get;


import baseUrl.JsonPlaseHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;

public class Get_11QueryParam_JsonPath_GetList_Assertion extends JsonPlaseHolderBaseUrl {
   /*
      Given
          https://jsonplaceholder.typicode.com/posts/3/comments
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be “application/json”
And
    “email” is “Veronica_Goodwin@timmothy.net”,
And
    “name” is "fugit labore quia mollitia quas deserunt nostrum sunt"
And
    “postId” is 3
And
    “id” is 15
   */

    @Test
    public void testName() {
        //1- set url
        spec.pathParams("first", "posts", "second", 3, "third", "comments");

        //2- set the expected data

        //3- send the request and get the response
        Response response =given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        //4- do assertion
        //1. yol soft assertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                //.contentType("application/json")
                .body("email" , hasItem("Veronica_Goodwin@timmothy.net"),
                        "name", hasItem("fugit labore quia mollitia quas deserunt nostrum sunt"),
                        "postId", hasItem(3),
                        "id", hasItem(15));

        //2.yol JsonPath ve Junit ile
        JsonPath jsonPath=response.jsonPath();
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        assertEquals("Veronica_Goodwin@timmothy.net", jsonPath.getString("email.get(0)"));
        assertEquals("fugit labore quia mollitia quas deserunt nostrum sunt", jsonPath.getString("name.get(0)"));
        assertEquals(3, jsonPath.getInt("postId.get(0)"));
        assertEquals(15, jsonPath.getInt("id.get(4)"));

        //3.yol
        List<Integer> postIds=jsonPath.getList("postId");
        System.out.println("postIds = " + postIds);
        assertEquals(3, postIds.get(3).intValue());

        List<Integer> idS=jsonPath.getList("id");
        System.out.println("idS = " + idS);
        assertEquals(15, idS.get(4).intValue());

        List<String> nameS=jsonPath.getList("name");
        System.out.println("nameS = " + nameS);
        assertEquals("fugit labore quia mollitia quas deserunt nostrum sunt", nameS.get(0));

        List<String> emailS=jsonPath.getList("email");
        System.out.println("emailS = " + emailS);
        assertEquals("Veronica_Goodwin@timmothy.net", emailS.get(0));

        List<String> bodyS=jsonPath.getList("body");
        System.out.println("bodyS = " + bodyS);
        assertEquals("ut dolorum nostrum id quia aut est\nfuga est inventore vel eligendi explicabo quis consectetur\naut occaecati repellat id natus quo est\nut blanditiis quia ut vel ut maiores ea",
                bodyS.get(0));

    }


    @Test
    public void name() {
    /*
Given
    https://jsonplaceholder.typicode.com/posts/3/comments?name=fugit labore quia mollitia quas deserunt nostrum sunt
When
    User send GET Request to the URL
Then
    HTTP Status Code should be 200
And
    Response format should be “application/json”
And
    "postId" is 3,
And
    "id" is 11,
And
    “name” is "fugit labore quia mollitia quas deserunt nostrum sunt"
And
   "email" is “Veronica_Goodwin@timmothy.net”,
And
    “body” is "ut dolorum nostrum id quia aut est\nfuga est inventore vel eligendi explicabo quis consectetur\naut occaecati repellat id natus quo est\nut blanditiis quia ut vel ut maiores ea"
   */

        //1- set the url
        spec.pathParams("p1", "posts", "p2", 3, "p3","comments")
                .queryParam("name", "fugit labore quia mollitia quas deserunt nostrum sunt");

        //2- set the expected data

        //3- send the request and get the response
        Response response= given(spec).get("{p1}/{p2}/{p3}");
        response.prettyPrint();

        //4- do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("postId", equalTo(3),
                        "id", equalTo( 11),
                        "name",  equalTo("fugit labore quia mollitia quas deserunt nostrum sunt"),
                        "email", equalTo("Veronica_Goodwin@timmothy.net"),
                        "body", equalTo("ut dolorum nostrum id quia aut est\nfuga est inventore vel eligendi explicabo quis consectetur\naut occaecati repellat id natus quo est\nut blanditiis quia ut vel ut maiores ea"));



    }
}
