package com.olexiy.lunchplacepicker.service.like;


import com.olexiy.lunchplacepicker.models.Like;

import java.util.List;

public interface LikeService {

    Like getById(Integer id);

    void deleteById(Integer id);

    Like save(Like like);

    List<Like> getAllByMenuID(int id);

    Like getByUserIDAndAndMenuId(int userID, int menuID);
}