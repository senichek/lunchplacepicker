package com.olexiy.lunchplacepicker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes_of_restaurant", uniqueConstraints = {@UniqueConstraint(columnNames = "rest_id", name = "users_unique_like_per_restaurant_idx")})
public class LikeOfRestaurant extends AbstractBaseEntity {
    @Column(name = "creation_date", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value = "restaurant")
    @NotNull
    private Restaurant restaurant;

    @Column(name = "user_id", nullable = false)
    @NotNull
    private Integer userID;

    public LikeOfRestaurant(Integer id, LocalDateTime creationDateTime) {
        super(id);
        this.creationDateTime = creationDateTime;
    }

    public LikeOfRestaurant() {
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}