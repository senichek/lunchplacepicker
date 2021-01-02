package com.olexiy.lunchplacepicker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "register_date", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime registerDateTime;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;

    @Column(name = "address", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String address;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 1000)
    private String description;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OnDelete(action = OnDeleteAction.CASCADE)
   // @JsonBackReference
    @NotNull
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "admin_id", nullable = false)
    @JsonBackReference(value = "user")
    @NotNull
    private User user;

    public Restaurant(Integer id, LocalDateTime registerDateTime, String name, String address, String description) {
        super(id);
        this.registerDateTime = registerDateTime;
        this.name = name;
        this.address = address;
        this.description = description;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
