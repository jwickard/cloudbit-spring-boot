package com.github.jwickard.cloudbitspringboot.config
import com.mongodb.Mongo
import com.mongodb.MongoURI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
/**
 * <p>MongoConfig</p>
 * <p>Our Mongo Configuration</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
@Configuration
@EnableMongoRepositories(basePackages = 'com.github.jwickard.cloudbitspringboot.repositories')
class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    Environment env

    @Override
    protected String getDatabaseName() {
        String mongourl = env.getProperty('MONGOLAB_URI')

        return mongourl.substring(mongourl.lastIndexOf('/')+1)
    }

    @Override
    Mongo mongo() throws Exception {
        return new Mongo(new MongoURI(env.getProperty('MONGOLAB_URI')))
    }

    @Override
    protected String getMappingBasePackage() {
        return 'com.github.jwickard.cloudbitspringboot.model'
    }
}
