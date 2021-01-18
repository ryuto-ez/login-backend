package com.ryuto.demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpResponse

@RestController
class UserController (val repo : UserRepo){
    @PostMapping("/newUser")
    fun createUser(@RequestBody user: User): ResponseEntity<String> {
        var flag = false
        repo.findAll().forEach {
            x -> if (user.username == x.username) {
                flag = true
            }
        }
        if (flag) {
            return ResponseEntity("Username exists",HttpStatus.BAD_REQUEST)
        } else {
            repo.save(user)
            return ResponseEntity(HttpStatus.OK)
        }

    }

    @GetMapping("/getAllUsers")
    fun returnUsers(): List<User> {
        return repo.findAll().toList();
    }

    @PostMapping("/login")
    fun login(@RequestBody user:User): ResponseEntity<String> {
        var flag = false
        repo.findAll().forEach { x -> if (user.username == x.username) {
                if (user.password == x.password) {
                    return ResponseEntity("Login Successful",HttpStatus.OK)
                } else {
                    return ResponseEntity("Password/username is incorrect",HttpStatus.BAD_REQUEST)
                }
            }
        }
        return ResponseEntity("Password/username is incorrect",HttpStatus.BAD_REQUEST)

    }

}