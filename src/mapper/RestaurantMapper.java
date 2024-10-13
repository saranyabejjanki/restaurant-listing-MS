package com.sarulearn.restaurantlisting.mapper;

import com.sarulearn.restaurantlisting.dto.RestaurantDTO;
import com.sarulearn.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RestaurantMapper {

    RestaurantMapper  RESTAURANT_MAPPER_INSTANCE = Mappers.getMapper(RestaurantMapper.class);

     RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);

     Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);


}
