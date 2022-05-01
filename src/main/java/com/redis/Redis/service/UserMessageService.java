package com.redis.Redis.service;

import com.redis.Redis.model.AppResponse;
import com.redis.Redis.model.PhoneNumber;
import com.redis.Redis.model.UserMessage;
import com.redis.Redis.repository.PhoneNumberRepository;
import com.redis.Redis.repository.UserAccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageService {
    // Autowire: enables you to inject the object dependency implicitly
    // Autowire the Accounts repository
    @Autowired
    private UserAccountRepository userAccountRepository;

    // Autowire the Phone Number
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    // Validate the number existance.
    // Make sure the authenticated user has the to number.
    // Check the TO number, return appropraite response.
    public AppResponse saveNumber(UserMessage message, long userId){
        // Find the phone number if it exist
        List<PhoneNumber> phoneNumber = phoneNumberRepository.findbyNumber(message.getTo());
        if(phoneNumber.isEmpty())
            return new AppResponse("", "To parameter not found");

        if(phoneNumber.get(0).getAccount().getId() != userId)
            return new AppResponse("", "To parameter not found");

        // Count the number of time saved in Redis

        // Save in tredis

        return new AppResponse("inbound sms ok", "");
    }

}
