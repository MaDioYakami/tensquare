package com.example.demo.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author madio
 */
public class CacheManagerFactory {
    private CacheManager manager;
    private static CacheManagerFactory factory = new CacheManagerFactory();
    private final static String EHCACHEFILE = "/ehcache.xml";
    private String cacheName = "user";

    private CacheManagerFactory() {
    }

    public static CacheManagerFactory getInstance() {
        return factory;
    }

    public CacheManager getCacheManager() {
        if (manager == null) {
            InputStream is = this.getClass().getResourceAsStream(EHCACHEFILE);
            manager = CacheManager.create(is);
        }
        return manager;
    }

    public Cache getCache(String cache) {
        return getCacheManager().getCache(cache);
    }

    public void setCache(Cache cache) {
        getCacheManager().addCache(cache);
    }

    public void setCache(String cache) {
        getCacheManager().addCache(cache);
    }

    public Element getElement(String key) {
        if (getCache(cacheName) == null) {
            setCache(cacheName);
        }
        return getCache(cacheName).get(key);
    }

    public void setElement(Element element) {
        if (getCache(cacheName) == null) {
            setCache(cacheName);
        }
        getCache(cacheName).put(element);
    }

    public Boolean continaElementKey(String key) {
        if (getCache(cacheName) == null) {
            setCache(cacheName);
        }
        return getCache(cacheName).isKeyInCache(key);
    }

    public void remove(Serializable key) {
        manager.getCache(cacheName).remove(key);
    }
}