package com.example.equipment.entity;

import com.example.equipment.security.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;
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

    @ElementCollection(targetClass = UserRole.class)
    @CollectionTable(name = "user_role_mapping", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Order> orders;


    public List<String> getRoles() {
        return roles.stream()
                .map(UserRole::name)
                .collect(Collectors.toList());
    }
}
