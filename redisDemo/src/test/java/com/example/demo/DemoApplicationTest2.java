package com.example.demo;

import com.example.demo.ehcache.EHCacheUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * EhCache Jgroups 方式集群缓存
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest2 {

    @Test
    public void testOne() {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("oneUrl");
        list.add("twoUrl");
        map.put("oneMap", list);
        map.put("twoMap", list);
        EHCacheUtils.setCache("userOneUrl", map);
        HashMap userOneUrl = (HashMap) EHCacheUtils.getCache("userOneUrl");
        List<String> three = (List<String>) userOneUrl.get("threeMap");
        if (three == null) {
            List<String> listNew = new ArrayList<>();
            listNew.add("threeUrl");
            userOneUrl.put("threeMap", listNew);
            EHCacheUtils.setCache("userOneUrl", userOneUrl);
        }

        userOneUrl = (HashMap) EHCacheUtils.getCache("userOneUrl");
        System.out.println(userOneUrl);
    }
}