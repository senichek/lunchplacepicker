package com.olexiy.lunchplacepicker.service.like;

import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;
import com.olexiy.lunchplacepicker.repository.LikeOfRestaurantRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeOfRestaurantServiceImpl implements LikeOfRestaurantService {

    private LikeOfRestaurantRepo likeOfRestaurantRepo;

    public LikeOfRestaurantServiceImpl(LikeOfRestaurantRepo likeOfRestaurantRepo) {
        this.likeOfRestaurantRepo = likeOfRestaurantRepo;
    }

    @Override
    public LikeOfRestaurant getById(Integer id) {
        return likeOfRestaurantRepo.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        likeOfRestaurantRepo.deleteById(id);
    }

    @Override
    public LikeOfRestaurant save(LikeOfRestaurant likeOfRestaurant) {
        //return likeOfRestaurantRepo.save(likeOfRestaurant);
        return likeOfRestaurantRepo.save(likeOfRestaurant);
    }

    @Override
    public List<LikeOfRestaurant> getAllByRestaurantID(int id) {
        return likeOfRestaurantRepo.getAllByRestaurantId(id);
    }

    public LikeOfRestaurant getByUserIDAndRestaurantId(int userID, int restaurantID) {
        return likeOfRestaurantRepo.getByUserIDAndRestaurantId(userID, restaurantID);
    }
}