package com.redis.Redis.controller;


import com.redis.Redis.model.AppResponse;
import com.redis.Redis.model.UserMessage;
import com.redis.Redis.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author mdabra
 */

@RestController
@ControllerAdvice
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private UserMessageService userMessageService;

    @PostMapping("/inbound/sms")
    public ResponseEntity<AppResponse> inbound(@Validated @RequestBody UserMessage message){
        long userId = 1;
        AppResponse response = userMessageService.saveNumber(message, userId);
        if(response.getError() != "")
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/outbound/sms")
    public ResponseEntity<AppResponse> outbound(@Validated @RequestBody UserMessage message) {
        long userId = 1;
        AppResponse response = userMessageService.saveNumber(message, userId);
        if(response.getError() != "")
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(response);
    }
}
