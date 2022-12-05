package ru.kata.spring.boot_security.demo.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import ru.kata.spring.boot_security.demo.model.User;


import javax.persistence.EntityManager;


import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getList() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }



    @Override
    public void deleteUser(Long id) {
//        User user = entityManager.find(User.class, id);
//
//// get all books that this author wrote alone
//        Query q = entityManager.createNativeQuery("SELECT ur.role_id FROM user_roles ur JOIN role r ON ur.role_id = r.id JOIN user_roles ur2 ON r.id = ur2.role_id WHERE ur2.role_id = ? GROUP BY ur.role_id HAVING count(ur.user_id) = 1");
//        q.setParameter(1, user.getId());
//        List<Long> role_ids = (List<Long>)q.getResultList();
//
//// remove all associations for this author
//        q = entityManager.createNativeQuery("DELETE FROM user_roles ur WHERE ur.user_id = ?");
//        q.setParameter(1, user.getId());
//        q.executeUpdate();
//
//// remove all books that this author wrote alone
//        q = entityManager.createNativeQuery("DELETE FROM Role r WHERE r.id IN (:ids)");
//        q.setParameter("ids", role_ids);
//        q.executeUpdate();
//
//// remove author
//        q = entityManager.createNativeQuery("DELETE FROM Users u WHERE u.id =:id");
//        q.setParameter("id", user.getId());
//        q.executeUpdate();


        entityManager.createQuery(
                "DELETE User WHERE id = :id").setParameter("id", id).executeUpdate();
//        entityManager.remove(getUser(id));
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public UserDetails getUser(String username) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.name = :username", User.class);

        return query.setParameter("username", username)
               .getSingleResult();


    }
}
