package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamplesTest {

    @Test
    public void putTest() {
        JSONObject request = new JSONObject();
        request.put("name", "Keivyla");
        request.put("job", "Medic");

        baseURI = "https://reqres.in/api";

        given().body(request.toString())
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .put("/users/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Keivyla"))
                .body("job", equalTo("Medic"))
                .body("updatedAt", is(not(empty())))
        ;
    }

}
