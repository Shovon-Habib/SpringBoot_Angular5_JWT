package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Role {

    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
