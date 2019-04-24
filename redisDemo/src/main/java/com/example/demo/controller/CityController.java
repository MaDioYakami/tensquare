package com.example.demo.controller;

import com.example.demo.pojo.City;
import com.example.demo.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private RedisUtil redisUtil;


    /**
     * http://localhost:8080/apm/saveCity?cityName=北京&cityIntroduce=中国首都&cityId=1
     */
    @GetMapping(value = "saveCity")
    public String saveCity(String cityId, String cityName, String cityIntroduce) {
        City city = new City(cityId, cityName, cityIntroduce);
//        redisService.set(cityId + "", city);
        return "success";
    }

//    /**
//     * http://localhost:8080/apm/getCityById?cityId=1
//     */
//    @GetMapping(value = "getCityById")
//    public City getCity(String cityId) {
////        City city = (City) redisService.get(cityId + "");
//        return city;
//    }
}
