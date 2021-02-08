package com.olexiy.lunchplacepicker.service.like;


import com.olexiy.lunchplacepicker.models.Like;

public interface LikeService {

    Like getById(Integer id);

    void deleteById(Integer id);

    Like save(Like like);
}