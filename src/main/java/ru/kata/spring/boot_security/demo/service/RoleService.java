package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface RoleService  {

    public boolean add(Role role);
    public List<Role> getList();
    public Role getRole(long id);
    public void deleteRole(long id);
    public void editRole(Role role);

    @Transactional
    List<Role> listByRole(List<String> name);
}
