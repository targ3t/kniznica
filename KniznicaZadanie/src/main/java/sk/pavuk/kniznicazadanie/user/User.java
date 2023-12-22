package sk.pavuk.kniznicazadanie.user;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "user_sequence"
    )
    private Integer userId;
    private String email;
    private String heslo;
    private String role;

    public User() {
    }

    public User(Integer userId, String email, String heslo, String role) {
        this.userId = userId;
        this.email = email;
        this.heslo = heslo;
        this.role = role;
    }

    public User(String email, String heslo, String role) {
        this.email = email;
        this.heslo = heslo;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", heslo='" + heslo + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
