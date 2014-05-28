package com.github.jwickard.cloudbitspringboot.repositories
import com.github.jwickard.cloudbitspringboot.model.Profile
import org.springframework.data.mongodb.repository.MongoRepository
/**
 * <p>IProfileRepository</p>
 * <p>Repository Interface for Profile</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
interface IProfileRepository extends MongoRepository<Profile, String> {
    public Profile findByUserId(String id)
}
