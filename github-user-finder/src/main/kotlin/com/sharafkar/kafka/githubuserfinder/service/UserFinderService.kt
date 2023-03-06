package com.sharafkar.kafka.githubuserfinder.service

import com.sharafkar.kafka.model.User
import com.sharafkar.kafka.model.UserItems
import org.slf4j.Logger
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class UserFinderService(private val kafkaTemplate: KafkaTemplate<String, User>, private val logger: Logger) {

    companion object {
        private const val KAFKA_TOPIC = "github-users"
    }

    fun find(username: String) {
        val usersMono = WebClient.create()
            .get()
            .uri("https://api.github.com/search/users?q=$username")
            .accept()
            .retrieve()
            .bodyToMono(UserItems::class.java)

        usersMono.subscribe { users ->
            users.items?.forEach { user ->
                //username value is Key
                kafkaTemplate.send(KAFKA_TOPIC, username, user)
                logger.info("User Found: ${user.login}")
            }
        }
    }
}