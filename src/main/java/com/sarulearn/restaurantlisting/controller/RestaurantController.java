package com.sarulearn.restaurantlisting.controller;

import com.sarulearn.restaurantlisting.dto.RestaurantDTO;
import com.sarulearn.restaurantlisting.service.IRestaurantService;
import com.sarulearn.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private IRestaurantService restaurantService;

    @GetMapping(path ="/restaurants")
    public ResponseEntity<List<RestaurantDTO>> findAllRestaurants(){

        List<RestaurantDTO> restaurantDTOList=restaurantService.findAllRestaurants();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        if(!restaurantDTOList.isEmpty()){
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(restaurantDTOList,httpStatus);
    }



    @PostMapping(path ="/restaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){

        RestaurantDTO savedRestaurantDTO=restaurantService.saveRestaurant(restaurantDTO);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        if(Objects.nonNull(restaurantDTO)){
            httpStatus = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(savedRestaurantDTO,httpStatus);
    }

    @GetMapping(path ="/restaurant/{restaurantId}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer restaurantId){
        RestaurantDTO restaurantDTO = restaurantService.findRestaurantById(restaurantId);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        if(Objects.nonNull(restaurantDTO)){
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(restaurantDTO,httpStatus);
    }

    @PutMapping(path="/restaurant/update/{restaurantId}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO,@PathVariable Integer restaurantId){
        RestaurantDTO savedRestaurantDTO = restaurantService.updateRestaurant(restaurantDTO,restaurantId);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        if(Objects.nonNull(restaurantDTO)){
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(savedRestaurantDTO,httpStatus);
    }

    @DeleteMapping(path ="/restaurant/delete/{restaurantId}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Integer restaurantId){

        restaurantService.deleteRestaurant(restaurantId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
