package com.olexiy.lunchplacepicker.service.like;

import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;
import com.olexiy.lunchplacepicker.repository.LikeOfRestaurantRepo;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeOfRestaurantServiceImpl implements LikeOfRestaurantService {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    private LikeOfRestaurantRepo likeOfRestaurantRepo;

    public LikeOfRestaurantServiceImpl(LikeOfRestaurantRepo likeOfRestaurantRepo) {
        this.likeOfRestaurantRepo = likeOfRestaurantRepo;
    }

    @Override
    public LikeOfRestaurant getById(Integer id) {
        LikeOfRestaurant likeOfRestaurant = likeOfRestaurantRepo.getLikeOfRestaurantById(id);
        if (likeOfRestaurant == null) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            log.info("get menu {}", likeOfRestaurant);
            return likeOfRestaurant;
        }
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

    @Override
    public LikeOfRestaurant getByUserId(Integer id) {
        return likeOfRestaurantRepo.getByUserID(id);
    }
}