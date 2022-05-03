package com.redis.Redis.service;

import com.redis.Redis.model.AppResponse;
import com.redis.Redis.model.PhoneNumber;
import com.redis.Redis.model.Stop;
import com.redis.Redis.model.UserMessage;
import com.redis.Redis.repository.PhoneNumberRepository;
import com.redis.Redis.repository.StopRepository;
import com.redis.Redis.repository.UserAccountRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @Autowired
    private StopRepository stopRepository;
    
    private static final Logger LOG = Logger.getLogger(UserMessageService.class.getName());
    
    

    // Validate the number existance.
    // Make sure the authenticated user has the to number.
    // Check the TO number, return appropraite response.
    public AppResponse saveNumber(UserMessage message, long userId){
        // Find the phone number if it exist
        PhoneNumber phoneNumber = phoneNumberRepository.findByNumber(message.getTo());
        if(phoneNumber == null)
            return new AppResponse("", "To parameter not found");
//
        if(phoneNumber.getAccount().getId() != userId)
            return new AppResponse("", "To parameter not found");

        // Check message content for STOP OR stop or STOP\r\n
        String stopRegex = "(STOP|stop)\\s*\\n*";
        boolean messageContainStop = message.getText().matches(stopRegex);
        if(messageContainStop)
            return new AppResponse("MATCH found", "");
        // Count the number of time saved in Redis
        
        
        // Save in tredis
        String from = message.getFrom();
            String to = message.getTo();
            String stopId = from+"_"+to;
        try {
            Stop stopObj = new Stop();
            stopObj.setId(stopId);
            stopObj.setFrom(from);
            stopObj.setTo(to);
            System.out.println("Herer++++");
            stopRepository.save(stopObj);
            System.out.println("After saving+++");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), "Failed to save");
        }
        
//        List<Stop> findAll = stopRepository.findAll();
//        findAll.stream().forEach((t) -> {
//            System.out.println(t.getFrom()+" to: "+t.getTo()+" Counter: "+t.getCounter());
//        });
        Stop findStopByFrom = stopRepository.findStopByFrom(stopId);
        System.out.println(findStopByFrom.getFrom()+" to: "+findStopByFrom.getTo()+" Counter: ");
        return new AppResponse("inbound sms ok", "");
    }
    

}
