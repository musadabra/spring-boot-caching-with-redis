package com.redis.Redis.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 * @author Musa Dabra
 * THIS CLASS IS A DATA ACCESS OBJECT, MODEL, USED FOR RETRIVING OR SAVING PHONE_NUMBER IN THE DB.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "phone_number")
public class PhoneNumber{
    @Id
    private long id;

    private String number;

    // Many to One is Relational mapping, the fetch type instruct the JPA to either get the related entity data or not
    // The EAGER fetchtype instruct the JPA to query the phone numbers including the account entity.
    // The Join column; specifies the foriegn key.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="account_id", nullable=false)
    private UserAccount account;

}
