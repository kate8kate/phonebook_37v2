package dto;

public class ContactDTO {
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String description;

    public ContactDTO() {
    }

    public String getName() {
        return name;
    }

    public ContactDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ContactDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ContactDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}