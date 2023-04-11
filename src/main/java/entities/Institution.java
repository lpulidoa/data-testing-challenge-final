package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="institution")
@Table(name="institution")
public class Institution {

    @Id
    @Column(name = "idInstitution",nullable = false)
    private int id;

    @Column(name = "instName", nullable = false,length = 45)
    private String name;

    @Column(name = "phoneNumber",nullable = false,length = 45)
    private String phone;

    @Column(name = "email",nullable = false,length = 45)
    private String email;

    public Institution() {
    }

    public Institution(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


