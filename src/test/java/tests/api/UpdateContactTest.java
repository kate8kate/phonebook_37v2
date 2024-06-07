package tests.api;

import dto.AllContactsDTO;
import dto.ContactDTOLombok;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import static io.restassured.RestAssured.given;

public class UpdateContactTest extends BaseTestAPI{
    String id = "";
    String oldEmail = "";
    ContactDTOLombok contactDTOLombok = null;
    ContactDTOLombok updatedContact = null;
    @BeforeMethod
    public void precondition() {
        Random random = new Random();
        String name = "John" + String.valueOf(random.nextInt(1000));
        String phone = String.valueOf(random.nextInt(1000,10000)) +"456789";

        contactDTOLombok = ContactDTOLombok.builder()
                .name(name)
                .lastName("Smith")
                .email("some@mail.com")
                .phone(phone)  //"0123456789"
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
        System.out.println("add contact: " + message);
        String[] str = message.split(":");
        id = str[1].trim();
        System.out.println(id);
    }

    @Test
    public void updateContactTest() {
        contactDTOLombok.setId(id);
        contactDTOLombok.setEmail("new@mail.com");
        String message = given()
                .header(AUTH, token)
                .body(contactDTOLombok)
                .contentType(ContentType.JSON)
                .put("/contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().path("message");
        System.out.println("message for upd contact: " + message);

        AllContactsDTO allContactsDTO = given()
                .header(AUTH,token)
                .when()
                .get(ENDPOINT_CONTACTS)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactsDTO.class);

        List<ContactDTOLombok> allContacts = allContactsDTO.getContacts();
        for(ContactDTOLombok contact : allContacts) {
            if (contact.getId().equals(id)) {
                oldEmail = contact.getEmail();
                System.out.println("Old mail "+ oldEmail);
                updatedContact = contact;
                System.out.println("Updated contact" + contact);
            }
        }
        Assert.assertEquals(oldEmail, contactDTOLombok.getEmail(), "Email doesn't match");
    }
}
