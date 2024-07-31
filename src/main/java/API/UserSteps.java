package API;

import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;

public class UserSteps {
    private static final String CREATE_ENDPOINT = "/api/auth/register";
    private static final String DELETE_ENDPOINT = "/api/auth/user";

    public Response sendPostRequestAuthRegister(User userCreate) {
        Response response = given()
                .header("Content-Type", "application/json; charset=utf-8")
                .body(userCreate)
                .when()
                .post(CREATE_ENDPOINT);

        return response;
    }

    public Response sendDeleteRequestAuthUser(String token) {
        Response response = given()
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Authorization", token)
                .when()
                .delete(DELETE_ENDPOINT);

        return response;
    }


}
