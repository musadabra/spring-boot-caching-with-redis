/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redis.Redis.config;

import com.redis.Redis.model.Stop;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 *
 * @author dell
 */
@Configuration
@EnableRedisRepositories
public class RedisConfig {
    
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(redisHost);
        configuration.setPort(redisPort);
        return new JedisConnectionFactory(configuration);
    }

//    @Bean 
//    public LettuceConnectionFactory redisConnectionFactory() {
//        LettuceConnectionFactory lcf = new LettuceConnectionFactory();
//        lcf.setHostName(redisHost);
//        lcf.setPort(redisPort);		
//        lcf.afterPropertiesSet();
//        return lcf;
//    }
    
    @Bean
    public RedisTemplate<String, Stop> template() {
        RedisTemplate<String, Stop> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory());
        template.setConnectionFactory(connectionFactory());
        template.afterPropertiesSet();
        return template;
    }

}
