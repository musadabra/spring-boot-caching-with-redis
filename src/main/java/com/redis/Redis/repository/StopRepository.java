/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redis.Redis.repository;

import com.redis.Redis.config.RedisConfig;
import com.redis.Redis.model.Stop;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import static org.springframework.data.redis.serializer.RedisSerializationContext.java;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

/**
 *
 * @author dell
 */
@Repository
public class StopRepository {
    
    private RedisConfig redisConfig;
    
    private static final Logger LOG = Logger.getLogger(StopRepository.class.getName());
    public final String HASH_KEY = "Stop";
    
    private HashOperations hashOperations;
    @Autowired
    private RedisTemplate template;
    
    public StopRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void create(Stop stop) {
        hashOperations.put(HASH_KEY, stop.getId(), stop);
        LOG.log(Level.INFO, "STOP with ID {0} saved", stop.getId());
    }
	
    public Stop get(String stopKey) {
            return (Stop) hashOperations.get(HASH_KEY, stopKey);
    }

    public Map<String, Stop> getAll(){
            return hashOperations.entries(HASH_KEY);
    }

    public void update(Stop stop) {
        hashOperations.put(HASH_KEY, stop.getId(), stop);
        LOG.log(Level.INFO, "User with ID {0} updated", stop.getId());
    }

    public void delete(String stopKey) {
        hashOperations.delete(HASH_KEY, stopKey);
        LOG.log(Level.INFO, "User with ID {0} deleted", stopKey);
    }

    public void saveWithExpiration(Stop stopObj) {
        template.opsForHash().put(HASH_KEY, stopObj.getId(), stopObj);
        LOG.log(Level.INFO, "STOP with ID {0} saved", stopObj.getId());
    }
    
    public Set<String> getAllKeys(){
      Set<String> list = redisConfig.jedisConnection().keys("*");; 
      return list;
    }
}
