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
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;

    @Column(name = "address", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String address;

    @Column(name = "register_date", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime registerDateTime;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 1000)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference(value = "restaurant")
    @NotNull
    private List<Menu> menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rest_admin_id", nullable = false)
    @JsonBackReference(value = "user")
    @NotNull
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference(value = "restaurant")
    private List<LikeOfRestaurant> likesOfRestaurant;

    public Restaurant(Integer id, String name, String address, String description, LocalDateTime registerDateTime) {
        super(id);
        this.name = name;
        this.address = address;
        this.description = description;
        this.registerDateTime = registerDateTime;
    }

    public Restaurant() {
    }

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(LocalDateTime registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LikeOfRestaurant> getLikesOfRestaurant() {
        return likesOfRestaurant;
    }

    public void setLikesOfRestaurant(List<LikeOfRestaurant> likesOfRestaurant) {
        this.likesOfRestaurant = likesOfRestaurant;
    }

    public int getTotalLikes() {
        return this.likesOfRestaurant.size();
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", registerDateTime=" + registerDateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
