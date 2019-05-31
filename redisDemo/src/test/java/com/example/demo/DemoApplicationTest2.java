package com.example.demo;

import com.example.demo.ehcache.CacheManagerFactory;
import com.example.demo.ehcache.EHCacheUtils;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

/**
 * EhCache Jgroups 方式集群缓存
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest2 {


    CacheManagerFactory cmf = CacheManagerFactory.getInstance();

    @Test
    public void testOne() {
        cmf.setElement("userCache", new Element("one", "hello"));
        Element element = cmf.getElement("userCache", "one");
        String s = (String) element.getObjectValue();
        System.out.println(s);
    }


}
