package tests;

import dto.ContactDTO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteContactTests extends BaseTest{

    @BeforeClass
    public void preconditions() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().login(user);
    }

    @AfterClass
    public void methodPostCondition() {
        app.getUserHelper().clickLogoutBtn();
        app.getHomePageHelper().navigateToHomePage();
    }

    @Test
    public void deleteOneContactTest() {
//        app.getContactHelper().clickAddOnNavBar();
//        ContactDTO contactDTO = new ContactDTO()
//                .setName("contacttodekate")
//                .setLastName("jfnvjkeg")
//                .setPhone("6544567890")
//                .setEmail("jbgjg@lkngb.com")
//                .setAddress("lsjdfnhwi")
//                .setDescription("jdcnw");
//        app.getContactHelper().addContact(contactDTO);
//        app.getContactHelper().pause(3000);
//        app.getContactHelper().deleteContactByName(contactDTO.getName());
//        app.getContactHelper().pause(3000);
//        Assert.assertFalse(app.getContactHelper()
//                .isContactByNameExist(contactDTO.getName()));
    }

    @Test
    public void deleteAllExistingContacts() {
        app.getContactHelper().deleteAllContacts();
        app.getContactHelper().pause(3000);
        Assert.assertTrue(app.getContactHelper().isContactListEmpty());
    }
}
