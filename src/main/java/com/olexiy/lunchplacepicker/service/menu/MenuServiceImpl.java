package com.olexiy.lunchplacepicker.service.menu;

import com.olexiy.lunchplacepicker.models.Menu;
import com.olexiy.lunchplacepicker.repository.MenuRepo;
import com.olexiy.lunchplacepicker.repository.RestaurantRepo;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    MenuRepo menuRepo;

    RestaurantRepo restaurantRepo;

    public MenuServiceImpl(MenuRepo menuRepo, RestaurantRepo restaurantRepo) {
        this.menuRepo = menuRepo;
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public List<Menu> getAll() {
        return menuRepo.findAll();
    }

    @Override
    public Menu getByID(Integer id) {
        if (!menuRepo.existsById(id)) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            return menuRepo.getById(id);
        }
    }

    @Override
    public List<Menu> getAllByRestaurantIdWithLikes(Integer id) {
        return menuRepo.getAllByRestaurantIdWithLikes(id);
    }

    @Override
    public List<Menu> getAllByRestaurantId(Integer id) {
        return menuRepo.getAllByRestaurantId(id);
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepo.save(menu);
    }

    @Override
    public void delete(Integer id) {
        if (!menuRepo.existsById(id)) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            menuRepo.deleteById(id);
        }
    }

    @Override
    public List<Menu> getAllWithLikes() {
        List<Menu> all = menuRepo.getAllWithLikes();
        return all;
    }

    @Override
    public List<Menu> getAllWithLikesDesc() {
        List<Menu> menus = menuRepo.getAllWithLikes();

        List<Menu> sortedMenus = menus.stream()
                .sorted(Comparator.comparingInt(Menu::getTotalLikes).reversed())
                .collect(Collectors.toList());

        return sortedMenus;
    }

    @Override
    public List<Menu> getAllWithLikesAsc() {
        List<Menu> menus = menuRepo.getAllWithLikes();

        List<Menu> sortedMenus = menus.stream()
                .sorted(Comparator.comparingInt(Menu::getTotalLikes))
                .collect(Collectors.toList());

        return sortedMenus;
    }
}