package com.olexiy.lunchplacepicker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes_of_menu", uniqueConstraints = {@UniqueConstraint(columnNames = "menu_id", name = "users_unique_like_per_menu_idx")})
public class LikeOfMenu extends AbstractBaseEntity {
    @Column(name = "creation_date", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value = "menu")
    @NotNull
    private Menu menu;

    @Column(name = "user_id", nullable = false)
    @NotNull
    private Integer userID;

    public LikeOfMenu(Integer id, LocalDateTime creationDateTime) {
        super(id);
        this.creationDateTime = creationDateTime;
    }

    public LikeOfMenu() {
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}