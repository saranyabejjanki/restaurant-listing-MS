package com.sarulearn.restaurantlisting.service;

import com.sarulearn.restaurantlisting.dto.RestaurantDTO;
import com.sarulearn.restaurantlisting.entity.Restaurant;
import com.sarulearn.restaurantlisting.mapper.RestaurantMapper;
import com.sarulearn.restaurantlisting.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService  implements  IRestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDTO> findAllRestaurants() {

       List<Restaurant> restaurants = restaurantRepository.findAll();
      List<RestaurantDTO> restaurantDTOS =restaurants.stream().
              map(restaurant -> RestaurantMapper.RESTAURANT_MAPPER_INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).
              collect(Collectors.toList());
        return restaurantDTOS;
    }

    @Override
    public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = RestaurantMapper.RESTAURANT_MAPPER_INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO);
        RestaurantDTO restaurantDTOObject=null;
        Restaurant savedRestaurant =null;
        System.out.println(restaurant.getAddress()+" "+restaurantDTO.getAddress());
        if(Objects.nonNull(restaurant)) {
            savedRestaurant = restaurantRepository.save(restaurant);
        }
        if(Objects.nonNull(savedRestaurant))
        restaurantDTOObject = RestaurantMapper.RESTAURANT_MAPPER_INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);

        return  restaurantDTOObject;
    }

    @Override
    public RestaurantDTO findRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        RestaurantDTO restaurantDTOObject=null;
        if(restaurant.isPresent()){
            restaurantDTOObject =RestaurantMapper.RESTAURANT_MAPPER_INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get());
        }
        return restaurantDTOObject;
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO, Integer id) throws RuntimeException {
        RestaurantDTO restaurantDTOObject = null;
        Restaurant savedRestaurant = null;
        if (restaurantDTO.getId() == id) {
            Restaurant restaurant = RestaurantMapper.RESTAURANT_MAPPER_INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO);
            System.out.println(restaurant.getAddress() + " " + restaurantDTO.getAddress());
            if (Objects.nonNull(restaurant)) {
                savedRestaurant = restaurantRepository.save(restaurant);
            }
        } else {
            throw new RuntimeException("Id is not same");
        }
        if(Objects.nonNull(savedRestaurant))
            restaurantDTOObject = RestaurantMapper.RESTAURANT_MAPPER_INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);

        return  restaurantDTOObject;
    }

    @Override
    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);

    }
}
