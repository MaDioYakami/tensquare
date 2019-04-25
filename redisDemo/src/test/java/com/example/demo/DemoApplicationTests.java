package com.example.demo;

import com.example.demo.pojo.City;
import com.example.demo.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testOne() {
        try {
            boolean set = redisUtil.set("test", "测试字符串数据");
            System.out.println(set);
            String test = (String) redisUtil.get("test");
            System.out.println(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveTest() {
        City city = new City("1","城市2","城市哎哎2");
        List<Object> list = new ArrayList<>();
        list.add(city);
        list.add(city);
        list.add(city);
        redisUtil.del("cityList");
        boolean cityList = redisUtil.lSet("cityList", list);
        System.out.println(cityList);
        List<Object> cityList1 = redisUtil.lGet("cityList", 0, -1);
        System.out.println(cityList1);

    }

}
