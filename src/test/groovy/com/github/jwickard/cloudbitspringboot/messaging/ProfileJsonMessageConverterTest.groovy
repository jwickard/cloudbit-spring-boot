package com.github.jwickard.cloudbitspringboot.messaging
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.jwickard.cloudbitspringboot.model.Profile
import spock.lang.Specification
/**
 * <p>ProfileJsonMessageConverterTest</p>
 * <p>Test Suite for Message Converter</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
class ProfileJsonMessageConverterTest extends Specification {

    def ObjectMapper mapper
    def userid = '2h2hj2'
    def avatar = 'someavatar'
    def country = 'CA'
    def displayName = 'display name'
    def fullName = "Full Name"
    def locale = 'en_US'
    def gender = 'MALE'
    def Float height = 48.7
    def Float runningStride = 81.9
    def Float walkingStride = 70
    def timezone = 'America/Los_Angeles'
    def Float weight = 189
    def body = "{\"user\":{\"avatar\":\"$avatar\",\"avatar150\":\"http://www.fitbit.com/images/profile/defaultProfile_150_male.gif\",\"country\":\"$country\",\"dateOfBirth\":\"1970-05-20\",\"displayName\":\"$displayName\",\"distanceUnit\":\"en_US\",\"encodedId\":\"$userid\",\"foodsLocale\":\"en_US\",\"fullName\":\"$fullName\",\"gender\":\"$gender\",\"glucoseUnit\":\"en_US\",\"height\":$height,\"heightUnit\":\"en_US\",\"locale\":\"$locale\",\"memberSince\":\"2014-05-23\",\"offsetFromUTCMillis\":-25200000,\"strideLengthRunning\":$runningStride,\"strideLengthWalking\":$walkingStride,\"timezone\":\"$timezone\",\"waterUnit\":\"en_US\",\"weight\":$weight,\"weightUnit\":\"en_US\"}}"
    def  messageConverter

    def setup() {

        mapper = new ObjectMapper()
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)

        messageConverter = new ProfileJsonMessageConverter()
        messageConverter.objectMapper = mapper
    }

    void 'it should map Json properties'() {
        when:
            Profile profile = messageConverter.fromMessage(body)

        then:
            profile.userId == userid
            profile.avatar == avatar
            profile.country == country
            profile.displayName == displayName
            profile.locale == locale
            profile.fullName == fullName
            profile.gender == gender
            profile.height == height
            profile.runningStride == runningStride
            profile.walkingStride == walkingStride
            profile.timezone == timezone
            profile.weight == weight
    }
}
