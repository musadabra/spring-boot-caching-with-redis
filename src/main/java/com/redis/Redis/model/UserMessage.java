package com.redis.Redis.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 *
 * @author Musa Dabra
 * This class is a DATA TRANSFER OBJECT MODEL, USED TAKES INFROMATION FROM BODY OF THE REQUST
 * DESERIALIZE THE REQUEST USING SERIALIZABLE
 * VALIDATE THE REQUEST BODY
 * FORM AN OBJECT OF THE REQEUST DATA FOR PERSISTANCE TO DB.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserMessage implements Serializable {

    // Not empty and string min length 6 max length 16
    @NotEmpty
    @Range(min = 6, max = 16)
    private String from;

    // Not empty and string min length 6 max length 16
    @NotEmpty
    @Range(min = 6, max = 16)
    private String to;

    @NotBlank
    private String text;
}
