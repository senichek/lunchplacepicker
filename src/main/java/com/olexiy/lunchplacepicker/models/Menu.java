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
import java.util.Map;

@Entity
@Table(name = "menus")
public class Menu extends AbstractBaseEntity {

    @Column(name = "creation_date", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDateTime;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 5000)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
   // @JsonManagedReference(value = "menu")
    private Map<Integer, Like> likes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
  //  @JsonBackReference(value = "menu")
    @NotNull
    private Restaurant restaurant;

    public Menu(Integer id, LocalDateTime creationDateTime, String description) {
        super(id);
        this.creationDateTime = creationDateTime;
        this.description = description;
    }

    public Menu() {
    }
}
