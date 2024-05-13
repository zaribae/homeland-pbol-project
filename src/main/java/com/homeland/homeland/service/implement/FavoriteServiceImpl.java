package com.homeland.homeland.service.implement;

import com.homeland.homeland.model.Favorite;
import com.homeland.homeland.model.Property;
import com.homeland.homeland.model.User;
import com.homeland.homeland.repository.FavoriteRepository;
import com.homeland.homeland.service.FavoriteService;
import com.homeland.homeland.service.PropertyService;
import com.homeland.homeland.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserService userService;
    private final PropertyService propertyService;

    @Override
    public void addFavorite(Long userId, Long propertyId) {
        Favorite favorite = Favorite.builder()
                .user(userService.findById(userId))
                .property(propertyService.findById(propertyId))
                .build();

        favoriteRepository.save(favorite);
    }

    @Override
    public void removeFavorite(User user, Property property) {
        favoriteRepository.deleteByUserIdAndPropertyId(user.getId(), property.getId());
    }

    @Override
    public List<Favorite> getAllUserFavorites(User user) {
        return favoriteRepository.findAllByUserId(user.getId());
    }
}
