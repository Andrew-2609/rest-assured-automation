package tests;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

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
        given()
                .get("https://reqres.in/api/users")
                .then().statusCode(200);
    }

}
