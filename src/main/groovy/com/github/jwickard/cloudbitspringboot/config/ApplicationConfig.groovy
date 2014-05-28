package com.github.jwickard.cloudbitspringboot.config
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.jwickard.cloudbitspringboot.messaging.ProfileJsonMessageConverter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
/**
 * <p>ApplicationConfig</p>
 * <p>Core Configuration for our spring boot application</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
@ComponentScan
@EnableAutoConfiguration
class ApplicationConfig {

    @Bean
    ProfileJsonMessageConverter messageConverter(){
        return new ProfileJsonMessageConverter()
    }

    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper()
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
        return mapper
    }

    public static final void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args)
    }
}
