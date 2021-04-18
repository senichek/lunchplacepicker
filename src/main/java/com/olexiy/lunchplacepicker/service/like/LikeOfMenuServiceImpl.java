package com.olexiy.lunchplacepicker.service.like;

import com.olexiy.lunchplacepicker.models.LikeOfMenu;
import com.olexiy.lunchplacepicker.repository.LikeOfMenuRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeOfMenuServiceImpl implements LikeOfMenuService {

    private LikeOfMenuRepo likeOfMenuRepo;

    public LikeOfMenuServiceImpl(LikeOfMenuRepo likeOfMenuRepo) {
        this.likeOfMenuRepo = likeOfMenuRepo;
    }

    @Override
    public LikeOfMenu getById(Integer id) {
        return likeOfMenuRepo.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        likeOfMenuRepo.deleteById(id);
    }

    @Override
    public LikeOfMenu save(LikeOfMenu likeOfMenu) {
        return likeOfMenuRepo.save(likeOfMenu);
    }

    @Override
    public List<LikeOfMenu> getAllByMenuID(int id) {
        return likeOfMenuRepo.getAllByMenu_Id(id);
    }

    public LikeOfMenu getByUserIDAndAndMenuId(int userID, int menuID) {
        return likeOfMenuRepo.getByUserIDAndAndMenuId(userID, menuID);
    }

    @Override
    public LikeOfMenu getByUserId(Integer id) {
        return likeOfMenuRepo.getByUserID(id);
    }
}