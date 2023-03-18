package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;


public interface RoleService {
    void addRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);
}
