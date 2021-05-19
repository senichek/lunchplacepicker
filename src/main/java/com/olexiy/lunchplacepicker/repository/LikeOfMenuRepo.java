package com.olexiy.lunchplacepicker.repository;

import com.olexiy.lunchplacepicker.models.LikeOfMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LikeOfMenuRepo extends JpaRepository<LikeOfMenu, Integer> {
    LikeOfMenu getLikeOfMenuById(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM LikeOfMenu l WHERE l.id=:id")
    void deleteById(Integer id);

    List<LikeOfMenu> getAllByMenu_Id(int id);

    LikeOfMenu getByUserIDAndAndMenuId(int userID, int menuID);

    LikeOfMenu getByUserID(Integer id);
}