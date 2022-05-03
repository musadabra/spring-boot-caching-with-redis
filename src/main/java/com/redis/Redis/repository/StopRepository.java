/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redis.Redis.repository;

import com.redis.Redis.model.Stop;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public class StopRepository {
    
    public static final String HASH_KEY = "STOP";
    
    @Autowired
    private RedisTemplate<String, Object> template;
    private static final Logger LOG = Logger.getLogger(StopRepository.class.getName());
    
    public Stop save(Stop stop){
        try {
            template.opsForHash().put(HASH_KEY, stop.getId(), stop);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, null, "Failed to save to redis.");
        }
        return stop;
    }
    
    public List<Object> findAll(){
        List<Object> allValues = new ArrayList<>();
        try {
            allValues = template.opsForHash().values(HASH_KEY);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, null, "Failed to fetch all from redis.");
        }
        return allValues;
    }
    
    public Stop findStopByFrom(String id){
        return (Stop) template.opsForHash().get(HASH_KEY, id);
    }
    
    public long deleteStop(String id){
        return template.opsForHash().delete(HASH_KEY, id);
    }
}
