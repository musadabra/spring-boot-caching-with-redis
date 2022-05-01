package com.redis.Redis.repository;

import com.redis.Redis.model.PhoneNumber;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
    List<PhoneNumber> findbyNumber(String number);
}
