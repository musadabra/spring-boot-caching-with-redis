package com.redis.Redis.repository;

import com.redis.Redis.model.PhoneNumber;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

    public PhoneNumber findByNumber(String to);
}
