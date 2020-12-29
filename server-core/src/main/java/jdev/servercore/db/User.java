package jdev.servercore.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "name")
    String name;

    @Column(name = "role")
    String role;

    @Override
    public String toString() {
        return "User{" +
                ", user='" + name +
                ", role='" + role +
                "'}";
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {return role;}
    public void setRole(String role) {
        this.role = role;
    }

    public User(){}
    public User(String name, String role){
        this.name = name;
        this.role = role;
    }
}
