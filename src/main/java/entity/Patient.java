package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "patients")
public class Patient extends Person implements Serializable {
    private boolean gerder;
    private String dateOfBirth;
    private String address;

    public Patient() {
    }

    public Patient(String id, String name, String phone, boolean gerder, String dateOfBirth, String address) {
        super(id, name, phone);
        this.gerder = gerder;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public boolean isGerder() {
        return gerder;
    }

    public void setGerder(boolean gerder) {
        this.gerder = gerder;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "gerder=" + gerder +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
