package com.olexiy.lunchplacepicker.models;

public interface HasID {
    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        return getId() == null;
    }
}
