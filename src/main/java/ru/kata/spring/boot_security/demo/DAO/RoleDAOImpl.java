package ru.kata.spring.boot_security.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

//    @PersistenceContext
    @Autowired
    private EntityManager entityManager;


    @Override
    public boolean add(Role role) {
        entityManager.persist(role);
        return true;
    }
    @Override
    public List<Role> getList() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRole(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void deleteRole(long id) {
        entityManager.remove(getRole(id));
    }

    @Override
    public void editRole(Role role) {
        entityManager.merge(role);
    }

//    @Override
//    public List<Role> getRoleList() {
//        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
//    }
//
//    @Override
//    public Role getRole(long id) {
//        return entityManager.find(Role.class, id);
//    }
//
//
//    @Override
//    public Role findByName(String name) {
//
//        return entityManager.createQuery("SELECT u FROM Role u WHERE u.user.roles = :id", Role.class)
//                .setParameter("id", name)
//                .getResultList().stream().findAny().orElse(null);
//    }
//
//    @Override
//    public List<Role> listByName(List<String> name) {
//        return entityManager.createQuery("SELECT u FROM Role u WHERE u.user.roles in (:id)", Role.class)
//                .setParameter("id", name)
//                .getResultList();
//    }
}


