package tests.api;

import dto.AllContactsDTO;
import dto.ContactDTOLombok;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllContactsTests extends BaseTestAPI{


    @Test(description = "positive get all contacts test")
    public void getAllContactsTest() {
        AllContactsDTO allContactsDTO = given()
                .header(AUTH,token)
                .when()
                .get(ENDPOINT_CONTACTS)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactsDTO.class);
        System.out.println(allContactsDTO.getContacts().get(0).getId());
        List<ContactDTOLombok> allContacts = allContactsDTO.getContacts();
        for(ContactDTOLombok contact : allContacts) {
            System.out.println("id: "+ contact.getId() +
                    " name: " + contact.getName());
        }
    }
    @Test(description = "negative get all contacts test invalid endpoint")
    public void getAllContactsInvalidEndpoint() {
        given()
                .header(AUTH,token)
                .when()
                .get("/contact")
                .then()
                .assertThat().statusCode(403);
    }

}
