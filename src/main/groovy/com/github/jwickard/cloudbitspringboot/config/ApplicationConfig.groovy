package com.github.jwickard.cloudbitspringboot.config

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration

/**
 * <p>ApplicationConfig</p>
 * <p>Core Configuration for our spring boot application</p>
 * @author Joel Wickard (Object Partners Inc.)
 */
@EnableAutoConfiguration
class ApplicationConfig {
    public static final void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args)
    }
}
