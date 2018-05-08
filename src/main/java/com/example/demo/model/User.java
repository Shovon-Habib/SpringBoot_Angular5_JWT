package com.example.demo.model;

import com.example.demo.config.STATUS;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class User {

    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String name;

    @Column(unique=true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private STATUS status;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role")
    private List<Role> roles;

    public User(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }
}
