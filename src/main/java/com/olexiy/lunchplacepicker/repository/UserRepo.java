package com.olexiy.lunchplacepicker.repository;

import com.olexiy.lunchplacepicker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT DISTINCT u FROM User u JOIN FETCH u.roles")
    List<User> getAll();

    @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.roles WHERE u.id=:id")
    User getById(Integer id);

    User getByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    void deleteById(Integer id);

    boolean existsById(Integer id);
}
