package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class Init {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void createTable() {

        if (roleService.getList().isEmpty()) {
            Role admin = new Role(1L, "ROLE_ADMIN");
            Role user = new Role(2L, "ROLE_USER");

            roleService.add(admin);
            roleService.add(user);

            Set<Role> roles = new HashSet<>();
            roles.add(admin);

            User newAdmin = new User("ADMIN", "ADMIN", 20, "ADMIN@yan.ru",
                    "$2a$12$Q2qTTtELnCTIiCzofXjSbudGjEoVCndDdMWEWjfi8CvlCs7.2UbYm", roles);
            userService.add(newAdmin);

            System.out.println("hello, I have just create few users: \n" +
                    "username: ADMIN      password: ADMIN ");
        }
    }
}
