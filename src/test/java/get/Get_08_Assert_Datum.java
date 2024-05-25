package get;


import baseUrl.JsonPlaseHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;

public class Get_08_Assert_Datum extends JsonPlaseHolderBaseUrl {
 /*
        Given
            https://jsonplaceholder.typicode.com/users
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "application/json"
        And
            Status Line should be HTTP/1.1 200 OK
        And
            name should be "Leanne Graham"
        And
            email should be "Sincere@april.biz"
        And
            city should be "Gwenborough"
        And
            company names should be "Romaguera-Crona", "Deckow-Crist"
     */
//baseurl'den importu alabilmesi icin junitten yaptım
    //cunku baseurl @Before notasyonu Junit'ten
    @Test
    public void testName() {

        //1- set the url
        spec.pathParam("path1","users");

        //2- set the expected data

        //3- send the request and get the response
        Response response =given(spec).get("{path1}");
        response.prettyPrint();

        //4- do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK")
                .body("name", hasItem("Leanne Graham"), //hasItem ile tek bir data dogrulanir
                        "name", hasItems("Clementina DuBuque", "Glenna Reichert"),//hasItems ile coklu data dogrulanir
                        "email", hasItem("Sincere@april.biz"),
                        "email", hasItems("Chaim_McDermott@dana.io","Sincere@april.biz"),
                        "address.city", hasItem("Gwenborough"),
                        "address.city", hasItems("Bartholomebury","Gwenborough"),
                        "company.name", hasItem("Romaguera-Jacobson"),
                        "company.name", hasItems("Romaguera-Crona", "Deckow-Crist")
                        );


    }
}
