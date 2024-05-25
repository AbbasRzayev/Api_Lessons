package get;

import baseUrl.GoRestBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Get_07_BaseUrl_TestNG extends GoRestBaseUrl {
/*
https://gorest.co.in/public/v2/users
User send GET Request to the URL
    Response format should be “application/json”
    HTTP Status Code should be 200
    name contains "Kamlesh Shah"
    id should be 6919806
    gender should be female

 */

    @Test
    public void testName() {
        //1- Set the url
        specification.pathParam("first","users");

        //2- Set the expected data

        //3- Send the request and get the response
        Response response =given(specification).get("{first}");
        response.prettyPrint();

        //4- Do assertion
        //tekil dogrulama
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", hasItem("Rev. Dhanapati Desai"),
                        "id", hasItem(6927838),
                        "gender", hasItem("female"));

        //coklu data dogrulama
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", hasItems("Chandani Mehra", "Rev. Dhanapati Desai", "Dakshayani Ahluwalia"),
                        "gender", hasItems("male","female"),
                        "email",hasItems("dhanapati_desai_rev@rath-gislason.example","parvati_pres_kaniyar@von-mcglynn.example"),
                        "id",hasItems(6927845, 6927844, 6927843));



    }
}
