package tests.api;

import dto.UserDTOLombok;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTestAPI {
    UserDTOLombok userAPI = UserDTOLombok.builder()
            .username("jbgjg@lkngb.com")
            .password("Qwerty123!")
            .build();
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiamJnamdAbGtuZ2IuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MTU5Mjk4MDYsImlhdCI6MTcxNTMyOTgwNn0.s_km-lgcl20uoG7z3HSDB-Z3xTAsFDmiS5q6aleozLQ";
    public static final String AUTH = "Authorization";
    @BeforeSuite
    public void initAPI() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "/v1";
    }
}
