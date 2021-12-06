package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestExamples {

    @Test
    public void firstTest() {
        Response response = RestAssured.get("https://reqres.in/api/users");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
    }

}
