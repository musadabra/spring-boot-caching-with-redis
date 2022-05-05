/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.redis.Redis.model;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author Musa Dabra
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@RedisHash("Stop")
public class Stop implements Serializable{
    @Id
    private String id;
    private String from;
    private String to;
    private int counter;
    
    public Stop(String id, String from, String to){
        this.id = id;
        this.from = from;
        this.to = to;
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }
    
    public void incriment(){
        counter = 0;
    }
}
