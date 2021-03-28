package com.olexiy.lunchplacepicker.service.like;

import com.olexiy.lunchplacepicker.models.LikeOfMenu;

import java.util.List;

public interface LikeOfMenuService {

    LikeOfMenu getById(Integer id);

    void deleteById(Integer id);

    LikeOfMenu save(LikeOfMenu likeOfMenu);

    List<LikeOfMenu> getAllByMenuID(int id);

    LikeOfMenu getByUserIDAndAndMenuId(int userID, int menuID);
}