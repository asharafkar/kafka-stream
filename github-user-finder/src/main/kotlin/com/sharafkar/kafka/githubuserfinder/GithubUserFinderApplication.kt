package com.sharafkar.kafka.githubuserfinder

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class GithubUserFinderApplication {

    @Bean
    fun logger(): Logger {
        return LoggerFactory.getLogger(this::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<GithubUserFinderApplication>(*args)
}
