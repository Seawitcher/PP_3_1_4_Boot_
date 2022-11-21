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
        public void createTable () {
            roleService.add(new Role(1, "ADMIN"));
            roleService.add(new Role(2, "USER"));
            Set<Role> setRole = new HashSet<>();
            setRole.add(roleService.getRole(1));
            User user1 = new User(1, "Alex", "Zer", 20,
                    "sea@yan.ru", "$2a$12$nNj251hCDwafhk/uGw2Wtehm7whW7QWOx6rdmxLKliLl5X8QbUSC.");
            user1.setRoles(setRole);
            userService.add(user1);
        }
    }
