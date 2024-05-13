package com.homeland.homeland.repository;

import com.homeland.homeland.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findAllByUserId(Long userId);

    List<Favorite> findAllByPropertyId(Long propertyId);

    void deleteByUserIdAndPropertyId(Long userId, Long propertyId);
}
