package com.olexiy.lunchplacepicker.to;

import com.olexiy.lunchplacepicker.models.AbstractBaseEntity;
import com.olexiy.lunchplacepicker.models.Role;
import org.hibernate.annotations.BatchSize;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

public class UserTO extends AbstractBaseEntity {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @NotNull
    private LocalDateTime registered;

    @BatchSize(size = 200)
    private Set<Role> roles;

    public UserTO(Integer id, String name, String email, LocalDateTime registered, Set<Role> roles) {
        super(id);
        this.name = name;
        this.email = email;
        this.registered = registered;
        this.roles = roles;
    }

    public UserTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
