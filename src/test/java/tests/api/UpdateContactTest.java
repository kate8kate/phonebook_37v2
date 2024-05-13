package tests.api;

import dto.ContactDTOLombok;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class UpdateContactTest extends BaseTestAPI{
@Test(description = "positive update contact test")
    public void updateContactTest() {
    Random random = new Random();
    String name = "John" + String.valueOf(random.nextInt(1000));
    String phone = String.valueOf(random.nextInt(1000, 10000)) + "456789";

    ContactDTOLombok contactDTOLombok = ContactDTOLombok.builder()
            .name(name)
            .lastName("Smith")
            .email("some@mail.com")
            .phone(phone) //0123456789
            .address("street")
            .description("first")
            .build();

    String message = given()
            .header(AUTH, token)
            .body(contactDTOLombok)
            .contentType(ContentType.JSON)
            .post(ENDPOINT_CONTACTS)
            .then()
            .assertThat().statusCode(200)
            .extract().path("message");
    String[] str = message.split(":");
    String id = str[1].trim();

    String updateEmail = "new@mail.com";

        given()
                .header(AUTH,token)
                .contentType(ContentType.JSON)
                .body("email: "+ updateEmail)
                .put(ENDPOINT_CONTACTS + "/" + id)
                .then()
                .assertThat().statusCode(200);

}

}
