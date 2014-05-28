package com.github.jwickard.cloudbitspringboot.messaging

import com.github.jwickard.cloudbitspringboot.model.Profile
import com.github.jwickard.cloudbitspringboot.repositories.IProfileRepository
import org.springframework.beans.factory.annotation.Autowired
/**
 * <p>ProfileReceiverImpl</p>
 * <p>Receiver Implementation</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
class ProfileReceiverImpl implements ProfileReceiver {

    @Autowired
    IProfileRepository profileRepository

    @Autowired
    ProfileJsonMessageConverter messageConverter

    @Override
    void receiveMessage(String msg) {
        println(msg)

        Profile incoming = messageConverter.fromMessage(msg)

        Profile existing = profileRepository.findByUserId(incoming.getUserId())

        if(existing != null) {
            existing.avatar = incoming.avatar
            existing.country = incoming.country
            existing.birthday = incoming.birthday
            existing.displayName = incoming.displayName
            existing.fullName = incoming.fullName
            existing.gender = incoming.gender
            existing.height = incoming.height
            existing.runningStride = incoming.runningStride
            existing.walkingStride = incoming.walkingStride
            existing.timezone = incoming.timezone
            existing.weight = incoming.weight

            profileRepository.save(existing)
        } else {
            profileRepository.save(incoming)
        }
    }
}
