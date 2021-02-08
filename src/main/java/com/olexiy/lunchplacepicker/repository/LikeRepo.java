package com.olexiy.lunchplacepicker.repository;

import com.olexiy.lunchplacepicker.models.Like;
import com.olexiy.lunchplacepicker.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LikeRepo extends JpaRepository<Like, Integer> {
    Like getById(Integer id);

    void deleteById(Integer id);
}
