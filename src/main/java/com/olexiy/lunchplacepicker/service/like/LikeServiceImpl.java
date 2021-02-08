package com.olexiy.lunchplacepicker.service.like;

import com.olexiy.lunchplacepicker.models.Like;
import com.olexiy.lunchplacepicker.repository.LikeRepo;

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
}