package com.github.jwickard.cloudbitspringboot.messaging
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.jwickard.cloudbitspringboot.model.Profile
import org.springframework.amqp.support.converter.MessageConversionException
import org.springframework.beans.factory.annotation.Autowired
/**
 * <p>ProfileMessageConverter</p>
 * <p>Converts JSON to Profile</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
class ProfileJsonMessageConverter {

    @Autowired
    ObjectMapper objectMapper

    Profile fromMessage(String message) throws MessageConversionException {
        Profile p = objectMapper.readValue(message, Profile.class)
        return p
    }
}
