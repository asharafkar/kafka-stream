package com.sharafkar.kafka.githubuserprocess

import com.sharafkar.kafka.model.User
import org.apache.kafka.streams.kstream.KStream
import org.slf4j.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Function

@Configuration
class UserKafkaProcess(private val logger: Logger) {

    @Bean
    fun usersProcess(): Function<KStream<String, User>, KStream<String, User>> {
        return Function { kStream: KStream<String, User> ->
            kStream.filter { key, user ->
                if (user.login == key) {
                    logger.info("Username is equal: ${user.login}")
                } else {
                    logger.info("Username is not equal: ${user.login}")
                }
                user.login == key
            }
        }
    }
}