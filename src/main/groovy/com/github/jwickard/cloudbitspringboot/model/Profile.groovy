package com.github.jwickard.cloudbitspringboot.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import org.springframework.data.annotation.Id
/**
 * <p>Profile</p>
 * <p>Our Profile Model</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
@JsonRootName('user')
@JsonIgnoreProperties(['avatar150', 'distanceUnit', 'foodsLocale', 'glucoseUnit', 'heightUnit', 'memberSince',
                       'offsetFromUTCMillis', 'waterUnit', 'weightUnit'])
class Profile {

    @Id
    private String id
    private String avatar
    private String country
    @JsonProperty('dateOfBirth')
    private Date birthday
    private String displayName
    private String locale
    @JsonProperty('encodedId')
    private String userId
    private String fullName
    private String gender
    private Float height
    @JsonProperty('strideLengthRunning')
    private Float runningStride
    @JsonProperty('strideLengthWalking')
    private Float walkingStride
    private String timezone
    private Float weight

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getAvatar() {
        return avatar
    }

    void setAvatar(String avatar) {
        this.avatar = avatar
    }

    String getCountry() {
        return country
    }

    void setCountry(String country) {
        this.country = country
    }

    Date getBirthday() {
        return birthday
    }

    void setBirthday(Date birthday) {
        this.birthday = birthday
    }

    String getDisplayName() {
        return displayName
    }

    void setDisplayName(String displayName) {
        this.displayName = displayName
    }

    String getLocale() {
        return locale
    }

    void setLocale(String locale) {
        this.locale = locale
    }

    String getUserId() {
        return userId
    }

    void setUserId(String userId) {
        this.userId = userId
    }

    String getFullName() {
        return fullName
    }

    void setFullName(String fullName) {
        this.fullName = fullName
    }

    String getGender() {
        return gender
    }

    void setGender(String gender) {
        this.gender = gender
    }

    Float getHeight() {
        return height
    }

    void setHeight(Float height) {
        this.height = height
    }

    Float getRunningStride() {
        return runningStride
    }

    void setRunningStride(Float runningStride) {
        this.runningStride = runningStride
    }

    Float getWalkingStride() {
        return walkingStride
    }

    void setWalkingStride(Float walkingStride) {
        this.walkingStride = walkingStride
    }

    String getTimezone() {
        return timezone
    }

    void setTimezone(String timezone) {
        this.timezone = timezone
    }

    Float getWeight() {
        return weight
    }

    void setWeight(Float weight) {
        this.weight = weight
    }
}
