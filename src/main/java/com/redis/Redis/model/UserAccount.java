package com.redis.Redis.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Musa Dabra
 * THIS CLASS IS A DATA ACCESS OBJECT, MODEL, USED FOR RETRIVING OR SAVING PHONE_NUMBER IN THE DB.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "account")
public class UserAccount {
    @Id
    private long id;
    
    @Column(name = "auth_id")
    private String password;

    @Column
    private String username;
}
