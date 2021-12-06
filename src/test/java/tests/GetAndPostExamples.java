package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

@SuppressWarnings("NewClassNamingConvention")
public class GetAndPostExamples {

    @Test
    public void getTest() {
        baseURI = "https://reqres.in/api";

        given().get("/users?page=1")
                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("Charles"))
                .body("data.first_name", hasItems("George", "Janet"))
        ;
    }

}
