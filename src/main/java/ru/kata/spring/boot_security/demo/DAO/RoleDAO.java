package ru.kata.spring.boot_security.demo.DAO;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDAO {

    boolean add(Role user);

//    List<Role> getRoleList();

    Role getRole(long id);
//
//    Role findByName(String name);
//
//    List<Role> listByName(List<String> name);

    List<Role> getList();

    void deleteRole(long id);

    void editRole(Role role);
}
