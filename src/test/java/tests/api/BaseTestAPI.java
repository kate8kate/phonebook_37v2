package tests.api;

import dto.UserDTOLombok;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class BaseTestAPI {
    public static final String ENDPOINT_LOGIN = "/user/login/usernamepassword";
    public static final String ENDPOINT_CONTACTS = "/contacts";

    UserDTOLombok userAPI = UserDTOLombok.builder()
            .username("jbgjg@lkngb.com")
            .password("Qwerty123!")
            .build();
    public static final String TOKEN1 = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiamJnamdAbGtuZ2IuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MTU5Mjk4MDYsImlhdCI6MTcxNTMyOTgwNn0.s_km-lgcl20uoG7z3HSDB-Z3xTAsFDmiS5q6aleozLQ";
    public String token = "";
    public static final String AUTH = "Authorization";
    @BeforeSuite
    public void initAPI() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "/v1";
        token = requestLoginApi(userAPI).then().extract().path("token");
    }
    public Response requestLoginApi(UserDTOLombok user) {
        return given()
                .body(userAPI)
                .when()
                .post(ENDPOINT_LOGIN);
    }
}
