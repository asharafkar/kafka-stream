package com.sharafkar.kafka.githubuserfinder.controller

import com.sharafkar.kafka.githubuserfinder.service.UserFinderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserFinderController(private val userFinderService: UserFinderService) {

    @GetMapping("/find/{username}")
    fun find(@PathVariable("username") username: String): String {
        userFinderService.find(username)
        return "Find github users"
    }
}