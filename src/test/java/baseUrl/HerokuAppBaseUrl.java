package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public  class HerokuAppBaseUrl {

    String baseUrl ="https://restful-booker.herokuapp.com";

protected RequestSpecification specHeroku;

  @Before //Anatosyon JUnitten oldugu icin TEst metodu da JUnit den olmali
    public void setup(){
      specHeroku=new RequestSpecBuilder()
              .setBaseUri(baseUrl).build();
  }

}
