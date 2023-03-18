package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class InitUsers implements CommandLineRunner {

    private final UserService userService;
    private final EntityManager em;
    private final RoleService roleService;
    @Autowired
    public InitUsers(UserService userService, RoleService roleService, EntityManager em) {
        this.userService = userService;
        this.roleService = roleService;
        this.em = em;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Role ROLE_USER = new Role("ROLE_USER");
        roleService.addRole(ROLE_USER);
        Role ROLE_ADMIN = new Role("ROLE_ADMIN");
        roleService.addRole(ROLE_ADMIN);
        User user = new User();
        user.setName("UserName");
        user.setSurname("UserSurname");
        user.setUsername("user");
        user.setPassword("user");
        user.setRoles(new HashSet<>(Arrays.asList(ROLE_USER)));
        userService.addUser(user);
        User admin = new User();
        admin.setName("AdminName");
        admin.setSurname("AdminSurname");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRoles(new HashSet<>(Arrays.asList(ROLE_USER, ROLE_ADMIN)));
        userService.addUser(admin);
        User admin1 = new User();
        admin1.setName("AdminName1");
        admin1.setSurname("AdminSurname1");
        admin1.setUsername("admin1");
        admin1.setPassword("admin1");
        admin1.setRoles(new HashSet<>(Arrays.asList(ROLE_USER, ROLE_ADMIN)));
        userService.addUser(admin1);
    }
}
