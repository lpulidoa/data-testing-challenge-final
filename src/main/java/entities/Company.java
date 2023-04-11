package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="company")
@Table(name="company")
public class Company {

    @Id
    @Column(name = "idCompany",nullable = false)
    private int id;

    @Column(name = "coName", nullable = false,length = 45)
    private String name;

    @Column(name = "phoneNumber",nullable = false,length = 45)
    private String phoneNumber;

    @Column(name = "email",nullable = false,length = 45)
    private String email;

    @Column(name = "address",length = 45)
    private String address;

    public Company() {
    }

    public Company(int id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
