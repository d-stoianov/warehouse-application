package warehouse.model.common;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ContactInfo {
    private String fullName;
    private String phoneNumber;
    private String email;

    public ContactInfo() {
    }

    public ContactInfo(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ContactInfo that)) return false;
        return Objects.equals(fullName, that.fullName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phoneNumber, email);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
