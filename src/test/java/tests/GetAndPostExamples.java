package tests;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
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

    @Test
    public void postTest() {
        JSONObject request = new JSONObject();
        request.put("name", "Andrew");
        request.put("job", "Automation Tester");

        baseURI = "https://reqres.in/api";

        given().body(request.toString())
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all()
        ;
    }

}
