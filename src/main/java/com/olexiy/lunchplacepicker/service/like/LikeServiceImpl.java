package com.olexiy.lunchplacepicker.service.like;

import com.olexiy.lunchplacepicker.models.Like;
import com.olexiy.lunchplacepicker.repository.LikeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    private LikeRepo likeRepo;

    public LikeServiceImpl(LikeRepo likeRepo) {
        this.likeRepo = likeRepo;
    }

    @Override
    public Like getById(Integer id) {
        return likeRepo.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        likeRepo.deleteById(id);
    }

    @Override
    public Like save(Like like) {
        return likeRepo.save(like);
    }

    @Override
    public List<Like> getAllByMenuID(int id) {
        return likeRepo.getAllByMenu_Id(id);
    }

    public Like getByUserIDAndAndMenuId(int userID, int menuID) {
        return likeRepo.getByUserIDAndAndMenuId(userID, menuID);
    }
}