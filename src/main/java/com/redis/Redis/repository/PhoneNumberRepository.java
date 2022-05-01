package com.redis.Redis.repository;

import com.redis.Redis.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
    public PhoneNumber findbyNumber(String to);
}
