package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

@SuppressWarnings("NewClassNamingConvention")
public class GetAndPostExamples {

    @Test
    public void getTest() {
        baseURI = "https://reqres.in/api";

        given().get("/users?page=1")
                .then().statusCode(200);
    }

}
