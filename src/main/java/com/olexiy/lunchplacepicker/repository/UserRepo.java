package com.olexiy.lunchplacepicker.repository;

import com.olexiy.lunchplacepicker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<User, Integer> {

    //@Query(value = "SELECT new com.olexiy.lunchplacepicker.to.UserTO(u.id, u.name, u.email, u.registered) FROM User u JOIN FETCH u.roles")
   // List<UserTO> getAll();

    User getById(Integer id);

    User getByEmail(String email);

    void deleteById(Integer id);

    boolean existsById(Integer id);
}
