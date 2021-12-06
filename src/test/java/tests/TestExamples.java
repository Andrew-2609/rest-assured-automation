package tests;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TestExamples {

    @Test
    public void firstTest() {
        Response response = get("https://reqres.in/api/users");

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("Content-Type"));

        int statusCode = response.statusCode();

        assertEquals(statusCode, 200);
    }

    @Test
    public void secondTest() {
        baseURI = "https://reqres.in/api";

        given().get("/users?page=1")
                .then().statusCode(200).body("data[1].id", equalTo(2))
        ;
    }

}
