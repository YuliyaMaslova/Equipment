package com.example.equipment.entity;

import com.example.equipment.security.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String login;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<UserRole> roles;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Order> orders;


    public List<String> getRoles() {
        return roles.stream()
                .map(UserRole::name)
                .collect(Collectors.toList());
    }
}
