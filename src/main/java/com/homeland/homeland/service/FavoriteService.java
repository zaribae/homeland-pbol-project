package com.homeland.homeland.service;

import com.homeland.homeland.model.Favorite;
import com.homeland.homeland.model.Property;
import com.homeland.homeland.model.User;

import java.util.List;

public interface FavoriteService {

    void addFavorite(Long userId, Long propertyId);
    void removeFavorite(User user, Property property);
    List<Favorite> getAllUserFavorites(User user);
}
