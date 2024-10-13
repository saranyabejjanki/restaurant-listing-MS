package com.sarulearn.restaurantlisting.service;

import com.sarulearn.restaurantlisting.dto.RestaurantDTO;
import com.sarulearn.restaurantlisting.entity.Restaurant;

import java.util.List;

public interface IRestaurantService {

  List<RestaurantDTO> findAllRestaurants();

  RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO);

  RestaurantDTO findRestaurantById(Integer id);

  RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO,Integer id);

  void deleteRestaurant(Integer id);

}
