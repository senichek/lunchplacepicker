package com.olexiy.lunchplacepicker.repository;

import com.olexiy.lunchplacepicker.models.LikeOfMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LikeOfMenuRepo extends JpaRepository<LikeOfMenu, Integer> {
    LikeOfMenu getById(Integer id);

    void deleteById(Integer id);

    List<LikeOfMenu> getAllByMenu_Id(int id);

    LikeOfMenu getByUserIDAndAndMenuId(int userID, int menuID);
}