package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaseHolderBaseUrl {

    String baseUrl ="https://jsonplaceholder.typicode.com";

protected RequestSpecification spec;

  @Before //Anatosyon JUnitten oldugu icin TEst metodu da JUnit den olmali
    public void setup(){
      spec=new RequestSpecBuilder().setContentType(ContentType.JSON)
              .setAccept(ContentType.JSON).setBaseUri(baseUrl).build();
  }

}
