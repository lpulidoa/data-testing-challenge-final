package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "employee")
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "idEmployee", nullable = false)
    private int id;

    @Column(name = "firstName", length = 45, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 45, nullable = false)
    private String lastName;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Column(name = "phoneNumber", length = 45, nullable = false)
    private String phone;

    @Column(name = "address", length = 45)
    private String address;

    @Column(name = "Salary", nullable = false)
    private String salary;

    @Column(name = "birthDate", nullable = false)
    private Date birth;

    @ManyToOne
    @JoinColumn(name = "idCompany", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "idInstitution", nullable = false)
    private Institution institution;


    private Employee(int id, String firstName, String lastName, String email, String phone, String address, Date birth,
                     String salary, Company company, Institution institution) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.birth = birth;
        this.company = company;
        this.institution = institution;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
