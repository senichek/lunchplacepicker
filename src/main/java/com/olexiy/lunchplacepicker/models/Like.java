package com.olexiy.lunchplacepicker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes", uniqueConstraints = {@UniqueConstraint(columnNames = "menu_id", name = "users_unique_email_idx")})
public class Like extends AbstractBaseEntity {
    @Column(name = "creation_date", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDateTime;

    public Like(Integer id, Integer userID, Integer menuID, LocalDateTime creationDateTime) {
        super(id);
        this.userID = userID;
        this.menuID = menuID;
        this.creationDateTime = creationDateTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @NotNull
    private Menu menu;

    @Column(name = "user_id", nullable = false)
    @javax.validation.constraints.NotNull
    private Integer userID;

    @Column(name = "menu_id", nullable = false)
    @javax.validation.constraints.NotNull
    private Integer menuID;

    public Like() {
    }
}
