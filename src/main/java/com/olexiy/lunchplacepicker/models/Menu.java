package com.olexiy.lunchplacepicker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu extends AbstractBaseEntity {

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 5000)
    private String description;

    @Column(name = "creation_date", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDateTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference(value = "menu")
    private List<LikeOfMenu> likesOfMenu;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value = "restaurant")
    @NotNull
    private Restaurant restaurant;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    public Menu(Integer id, LocalDateTime creationDateTime, String description, String imgUrl) {
        super(id);
        this.creationDateTime = creationDateTime;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public Menu() {
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LikeOfMenu> getLikes() {
        return likesOfMenu;
    }

    public void setLikes(List<LikeOfMenu> likesOfMenu) {
        this.likesOfMenu = likesOfMenu;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getTotalLikes() {
        return this.likesOfMenu.size();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                " description='" + description + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}