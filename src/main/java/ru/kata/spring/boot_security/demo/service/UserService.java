package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {



    public void add(User user);
    public List<User> getList();
    public User getUser(Long id);
    public void deleteUser(Long id);
    public void editUser(User user);


    User loadUserByUserEmail(String email)throws UsernameNotFoundException;
}
