package com.olexiy.lunchplacepicker.service.menu;


import com.olexiy.lunchplacepicker.models.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getAll();

    Menu getByID(Integer id);

    List<Menu> getAllByRestaurantIdWithLikes(Integer id);

    List<Menu> getAllByRestaurantId(Integer id);

    Menu save(Menu menu);

    void delete(Integer id);

    List<Menu> getAllWithLikes();

    List<Menu> getAllWithLikesDesc();

    List<Menu> getAllWithLikesAsc();
}