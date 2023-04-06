package APITesting;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class TC_002 {

    @Test
    public void CreatePost(){

        String body="{\n" +
                "\t\"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}";

        given().baseUri("https://jsonplaceholder.typicode.com/")
                .header("Content-Type","application/json")
                .body(body).log().all()
                .when().post("posts")
                .then().log().all()
                .assertThat().statusCode(201).body("id",equalTo(101));

    }
}
