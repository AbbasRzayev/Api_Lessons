package get;

import baseUrl.RestCountries_BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Get_10_PathParams_Groovy_Language extends RestCountries_BaseUrl {
     /*
            Given
                https://restcountries.com/v3.1/lang/turkish
            When
                User sends a GET Request to the url
            Then
                HTTP Status Code should be 200
            And
                Content Type should be "application/json"
           And
                official name should be "Republic of Turkey",
           And
                capital should be "Ankara"
           And
                region should be "Asia"
           And
                continents should be "Europe", "Asia"

         */

    @Test
    public void testName() {
        //1- set the url
        specRestCountries.pathParams("first", "lang", "second", "turkish");

        //2- set the expected data

        //3-send the request and get the response
        Response response =given(specRestCountries).get("{first}/{second}");
        response.prettyPrint();

        //4-do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json")
               // .body("name.official", equalTo("Republic of Turkey")); Actual: <[Republic of Cyprus, Republic of Turkey]> oldugu icin equalTo kullanamayız
                .body("name.official", hasItems("Republic of Turkey"));




    }
}
