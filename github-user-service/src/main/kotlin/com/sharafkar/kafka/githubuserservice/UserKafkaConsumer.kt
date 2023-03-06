package com.sharafkar.kafka.githubuserservice

import com.sharafkar.kafka.model.User
import org.apache.kafka.streams.kstream.KStream
import org.slf4j.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
class UserKafkaConsumer(private val logger: Logger) {

    @Bean
    fun userService(): Consumer<KStream<String, User>> {
        return Consumer { kstream ->
            kstream.foreach { key, user ->
                logger.info("User found{id=${user.id}, username=${user.login}, avatar=${user.avatar_url}}")
            }
        }
    }
}