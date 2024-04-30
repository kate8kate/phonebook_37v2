package helpers;

import dto.ContactDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    By getAllContactsNames = By.xpath("//div[contains(@class,'contact-item_card')]/h2");
    By btnRemoveContact = By.xpath("//button[text()='Remove']");

    public void clickAddOnNavBar() {
        driver.findElement(By.xpath("//a[@href='/add']")).click();
    }

    public void addContact(ContactDTO contactDTO) {
        fillNameOnAddContact(contactDTO.getName());
        fillLastNameOnAddContact(contactDTO.getLastName());
        fillPhoneAddContact(contactDTO.getPhone());
        fillEmailAddContact(contactDTO.getEmail());
        fillAddressAddContact(contactDTO.getAddress());
        fillDescriptionAddContact(contactDTO.getDescription());
        clickAddContact();
    }

    public void fillNameOnAddContact(String name) {
        typeText(name, By.xpath("//input[@placeholder='Name']"));
    }

    public void fillLastNameOnAddContact(String lastName) {
        typeText(lastName, By.xpath("//input[@placeholder='Last Name']"));
    }
    public void fillPhoneAddContact(String phone) {
        typeText(phone, By.xpath("//input[@placeholder='Phone']"));
    }
    public void fillEmailAddContact(String email) {
        typeText(email, By.xpath("//input[@placeholder='email']"));
    }
    public void fillAddressAddContact(String address) {
        typeText(address,By.xpath("//input[@placeholder='Address']"));
    }

    public void fillDescriptionAddContact(String description) {
        typeText(description, By.xpath("//input[@placeholder='description']"));
    }
    public void clickAddContact() {
        driver.findElement(By.xpath("//div[contains(@class,'add_form')]//button")).click();
    }
    public boolean isContactDisplaysOnThePage(String phone) {
        List<WebElement> allPhones = driver.findElements(By
                .xpath("//div[contains(@class,'contact-item_card')]//h3"));
        boolean res = false;
        for(WebElement el:allPhones) {
            if(getTextBaseByElement(el).equals(phone)) {
                res = true;
                break;
            }
        }
        return res;
    }

    public void deleteContactByName(String name) {
        // find all names of our contacts:
        // div[contains(@class,'contact-item_card')]/h2
        List<WebElement> allContactsNames = findElementsBase(getAllContactsNames);
        // find our contact
        if(!allContactsNames.isEmpty()) {
            for (WebElement el : allContactsNames) {
                if(getTextBaseByElement(el).equals(name)) {
                    // click on our contact
                    // click //button[text()='Remove']
                    clickBaseByElement(el);
                    clickBase(btnRemoveContact);
                }
            }
        } else {
            System.out.println("list is empty");
        }
    }
    public boolean isContactByNameExist(String name) {
        // return true, if contact by name exist
        boolean flag = false;
        List<WebElement> allContactNames = findElementsBase(getAllContactsNames);
        if(!allContactNames.isEmpty()) {
            for (WebElement el : allContactNames) {
                if(getTextBaseByElement(el).equals(name)) {
                    flag = true;
                    return flag;
                }
            }
        } else {
            System.out.println("list is empty");
            return false;
        }
        return flag;
    }
    public void deleteAllContacts() {

        while(!findElementsBase(getAllContactsNames).isEmpty())
        {
            WebElement element = findElementBase(getAllContactsNames);
            clickBaseByElement(element);
            clickBase(btnRemoveContact);
            pause(1500);
        }

//        List<WebElement> allContactsNames = findElementsBase(getAllContactsNames);
//        // find our contact
//        if(!allContactsNames.isEmpty()) {
//            /*
//            list {1,2,3,4,5,6,7}
//            1-r
//            {2,3,4,5,6,7}
//             */
//            for (WebElement el : allContactsNames) {
//                    // click on our contact
//                    // click //button[text()='Remove']
//                    pause(1500);
//                    clickBaseByElement(el);
//                    clickBase(btnRemoveContact);
//            }
//        } else {
//            System.out.println("list is empty");
//        }
    }

    public boolean isContactListEmpty() {
        List<WebElement> allContactsNames = findElementsBase(getAllContactsNames);
        return allContactsNames.isEmpty();
    }
}
