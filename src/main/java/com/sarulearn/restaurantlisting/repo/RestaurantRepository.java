package com.sarulearn.restaurantlisting.repo;

import com.sarulearn.restaurantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {


}
